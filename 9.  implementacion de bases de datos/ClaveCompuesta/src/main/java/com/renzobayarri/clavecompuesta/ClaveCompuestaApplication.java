package com.renzobayarri.clavecompuesta;

import com.renzobayarri.clavecompuesta.entity.Compra;
import com.renzobayarri.clavecompuesta.repository.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class ClaveCompuestaApplication implements CommandLineRunner {

    private CompraRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ClaveCompuestaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Compra compra1 = new Compra();
        compra1.setClienteId(1L);
        compra1.setFecha(LocalDate.now());
        repository.save(compra1);

        Compra compra2 = new Compra();
        compra2.setClienteId(2L);
        compra2.setFecha(LocalDate.now().minusDays(1));
        repository.save(compra2);

        Compra compra3 = new Compra();
        compra3.setClienteId(3L);
        compra3.setFecha(LocalDate.now().minusDays(2));
        repository.save(compra3);

        Compra compra4 = new Compra();
        compra4.setClienteId(4L);
        compra4.setFecha(LocalDate.now().minusDays(3));
        repository.save(compra4);

        Compra compra5 = new Compra();
        compra5.setClienteId(5L);
        compra5.setFecha(LocalDate.now().minusDays(4));
        repository.save(compra5);
    }
}
