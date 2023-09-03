package tech.codingclub.helix.entity;

public class WikiResult {
    private String query;
    private String imgUrl;
    private String textResult;

    public WikiResult(String query, String imgUrl, String textResult){
        this.query=query;
        this.imgUrl=imgUrl;
        this.textResult=textResult;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTextResult() {
        return textResult;
    }

    public String getQuery() {
        return query;
    }
}
