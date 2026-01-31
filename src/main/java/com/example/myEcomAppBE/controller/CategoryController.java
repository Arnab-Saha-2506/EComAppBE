package com.example.myEcomAppBE.controller;

import com.example.myEcomAppBE.dto.AllProductsOfCategoryDTO;
import com.example.myEcomAppBE.dto.CategoryDTO;
import com.example.myEcomAppBE.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() throws Exception{
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody String categoryName) throws Exception{
        CategoryDTO response = categoryService.addCategory(categoryName);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) throws Exception{
        CategoryDTO response = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) throws Exception{
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }

    //GetAllProductsOfCategory
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable Long categoryId) throws Exception{
        AllProductsOfCategoryDTO response = categoryService.getAllProductsOfCategory(categoryId);
        return ResponseEntity.ok().body(response);
    }

}
