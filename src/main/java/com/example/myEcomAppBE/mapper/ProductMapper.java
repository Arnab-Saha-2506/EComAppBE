package com.example.myEcomAppBE.mapper;

import com.example.myEcomAppBE.dto.FakeStoreProductDetailsDTO;
import com.example.myEcomAppBE.dto.FakeStoreProductsDTO;
import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.entity.CategoryEntity;
import com.example.myEcomAppBE.entity.ProductEntity;

import java.util.List;

public class ProductMapper {

//    public static List<ProductsDTO> FakeStoreProductsDTOToProductsDTO(List<FakeStoreProductsDTO> response){
//        return response.stream()
//                .map(product -> ProductsDTO.builder()
//                        .id(product.getId())
//                        .title(product.getTitle())
//                        .category(product.getCategory())
//                        .build())
//                .toList();
//    }

//    public static ProductDetailsDTO FakeStoreProductDetailsDTOToProductDetailsDTO(FakeStoreProductDetailsDTO response){
//        return ProductDetailsDTO.builder()
//                .id(response.getId())
//                .title(response.getTitle())
//                .price(response.getPrice())
//                .description(response.getDescription())
//                .category(response.getCategory())
//                .build();
//
////        return null;
//    }

    public static ProductEntity toEntity(ProductsDTO dto, CategoryEntity category){
        return ProductEntity.builder()
                .title(dto.getTitle())
                .price(dto.getPrice())
                .brand(dto.getBrand())
                .description(dto.getDescription())
                .discountPercentage(dto.getDiscountPercentage())
                .color(dto.getColor())
                .popular(dto.isPopular())
                .category(category)
                .image(dto.getImage())
                .build();
    }

    public static ProductsDTO toDto(ProductEntity entity){
        return ProductsDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .brand(entity.getBrand())
                .description(entity.getDescription())
                .discountPercentage(entity.getDiscountPercentage())
                .color(entity.getColor())
                .popular(entity.isPopular())
                .categoryId(entity.getCategory().getId())
                .image(entity.getImage())
                .build();
    }
}
