package tech.codingclub.helix.entity;

import java.util.Date;

public class TweetUI extends Tweet{
    public String author_name;
    public String email;

    public TweetUI(){

    }

    public TweetUI(Tweet tweet,Member member) {
        this.author_name=member.name;
        this.email=member.email;
        this.author_id=tweet.author_id;
        this.id=tweet.id;
        this.created_at= tweet.created_at;
        this.message=tweet.message;
    }
}
