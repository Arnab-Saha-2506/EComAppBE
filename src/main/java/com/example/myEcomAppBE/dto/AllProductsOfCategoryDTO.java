package com.example.myEcomAppBE.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "CategoryId", "CategoryName", "Products", "totalProducts" })
public class AllProductsOfCategoryDTO {

    Long CategoryId;
    String CategoryName;
    List<String> Products;
    Integer totalProducts;
}
