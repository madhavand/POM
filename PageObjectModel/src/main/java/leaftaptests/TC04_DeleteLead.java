package leaftaptests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftappages.LoginPage;
import wrappers.LeafTapWrappers;

public class TC04_DeleteLead extends LeafTapWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC004";
		browserName="chrome";
		testCaseName="Duplicate Lead";
		testDescription="Duplicate a Lead in LeafTaps";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteLead(String username,String pwd,String firstName,String phoneNum,String errorMsg) throws InterruptedException{		
		new LoginPage(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMLink()
		.clickLeadsTab()
		.clickFindLeadsLink()
		.clickPhone()
		.enterPhoneNum(phoneNum)
		.clickFindLeadsButton()
		.storeLeadId()
		.clickFirstRecord()
		.clickDelete()
		.clickFindLeadsLink()
		.enterLeadId(leadId)
		.clickFindLeadsButton()
		.verifyNoRecordsMsg(errorMsg);		
		}
}
