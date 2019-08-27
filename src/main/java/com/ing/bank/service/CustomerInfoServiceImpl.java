package com.ing.bank.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.InfoDetails;
import com.ing.bank.dto.InfoDto;
import com.ing.bank.entity.OrderDetails;
import com.ing.bank.repository.CustomerRepository;
import com.ing.bank.util.MailApi;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	MailApi mailApi;

	@Override
	public InfoDetails custInfo(InfoDto infoDto) {

		OrderDetails details = new OrderDetails();
		details.setOrderedDate(LocalDate.now());
		details.setAge(infoDto.getAge());
		details.setEmail(infoDto.getEmail());
		details.setName(infoDto.getName());
		details.setAddress(infoDto.getAddress());
		details.setPanCard(infoDto.getPanCard());
		details.setPhone(infoDto.getPhone());
		details.setProductId(infoDto.getProductId());
		Integer num = 100000 + new Random().nextInt(900000);
		details.setOrderGenId(num);

		customerRepository.save(details);

		mailApi.sendMail(details.getEmail(), details.getOrderGenId());
String message="Your Order has been placed successfully with orderId ";
String h=num.toString();
String message1=message.concat(h);
		InfoDetails det = new InfoDetails();
		det.setOrderId(details.getOrderGenId());
		det.setMessage(message1);
		det.setStatusCode(200);
		det.setStatus("SUCCESS");
		return det;

	}

}
