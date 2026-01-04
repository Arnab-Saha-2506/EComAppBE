package com.example.myEcomAppBE.controller;

import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<List<ProductsDTO>> getAllProducts() throws IOException {
        //Fetches all products from the service layer
        List<ProductsDTO> result = this.productsService.getAllProducts();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailsDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductDetailsDTO result = this.productsService.getProductById(id);
        return ResponseEntity.ok().body(result);
    }

}
