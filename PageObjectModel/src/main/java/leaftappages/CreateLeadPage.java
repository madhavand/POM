package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class CreateLeadPage extends LeafTapWrappers{

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	
		if(!verifyTitle("Create Lead | opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public CreateLeadPage enterCompanyName(String data)
	{
		//enterById("createLeadForm_companyName", data);
		enterById(prop.getProperty("createLead.CompanyName.id"),data);
		return new CreateLeadPage(driver, test);
	}
	public CreateLeadPage enterFirstName(String data)
	{
		//enterById("createLeadForm_firstName", data);
		enterById(prop.getProperty("createLead.FirstName.id"),data);
		return new CreateLeadPage(driver, test);
	}
	public CreateLeadPage enterLastName(String data)
	{
		//enterById("createLeadForm_lastName", data);	
		enterById(prop.getProperty("createLead.LastName.id"),data);
		return new CreateLeadPage(driver, test);
	}	
	public CreateLeadPage enterPhoneNumber(String data)
	{
		//enterById("createLeadForm_primaryPhoneNumber", data);		
		enterById(prop.getProperty("createLead.PhoneNumber.id"),data);
		return new CreateLeadPage(driver, test);
	}
	public CreateLeadPage enterEmail(String data)
	{
		//enterById("createLeadForm_primaryEmail", data);		
		enterById(prop.getProperty("createLead.Email.id"),data);
		return new CreateLeadPage(driver, test);
	}
	public ViewLeadPage clickCreateLead()
	{
		//clickByName("submitButton");
		clickByName(prop.getProperty("createLead.createlead.Name"));
		return new ViewLeadPage(driver, test);
	}
	
}
