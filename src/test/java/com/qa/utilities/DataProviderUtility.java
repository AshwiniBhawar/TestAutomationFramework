package com.qa.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.qa.pojo.LoginTestData;
import com.qa.pojo.LoginTestData.User;


public class DataProviderUtility {
	
	@DataProvider(name="LoginDataProviderExcel")
	public static Iterator<User> loginDataProviderExcel() {

		File testdata = new File("./src/test/resources/testdata/logindata.xlsx");
		XSSFWorkbook xssfWorkbook=null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		List<User> userList=null;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Cell homepagetitle;
		User user;
		
		try {
			userList=new ArrayList<User>();
			xssfWorkbook= new XSSFWorkbook(testdata);
			xssfSheet=xssfWorkbook.getSheet("LoginTestData");
			rowIterator=xssfSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				row=rowIterator.next();
				emailAddressCell=row.getCell(0);
				passwordCell=row.getCell(1);
				homepagetitle=row.getCell(2);
				user= new User(emailAddressCell.toString(),passwordCell.toString(),homepagetitle.toString());
				userList.add(user);	
			}
			
			xssfWorkbook.close();
			
		} catch (InvalidFormatException | IOException e) {
			throw new CustomException(e.getMessage());
		} 
		
		return userList.iterator();
	}
	
	@DataProvider(name="LoginDataProviderCSV")
	public static Iterator<User> loginDataProviderCSV(){
		
		File csvFile = new File("./src/test/resources/testdata/logindata.csv");
		FileReader fileReader=null;
		CSVReader csvReader;
		String[] line;
		List<User> userList=null;
		try {
			fileReader= new FileReader(csvFile);
			csvReader= new CSVReader(fileReader);
			csvReader.readNext();
			
			userList=new ArrayList<User>();
			User userData;
			
			while((line=csvReader.readNext()) != null) {
				userData= new User(line[0],line[1],line[2]);
				userList.add(userData);
			}
			
		} catch (FileNotFoundException e) {
			throw new CustomException("File not found "+e.getMessage());
		}
		catch(CsvValidationException | IOException e) {
			throw new CustomException("CSV file issue "+e.getMessage());
		}
		
		return userList.iterator();
	}
	
	@DataProvider(name="LoginDataProviderJSON")
	public Iterator<Object[]> loginDataProviderJson() {
		Gson gson= new Gson();
		File testdata = new File("./src/test/resources/testdata/logindata.json");
		FileReader fileReader;
		try {
			fileReader = new FileReader(testdata);
		} catch (FileNotFoundException e) {
			throw new CustomException("File not found "+e.getMessage());
		}
		LoginTestData data=gson.fromJson(fileReader, LoginTestData.class);
		
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		
		for(LoginTestData.User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		
		return dataToReturn.iterator();
	}
}
