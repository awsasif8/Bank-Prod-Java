package com.ing.bank.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDescriptionResponseDto {

	
	private String message; 
	private int statusCode;
	private String status;
	private List<ProductDescriptionDto> data;
	
}
