package com.jake.springrediscache.countriesbe.repository;

import com.jake.springrediscache.countriesbe.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c.name FROM Country c")
    List<String> findAllCountryNames();
}
