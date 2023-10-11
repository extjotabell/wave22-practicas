package com.example.showroom.service;

import com.example.showroom.dto.ClothesDTO;
import com.example.showroom.dto.OutDTO;
import com.example.showroom.entity.Clothes;
import com.example.showroom.repository.IShowroomRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowroomServiceImp implements IShowroomService{

    IShowroomRepository showroomRepository;
    @Override
    public OutDTO createClothes(ClothesDTO clothesDTO) {
        Clothes clothes = toEntity(clothesDTO);
        showroomRepository.save(toEntity(clothesDTO));
        return new OutDTO("Save successfully");
    }

    @Override
    public List<ClothesDTO> getClothes() {
        List<Clothes> clothes = showroomRepository.findAll();
        return clothes.stream().map(c->toDTO(c)).collect(Collectors.toList());
    }

    @Override
    public ClothesDTO getClothesByCode(String code) {
        return toDTO(showroomRepository.findByCode(code));
    }

    @Override
    public OutDTO updateClothesByCode(ClothesDTO clothesDTO,String code) {
        Clothes clothes = showroomRepository.findByCode(code);
        clothesDTO.setId(clothes.getId());
        showroomRepository.save(toEntity(clothesDTO));
        return new OutDTO("Update successfully");
    }

    @Override
    public OutDTO deleteClothesByCode(String code) {
        showroomRepository.deleteByCode(code);
        return new OutDTO("Delete successfully");
    }

    @Override
    public List<ClothesDTO> getClothesBySize(String size) {
        List<Clothes> clothes = showroomRepository.findAllBySize(size);
        return clothes.stream().map(c->toDTO(c)).collect(Collectors.toList());
    }

    private ClothesDTO toDTO(Clothes clothes){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(clothes, ClothesDTO.class);

    }
    private Clothes toEntity(ClothesDTO clothes){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(clothes, Clothes.class);

    }
}
