package com.url.service;

import com.url.model.Url;

public interface UrlService {
    Url generateShortUrl(String originalUrl);
    Url getOriginalUrl(String shortUrl);
} 