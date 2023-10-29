package com.jake.springrediscache.countriesbe.service;

import com.jake.springrediscache.countriesbe.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    List<String> getAllCountryNames();

    List<Country> insertCountries();

    Country insertCountry(Country country);
}
