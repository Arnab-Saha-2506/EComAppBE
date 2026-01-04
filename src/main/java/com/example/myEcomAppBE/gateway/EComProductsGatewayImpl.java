package com.example.myEcomAppBE.gateway;

import com.example.myEcomAppBE.dto.FakeStoreDTO;
import com.example.myEcomAppBE.dto.ProductsDTO;
import com.example.myEcomAppBE.gateway.API.FakeStoreProductsAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

//import static java.util.stream.Collectors.toList;

@Component
public class EComProductsGatewayImpl implements EComProductsGateway{

    private final FakeStoreProductsAPI fakeStoreProductsAPI;

    EComProductsGatewayImpl(FakeStoreProductsAPI fakeStoreProductsAPI){
        this.fakeStoreProductsAPI = fakeStoreProductsAPI;
    }

    @Override
    public List<ProductsDTO> getAllProducts() throws IOException{
//        FakeStoreDTO response = this.fakeStoreProductsAPI.getAllProducts().execute().body();
        List<FakeStoreDTO> response = this.fakeStoreProductsAPI.getAllProducts().execute().body();
        if(response == null){
            throw new IOException("Failed to fetch products from FakeStore API");
        }
        return response.stream()
                .map(product -> ProductsDTO.builder()
                        .id(product.getId())
                        .title(product.getTitle())
                        .category(product.getCategory())
                        .build())
                .toList();
    }
}
