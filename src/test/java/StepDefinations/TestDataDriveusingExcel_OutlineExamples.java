package StepDefinations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import Utils.ExcelDataReader;
import Utils.GlobalVars;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDataDriveusingExcel_OutlineExamples {
	
	@Given("^Get the test data alone \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void get_the_test_data_alone(String FilePath, String SheetName, String Testcase) throws Throwable {
		GlobalVars.Testcase=Testcase;
		System.out.println("Testcase name is: "+ Testcase);
		//List<Map<Object, Object>> lsMapObj = GetDataTable.getListofMapfromExcel(FilePath, SheetName, "", Testcase);
		System.out.println("LIST MAP SIZE: "+GlobalVars.glsMapObj.size());
		if (GlobalVars.glsMapObj.isEmpty() == true) {
			System.out.println("INSIDE IF and calling >> GetDataTable.getListofMapfromExcel");
			GlobalVars.glsMapObj = ExcelDataReader.getListofMapfromExcel(FilePath, SheetName, "", "");
		}
		GlobalVars.softAssert.assertEquals(true, true, "STEP1: Test data reterived in a LIST of MAPS");
	}
	
	@When("^my login \"([^\"]*)\" and \"([^\"]*)\"$")
	public void my_login_and(String arg1, String arg2) throws Throwable {
		System.out.println("my_login");
		
		//Data filtering from map to a list  
		for (HashMap<Object, Object> mapObj : GlobalVars.glsMapObj) {
			boolean bflag = false;
			Set<Object> set = mapObj.keySet();
			for(Object key: set) {
				//System.out.println(key.toString());
				//Global HashMap object
				if (GlobalVars.Testcase.equalsIgnoreCase(mapObj.get(key).toString())) {
					GlobalVars.gMapObj=(HashMap) mapObj.clone();
				}
				//Global LinkedList object
				if (GlobalVars.Testcase.equalsIgnoreCase(mapObj.get(key).toString()) || bflag) {
					bflag= true;
					//System.out.println("Key:"+key +"    Value:"+mapObj.get(key));
					GlobalVars.glsObj.add((Object)mapObj.get(key));
				}
				if (GlobalVars.Testcase.equalsIgnoreCase(mapObj.get(key).toString())) {
					//GlobalVars.gMapObj=(HashMap) mapObj.clone();
					System.out.println("Testcase	"+mapObj.get("Testcase"));
					System.out.println("username	"+mapObj.get("username"));
					System.out.println("password	"+mapObj.get("password"));
					System.out.println("FIN		"+mapObj.get("FIN"));
					System.out.println("DOB		"+mapObj.get("DOB"));
					System.out.println("address		"+mapObj.get("address"));
					System.out.println("city		"+mapObj.get("city"));
				}
				else {
					System.out.println("INSIDE Break");
					break;
				}
			}
		}
		GlobalVars.softAssert.assertEquals(true, true, "STEP2: Test data filtered from LIST for a respecifc MAP/ TESTCASE");
	}
	
	@Then("^my details$")
	public void my_details() throws Throwable {
	   System.out.println("my_details");
	   //just need my personal details alone
	   System.out.println("GlobalVars.glsObj: "+GlobalVars.glsObj);
	   //System.out.println("GlobalVars.glsObj index 0: "+GlobalVars.glsObj.get(0));
	   System.out.println("GlobalVars.gMapObj: "+GlobalVars.gMapObj);
	   //System.out.println("GlobalVars.gMapObj map 0: "+GlobalVars.gMapObj.get("Testcase"));
	  
	}

}
