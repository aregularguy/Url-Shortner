package com.url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.dto.UrlRequest;
import com.url.model.Url;
import com.url.service.UrlService;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;
    
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return new ResponseEntity<>("URL Shortener API is working!", HttpStatus.OK);
    }
    
    @PostMapping("/shorten")
    public ResponseEntity<Url> shortenUrl(@RequestBody UrlRequest urlRequest) {
        Url shortenedUrl = urlService.generateShortUrl(urlRequest.getOriginalUrl());
        return new ResponseEntity<>(shortenedUrl, HttpStatus.CREATED);
    }
    
    @GetMapping("/{shortUrl}")
    public ResponseEntity<Url> getOriginalUrl(@PathVariable String shortUrl) {
        Url url = urlService.getOriginalUrl(shortUrl);
        if (url != null) {
            return new ResponseEntity<>(url, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
} 