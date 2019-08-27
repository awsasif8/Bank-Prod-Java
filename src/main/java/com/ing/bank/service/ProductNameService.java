package com.ing.bank.service;

import org.springframework.stereotype.Service;

import com.ing.bank.dto.ProductDescriptionResponseDto;
import com.ing.bank.dto.ProductNameResponeDto;

@Service
public interface ProductNameService {

	public ProductNameResponeDto getProductNameList();
	
	public ProductDescriptionResponseDto getProductDescription(int productId);
	
}
