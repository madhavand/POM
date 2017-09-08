package servicenowpages;

import wrappers.ServiceNowWrappers;

public class UserPopupPage extends ServiceNowWrappers{
	
	public UserPopupPage() throws InterruptedException{
		switchToWindowfor();
		if(verifyTitleContains("ServiceNow"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}	
		}
	public UserPopupPage enterUserName(String user) throws InterruptedException{
		enterByXpathEnterKey("(//input[@class = 'form-control'])[1]", user);
		threadWait();
		return this;
	}
	
	public IncidentPage clickIncidentByUser() throws InterruptedException{
		clickByXpathNoSnap("(//a[@class = 'glide_ref_item_link'])[1]");
		threadWait();
		switchToParentWindow();
		return new IncidentPage();
	}
}
