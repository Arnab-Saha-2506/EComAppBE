package com.example.myEcomAppBE.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreDTO {
    private String id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
    private FakeStoreRatingDTO rating;
}
