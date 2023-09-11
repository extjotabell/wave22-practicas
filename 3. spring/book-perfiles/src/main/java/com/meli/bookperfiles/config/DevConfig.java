package com.meli.bookperfiles.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Profile("dev")
@Configuration
public class DevConfig {

    @Autowired
    private Environment environment;
    @PostConstruct
    public void initialize() {
        System.out.println("------Iniciando el ambiente DEV--------");
    }

    @PostConstruct
    public  void getActiveProfiles(){
        for(String profileName : environment.getActiveProfiles()){
            System.out.println("------Perfil activo - " + profileName + "------");
        }
    }
}
