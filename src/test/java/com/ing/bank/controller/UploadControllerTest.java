package com.ing.bank.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ing.bank.dto.UploadResonseDTO;
import com.ing.bank.service.FileServices;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, UploadFileController.class })
@WebAppConfiguration
public class UploadControllerTest {
	@InjectMocks
	private UploadFileController uploadController;
	@Mock
	private FileServices fileService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(uploadController).build();
	}
	
	@Test
	public void uploadFileTest() throws JsonProcessingException, Exception {
		UploadResonseDTO resDTO = new UploadResonseDTO();
		resDTO.setMessage("File Uploaded Successfully");
		resDTO.setStatus("SUCCESS");
		resDTO.setStatusCode(HttpStatus.OK.value());
		
		MultipartFile file = null;
		ResponseEntity<UploadResonseDTO> expResult = new ResponseEntity<>(resDTO, HttpStatus.OK);
		when(fileService.store(Mockito.anyObject())).thenReturn(resDTO);
		ResponseEntity<UploadResonseDTO> actResult = uploadController.uploadMultipartFile(file);
		assertEquals(expResult, actResult);
	}
}
