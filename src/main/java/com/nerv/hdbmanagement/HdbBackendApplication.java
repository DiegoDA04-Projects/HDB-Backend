package com.nerv.hdbmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HdbBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HdbBackendApplication.class, args);
    }

}
