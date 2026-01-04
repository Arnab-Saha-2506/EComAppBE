package com.example.myEcomAppBE.gateway.API;

import com.example.myEcomAppBE.dto.FakeStoreDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreProductsAPI {
    @GET("/products")
    Call<List<FakeStoreDTO>> getAllProducts();
}
