package com.url.urlShortener.controller;

import com.url.urlShortener.model.UrlFormat;
import com.url.urlShortener.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController{
    private WebService webService;
    private List<UrlFormat> urlList = new ArrayList<UrlFormat>();

    @GetMapping("/urlxalias")
    public List<UrlFormat> getUrlByAlias(){
        return urlList;
    }

    @PostMapping(path = "/", consumes = "application/json")
    public ResponseEntity<String> createAlias(@RequestBody UrlFormat urlFormat) {
        UrlFormat newUrlFormat = webService.foundUrl(urlList, urlFormat.getUrl());
        if(newUrlFormat != null){
            return new ResponseEntity("alias:"+ newUrlFormat.getAlias(), HttpStatus.OK);
        }
        else{
            String result = webService.createAlias(urlFormat.getUrl());

            if(result.equals("-1"))
                return new ResponseEntity<>("La url no es correcta", HttpStatus.BAD_REQUEST);
            else{
                urlFormat.setAlias(result);
                urlList.add(urlFormat);
                return new ResponseEntity("alias: "+result, HttpStatus.OK);
            }
        }
    }

    @Autowired
    public void setWebService(WebService webService) {
        this.webService = webService;
    }
}
