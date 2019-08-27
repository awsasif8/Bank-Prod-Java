package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ing.bank.dto.UploadResonseDTO;
import com.ing.bank.service.FileServices;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class UploadFileController {
	
	@Autowired
	FileServices fileServices;
    
	@PostMapping("/uploadfile")
    public ResponseEntity<UploadResonseDTO> uploadMultipartFile(@RequestBody MultipartFile file) {
        return new ResponseEntity<>(fileServices.store(file),HttpStatus.OK);
    }
}