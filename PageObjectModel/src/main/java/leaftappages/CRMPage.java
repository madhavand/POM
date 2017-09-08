package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;


public class CRMPage extends LeafTapWrappers{

	public CRMPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	
		if(!verifyTitle("Opentaps Open Source ERP + CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public MyHomePage clickCRMLink(){
		//clickByLink("CRM/SFA");
		clickByLink(prop.getProperty("Home.CRMSFA.Link"));
		return new MyHomePage(driver, test);
	}
		
}
