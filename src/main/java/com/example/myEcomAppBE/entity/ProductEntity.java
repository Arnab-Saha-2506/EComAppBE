package com.example.myEcomAppBE.entity;

import com.example.myEcomAppBE.dto.FakeStoreRatingDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity extends BaseEntity{
//    private Long id;
    private String title;
    private String price;
    private String brand;
    private String description;
    private String discountPercentage;
    private String color;
    private boolean popular;
    private String image;
//    private FakeStoreRatingDTO rating;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity category;
}
