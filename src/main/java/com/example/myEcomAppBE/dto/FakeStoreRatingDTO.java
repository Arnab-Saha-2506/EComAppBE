package com.example.myEcomAppBE.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreRatingDTO {
    private double rate;
    private int count;
}
