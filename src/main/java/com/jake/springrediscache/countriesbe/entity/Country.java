package com.jake.springrediscache.countriesbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    private String nativeName;

    private int phone;

    private String capital;

    private String continent;

    private String currency;

    private String language;

    private String flag;
}
