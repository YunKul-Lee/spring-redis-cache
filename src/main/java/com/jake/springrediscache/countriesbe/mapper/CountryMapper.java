package com.jake.springrediscache.countriesbe.mapper;

import com.jake.springrediscache.countriesbe.entity.Country;
import com.jake.springrediscache.countriesbe.dto.CountryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    Country toCountry(CountryDto countryDto);

    CountryDto fromCountry(Country country);
}
