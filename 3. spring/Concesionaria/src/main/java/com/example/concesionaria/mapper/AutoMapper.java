package com.example.concesionaria.mapper;

import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.entity.Auto;
import org.springframework.stereotype.Component;
import com.example.concesionaria.dto.AutoServiceDTO;

@Component
public class AutoMapper {

    public Auto toEntity(AutoServiceDTO autoServiceDTO){
        return Auto.builder()
                .id(autoServiceDTO.getId())
                .brand(autoServiceDTO.getBrand())
                .model(autoServiceDTO.getModel())
                .services(autoServiceDTO.getServices())
                .countOfOwners(autoServiceDTO.getCountOfOwners())
                .currency(autoServiceDTO.getCurrency())
                .door(autoServiceDTO.getDoor())
                .manufacturingDate(autoServiceDTO.getManufacturingDate())
                .price(autoServiceDTO.getPrice())
                .build();
    }

    public AutoDTO toDTO(Auto auto){
        return AutoDTO.builder()
                .id(auto.getId())
                .brand(auto.getBrand())
                .model(auto.getModel())
                .countOfOwners(auto.getCountOfOwners())
                .currency(auto.getCurrency())
                .door(auto.getDoor())
                .manufacturingDate(auto.getManufacturingDate())
                .price(auto.getPrice())
                .build();
    }
    public AutoServiceDTO toDTOService(Auto auto){
        return AutoServiceDTO.builder()
                .id(auto.getId())
                .brand(auto.getBrand())
                .model(auto.getModel())
                .countOfOwners(auto.getCountOfOwners())
                .currency(auto.getCurrency())
                .door(auto.getDoor())
                .manufacturingDate(auto.getManufacturingDate())
                .price(auto.getPrice())
                .services(auto.getServices())
                .build();
    }
}
