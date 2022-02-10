package com.qa.marvelqa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MarvelQaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarvelQaApplication.class, args);
    }

}
