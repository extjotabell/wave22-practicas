package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDTO;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.ILasPerlasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LasPerlasService implements ILasPerlasService {

    ILasPerlasRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public LasPerlasService(ILasPerlasRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public List<JoyaDTO> getAllJoyas() {
        List<Joya> allJoyas = repository.findByEnVenta(true);
        List<JoyaDTO> allJoyasDTOs = new ArrayList<>();

        for (Joya joya : allJoyas) {
            allJoyasDTOs.add(mapper.convertValue(joya, JoyaDTO.class));
        }

        return allJoyasDTOs;
    }

    @Override
    @Transactional
    public Long saveJoya(JoyaDTO joyaToSave) {
        Joya joya = mapper.convertValue(joyaToSave, Joya.class);
        return repository.save(joya).getId();
    }

    @Override
    @Transactional
    public String deleteJoya(Long joyaIdToDelete) {
        Joya joyaToDelete = repository.findById(joyaIdToDelete).orElse(null);
        if (joyaToDelete == null) return "No hay joya con ese ID";
        joyaToDelete.setEnVenta(false);
        repository.save(joyaToDelete);
        return "La joya con ID #" + joyaIdToDelete + " fue eliminada correctamente";
    }

    @Override
    @Transactional
    public JoyaDTO findJoyaById(Long joyaIdToFind) throws Exception {
        Joya joyaFound = repository.findById(joyaIdToFind).orElse(null);
        if (joyaFound == null) throw new Exception("Joya not found");
        return mapper.convertValue(joyaFound, JoyaDTO.class);
    }

    @Override
    public JoyaDTO updateJoyaById(Long joyaIdToUpdate, JoyaDTO joyaNewInfo) throws Exception {
        Joya joyaFound = repository.findById(joyaIdToUpdate).orElse(null);
        if (joyaFound == null) throw new Exception("Joya not found");
        joyaFound.setNombre(joyaNewInfo.getNombre());
        joyaFound.setMaterial(joyaNewInfo.getMaterial());
        joyaFound.setPeso(joyaNewInfo.getPeso());
        joyaFound.setParticularidad(joyaNewInfo.getParticularidad());
        joyaFound.setPoseePiedra(joyaNewInfo.isPoseePiedra());
        joyaFound.setEnVenta(joyaNewInfo.isEnVenta());
        repository.save(joyaFound);
        joyaNewInfo.setId(joyaIdToUpdate);
        return joyaNewInfo;
    }
}
