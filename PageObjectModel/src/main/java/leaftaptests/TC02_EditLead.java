package leaftaptests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftappages.LoginPage;
import wrappers.LeafTapWrappers;

public class TC02_EditLead extends LeafTapWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC002";
		browserName="chrome";
		testCaseName="Edit Lead";
		testDescription="Edit a Lead in LeafTaps";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void editLead(String username,String pwd,String companyName,String firstName,String newCompanyName) throws InterruptedException{		
		new LoginPage(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMLink()
		.clickLeadsTab()
		.clickFindLeadsLink()
		.enterFirstName(firstName)
		.clickFindLeadsButton()
		.clickFirstRecord()
		.clickEdit()
		.enterCompanyName(newCompanyName)
		.clickUpdate()
		.verifyCompanyName(newCompanyName);		
	}
}
