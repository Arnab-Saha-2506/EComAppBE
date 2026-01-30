package com.example.myEcomAppBE.mapper;

import com.example.myEcomAppBE.dto.CategoryDTO;
import com.example.myEcomAppBE.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toEntity(String categoryName){
        return CategoryEntity.builder()
                .name(categoryName)
                .build();
    }
    public static CategoryDTO toDTO(CategoryEntity categoryEntity){
        return CategoryDTO.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }
}
