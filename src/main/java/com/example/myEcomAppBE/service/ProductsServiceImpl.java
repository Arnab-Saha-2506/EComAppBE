package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.ProductCategoryDTO;
import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.entity.CategoryEntity;
import com.example.myEcomAppBE.entity.ProductEntity;
import com.example.myEcomAppBE.exception.ProductNotFoundException;
import com.example.myEcomAppBE.gateway.EComProductsGateway;
import com.example.myEcomAppBE.mapper.ProductMapper;
import com.example.myEcomAppBE.repository.EComCategoryRepository;
import com.example.myEcomAppBE.repository.EComProductsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{

//    private final EComProductsGateway eComProductsGateway;
    private final EComProductsRepository repository;
    private final EComCategoryRepository categoryRepository;
//    ProductsServiceImpl(@Qualifier("eComProductsGatewayImpl") EComProductsGateway eComProductsGateway){
//        this.eComProductsGateway = eComProductsGateway;
//    }

    ProductsServiceImpl(EComProductsRepository repository, EComCategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
//    public List<ProductsDTO> getAllProducts() throws IOException {
//        return this.eComProductsGateway.getAllProducts();
//    }
    public List<ProductsDTO> getAllProducts() throws IOException {
//        return this.eComProductsGateway.getAllProducts();
//        return null;
        try{
            List<ProductEntity> ListResponse = repository.findAll();
            return ListResponse.stream()
                    .map(ProductMapper::toDto)
                    .toList();
        }
        catch (Exception e){
            throw new IOException("Failed to fetch products from the database", e);
        }
    }


    @Override
    public ProductsDTO getProductById(Long id) throws Exception {
//        return this.eComProductsGateway.getProductById(id);

        try{
            ProductEntity response = repository.getReferenceById(id);
            return ProductMapper.toDto(response);
        }
        catch (Exception e) {
            throw new Exception("Product not found with id: " + id);
        }
    }

    @Override
    public ProductsDTO addNewProduct(ProductsDTO dto) throws Exception {
        try {
            CategoryEntity category = categoryRepository.getReferenceById(dto.getCategoryId());
            ProductEntity response = repository.save(ProductMapper.toEntity(dto, category));
            return ProductMapper.toDto(response);
        } catch (Exception e) {
                throw new Exception("Category not found with id: " + dto.getCategoryId());
        }
    }

    @Override
    public void deleteProductById(Long id) throws Exception {
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Product not found with id: " + id);
        }
    }

    @Override
    public ProductCategoryDTO getProductWithCategory(Long id) throws Exception{
        try{
            ProductEntity entity = repository.getReferenceById(id);
            return ProductMapper.toDtoWithCategory(entity);
//            return null;
        } catch (Exception e) {
            throw new ProductNotFoundException("Couldn't find any product with id: "+id);
        }
    }

    @Override
    public List<ProductsDTO> getCheapProducts(int upperLimit) throws Exception{
        try {
            List<ProductEntity> productLists = repository.findByPriceLessThanEqual(upperLimit);
            if(productLists.isEmpty()){
                throw new Exception("No products found with price less than or equal to: " + upperLimit);
            }
            return productLists.stream()
                    .map(ProductMapper::toDto)
                    .toList();
        } catch (Exception e) {
            throw new Exception(e);
        }
//        return null;
    }
}
