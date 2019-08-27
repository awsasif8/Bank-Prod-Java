package com.ing.bank.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ing.bank.entity.Product;
import com.ing.bank.exception.ProductException;

public class ExcelUtils {

	static final Map<String, String> COLUMN_DETAILS = new HashMap<String, String>() {
		{
			put("Products", "Product_name,Description,Product_price,Product_Type");
		}
	};

	public static List<Product> parseExcelFile(InputStream is) {

		try {
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheet("Products");
			Iterator<Row> rows = sheet.iterator();

			List<Product> productList = new ArrayList<>();

			int rowNumber = 0;
			int cellIndex = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					String column[] = COLUMN_DETAILS.get("Products").split(",");

					Iterator<Cell> cellsInRow = currentRow.iterator();
					while (cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();
						if (cellIndex == 0 && !currentCell.getStringCellValue().equalsIgnoreCase(column[0])) { // Name
							break;
						} else if (cellIndex == 1 && !currentCell.getStringCellValue().equalsIgnoreCase(column[1])) { // description
							break;
						} else if (cellIndex == 2 && !currentCell.getStringCellValue().equalsIgnoreCase(column[2])) { // price
							break;
						} else if (cellIndex == 3 && !currentCell.getStringCellValue().equalsIgnoreCase(column[3])) { // type
							break;
						}
						cellIndex++;
					}
					if (cellIndex != 4) {
						throw new ProductException("Column order/Column name Invalid");
					}
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Product prod = new Product();

				cellIndex = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					if (cellIndex == 0) { // Name
						// prod.set
						prod.setProductName(currentCell.getStringCellValue());
					} else if (cellIndex == 1) { // description
						prod.setProductDescription(currentCell.getStringCellValue());
					} else if (cellIndex == 2) { // price
						prod.setProductPrice((double) currentCell.getNumericCellValue());
					} else if (cellIndex == 3) { // type
						prod.setProductType(currentCell.getStringCellValue());
					}
					cellIndex++;
				}

				productList.add(prod);
			}
			workbook.close();
			return productList;
		} catch (IOException e) {
			throw new ProductException(e.getMessage());
		}
	}
}