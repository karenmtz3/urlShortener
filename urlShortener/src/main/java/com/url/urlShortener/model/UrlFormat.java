package com.url.urlShortener.model;

import javax.validation.constraints.NotNull;

public class UrlFormat {
    @NotNull
    String url;

    String alias;

    public UrlFormat(String url){
        super();
        this.url = url;
    }

    public UrlFormat(){
        super();
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias(){
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
