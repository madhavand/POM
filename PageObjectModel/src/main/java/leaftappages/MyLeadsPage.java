package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class MyLeadsPage extends LeafTapWrappers{

	public MyLeadsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
		if(verifyTitleContains("opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	
	
	public FindLeadPage clickFindLeadsLink()
	{
		//clickByLink("Find Leads");
		clickByLink(prop.getProperty("MyLeadPage.FindLeads.Link"));
		return new FindLeadPage(driver, test);
	}
	public MergeLeadPage clickMergeLeadsLink()
	{
		//clickByLink("Merge Leads");
		clickByLink(prop.getProperty("MyLeadPage.MergeLeads.Link"));
		return new MergeLeadPage(driver, test);
	}

	public CreateLeadPage clickCreateLeadLink() {
		//clickByLink("Create Lead");
		clickByLink(prop.getProperty("MyLeadPage.CreateLead.Link"));
			return new CreateLeadPage(driver, test);
	}
}
