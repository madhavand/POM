package leaftaptests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftappages.LoginPage;
import wrappers.LeafTapWrappers;

public class TC01_CreateNewLead extends LeafTapWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC001";
		browserName="chrome";
		testCaseName="Create New Lead";
		testDescription="Create a New Lead in LeafTaps";
		project = "leaftap";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(/*invocationCount = 10,*/dataProvider="fetchData")
	public void createTestLead(String username,String pwd,String companyName,String firstName,String lastName,String phoneNumber,String email){		
		new LoginPage(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMLink()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPhoneNumber(phoneNumber)
		.enterEmail(email)
		.clickCreateLead()
		.verifyFirstName(firstName);
		
	}

	

}
