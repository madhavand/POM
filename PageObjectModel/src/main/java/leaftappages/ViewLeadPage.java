package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class ViewLeadPage extends LeafTapWrappers{

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
		if(!verifyTitle("View Lead | opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public ViewLeadPage verifyFirstName(String data)
	{
		//verifyTextContainsById("viewLead_firstName_sp", data);
		verifyTextContainsById(prop.getProperty("ViewLead.FName.id"),data);
		return new ViewLeadPage(driver, test);
	}
	public ViewLeadPage verifyCompanyName(String data)
	{
		//verifyTextContainsById("viewLead_companyName_sp", data);
		verifyTextContainsById(prop.getProperty("ViewLead.CompanyName.id"),data);
		return new ViewLeadPage(driver, test);
	}
	public EditLeadPage clickEdit(){
		//clickByLinkNoSnap("Edit");
		clickByLinkNoSnap(prop.getProperty("ViewLead.Edit.link"));
		return new EditLeadPage(driver, test);
	}
	public DuplicateLeadPage clickDuplicate(){
		//clickByLinkNoSnap("Duplicate Lead");
		clickByLinkNoSnap(prop.getProperty("ViewLead.DuplicateLead.link"));
		return new DuplicateLeadPage(driver, test);
	}
	public MyLeadsPage clickDelete(){
		//clickByLinkNoSnap("Delete");
		clickByLinkNoSnap(prop.getProperty("ViewLead.Delete.link"));
		return new MyLeadsPage(driver, test);
	}
	
}
