package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.bank.entity.OrderDetails;

public interface CustomerRepository  extends JpaRepository<OrderDetails,Integer>{

}
