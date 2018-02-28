package com.lzk.model;

import java.util.Date;

/**
 * Created by lzk on 2018/2/11 14:28
 * Description:
 */
public class Article {
    private Integer articleId;
    private String title;
    private Integer typeId;
    private String keyword;
    private String summary;
    private String context;
    private Integer readNumber;
    private Date createTime;
    private Type type;

    public Article() {
    }

    public Article(String title, Integer typeId, String keyword, String summary, String context) {
        this.title = title;
        this.typeId = typeId;
        this.keyword = keyword;
        this.summary = summary;
        this.context = context;
    }

    public Article(Integer articleId, String title, Integer typeId, String keyword, String summary, String context) {
        this.articleId = articleId;
        this.title = title;
        this.typeId = typeId;
        this.keyword = keyword;
        this.summary = summary;
        this.context = context;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", keyword='" + keyword + '\'' +
                ", summary='" + summary + '\'' +
                ", context='" + context + '\'' +
                ", readNumber=" + readNumber +
                ", createTime=" + createTime +
                ", type=" + type +
                '}';
    }
}
