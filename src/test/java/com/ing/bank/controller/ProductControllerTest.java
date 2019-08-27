package com.ing.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ing.bank.dto.ProductDescriptionDto;
import com.ing.bank.dto.ProductDescriptionResponseDto;
import com.ing.bank.dto.ProductNameDto;
import com.ing.bank.dto.ProductNameResponeDto;
import com.ing.bank.service.ProductNameService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ProductControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	ProductNameService productService;
	
	@InjectMocks
	ProductNameController productController;
	
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
	
	public ProductDescriptionDto getProductDescriptionDto()
	{
		ProductDescriptionDto productDescription = new ProductDescriptionDto();
		productDescription.setProductDescription("Test2");
		productDescription.setProductId(1);
		productDescription.setProductName("test");
		productDescription.setProductType("Insurance");
		return productDescription;
	}
	
	public ProductDescriptionResponseDto getProductDescriptionResponse()
	{		
		ProductDescriptionResponseDto productResponse = new ProductDescriptionResponseDto();
		List<ProductDescriptionDto> productDetails = new ArrayList<ProductDescriptionDto>();
		productDetails.add(getProductDescriptionDto());
		productResponse.setMessage("Product Description for specific project id");
		productResponse.setStatus("SUCCESS");
		productResponse.setStatusCode(200);
		productResponse.setData(productDetails);
		return productResponse;
	}
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }
	
	
	@Test
	public void productNamesTest() throws Exception
	{
		ResponseEntity<ProductNameResponeDto> expResult = new ResponseEntity<ProductNameResponeDto>(getProductNameResponeDto(), HttpStatus.OK);
        when(productService.getProductNameList()).thenReturn(getProductNameResponeDto());
        ResponseEntity<ProductNameResponeDto> actResult = productController.getProductNames();
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}
	
	@Test
	public void productDescriptionTest() throws Exception
	{
		ResponseEntity<ProductDescriptionResponseDto> expResult = new ResponseEntity<ProductDescriptionResponseDto>(getProductDescriptionResponse(), HttpStatus.OK);
        when(productService.getProductDescription(Mockito.anyInt())).thenReturn(getProductDescriptionResponse());
        ResponseEntity<ProductDescriptionResponseDto> actResult = productController.getProductDescription(Mockito.anyInt());
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}
	

}
