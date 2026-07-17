package com.ripudaman.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AggregateResponse {

    @JsonProperty("post_title")
    private String postTitle;

    @JsonProperty("author_name")
    private String authorName;

    public AggregateResponse() {
    }

    public AggregateResponse(String postTitle, String authorName) {
        this.postTitle = postTitle;
        this.authorName = authorName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}