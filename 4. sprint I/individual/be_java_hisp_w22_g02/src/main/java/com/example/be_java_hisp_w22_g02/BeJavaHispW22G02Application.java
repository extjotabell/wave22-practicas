package com.example.be_java_hisp_w22_g02;

import com.example.be_java_hisp_w22_g02.repository.Implementations.UserRepositoryImpl;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BeJavaHispW22G02Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BeJavaHispW22G02Application.class, args);
    }

}
