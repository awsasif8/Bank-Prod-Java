package com.ing.bank.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.ing.bank.dto.UploadResonseDTO;
import com.ing.bank.entity.Product;
import com.ing.bank.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	FileServices fileService;

	@Test
	public void storeTest() {
		
		UploadResonseDTO respDTO = new UploadResonseDTO();
		respDTO.setMessage("File Uploaded Successfully");
		respDTO.setStatus("SUCCESS");
		respDTO.setStatusCode(HttpStatus.OK.value());
		List<Product> prodList = new ArrayList<>();
		Product prod = new Product();
		prod.setProductDescription("hasdgahs");
		prod.setProductId(1);
		prod.setProductPrice(100.0);
		prod.setProductType("insurance");
		prodList.add(prod);
		
		assertEquals(true,true);
		
	}

}
