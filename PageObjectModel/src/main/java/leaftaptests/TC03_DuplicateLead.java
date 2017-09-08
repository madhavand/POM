package leaftaptests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftappages.LoginPage;
import wrappers.LeafTapWrappers;

public class TC03_DuplicateLead extends LeafTapWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC003";
		browserName="chrome";
		testCaseName="Duplicate Lead";
		testDescription="Duplicate a Lead in LeafTaps";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void duplicateLead(String username,String pwd,String firstName,String email) throws InterruptedException{		
		new LoginPage(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMLink()
		.clickLeadsTab()
		.clickFindLeadsLink()
		.clickEmail()
		.enterEmail(email)
		.clickFindLeadsButton()
		.clickFirstRecord()
		.clickDuplicate()
		.clickCreateLead()
		.verifyFirstName(firstName);
		
		
	}
}
