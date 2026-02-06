package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.AllProductsOfCategoryDTO;
import com.example.myEcomAppBE.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategories() throws Exception;
    CategoryDTO addCategory(String categoryName) throws Exception;
    void deleteCategoryById(Long id) throws Exception;
    CategoryDTO getCategoryById(Long id) throws Exception;
    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception;
    CategoryDTO getCategoryByName(String name)  throws Exception;
}
