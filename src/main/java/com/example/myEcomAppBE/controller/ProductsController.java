package com.example.myEcomAppBE.controller;

import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
public class ProductsController {

    private final ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping("/api/products")
    public List<ProductsDTO> getAllProducts() throws IOException {
        //Fetches all products from the service layer
        return this.productsService.getAllProducts();
    }

}
