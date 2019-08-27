package com.ing.bank.servicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bank.dto.ProductDescriptionResponseDto;
import com.ing.bank.dto.ProductNameDto;
import com.ing.bank.dto.ProductNameResponeDto;
import com.ing.bank.entity.Product;
import com.ing.bank.repository.ProductNameRepository;
import com.ing.bank.service.ProductNameServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductNameServiceImpl productService;
	
	@Mock
	ProductNameRepository productRepository;
	
	public Product getProduct()
	{
		Product product = new Product();
		product.setProductDescription("Test for this type");
		product.setProductId(1);
		product.setProductName("Test");
		product.setProductType("Insurance");
		return product;
	}
	
	public Product getProduct1()
	{
		Product product = new Product();
		product.setProductDescription("Test for this type");
		product.setProductId(2);
		product.setProductName("Test2");
		product.setProductType("Health Insurance");
		return product;
	}
	
	
	@Test
	public void productNamePositive()
	{
		List<Product> addProducts = new ArrayList<Product>();
		addProducts.add(getProduct());
		addProducts.add(getProduct1());
		Mockito.when(productRepository.findAll()).thenReturn(addProducts);
		ProductNameResponeDto productName = productService.getProductNameList();
		Assert.assertEquals(200, productName.getStatusCode());
	}
	
	@Test
	public void productDescription()
	{
		Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getProduct()));
		ProductDescriptionResponseDto productDescription = productService.getProductDescription(Mockito.anyInt());
		Assert.assertEquals(200, productDescription.getStatusCode());
		
	}

}
