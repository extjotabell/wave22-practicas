package com.mleiva.impljpa.joyerialasperlas.service;

import com.mleiva.impljpa.joyerialasperlas.dto.JewerlyDTO;
import com.mleiva.impljpa.joyerialasperlas.model.Jewerly;
import com.mleiva.impljpa.joyerialasperlas.repository.JewerlyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewerlyService implements IJewerlyService{

    private final JewerlyRepository repository;

    public JewerlyService(JewerlyRepository repository) {
        this.repository = repository;
    }

    ModelMapper mapper = new ModelMapper();
    @Override
    @Transactional(readOnly = true)
    public List<JewerlyDTO> getAllJewerlys() {
        List<Jewerly> jewerlyList = repository.findAll();
        return jewerlyList.stream()
                .filter(Jewerly::isVentaONo) // Filtra solo las joyas con ventaONo == true
                .map(jewerly -> mapper.map(jewerly, JewerlyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long saveJewerly(JewerlyDTO jewerlyDTO) {
        Jewerly jewerly = mapper.map(jewerlyDTO, Jewerly.class);
        repository.save(jewerly);
        return jewerly.getId();
    }

    @Override
    @Transactional
    public void deleteJewerly(long id) {
        Jewerly jewerly = repository.findById(id).orElse(null);
        jewerly.setVentaONo(false);
        repository.save(jewerly);
    }

    @Override
    @Transactional(readOnly = true)
    public JewerlyDTO findJewerly(long id) {
        Jewerly jewerly = repository.findById(id).orElse(null);
        return mapper.map(jewerly,JewerlyDTO.class);
    }

    @Override
    public Long updateJewerly(long id, JewerlyDTO jewerlyDTO) {
        Optional<Jewerly> optionalJoya = repository.findById(id); //Utilizamos Optional para manejar la posibilidad de que no se encuentre una joya con el ID especificado en el repositorio.
        // Usamos ifPresent() para ejecutar el código de actualización solo si se encuentra una joya con el ID proporcionado.
        optionalJoya.ifPresent(jewerly -> {
            Jewerly updatedJewerly = mapper.map(jewerlyDTO, Jewerly.class);
            updatedJewerly.setId(jewerly.getId());
            repository.save(updatedJewerly);
        });

        return optionalJoya.map(Jewerly::getId).orElse(null);
    }

}
