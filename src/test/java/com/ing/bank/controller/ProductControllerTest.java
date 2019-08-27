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
import com.ing.bank.service.ProductService;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, ProductController.class })
@WebAppConfiguration
public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;
	@Mock
	private ProductService productService;

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

}
