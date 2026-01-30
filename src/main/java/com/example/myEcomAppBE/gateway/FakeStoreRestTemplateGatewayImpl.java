package com.example.myEcomAppBE.gateway;

import com.example.myEcomAppBE.config.RetrofitBaseURL;
import com.example.myEcomAppBE.dto.FakeStoreProductDetailsDTO;
import com.example.myEcomAppBE.dto.FakeStoreProductsDTO;
import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.mapper.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGatewayImpl implements EComProductsGateway{
    private final RestTemplate restTemplate;

    private final RetrofitBaseURL retrofitBaseURL;

    FakeStoreRestTemplateGatewayImpl(RestTemplate restTemplate, RetrofitBaseURL retrofitBaseURL){
        this.restTemplate = restTemplate;
        this.retrofitBaseURL = retrofitBaseURL;

    }
    @Override
    public List<ProductsDTO> getAllProducts() throws IOException {
//        ResponseEntity<FakeStoreProductsDTO[]> responseEntity = this.restTemplate.getForEntity(retrofitBaseURL.getUrl() + "/products", FakeStoreProductsDTO[].class);
//        FakeStoreProductsDTO[] response = responseEntity.getBody();
//
//        if(response == null){
//            throw new IOException("Unable to fetch products from FakeStore API");
//        }
//        List<FakeStoreProductsDTO> responseList = Arrays.asList(response);
//        return ProductMapper.FakeStoreProductsDTOToProductsDTO(responseList);
        return null;
    }
    @Override
    public ProductDetailsDTO getProductById(Long id) throws Exception {
//        ResponseEntity<FakeStoreProductDetailsDTO>  responseEntity = this.restTemplate.getForEntity(retrofitBaseURL.getUrl() + "/products/" + id, FakeStoreProductDetailsDTO.class);
//        FakeStoreProductDetailsDTO response = responseEntity.getBody();
//        if(response == null){
//            throw new Exception("Failed to fetch this product");
//        }
//        return ProductMapper.FakeStoreProductDetailsDTOToProductDetailsDTO(response);

        return null;
    }
}
