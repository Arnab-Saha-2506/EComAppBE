package com.example.myEcomAppBE.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategoryDTO {
    private Long id;
    private String title;
    private String price;
    private String brand;
    private String description;
    private String discountPercentage;
    private String color;
    private boolean popular;
    private String image;
    private CategoryDTO category;
}
