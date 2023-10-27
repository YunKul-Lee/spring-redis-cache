package com.jake.springrediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRedisCacheApplication {

    // https://github.com/aedemirsen/countries-be/tree/redis-cache
    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCacheApplication.class, args);
    }

}
