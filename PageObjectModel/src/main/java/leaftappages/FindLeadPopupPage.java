package leaftappages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapWrappers;

public class FindLeadPopupPage extends LeafTapWrappers{
	String user;

	public FindLeadPopupPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	
		switchToWindowfor();
		if(!verifyTitle("Find Leads"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public FindLeadPopupPage enterLastNamePopUp(String data)
	{
		//enterByXpath("//input[@name='lastName']", data);
		enterByXpath(prop.getProperty("FindLeadPopup.LastName.xpath"),data);
		return new FindLeadPopupPage(driver, test);
	}
	public FindLeadPopupPage clickFindLeadsButtonPopup() throws InterruptedException{
		//clickByXpathNoSnap("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap(prop.getProperty("FindLeadPopup.findLeadButton.xpath"));
		threadWait();
		return this;
	}
		public MergeLeadPage clickFirstRecordPopUp() throws InterruptedException
		{
			//clickByXpathNoSnap("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a");
			clickByXpathNoSnap(prop.getProperty("FindLeadPopup.firstLead.xpath"));
			switchToParentWindow();
			threadWait();
			return new MergeLeadPage(driver, test);
			
		}public MergeLeadPage clickSecondRecordPopUp() throws InterruptedException
		{
			//clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a");
			clickByXpathNoSnap(prop.getProperty("FindLeadPopup.secondLead.xpath"));
			switchToParentWindow();
			threadWait();
			return new MergeLeadPage(driver, test);
		}
		
		public FindLeadPopupPage storemergeLeadId()
		{
			//mergeLeadId = getTextByXpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a");
			mergeLeadId = getTextByXpath(prop.getProperty("FindLeadPopup.firstLead.xpath"));
			return this;		
			}
}
