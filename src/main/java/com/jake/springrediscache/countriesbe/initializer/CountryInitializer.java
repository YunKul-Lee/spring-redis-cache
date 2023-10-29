package com.jake.springrediscache.countriesbe.initializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jake.springrediscache.countriesbe.entity.Country;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CountryInitializer {

    public static List<Country> readCountries() {
        String root = System.getProperty("user.dir");

        List<Country> countryList = new ArrayList<>();
        try {
            File countryJson = new File(root + "/assets/countries.json");
            Map<String, Map<String, Object>> result = new ObjectMapper().readValue(countryJson, HashMap.class);

            result.forEach((key, value) -> {
                String name = value.get("name").toString();
                String nativeName = value.get("native").toString();
                String continent = value.get("continent").toString();
                String capital = value.get("capital").toString();
                String currency = value.get("currency").toString();
                String languages = value.get("languages").toString();

                int phone;
                try {
                    phone = Integer.parseInt(value.get("phone").toString());
                } catch (NumberFormatException e) {
                    phone = -1;
                }

                Country c = Country.builder()
                        .code(key)
                        .name(name)
                        .nativeName(nativeName)
                        .continent(continent)
                        .capital(capital)
                        .currency(currency)
                        .language(languages)
                        .phone(phone)
                        .flag(key)
                        .build();

                countryList.add(c);
            });

        } catch (Exception e) {
            log.error("countries.json read fail : ", e);
        }

        return countryList;
    }


}
