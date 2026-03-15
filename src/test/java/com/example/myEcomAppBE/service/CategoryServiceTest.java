package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.CategoryDTO;
import com.example.myEcomAppBE.entity.CategoryEntity;
import com.example.myEcomAppBE.repository.EComCategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private EComCategoryRepository eComCategoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    @DisplayName("Should return list of categories")
    void getCategoriesTest_shouldReturnCategories() throws Exception{
        //Arrange
        List<CategoryEntity> categories = new ArrayList<>();
        CategoryEntity category1 = CategoryEntity.builder()
                .name("Electronics")
                .build();
        category1.setId(1L);

        CategoryEntity category2 = CategoryEntity.builder()
                .name("Cosmetics")
                .build();
        category1.setId(2L);

        categories.add(category1);
        categories.add(category2);

        when(eComCategoryRepository.findAll()).thenReturn(categories);

        //Act
        List<CategoryDTO> resultList =  categoryService.getCategories();

        //Assert
        assertEquals(resultList.size(), 2);
    }
}
