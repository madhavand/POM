package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class FindLeadPage extends LeafTapWrappers{

	public FindLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
		if(!verifyTitle("Find Leads | opentaps CRM"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public FindLeadPage enterFirstName(String data)
	{
		//enterByXpath("(//input[@name='firstName'])[3]", data);
		enterByXpath(prop.getProperty("FindLead.name.xpath"),data);
		return new FindLeadPage(driver, test);
	}
	
	public FindLeadPage enterLeadId(String data)
	{
		//enterByName("id", data);
		enterByName(prop.getProperty("FindLead.LeadId.name"),data);
		return new FindLeadPage(driver, test);
	}
	public FindLeadPage clickFindLeadsButton() throws InterruptedException{
		//clickByXpathNoSnap("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap(prop.getProperty("FindLead.findLeadButton.xpath"));
		threadWait();
		return this;
	}
		public ViewLeadPage clickFirstRecord()
		{
			//clickByXpathNoSnap("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a");
			clickByXpathNoSnap(prop.getProperty("FindLead.firstLead.xpath"));
			return new ViewLeadPage(driver, test);
			
		}
		public FindLeadPage storeLeadId(){
		leadId = getTextByXpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a");
		return this;		
		}
		
		public FindLeadPage clickEmail(){
			//clickByLinkNoSnap("Email");
			clickByLinkNoSnap(prop.getProperty("FindLead.email.link"));

			return this;
		}
		public FindLeadPage enterEmail(String data){
			//enterByName("emailAddress", data);
			enterByName(prop.getProperty("FindLead.email.name"),data);
		return this;
		}
		public FindLeadPage clickPhone(){
			//clickByLinkNoSnap("Phone");
			clickByLinkNoSnap(prop.getProperty("FindLead.phone.link"));
			return this;
		}
		public FindLeadPage enterPhoneNum(String data){
			//enterByName("phoneNumber", data);
			enterByName(prop.getProperty("FindLead.phone.name"),data);
		return this;
		}
		public FindLeadPage verifyNoRecordsMsg(String text){
			//verifyTextByXpath("//div[text()='No records to display']", text);
			verifyTextByXpath(prop.getProperty("FindLead.norecord.xpath"),text);
			return this;
			
		}
		
}
