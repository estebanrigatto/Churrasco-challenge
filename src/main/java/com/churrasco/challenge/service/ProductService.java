package com.churrasco.challenge.service;

import com.churrasco.challenge.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO getDetailsById(Integer id);

    List<ProductDTO> getAll();

    ProductDTO save(ProductDTO dto);

    ProductDTO update(Integer id, ProductDTO dto);

}
