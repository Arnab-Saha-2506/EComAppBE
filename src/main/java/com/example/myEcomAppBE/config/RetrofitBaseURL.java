package com.example.myEcomAppBE.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "retrofit-url")
public class RetrofitBaseURL {
    private String url;
}
