package com.ing.bank.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.Analysis;
import com.ing.bank.exception.ProductException;
import com.ing.bank.repository.OrderRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Analysis> analysis(String byDate) {

		try {

			List<Analysis> analysisList = new ArrayList<>();

			if (byDate.equals("day")) {

				List<Object> analysis = (List<Object>) orderRepository.findAnalysis();

				for (int i = 0; i < analysis.size(); i++) {
					Analysis ana = null;

					Object[] obj = (Object[]) analysis.get(i);
					ana = new Analysis();
					for (int j = 0; j < obj.length; j++) {

						if (j == 0) {
							ana.setCount(Integer.parseInt(obj[j].toString()));
						} else if (j == 1) {
							ana.setProductName((String) obj[j]);
						} else {
							ana.setProductId(Integer.parseInt(obj[j].toString()));
						}
					}
					analysisList.add(ana);
				}

				return analysisList;
			} else if (byDate.equals("week")) {
				LocalDate monthdate = LocalDate.now().minus(Period.ofDays(7));
				LocalDate now = LocalDate.now();

				String fromDate = monthdate.toString().replaceAll("/", "-");

				String toDate = now.toString().replaceAll("/", "-");

				List<Object> analysis = (List<Object>) orderRepository.findAnalysisbyWeek(fromDate, toDate);

				for (int i = 0; i < analysis.size(); i++) {
					Analysis ana = null;

					Object[] obj = (Object[]) analysis.get(i);
					ana = new Analysis();
					for (int j = 0; j < obj.length; j++) {

						if (j == 0) {
							ana.setCount(Integer.parseInt(obj[j].toString()));
						} else if (j == 1) {
							ana.setProductName((String) obj[j]);
						} else {
							ana.setProductId(Integer.parseInt(obj[j].toString()));
						}
					}
					analysisList.add(ana);
				}
				return analysisList;

			} else if (byDate.equals("month")) {
				LocalDate monthdate = LocalDate.now().minus(Period.ofDays(30));
				LocalDate now = LocalDate.now();
				// List<Analysis> analysis = (List<Analysis>)
				// orderRepository.findAnalysisbyWeek(monthdate);

				String fromDate = monthdate.toString().replaceAll("/", "-");
				String toDate = now.toString().replaceAll("/", "-");

				List<Object> analysis = (List<Object>) orderRepository.findAnalysisbyMonth(fromDate, toDate);

				for (int i = 0; i < analysis.size(); i++) {
					Analysis ana = null;

					Object[] obj = (Object[]) analysis.get(i);
					ana = new Analysis();
					for (int j = 0; j < obj.length; j++) {

						if (j == 0) {
							ana.setCount(Integer.parseInt(obj[j].toString()));
						} else if (j == 1) {
							ana.setProductName((String) obj[j]);
						} else {
							ana.setProductId(Integer.parseInt(obj[j].toString()));
						}
					}
					analysisList.add(ana);
				}
				return analysisList;
			} else {
				throw new ProductException("Please select the proper date");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
