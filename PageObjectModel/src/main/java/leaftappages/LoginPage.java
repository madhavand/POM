package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class LoginPage extends LeafTapWrappers{

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test=test;
	if(!verifyTitle("Opentaps Open Source ERP + CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public LoginPage typeUserName(String data){
		//enterById("username", data);
		enterById(prop.getProperty("Login.UserName.id"),data);
		return this;
	}
	
	public LoginPage typePassword(String data){
		//enterById("password", data);
		enterById(prop.getProperty("Login.password.id"),data);
		return this;
	}
	
	public CRMPage clickLogin(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return new CRMPage(driver, test);
	}
		
}
