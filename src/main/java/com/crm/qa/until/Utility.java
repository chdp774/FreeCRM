package com.crm.qa.until;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.base;

public class Utility extends base {
	public static long pageLoadTimeOut = 30;
	public static long implicitlyTimeOut = 20;
	
	public static ArrayList<Object[]> excelData() {
		Xls_Reader reader = new Xls_Reader("C:\\Eclipse-Workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_testdata.xlsx");
		int count = reader.getRowCount("Contacts");
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		
		for(int rowNum=2; rowNum<=count; rowNum++) {
			String fname = reader.getCellData("Contacts", "firstname", rowNum);
			String lname = reader.getCellData("Contacts", "lastname", rowNum);
			String des = reader.getCellData("Contacts", "description", rowNum);
			
			Object ob[] = {fname, lname, des};
			data.add(ob);
		}
		return data;
	}
	
	public static void takesScreenshotAtEndofTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		
	}
			
	
}
