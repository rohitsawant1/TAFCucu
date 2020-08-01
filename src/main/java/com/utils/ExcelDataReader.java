package com.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	public ExcelDataReader() {
		System.out.println("Inside GetDataTable");
	}
	
	public static List<List<Object>> getListfromExcel(String FilePath, String SheetName, String strColName){
		//ArrayList<Object[]> arrObj = new ArrayList<Object[]>();
		List<List<Object>> lls = new ArrayList<List<Object>>();
		String[] arrCol = null;
		int icolLength = 0;
		try {
			//Excelcode >> workbook >> sheet >>row
			FileInputStream FIS =new FileInputStream(FilePath);
			Workbook workBook = new XSSFWorkbook(FIS);
			Sheet sheet = workBook.getSheet(SheetName);
			System.out.println("The excel col count: "+sheet.getRow(0).getLastCellNum());
			int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println("The excel row count: "+rowcount);
			
			if (strColName.equals("") || strColName.trim() == "" || strColName.isEmpty()) {
				icolLength = sheet.getRow(0).getLastCellNum();
			}
			else {
				arrCol = strColName.split(",");
				icolLength = arrCol.length;
				System.out.println("Col Count: "+arrCol.length);
			}
			
			//Object[] obj = null;
			List<Object> ls = null;
			for(int i=1; i<=rowcount; i++) {
				//Object[] objCellValue = new Object[icolLength];
				ls = new ArrayList<Object>();
				//String[] str = new String[2];
				for (int j=0; j<icolLength; j++) {
					//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
					//objCellValue[j] = sheet.getRow(i).getCell(j).getStringCellValue();
					ls.add((Object)sheet.getRow(i).getCell(j).getStringCellValue());
				}
				
				//arrObj.add(objCellValue);
				lls.add(ls);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return lls;
		
	}

	
	public static List<HashMap<Object, Object>> getListofMapfromExcel(String FilePath, String SheetName, String strColName, String Testcase){
		//ArrayList<Object[]> arrObj = new ArrayList<Object[]>();
		//List<Map<Object, Object>> lsMapObj = new ArrayList<Map<Object, Object>>();
		List<HashMap<Object, Object>> lsMapObj = new LinkedList<HashMap<Object, Object>>();
		String[] arrCol = null;
		int icolLength = 0;
		try {
			//FIS >> workbook >> sheet >>row
			FileInputStream FIS =new FileInputStream(FilePath);
			Workbook workBook = new XSSFWorkbook(FIS);
			Sheet sheet = workBook.getSheet(SheetName);
			System.out.println("The excel col count: "+sheet.getRow(0).getLastCellNum());
			int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println("The excel row count: "+rowcount);
			
			if (strColName.equals("") || strColName.trim() == "" || strColName.isEmpty()) {
				icolLength = sheet.getRow(0).getLastCellNum();
			}
			else {
				arrCol = strColName.split(",");
				icolLength = arrCol.length;
				System.out.println("Col Count: "+arrCol.length);
			}
			for(int i=1; i<=rowcount; i++) {
				//Map<Object, Object> objMap = new HashMap<Object, Object>();
				//Map<Object, Object> objMap = new TreeMap<Object, Object>();
				LinkedHashMap<Object, Object> objMap = new LinkedHashMap<Object, Object>();//LinkedHashMap maintains the insertion order
				//System.out.println("Testcase name"+sheet.getRow(i).getCell(0).getStringCellValue().toString() +"  Expected test: "+Testcase);
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(Testcase)) {
					//System.out.println("Inside Testcase");
					for (int j=0; j<icolLength; j++) {
						Object key = (Object)sheet.getRow(0).getCell(j).getStringCellValue();
						Object Value = (Object)sheet.getRow(i).getCell(j).getStringCellValue();
						//System.out.println("Key: "+key);
						objMap.put(key, Value);
					}
					lsMapObj.add(objMap);
					break;
				}
				else if (Testcase.equals("") || Testcase.equals(null)) {
					for (int j=0; j<icolLength; j++) {
						Object key = (Object)sheet.getRow(0).getCell(j).getStringCellValue();
						Object Value = (Object)sheet.getRow(i).getCell(j).getStringCellValue();
						objMap.put(key, Value);
					}
					lsMapObj.add(objMap);
					
					//break;
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lsMapObj;
		
	}
}
