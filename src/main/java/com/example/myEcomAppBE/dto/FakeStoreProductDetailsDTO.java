package com.example.myEcomAppBE.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDetailsDTO {
	private String image;
	private Double price;
	private String description;
	private int id;
	private String title;
	private String category;
}