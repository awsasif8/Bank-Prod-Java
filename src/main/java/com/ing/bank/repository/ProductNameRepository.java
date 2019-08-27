package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bank.entity.Product;

@Repository
public interface ProductNameRepository extends JpaRepository<Product, Integer> {

}
