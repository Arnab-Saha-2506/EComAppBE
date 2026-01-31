package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.AllProductsOfCategoryDTO;
import com.example.myEcomAppBE.dto.CategoryDTO;
import com.example.myEcomAppBE.entity.CategoryEntity;
import com.example.myEcomAppBE.mapper.CategoryMapper;
import com.example.myEcomAppBE.mapper.GetAllProductsOfCategoryMapper;
import com.example.myEcomAppBE.repository.EComCategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final EComCategoryRepository eComCategoryRepository;

    public CategoryServiceImpl(EComCategoryRepository eComCategoryRepository) {
        this.eComCategoryRepository = eComCategoryRepository;
    }

    @Override
    public List<CategoryDTO> getCategories() throws Exception {
        try{
            List<CategoryEntity> ListResponse = eComCategoryRepository.findAll();
            return ListResponse.stream()
                    .map(CategoryMapper::toDTO)
                    .toList();
        }
        catch (Exception e){
            throw new IOException("Failed to fetch products from the database", e);
        }
    }

    @Override
    public CategoryDTO addCategory(String categoryName) throws Exception {
        try{
            CategoryEntity response = eComCategoryRepository.save(CategoryMapper.toEntity(categoryName));
            return CategoryMapper.toDTO(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategoryById(Long id) throws Exception {
        try{
            eComCategoryRepository.deleteById(id);
        }
        catch(Exception e) {
            throw new Exception("Category not found with id: " + id);
        }
    }

    @Override
    public CategoryDTO getCategoryById(Long id) throws Exception {
        try{
            CategoryEntity response = eComCategoryRepository.getReferenceById(id);
            return CategoryMapper.toDTO(response);
        }
        catch (Exception e) {
            throw new Exception("Category not found with id: " + id);
        }
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception{
        CategoryEntity entity = eComCategoryRepository.getReferenceById(categoryId);
        return GetAllProductsOfCategoryMapper.toDTO(entity);

//        return null;
    }
}
