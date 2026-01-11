package com.example.myEcomAppBE.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreProductsDTO {
    private String id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
    private FakeStoreRatingDTO rating;
}
