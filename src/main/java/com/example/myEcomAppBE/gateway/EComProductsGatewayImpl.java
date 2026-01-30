package com.example.myEcomAppBE.gateway;

import com.example.myEcomAppBE.dto.FakeStoreProductsDTO;
import com.example.myEcomAppBE.dto.FakeStoreProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductDetailsDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.gateway.API.FakeStoreProductsAPI;
import com.example.myEcomAppBE.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

//import static java.util.stream.Collectors.toList;

@Component("eComProductsGatewayImpl")
public class EComProductsGatewayImpl implements EComProductsGateway{

    private final FakeStoreProductsAPI fakeStoreProductsAPI;

    EComProductsGatewayImpl(FakeStoreProductsAPI fakeStoreProductsAPI){
        this.fakeStoreProductsAPI = fakeStoreProductsAPI;
    }

    @Override
    public List<ProductsDTO> getAllProducts() throws IOException{
//        List<FakeStoreProductsDTO> response = this.fakeStoreProductsAPI.getAllProducts().execute().body();
//        if(response == null){
//            throw new IOException("Failed to fetch products from FakeStore API");
//        }
//        return ProductMapper.FakeStoreProductsDTOToProductsDTO(response);

        return null;
    }

    @Override
    public ProductDetailsDTO getProductById(Long id) throws Exception {
//        FakeStoreProductDetailsDTO response = this.fakeStoreProductsAPI.getProductById(id).execute().body();
//        if(response == null) {
//            throw new Exception("Failed to fetch this product");
//        }
//        return ProductMapper.FakeStoreProductDetailsDTOToProductDetailsDTO(response);
        return null;
    }
}
