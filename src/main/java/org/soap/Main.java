package org.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.soap", "org.soap.service", "org.soap.config"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}