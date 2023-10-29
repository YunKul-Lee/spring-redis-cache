package com.jake.springrediscache.countriesbe.controller;

import com.jake.springrediscache.countriesbe.dto.CountryDto;
import com.jake.springrediscache.countriesbe.entity.Country;
import com.jake.springrediscache.countriesbe.mapper.CountryMapper;
import com.jake.springrediscache.countriesbe.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    private final CountryMapper countryMapper;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public ResponseEntity<CountryDto> insertCountry(@RequestBody CountryDto countryDto) {
        Country mappedCountry = countryMapper.toCountry(countryDto);
        Country country = countryService.insertCountry(mappedCountry);
        return ResponseEntity.ok(countryMapper.fromCountry(country));
    }

    @GetMapping("/names")
    public List<String> getAllCountryNames() {
        return countryService.getAllCountryNames();
    }

    @PostMapping("/insert_all")
    public List<Country> insertCountries() {
        return countryService.insertCountries();
    }
}
