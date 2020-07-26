package com.url.urlShortener.services;

import com.url.urlShortener.model.UrlFormat;

import java.util.List;

public interface WebService {
    String createAlias(String url);
    UrlFormat foundUrl(List<UrlFormat> urlList, String newUrl);
    UrlFormat getOriginalUrl(List<UrlFormat> urlList, String alias);
}
