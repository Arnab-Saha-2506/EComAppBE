package com.example.myEcomAppBE.mapper;

import com.example.myEcomAppBE.dto.FakeStoreProductDetailsDTO;
import com.example.myEcomAppBE.dto.FakeStoreProductsDTO;
import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;

import java.util.List;

public class ProductMapper {

    public static List<ProductsDTO> FakeStoreProductsDTOToProductsDTO(List<FakeStoreProductsDTO> response){
        return response.stream()
                .map(product -> ProductsDTO.builder()
                        .id(product.getId())
                        .title(product.getTitle())
                        .category(product.getCategory())
                        .build())
                .toList();
    }

    public static ProductDetailsDTO FakeStoreProductDetailsDTOToProductDetailsDTO(FakeStoreProductDetailsDTO response){
        return ProductDetailsDTO.builder()
                .id(response.getId())
                .title(response.getTitle())
                .price(response.getPrice())
                .description(response.getDescription())
                .category(response.getCategory())
                .build();

//        return null;
    }
}
