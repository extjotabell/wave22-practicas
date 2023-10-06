package com.example.relacionesjpa;

import com.example.relacionesjpa.dto.OneToOne.AddressDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class RelacionesJpaApplication implements CommandLineRunner {

    private UserService service;

    public static void main(String[] args) {
        SpringApplication.run(RelacionesJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        UserDto user1 = new UserDto(1L, new AddressDto("Mendoza"));
        service.guardarUser(user1);

        UserDto user2 = new UserDto(2L, new AddressDto("Buenos Aires"));
        service.guardarUser(user2);

    }
}
