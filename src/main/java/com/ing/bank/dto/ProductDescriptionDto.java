package com.ing.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDescriptionDto {
	
	private int productId;
	private String productName;
	private String productDescription;
	private String productType;
	private Double productPrice;

}
