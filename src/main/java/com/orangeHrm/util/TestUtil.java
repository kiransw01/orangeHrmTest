package com.orangeHrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {

	public static long Page_Load_TiemOut = 40;

	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static String filePath = "G:\\Selenium\\Selenium Workspace\\OrangeHrmTest"
			+ "\\src\\main\\java\\com\\orangeHrm\\testdata\\TestData.xlsx";

	public static void selectDropDown(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// public static ArrayList<Object[]> getData()
	public static Object[][] getData(String sheetName) {
		// ArrayList<Object[]> details=new ArrayList<Object[]>();
		// File file=new File(filePath);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(inputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workBook.getSheet("AddUser");
		int totalRowCount = sheet.getLastRowNum();
		int totalColumnCount = sheet.getRow(0).getLastCellNum();

		Object[][] myData = new Object[totalRowCount][totalColumnCount];

		// DataFormatter format=new DataFormatter();

		for (int i = 0; i < totalRowCount; i++) {
			for (int j = 0; j < totalColumnCount; j++) {
				/*
				 * String userRole=format.formatCellValue(sheet.getRow(i+1).getCell(j)); String
				 * employeeName=format.formatCellValue(sheet.getRow(i+1).getCell(j+1)); String
				 * userName=format.formatCellValue(sheet.getRow(i+1).getCell(j+2)); String
				 * status=format.formatCellValue(sheet.getRow(i+1).getCell(j+3)); String
				 * password=format.formatCellValue(sheet.getRow(i+1).getCell(j+4)); String
				 * confirmPassword=format.formatCellValue(sheet.getRow(i+1).getCell(j+5));
				 */

				// Object []
				// myData={userRole,employeeName,userName,status,password,confirmPassword};
				/*
				 * for(Object obj:myData) { System.out.println(obj); }
				 * 
				 * details.add(myData); break;
				 */
				myData[i][j] = sheet.getRow(i + 1).getCell(j).toString();

			}

		}
		return myData;
	}

	public static void putData(String user, boolean status) {
		String FilePath = "G:\\Selenium\\Selenium Workspace\\OrangeHrmTest"
				+ "\\src\\main\\java\\com\\orangeHrm\\testdata\\TestData.xlsx";
		File file = new File(FilePath);

		FileInputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file);
			workBook = new XSSFWorkbook(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DataFormatter formatter = new DataFormatter();
		sheet = workBook.getSheet("Users");
		int row = sheet.getLastRowNum();

		for (int i = 0; i < row; i++) {
			String value = formatter.formatCellValue(sheet.getRow(i + 1).getCell(0));
			if (value.equalsIgnoreCase(user)) {
				sheet.getRow(i + 1).getCell(1).setCellValue(status);
			}
		}

		FileOutputStream outPut;
		try {
			outPut = new FileOutputStream(file);
			workBook.write(outPut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
