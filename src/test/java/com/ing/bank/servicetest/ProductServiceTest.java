package com.ing.bank.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bank.dto.ProductNameDto;
import com.ing.bank.dto.ProductNameResponeDto;
import com.ing.bank.repository.ProductNameRepository;
import com.ing.bank.service.ProductNameServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductNameServiceImpl productService;
	
	@Mock
	ProductNameRepository productRepository;
	
	public ProductNameDto getProductNameDto()
	{
		ProductNameDto productName = new ProductNameDto();
		productName.setProductId(1);
		productName.setProductName("Test");
		return productName;
	}
	
	public ProductNameDto getProductNameDto1()
	{
		ProductNameDto productName = new ProductNameDto();
		productName.setProductId(2);
		productName.setProductName("Test2");
		return productName;
	}
	
	public ProductNameResponeDto getProductNameResponeDto()
	{
		ProductNameResponeDto productDto = new ProductNameResponeDto();
		List<ProductNameDto> getProducts = new ArrayList<ProductNameDto>();
		getProducts.add(getProductNameDto());
		getProducts.add(getProductNameDto1());
		productDto.setMessage("SUCCESS");
		productDto.setStatus("product name and id");
		productDto.setStatusCode(200);
		productDto.setData(getProducts);
		return productDto;
	}
	
	@Test
	public void productNamePositive()
	{
		Mockito.when(productRepository.findAll());
	}

}
