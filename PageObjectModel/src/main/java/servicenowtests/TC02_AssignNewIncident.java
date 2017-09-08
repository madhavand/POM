package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.HomePage;
import servicenowpages.Login;
import wrappers.ServiceNowWrappers;

public class TC02_AssignNewIncident extends ServiceNowWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC002";
		browserName="chrome";
		testCaseName="Assign New Incident";
		testDescription="Assigning the user for the Incident in Service Now";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void assignNewIncident(String username, String pwd,String incident,String incidentNum,String user,String state) throws InterruptedException{
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.typeIncident(incident)
		.clickUnassigned()
		.enterIncidentNumber(incidentNum)
		.clickIncident()
		.incidentStateChange(state)		
		.userAsssignedTo(user)
		.clickUpdate();
		new HomePage()
		.typeIncident(incident)
		.clickOpen()
		.enterIncidentNumber(incidentNum)
		.verifyTextAssignedUser(user);
	}


}
