package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Service
public interface ProductsService {
    List<ProductsDTO> getAllProducts() throws IOException;
    ProductDetailsDTO getProductById(Long id) throws Exception;
}
