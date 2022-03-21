package com.churrasco.challenge.mapper;

import com.churrasco.challenge.dto.ProductDTO;
import com.churrasco.challenge.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public ProductDTO entity2DTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setSKU(entity.getSKU());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPicture(entity.getPicture());
        dto.setPrice(entity.getPrice());
        dto.setCurrency(entity.getCurrency());
        return dto;
    }

    public ProductEntity DTO2Entity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setSKU(dto.getSKU());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPicture(dto.getPicture());
        entity.setPrice(dto.getPrice());
        entity.setCurrency(dto.getCurrency());
        return entity;
    }

    public List<ProductDTO> entityList2DTOList(List<ProductEntity> entities){
        List<ProductDTO> dtos = new ArrayList<>();
        for (ProductEntity entity : entities) {
            dtos.add(entity2DTO(entity));
        }
        return dtos;
    }

    public ProductEntity updateDTO2Entity(ProductEntity entity, ProductDTO dto) {
        entity.setSKU(dto.getSKU());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPicture(dto.getPicture());
        entity.setPrice(dto.getPrice());
        entity.setCurrency(dto.getCurrency());
        return entity;
    }

}
