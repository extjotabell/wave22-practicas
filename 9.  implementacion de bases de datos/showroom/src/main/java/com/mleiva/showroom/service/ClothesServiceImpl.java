package com.mleiva.showroom.service;

import com.mleiva.showroom.entity.Clothes;
import com.mleiva.showroom.entity.dto.ClothesDto;
import com.mleiva.showroom.entity.dto.RespClothesDto;
import com.mleiva.showroom.exception.NotFoundException;
import com.mleiva.showroom.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements IClothesService{

    @Autowired
    IClothesRepository repository;

    ModelMapper mapper = new ModelMapper();
    @Override
    @Transactional(readOnly = true)
    public List<ClothesDto> buscarTodos() {
        return repository.findAll().stream().map(clothes -> mapper.map(clothes, ClothesDto.class)).toList();
    }

    @Override
    @Transactional
    public RespClothesDto saveClothes(ClothesDto clothesDto) {
        Clothes clothes = mapper.map(clothesDto, Clothes.class);
        repository.save(clothes);
        return new RespClothesDto(clothesDto,"guardado con éxito.");
    }

    @Override
    @Transactional
    public RespClothesDto deleteClothes(Long id) {
        Clothes clothes = repository.findById(id).orElse(null);
        if (clothes == null){
            throw new NotFoundException("Esta prenda no se encuentra en la base de datos");
        }
        repository.deleteById(id);
        RespClothesDto resp = new RespClothesDto();
        resp.setMensaje("borrado exitoso");
        return resp;
    }

    @Override
    @Transactional(readOnly = true)
    public ClothesDto findById(Long id) {
        Clothes clothes = repository.findById(id).orElse(null);
        if (clothes == null){
            throw new NotFoundException("Esta prenda no se encuentra en la base de datos");
        }
        return mapper.map(clothes, ClothesDto.class);
    }

    @Override
    @Transactional
    public Long actualizar(long id, ClothesDto clothesDto) {
        Optional<Clothes> optionalClothes = repository.findById(id); //Utilizamos Optional para manejar la posibilidad de que no se encuentre una prenda con el ID especificado en el repositorio.
        // Usamos ifPresent() para ejecutar el código de actualización solo si se encuentra una prenda con el ID proporcionado.
        optionalClothes.ifPresent(clothes -> {
            Clothes actualizarClothes = mapper.map(clothesDto, Clothes.class);
            actualizarClothes.setCodigo(clothes.getCodigo());
            repository.save(actualizarClothes);
        });

        return optionalClothes.map(Clothes::getCodigo).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothesDto> findAllBySize(String size) {
        List<Clothes> clothesList = repository.findAllByTalle(size);
        if (clothesList == null){
            throw new NotFoundException("No hay prendas con ese talle");
        }
        return clothesList.stream().map(clothes -> mapper.map(clothes,ClothesDto.class)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothesDto> findAllByNameContaining(String name) {
        List<Clothes> clothesList = repository.findAllByNombreContainingIgnoreCase(name);
        if (clothesList == null){
            throw new NotFoundException("No hay prendas con ese nombre");
        }
        return clothesList.stream().map(clothes -> mapper.map(clothes,ClothesDto.class)).toList();
    }
}
