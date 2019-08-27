package com.ing.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.ProductDescriptionDto;
import com.ing.bank.dto.ProductDescriptionResponseDto;
import com.ing.bank.dto.ProductNameDto;
import com.ing.bank.dto.ProductNameResponeDto;
import com.ing.bank.entity.Product;
import com.ing.bank.repository.ProductNameRepository;

@Service
public class ProductNameServiceImpl implements ProductNameService {

	@Autowired
	ProductNameRepository productRepository;
	
	public ProductNameResponeDto getProductNameList() {
		
		List<Product> productNameList = productRepository.findAll();
		List<ProductNameDto> productDto = new ArrayList<ProductNameDto>();
		ProductNameResponeDto productNameResponse = new ProductNameResponeDto();
		
		for(int i =0;i<productNameList.size();i++)
		{
			ProductNameDto productName = new ProductNameDto();
			productName.setProductId(productNameList.get(i).getProductId());
			productName.setProductName(productNameList.get(i).getProductName());
			productDto.add(productName);
		}
		
		productNameResponse.setStatus("SUCCESS");
		productNameResponse.setMessage("product name and id");
		productNameResponse.setStatusCode(200);
		productNameResponse.setData(productDto);
		return productNameResponse;
	}

	
	public ProductDescriptionResponseDto getProductDescription(int productId) {
	
		
		Optional<Product> productDescription = productRepository.findById(productId);
		ProductDescriptionResponseDto productResponse = new ProductDescriptionResponseDto();
		ProductDescriptionDto productDto = new ProductDescriptionDto();
		List<ProductDescriptionDto> listOfData = new ArrayList<ProductDescriptionDto>();
		
		if(productDescription.isPresent())
		{
			productDto.setProductDescription(productDescription.get().getProductDescription());
			productDto.setProductId(productDescription.get().getProductId());
			productDto.setProductName(productDescription.get().getProductName());
			productDto.setProductPrice(productDescription.get().getProductPrice());
			productDto.setProductType(productDescription.get().getProductType());
		}
		
		listOfData.add(productDto);
		productResponse.setMessage("Product Description for specific project id");
		productResponse.setStatus("SUCCESS");
		productResponse.setStatusCode(200);
		productResponse.setData(listOfData);
		
		return productResponse;
	}

	
	
}
