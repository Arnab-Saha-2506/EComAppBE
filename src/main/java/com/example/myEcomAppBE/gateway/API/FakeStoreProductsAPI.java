package com.example.myEcomAppBE.gateway.API;

import com.example.myEcomAppBE.dto.FakeStoreProductsDTO;
import com.example.myEcomAppBE.dto.FakeStoreProductDetailsDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

public interface FakeStoreProductsAPI {
    @GET("/products")
    Call<List<FakeStoreProductsDTO>> getAllProducts() throws IOException;

    @GET("/products/{id}")
    Call<FakeStoreProductDetailsDTO> getProductById(@Path("id") Long id) throws Exception;
}
