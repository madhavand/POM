package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class MergeLeadPage extends LeafTapWrappers{

	public MergeLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	
		if(!verifyTitle("Merge Leads | opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public FindLeadPopupPage clickFromLeadIcon(){
		//clickByXpathNoSnap("(//img[@alt='Lookup'])[1]");
		clickByXpathNoSnap(prop.getProperty("MergeLead.FromLead.xpath"));
		return new FindLeadPopupPage(driver, test);
	}
	
	public FindLeadPopupPage clickToLeadIcon(){
		//clickByXpathNoSnap("(//img[@alt='Lookup'])[2]");
		clickByXpathNoSnap(prop.getProperty("MergeLead.ToLead.xpath"));
		return new FindLeadPopupPage(driver, test);
	}
	public ViewLeadPage clickMerge(){
		//clickByLinkNoSnap("Merge");
		clickByLinkNoSnap(prop.getProperty("MergePage.MergeLeads.Link"));
		acceptAlert();
		return new ViewLeadPage(driver, test);
	}
	
	
}