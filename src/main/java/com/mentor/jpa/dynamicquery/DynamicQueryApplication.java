package com.mentor.jpa.dynamicquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.mentor.jpa"})
@EnableJpaRepositories(basePackages = {"com.mentor.jpa"})
public class DynamicQueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicQueryApplication.class, args);
    }
}
