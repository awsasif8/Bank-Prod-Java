package com.ing.bank.service;

import java.util.List;

import com.ing.bank.dto.Analysis;

public interface ProductService {

	List<Analysis> analysis(String byDate);

}
