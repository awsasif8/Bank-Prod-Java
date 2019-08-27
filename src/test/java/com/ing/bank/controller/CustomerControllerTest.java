package com.ing.bank.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ing.bank.dto.InfoDetails;
import com.ing.bank.dto.InfoDto;
import com.ing.bank.service.CustomerInfoService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	@InjectMocks
CustomerInfoController customerInfoController;
	@Mock
	CustomerInfoService customerInfoService;
	
	@Test
	public void testInfo() {
		InfoDto infoDto = new InfoDto();
		infoDto.setAddress("Hyd");infoDto.setAge(25);infoDto.setEmail("sai@gmail.com");
		infoDto.setName("sai");
		infoDto.setPanCard("lkdjsflk");
		infoDto.setPhone(986798L);
		infoDto.setProductId(1);
		InfoDetails det = new InfoDetails();
		det.setStatusCode(200);
		det.setMessage("mail sent successfully");
		det.setStatusCode(200);
		det.setStatus("SUCCESS");
		
		Mockito.when(customerInfoService.custInfo(infoDto)).thenReturn(det);
		ResponseEntity entity=customerInfoController.info(infoDto);
		entity.getStatusCode();
		assertEquals(entity.getStatusCodeValue(),det.getStatusCode());
		
	}
}
