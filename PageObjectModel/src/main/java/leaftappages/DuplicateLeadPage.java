package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class DuplicateLeadPage extends LeafTapWrappers{

	public DuplicateLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
		if(!verifyTitle("Duplicate Lead | opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public ViewLeadPage clickCreateLead(){
		//clickByXpathNoSnap("//input[@name = 'submitButton']");
		clickByXpathNoSnap(prop.getProperty("DuplicateLead.CreateLead.xpath"));
		return new ViewLeadPage(driver, test);
		
	}
}
