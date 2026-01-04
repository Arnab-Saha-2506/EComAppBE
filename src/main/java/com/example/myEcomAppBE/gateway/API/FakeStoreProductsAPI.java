package com.example.myEcomAppBE.gateway.API;

import com.example.myEcomAppBE.dto.FakeStoreDTO;
import com.example.myEcomAppBE.dto.FakeStoreProductDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

public interface FakeStoreProductsAPI {
    @GET("/products")
    Call<List<FakeStoreDTO>> getAllProducts() throws IOException;

    @GET("/products/{id}")
    Call<FakeStoreProductDTO> getProductById(@Path("id") Long id) throws Exception;
}
