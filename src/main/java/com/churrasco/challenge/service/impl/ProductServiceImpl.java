package com.churrasco.challenge.service.impl;

import com.churrasco.challenge.dto.ProductDTO;
import com.churrasco.challenge.entity.ProductEntity;
import com.churrasco.challenge.exception.EntityNotFoundException;
import com.churrasco.challenge.exception.ExceptionEnum;
import com.churrasco.challenge.mapper.ProductMapper;
import com.churrasco.challenge.repository.ProductRepository;
import com.churrasco.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductDTO getDetailsById(Integer id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionEnum.PRODUCTNOTFOUND.getMessage()));
        ProductDTO result = productMapper.entity2DTO(entity);
        return result;
    }

    public List<ProductDTO> getAll() {
        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> result = productMapper.entityList2DTOList(entities);
        return result;
    }

    public ProductDTO save(ProductDTO dto) {
        ProductEntity entitySaved = productRepository.save(productMapper.DTO2Entity(dto));
        ProductDTO result = productMapper.entity2DTO(entitySaved);
        return result;
    }

    public ProductDTO update(Integer id, ProductDTO dto) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionEnum.PRODUCTNOTFOUND.getMessage()));
        ProductEntity entityUpdated = productRepository.save(productMapper.updateDTO2Entity(entity, dto));
        ProductDTO result = productMapper.entity2DTO(entityUpdated);
        return result;
    }
}
