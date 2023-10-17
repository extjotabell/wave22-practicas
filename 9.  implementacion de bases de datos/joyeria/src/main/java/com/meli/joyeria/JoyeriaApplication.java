package com.meli.joyeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.meli.joyeria")
public class JoyeriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoyeriaApplication.class, args);
    }

}
