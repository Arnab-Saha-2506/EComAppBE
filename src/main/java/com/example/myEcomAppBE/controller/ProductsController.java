package com.example.myEcomAppBE.controller;

import com.example.myEcomAppBE.dto.FakeStoreAddProductDTO;
import com.example.myEcomAppBE.dto.ProductCategoryDTO;
import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping
    public ResponseEntity<ProductsDTO> addNewProduct(@RequestBody ProductsDTO dto) throws Exception{
//        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Adding new products is not supported at the moment");
        return ResponseEntity.ok(productsService.addNewProduct(dto));
    }


    @GetMapping("/{id}/blabla")
    public ResponseEntity<ProductsDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductsDTO result = this.productsService.getProductById(id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) throws Exception {
        productsService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
    //GetProductWithCategory


    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getProductWithCategory(@PathVariable Long id) throws Exception{
        ProductCategoryDTO response = productsService.getProductWithCategory(id);
        return ResponseEntity.ok().body(response);
    }
    //GetProductsByIDs
}
