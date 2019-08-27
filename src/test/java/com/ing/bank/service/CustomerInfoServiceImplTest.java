package com.ing.bank.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bank.dto.InfoDetails;
import com.ing.bank.dto.InfoDto;
import com.ing.bank.entity.OrderDetails;
import com.ing.bank.repository.CustomerRepository;
import com.ing.bank.util.MailApi;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerInfoServiceImplTest {

	@Mock
	CustomerRepository customerRepository;
	@Mock
	MailApi api;

	@InjectMocks
	CustomerInfoServiceImpl customerInfoServiceImpl;

	@Test
	public void testCustInfo() {

		InfoDto infoDto = new InfoDto();
		infoDto.setAddress("Hyd");
		infoDto.setAge(25);
		infoDto.setEmail("sai@gmail.com");
		infoDto.setName("sai");
		infoDto.setPanCard("lkdjsflk");
		infoDto.setPhone(986798L);
		infoDto.setProductId(1);

		OrderDetails details = new OrderDetails();
		details.setOrderedDate(LocalDate.now());
		details.setAge(infoDto.getAge());
		details.setEmail(infoDto.getEmail());
		details.setName(infoDto.getName());
		details.setAddress(infoDto.getAddress());
		details.setPanCard(infoDto.getPanCard());
		details.setPhone(infoDto.getPhone());
		details.setProductId(infoDto.getProductId());
		int num = 100000 + new Random().nextInt(900000);
		details.setOrderGenId(num);
		InfoDetails det = new InfoDetails();
		det.setOrderId(details.getOrderGenId());
		det.setStatusCode(200);
		det.setMessage("mail sent successfully");
		det.setStatusCode(200);
		det.setStatus("SUCCESS");

		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(details);

		InfoDetails det1 = customerInfoServiceImpl.custInfo(infoDto);
		Mockito.doNothing().when(api).sendMail("sai555977charan", 123456);

		assertEquals(det1.getStatus(), det.getStatus());
	}

}
