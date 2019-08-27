package com.ing.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.bank.dto.Analysis;
import com.ing.bank.entity.OrderDetails;
@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

	@Query(value = "select od.product_id, pd.product_name, count(od.product_id)"
			+ " from order_details od INNER JOIN product pd using(product_id) "
			+ "where od.ordered_date = current_date() group by od.product_id,pd.product_name", nativeQuery =true)
	List<?> findAnalysis();
	
	@Query(value = "select od.product_id, pd.product_name, count(od.product_id) as productcount " + 
			"from order_details od INNER JOIN product pd using(product_id) " + 
			"where od.ordered_date between ?1 AND ?2 group by od.product_id,pd.product_name ", nativeQuery =true)
	List<?> findAnalysisbyWeek(String fromDate,String toDate);
	
	@Query(value = "select od.product_id, pd.product_name, count(od.product_id) as productcount " + 
			"from order_details od INNER JOIN product pd using(product_id) " + 
			"where od.ordered_date between ?1 AND ?2 group by od.product_id,pd.product_name ", nativeQuery =true)
	List<?> findAnalysisbyMonth(String fromDate,String toDate);

}
