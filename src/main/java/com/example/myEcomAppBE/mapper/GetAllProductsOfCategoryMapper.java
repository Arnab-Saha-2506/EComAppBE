package com.example.myEcomAppBE.mapper;

import com.example.myEcomAppBE.dto.AllProductsOfCategoryDTO;
import com.example.myEcomAppBE.entity.CategoryEntity;
import com.example.myEcomAppBE.entity.ProductEntity;

public class GetAllProductsOfCategoryMapper {
    public static AllProductsOfCategoryDTO toDTO(CategoryEntity entity){
        return AllProductsOfCategoryDTO.builder()
                .CategoryId(entity.getId())
                .CategoryName(entity.getName())
                .Products(entity.getProducts().stream()
                        .map(ProductEntity::getTitle)
                        .toList())
                .totalProducts(entity.getProducts().size())
                .build();

//        return null;
    }
}
