package com.ing.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.Analysis;
import com.ing.bank.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("analysis/{bydate}")
	public ResponseEntity<List<Analysis>> analysis(@PathVariable("bydate") String byDate){
		return new ResponseEntity<>(productService.analysis(byDate), HttpStatus.OK);
	}

}
