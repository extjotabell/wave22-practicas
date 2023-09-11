package com.renzobayarri.calcularcalorias.config;

import com.renzobayarri.calcularcalorias.repository.IngredienteRepository;
import com.renzobayarri.calcularcalorias.repository.IngredienteRepositoryImpl;
import com.renzobayarri.calcularcalorias.repository.PlatoRepository;
import com.renzobayarri.calcularcalorias.repository.PlatoRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean(name = "ingredienteRepository")
    public IngredienteRepository getIngredienteRepository() throws IOException {
        return new IngredienteRepositoryImpl();
    }

    @DependsOn("ingredienteRepository")
    @Bean("platoRepository")
    public PlatoRepository getPlatoRepository(){
        return new PlatoRepositoryImpl();
    }

}
