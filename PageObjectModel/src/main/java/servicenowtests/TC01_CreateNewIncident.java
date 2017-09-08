package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.LeafTapWrappers;

public class TC01_CreateNewIncident extends LeafTapWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC001";
		browserName="chrome";
		testCaseName="Create New Incident in Service now ";
		testDescription="Create a New Incident in Service Now";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void createNewIncident(String username, String pwd,String incident,String data,String desc) throws InterruptedException{
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.typeIncident(incident)
		.clickNew()
		.getIncidentNumber()
		.enterCallerId(data)
		.enterDescription(desc)
		.clickSubmit()
		.enterIncidentNumber(incidentNumber)
		.verifyTextIncidentLink(incidentNumber);
	}


}
