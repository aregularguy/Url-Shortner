package com.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.url.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortUrl(String shortUrl);
} 