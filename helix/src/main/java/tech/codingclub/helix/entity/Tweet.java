package tech.codingclub.helix.entity;

public class Tweet {
    public Long id;
    public Long author_id;
    public String message;
    public Long created_at;

    public Tweet(){

    }

    public Tweet(Long id,Long author_id,Long created_at,String message){
        this.id=id;
        this.created_at=created_at;
        this.author_id=author_id;
        this.message=message;
    }

}
