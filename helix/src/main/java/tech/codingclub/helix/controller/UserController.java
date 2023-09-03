package tech.codingclub.helix.controller;


import org.jooq.Condition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.codingclub.helix.database.GenericDB;
import tech.codingclub.helix.entity.*;
import tech.codingclub.helix.global.SysProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * User: rishabh
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String userWelcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member x=ControllerUtils.getCurrentMember(request);

        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/public-tweet/{id}")
    public
    @ResponseBody
    List<TweetUI> publicTweet(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        Condition condition= tech.codingclub.helix.tables.Tweet.TWEET.ID.lessThan(id);
        List<Tweet> data= (List<Tweet>) GenericDB.getRows(tech.codingclub.helix.tables.Tweet.TWEET,Tweet.class,condition,3, tech.codingclub.helix.tables.Tweet.TWEET.ID.desc());
        Set<Long> tweetIds=new HashSet<Long>();
        for(Tweet tweet:data){
            tweetIds.add(tweet.author_id);
        }

        Condition memberCond= tech.codingclub.helix.tables.Member.MEMBER.ID.in(tweetIds);
        List<Member> c= (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class,memberCond,null);
        Map<Long,Member> hashMap=new HashMap<Long, Member>();
        for(Member member:c){
            hashMap.put(member.id,member);
        }

        ArrayList<TweetUI> tweetUIS=new ArrayList<TweetUI>();
        for(Tweet tweet:data){
            TweetUI tweetUI=new TweetUI(tweet,hashMap.get(tweet.author_id));
            tweetUIS.add(tweetUI);
        }
        return tweetUIS;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-post")
    public
    @ResponseBody
    String createpost(@RequestBody String data, HttpServletRequest request, HttpServletResponse response) {
        Tweet tweet=new Tweet(null,ControllerUtils.getUserId(request),new Date().getTime(),data);
        new GenericDB<Tweet>().addRow(tech.codingclub.helix.tables.Tweet.TWEET,tweet);
        return "Posted Successfully";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/follow-member")
    public
    @ResponseBody
    String followMember(@RequestBody Long memberId, HttpServletRequest request, HttpServletResponse response) {
        Long currentMember=ControllerUtils.getUserId(request);
        if(currentMember!=null && memberId!=null && !currentMember.equals(memberId)){
            Follower follow=new Follower(currentMember,memberId);
            new GenericDB<Follower>().addRow(tech.codingclub.helix.tables.Follower.FOLLOWER,follow);
            return "Connected Successfully";
        }else {
            return "Not permitted";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/un-follow-member")
    public
    @ResponseBody
    String unfollowMember(@RequestBody Long memberId, HttpServletRequest request, HttpServletResponse response) {
        Long currentMemberId=ControllerUtils.getUserId(request);
        if(currentMemberId!=null && memberId!=null && !currentMemberId.equals(memberId)){
            Condition condition= tech.codingclub.helix.tables.Follower.FOLLOWER.USER_ID.eq(currentMemberId).and(tech.codingclub.helix.tables.Follower.FOLLOWER.FOLLOWING_ID.eq(memberId));
            Boolean isSuccess=GenericDB.deleteRow(tech.codingclub.helix.tables.Follower.FOLLOWER,condition);
            if(isSuccess)
            return "Un-followed Successfully";
        }else {
            return "Not permitted";
        }
        return "Bad request";
    }

    public void preLoadVariables(ModelMap modelMap, Long currentMemberId){
        modelMap.addAttribute("USER_IMAGE","/images/profile-image/"+currentMemberId+".jpeg");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/recommendations")
    public String recommendations(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member member=ControllerUtils.getCurrentMember(request);
        List<Member> x= (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class,null,10, tech.codingclub.helix.tables.Member.MEMBER.ID.desc());

        ArrayList<Long> memberIds=new ArrayList<Long>();
        for(Member memberTemp:x){
            memberIds.add(memberTemp.id);
        }

        Condition condition= tech.codingclub.helix.tables.Follower.FOLLOWER.USER_ID.eq(member.id).and(tech.codingclub.helix.tables.Follower.FOLLOWER.FOLLOWING_ID.in(memberIds));
        List<Follower> followerMembers= (List<Follower>) GenericDB.getRows(tech.codingclub.helix.tables.Follower.FOLLOWER,Follower.class,condition,null);
        Set<Long> followIds=new HashSet<Long>();
        for(Follower follower:followerMembers){
            followIds.add(follower.following_id);
        }

        for(Member memberT:x){
            if(followIds.contains(memberT.id)){
                //current user follows this person.
                memberT.is_followed=true;
            }
        }

        modelMap.addAttribute("NAME",member.name);
        modelMap.addAttribute("RECOMMENDATIONS",x);
        preLoadVariables(modelMap,member.id);
        return "recommendations";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/followed")
    public String followed(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Long currentMemberId=ControllerUtils.getUserId(request);

        Condition condition= tech.codingclub.helix.tables.Follower.FOLLOWER.USER_ID.eq(currentMemberId);
        List<Long> followingIds=new GenericDB<Long>().getColumnRows(tech.codingclub.helix.tables.Follower.FOLLOWER.FOLLOWING_ID, tech.codingclub.helix.tables.Follower.FOLLOWER, Long.class ,condition,100);

        List<Member> followMembers= (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class, tech.codingclub.helix.tables.Member.MEMBER.ID.in(followingIds),10, tech.codingclub.helix.tables.Member.MEMBER.ID.desc());
        modelMap.addAttribute("FOLLOWED",followMembers);
        preLoadVariables(modelMap,currentMemberId);
        return "followed";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public String updateUser(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {

        return "updateuser";
    }

    private static String saveUploadedFile( MultipartFile file, Long userId){
        try {
            String path = SysProperties.getBaseDir()+"/images/profile-image/"+userId+".jpeg";
            file.transferTo( new File(path));
            return "/images/profile-image/"+userId+".jpeg";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/profile-image/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile, HttpServletRequest request) {
        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
        String path = "";
        try {
            Long currentMemberId = ControllerUtils.getUserId(request);
            path = saveUploadedFile(uploadfile,currentMemberId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(path, new HttpHeaders(), HttpStatus.OK);
    }

}