package com.example.myEcomAppBE.service;

import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.entity.ProductEntity;
import com.example.myEcomAppBE.gateway.EComProductsGateway;
import com.example.myEcomAppBE.mapper.ProductMapper;
import com.example.myEcomAppBE.repository.EComProductsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{

//    private final EComProductsGateway eComProductsGateway;
    private final EComProductsRepository repository;

//    ProductsServiceImpl(@Qualifier("eComProductsGatewayImpl") EComProductsGateway eComProductsGateway){
//        this.eComProductsGateway = eComProductsGateway;
//    }

    ProductsServiceImpl(EComProductsRepository repository){
        this.repository = repository;
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
            if(ListResponse.isEmpty()){
                throw new Exception("No products found in the database");
            }
            return ListResponse.stream()
                    .map(ProductMapper::toDto)
                    .toList();
        }
        catch (Exception e){
            throw new IOException("Failed to fetch products from the database");
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
    public ProductsDTO addNewProduct(ProductsDTO dto){
        ProductEntity response = repository.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(response);
    }
}
