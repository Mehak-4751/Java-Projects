package tech.codingclub.helix.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.codingclub.helix.entity.WikiResult;
import tech.codingclub.helix.global.HttpUrlConnectionExample;

import java.io.IOException;

public class WikipediaDownloader{
    public String keyword;
    public String response;

    public WikipediaDownloader(String keyword){
        this.keyword=keyword;
    }

    public WikiResult getResult(){
        //STEP1 Create Clean keyword - Replace space with underscore
        //STEP2 Get wikipedia url
        //STEP3 Read content at this url
        //STEP4 Parse the useful data using jsoup
        //STEP5 Store it in database
        if(keyword==null || keyword.length()==0){
            return null;
        }

        //STEP1
        String clean_keyword=keyword.trim().replaceAll("[ ]+","_");
        System.out.println(clean_keyword);

        //STEP2
        String wikiurl=getWikipediaUrl(clean_keyword);
        System.out.println(wikiurl);

        //STEP3
        String wikipediaResponseHTML= null;
        try {
            wikipediaResponseHTML = HttpUrlConnectionExample.sendGet(wikiurl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(wikipediaResponseHTML);
        String imgurl = null;
        //STEP4
        try{
            Document document=Jsoup.parse(wikipediaResponseHTML,"https://en.wikipedia.org/wiki/");
            Elements element = document.body().select(".mw-parser-output > *");
            try{
                imgurl=document.body().select(".infobox img").get(0).attr("src");
            }catch (Exception e){
                e.printStackTrace();
            }
            int state=0;
            for(Element childElement: element){
                //System.out.println(childElement.tagName());
                if(childElement.tagName().equals("table")){
                    state=1;
                }else if(state==1){
                    if(childElement.tagName().equals("p")) {
                        state=2;
                        response=childElement.text();
                        break;
                    }
                }
            }
            //if(state==2){
            //System.out.println(response);
            //}
        }catch (Exception e){
            e.printStackTrace();
        }

        WikiResult wikiResult=new WikiResult(keyword,imgurl,response);
        return wikiResult;
    }

    private String getWikipediaUrl(String clean_keyword) {
        return "https://en.wikipedia.org/wiki/"+clean_keyword;
    }

}
