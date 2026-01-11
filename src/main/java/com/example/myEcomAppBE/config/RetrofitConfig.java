package com.example.myEcomAppBE.config;

import com.example.myEcomAppBE.gateway.API.FakeStoreProductsAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit(RetrofitBaseURL retrofitBaseURL){
        return new Retrofit.Builder()
                .baseUrl(retrofitBaseURL.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreProductsAPI fakeStoreProductsAPI(Retrofit retrofit){
        return retrofit.create(FakeStoreProductsAPI.class);
    }
}
