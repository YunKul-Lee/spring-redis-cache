package com.jake.springrediscache.countriesbe.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class RedisCacheService implements CacheService {

    private final CacheManager cacheManager;

    @Override
    public void evictCacheValues(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        log.info("Clear Cache [{}]", cacheName);
    }
}
