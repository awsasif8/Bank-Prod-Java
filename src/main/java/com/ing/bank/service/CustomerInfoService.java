package com.ing.bank.service;

import org.springframework.stereotype.Service;

import com.ing.bank.dto.InfoDetails;
import com.ing.bank.dto.InfoDto;

@Service
public interface CustomerInfoService {

	InfoDetails custInfo(InfoDto infoDto);

}
