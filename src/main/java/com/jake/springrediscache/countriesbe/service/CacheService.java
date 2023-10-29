package com.jake.springrediscache.countriesbe.service;

public interface CacheService {

    void evictCacheValues(String cacheName);
}
