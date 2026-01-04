package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.gateway.EComProductsGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{

    private final EComProductsGateway eComProductsGateway;

    ProductsServiceImpl(EComProductsGateway eComProductsGateway){
        this.eComProductsGateway = eComProductsGateway;
    }

    @Override
    public List<ProductsDTO> getAllProducts() throws IOException {
        return this.eComProductsGateway.getAllProducts();
    }
}
