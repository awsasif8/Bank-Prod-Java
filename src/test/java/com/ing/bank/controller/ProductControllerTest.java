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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ing.bank.dto.Analysis;
import com.ing.bank.dto.ProductDescriptionDto;
import com.ing.bank.dto.ProductDescriptionResponseDto;
import com.ing.bank.dto.ProductNameDto;
import com.ing.bank.dto.ProductNameResponeDto;
import com.ing.bank.service.ProductNameServiceImpl;
import com.ing.bank.service.ProductService;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, ProductController.class })
@WebAppConfiguration
public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;
	
	@InjectMocks
	ProductNameController productName;
	
	@Mock
	private ProductService productService;
	
	@Mock
	ProductNameServiceImpl productServiceImpl;

	private MockMvc mockMvc;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void Analysistest() {
		Analysis an=new Analysis(1, "Insurance", 3);
		List<Analysis> analysis=new ArrayList<>();
		analysis.add(an);
		ResponseEntity<List<Analysis>> expResult = new ResponseEntity<>(analysis, HttpStatus.OK);
		when(productService.analysis(Mockito.anyString())).thenReturn(analysis);
	
		ResponseEntity<List<Analysis>> actResult = productController.analysis("day");
		assertEquals(expResult, actResult);
		
	}
	
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
	
	
	@Test
	public void productNamesTest() throws Exception
	{
		ResponseEntity<ProductNameResponeDto> expResult = new ResponseEntity<ProductNameResponeDto>(getProductNameResponeDto(), HttpStatus.OK);
        when(productServiceImpl.getProductNameList()).thenReturn(getProductNameResponeDto());
        ResponseEntity<ProductNameResponeDto> actResult = productName.getProductNames();
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}
	
	@Test
	public void productDescriptionTest() throws Exception
	{
		ResponseEntity<ProductDescriptionResponseDto> expResult = new ResponseEntity<ProductDescriptionResponseDto>(getProductDescriptionResponse(), HttpStatus.OK);
        when(productServiceImpl.getProductDescription(Mockito.anyInt())).thenReturn(getProductDescriptionResponse());
        ResponseEntity<ProductDescriptionResponseDto> actResult = productName.getProductDescription(Mockito.anyInt());
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}
	

}
