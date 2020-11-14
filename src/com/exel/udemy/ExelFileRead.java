package com.exel.udemy;

import java.io.File;
import java.io.FileInputStream;



public class ExelFileRead {

	/*public static void getUdemyExel(String filePath, String sheetName) {

		try {
			FileInputStream fileInput = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowSize = sheet.getPhysicalNumberOfRows();
			int colSize = sheet.getRow(0).getLastCellNum();
			System.out.println("rowSize = "+rowSize + "\ncolSize =" + colSize);
			for (int i = 0; i < rowSize; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < colSize; j++) {
					XSSFCell cell = row.getCell(j);
				String value=	cell.toString().trim();
				
				System.out.print(value+"    ");
				
				}
				System.out.println();
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
	
	*
	*
	*
	*
	*/
	
	

	
}
