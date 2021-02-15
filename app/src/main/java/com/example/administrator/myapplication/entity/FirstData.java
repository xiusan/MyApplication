package com.example.administrator.myapplication.entity;

/**
 * 头条实体类
 */
public class FirstData {
    //标题
    private String title;
    //地址
    private String url;
    //出处
    private String authorName;
    //图片地址
    private String thumbnailPicS;
    //唯一码
    private String uniquekey;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getThumbnailPicS() {
        return thumbnailPicS;
    }

    public void setThumbnailPicS(String thumbnailPicS) {
        this.thumbnailPicS = thumbnailPicS;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }
}
