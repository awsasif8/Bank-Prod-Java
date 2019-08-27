package com.ing.bank.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analysis {
	
	private Integer productId;
	private String productName;
	private Integer count;
}
