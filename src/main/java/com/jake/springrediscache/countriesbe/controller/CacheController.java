package com.jake.springrediscache.countriesbe.controller;

import com.jake.springrediscache.constants.CacheNames;
import com.jake.springrediscache.countriesbe.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    @DeleteMapping("/names/evict")
    public Boolean evictCountryNamesCache() {
        cacheService.evictCacheValues(CacheNames.COUNTRY_NAMES);
        return true;
    }
}
