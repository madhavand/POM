package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class EditLeadPage extends LeafTapWrappers{

	public EditLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
		if(!verifyTitle("opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	
	public EditLeadPage enterCompanyName(String data){
		//enterById("updateLeadForm_companyName", data);
		enterById(prop.getProperty("EditLead.companyName.id"), data);
		return this;
	}
	
	public ViewLeadPage clickUpdate(){
		//clickByXpathNoSnap("(//input[@name = 'submitButton'])[1]");
		clickByXpathNoSnap(prop.getProperty("EditLead.update.xpath"));
		return new ViewLeadPage(driver, test);
	}
		
}
