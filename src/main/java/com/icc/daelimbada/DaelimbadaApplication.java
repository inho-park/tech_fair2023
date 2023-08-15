package com.icc.daelimbada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DaelimbadaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaelimbadaApplication.class, args);
    }

}
