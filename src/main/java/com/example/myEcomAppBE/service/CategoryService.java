package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategories() throws Exception;
    CategoryDTO addCategory(String categoryName) throws Exception;
    void deleteCategoryById(Long id) throws Exception;
    CategoryDTO getCategoryById(Long id) throws Exception;
}
