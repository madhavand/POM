package leaftaptests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftappages.LoginPage;
import leaftappages.MyLeadsPage;
import wrappers.LeafTapWrappers;

public class TC05_MergeLead extends LeafTapWrappers{
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC005";
		browserName="chrome";
		testCaseName="Merge Lead";
		testDescription="Merge a two Leads in LeafTaps";
		authors="Babu";
		category="Smoke";
	}
	@Test(dataProvider="fetchData")
	public void mergeLead(String username,String pwd,String lastName, String errorMsg) throws InterruptedException{		
		new LoginPage(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMLink()
		.clickLeadsTab()
		.clickMergeLeadsLink()
		.clickFromLeadIcon()
		.enterLastNamePopUp(lastName)
		.clickFindLeadsButtonPopup()
		.storemergeLeadId()
		.clickFirstRecordPopUp()
		.clickToLeadIcon()
		.enterLastNamePopUp(lastName)
		.clickFindLeadsButtonPopup()
		.clickSecondRecordPopUp()
		.clickMerge();
		new MyLeadsPage(driver, test)
		.clickFindLeadsLink()
		.enterLeadId(mergeLeadId)
		.clickFindLeadsButton()
		.verifyNoRecordsMsg(errorMsg);	
	}
}