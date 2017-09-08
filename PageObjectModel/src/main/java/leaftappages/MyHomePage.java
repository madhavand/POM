package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class MyHomePage extends LeafTapWrappers{

	public MyHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	
		if(!verifyTitle("My Home | opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public MyLeadsPage clickLeadsTab()
	{
		//clickByLink("Leads");
		clickByLink(prop.getProperty("MyHomePage.Lead.Link"));
		return new MyLeadsPage(driver, test);
	}
		
}
