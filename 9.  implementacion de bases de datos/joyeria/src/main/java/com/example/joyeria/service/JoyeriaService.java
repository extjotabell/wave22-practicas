package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.ResponseDTO;
import com.example.joyeria.entity.Joya;
import com.example.joyeria.exception.EntityNotFoundException;
import com.example.joyeria.repository.IJoyeriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService {

    @Autowired
    IJoyeriaRepository repo;

    public Long create(JoyaDTO joyaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        return repo.save(joya).getNro_identificatorio();
    }

    @Override
    public List<JoyaDTO> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Joya> joyas = repo.findAll();

        return joyas.stream().filter(Joya::isVentaONo)
                .map(joya -> mapper.convertValue(joya, JoyaDTO.class)).toList();
    }

    @Override
    public ResponseDTO eliminar(Long id) {

        Joya joya = repo.getReferenceById(id);
        joya.setVentaONo(false);
        repo.save(joya);
        return new ResponseDTO("The jewel with id " +id+ " was deleted successfully");
    }

    @Override
    public JoyaDTO updateJewel(Long id, JoyaDTO joyaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Joya nuevaJoya = mapper.convertValue(joyaDTO , Joya.class);
        nuevaJoya.setNro_identificatorio(id);

        try{
            Joya joya = repo.getReferenceById(id);
            joya.setNombre(joyaDTO.getNombre());
            joya.setPeso(joyaDTO.getPeso());
            joya.setMaterial(joya.getMaterial());
            joya.setParticularidad(joya.getParticularidad());
            joya.setPosee_piedra(joyaDTO.isPosee_piedra());
            joya.setVentaONo(joyaDTO.isVentaONo());
            repo.save(joya);
        }catch(Exception e){
            throw new EntityNotFoundException(e.getMessage());
        }
        return joyaDTO;
    }


}