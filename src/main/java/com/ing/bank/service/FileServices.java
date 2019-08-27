package com.ing.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ing.bank.dto.UploadResonseDTO;
import com.ing.bank.entity.Product;
import com.ing.bank.exception.ProductException;
import com.ing.bank.repository.ProductRepository;
import com.ing.bank.util.ExcelUtils;

@Service
public class FileServices {

	@Autowired
	ProductRepository productRepository;

	public UploadResonseDTO store(MultipartFile file) {
		List<Product> lstCustomers;
		try {
			lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
			if (!lstCustomers.isEmpty()) {
				UploadResonseDTO respDTO = new UploadResonseDTO();
				respDTO.setMessage("File Uploaded Successfully");
				respDTO.setStatus("SUCCESS");
				respDTO.setStatusCode(HttpStatus.OK.value());

				productRepository.deleteAll();
				productRepository.saveAll(lstCustomers);
				return respDTO;
			} else {
				throw new ProductException("File is empty");
			}
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
	}
}
