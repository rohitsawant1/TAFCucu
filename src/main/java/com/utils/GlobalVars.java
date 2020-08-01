package com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.asserts.SoftAssert;

public class GlobalVars {
	
	public GlobalVars() {
		System.out.println("Inside GlobalVars constructor");
	}
	
	public static String strTest = "rrrr";
	public static long PAGE_LOAD_TIME = 10;
	public static long IMPLICIT_WAIT = 10;
	
	public static List<List<Object>> gllo = new ArrayList<List<Object>>();
	public static List<HashMap<Object, Object>> glsMapObj = new LinkedList<HashMap<Object,Object>>();
	public static SoftAssert softAssert;// = new SoftAssert();
	public static String Testcase="";
	public static List<Object> glsObj = new LinkedList<Object>();
	public static HashMap<Object, Object> gMapObj = new LinkedHashMap<Object, Object>();
	public static WebDriver gdriver;
	public List<WebDriver> storedDrivers = new ArrayList<>();
	

}
