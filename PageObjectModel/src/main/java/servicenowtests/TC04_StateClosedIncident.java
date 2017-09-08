package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.ServiceNowWrappers;

public class TC04_StateClosedIncident extends ServiceNowWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC004";
		browserName="chrome";
		testCaseName="State Closed Incident";
		testDescription="Change the status of incident to Closed in Service Now";
		authors="Babu";
		category="Smoke";
	}
	@Test(dataProvider="fetchData")
	public void stateClosedIncident(String username, String pwd,String incident,String incidentNum,String user,String state,String desc,String errorMsg) throws InterruptedException{
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.typeIncident(incident)
		.clickResolved()
		.enterIncidentNumber(incidentNum)
		.clickIncident()
		.incidentStateChange(state)		
		.clearDescription()
		.clickUpdateAlert()
		.acceptAlertMsg()
		.enterDescription(desc)
		.clickUpdate()
		.enterIncidentNumber(incidentNum)
		.verifyTextErrorMsg(errorMsg);
	}
}