package com.jake.springrediscache.countriesbe.service;

import com.jake.springrediscache.constants.CacheNames;
import com.jake.springrediscache.countriesbe.entity.Country;
import com.jake.springrediscache.countriesbe.initializer.CountryInitializer;
import com.jake.springrediscache.countriesbe.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepo;

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    @Cacheable(CacheNames.COUNTRY_NAMES)
    @Override
    public List<String> getAllCountryNames() {
        log.info("Cache 미적용. DB 에서 데이터 조회");
        return countryRepo.findAllCountryNames();
    }

    @Override
    public List<Country> insertCountries() {
        return countryRepo.saveAll(CountryInitializer.readCountries());
    }

    @Caching(
            evict = {
                    @CacheEvict(value = CacheNames.COUNTRY_NAMES, allEntries = true, condition = "#country.code != null")
            }
    )
    @Override
    public Country insertCountry(Country country) {
        return countryRepo.save(country);
    }
}
