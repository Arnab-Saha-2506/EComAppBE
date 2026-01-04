package com.example.myEcomAppBE.gateway;

import com.example.myEcomAppBE.dto.ProductsDTO;

import java.io.IOException;
import java.util.List;

public interface EComProductsGateway {
    List<ProductsDTO> getAllProducts() throws IOException;
}
