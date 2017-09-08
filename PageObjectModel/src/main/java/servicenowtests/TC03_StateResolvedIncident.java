package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.ServiceNowWrappers;

public class TC03_StateResolvedIncident extends ServiceNowWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC003";
		browserName="chrome";
		testCaseName="State Resolved Incident";
		testDescription="Change the status of incident to Resolved in Service Now";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void stateResolvedIncident(String username, String pwd,String incident,String incidentNum,String user,String state) throws InterruptedException{
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.typeIncident(incident)
		.clickOpen()
		.enterIncidentNumber(incidentNum)
		.clickIncident()
		.incidentStateChange(state)
		.clickUserAsssignedTo()
		.enterUserName(user)
		.clickIncidentByUser()
		.clickUpdate()
		.enterIncidentNumber(incidentNum)
		.verifyTextIncidentLink(incidentNum)
		.verifyTextIncidentState(state);
		
		
		

		

	}


}
