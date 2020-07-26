package com.url.urlShortener.services.impl;

import com.url.urlShortener.model.UrlFormat;
import com.url.urlShortener.services.WebService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WebServiceImpl implements WebService {

    @Override
    public String createAlias(String url){
        if(validateUrl(url)){
            return generateAlias(url);
        }
        return "-1";
    }
    
    @Override
    public UrlFormat foundUrl(List<UrlFormat> urlList, String newUrl){
       try{
           UrlFormat urlFormat = urlList.stream().filter(
                   url -> url.getUrl().equals(newUrl)
           ).findFirst().get();

           return urlFormat;

       }catch (Exception ex){
           return null;
       }
    }

    @Override
    public UrlFormat getOriginalUrl(List<UrlFormat> urlList, String alias){
        try {
            UrlFormat urlObj = urlList.stream().filter(
                    urlFormat -> urlFormat.getAlias().equals(alias)
            ).findFirst().get();

            return urlObj;

        }catch (Exception ex){
            return null;
        }
    }

    public boolean validateUrl(String url){
        UrlValidator urlValidator = new UrlValidator();
        boolean result = urlValidator.isValid(url) ||
                urlValidator.isValid("http://" + url) ||
                urlValidator.isValid("https://" + url);
        return result;
    }

    public String generateAlias(String url){
        String alias;
        int length;

        if(url.contains("google")){
            length = 5;
            alias = RandomStringUtils.random(length, true, false);

        }
        else if(url.contains("yahoo")){
            length = 7;
            alias = RandomStringUtils.random(length, true, true);
        }
        else{
            String pattern = "[\\W\\daeiouAEIOU]";
            alias = url.replaceAll(pattern, "");
        }

        return alias;
    }
}
