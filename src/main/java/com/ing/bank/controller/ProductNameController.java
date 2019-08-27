package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.ProductDescriptionResponseDto;
import com.ing.bank.dto.ProductNameResponeDto;
import com.ing.bank.service.ProductNameService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductNameController {

	@Autowired
	ProductNameService productService;
	
	@GetMapping("/productnames")
	public ResponseEntity<ProductNameResponeDto> getProductNames()
	{
		return new ResponseEntity<ProductNameResponeDto>(productService.getProductNameList(),HttpStatus.OK);
	}
	
	@GetMapping("/productdescription/{productId}")
	public ResponseEntity<ProductDescriptionResponseDto> getProductDescription(@PathVariable("productId") int productId)
	{
		return new ResponseEntity<ProductDescriptionResponseDto>(productService.getProductDescription(productId),HttpStatus.OK);
	}
	
	
}
