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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        verify(eComCategoryRepository, times(1)).findAll();
        assertEquals(resultList.get(0).getName(), "Electronics");
    }

    @Test
    void addCategoryTest_shouldAddCategory() throws Exception{
        //Arrange
        CategoryEntity category1 = CategoryEntity.builder()
                .name("Sports")
                .build();
        category1.setId(1L);

        String categoryName = "Sports";

        when(eComCategoryRepository.save(any(CategoryEntity.class))).thenReturn(category1);

        //Act
        CategoryDTO resultDTO = categoryService.addCategory(categoryName);

        //Assert
        assertEquals(resultDTO.getName(), "Sports");
        verify(eComCategoryRepository, times(1)).save(any(CategoryEntity.class));
    }

    @Test
    void getCategoryByName_shouldReturnCategoryByName() throws Exception{
        //Arrange
        CategoryEntity category1 = CategoryEntity.builder()
                .name("Sports")
                .build();
        category1.setId(1L);

        when(eComCategoryRepository.findByName(anyString())).thenReturn(Optional.of(category1));

        //Act
        CategoryDTO resultDTO = categoryService.getCategoryByName("sports");

        //Assert
        assertEquals(resultDTO.getName(), "Sports");
        verify(eComCategoryRepository, times(1)).findByName(anyString());
    }
}
