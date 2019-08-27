package com.ing.bank.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String name;
	private int age;
	private String email;
	private Long phone;
	private String address;
	private LocalDate orderedDate;
	private String panCard;
	private int productId;
	private int orderGenId;
}
