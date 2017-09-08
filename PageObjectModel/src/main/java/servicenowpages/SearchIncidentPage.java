package servicenowpages;

import wrappers.ServiceNowWrappers;

public class SearchIncidentPage extends ServiceNowWrappers{

	public SearchIncidentPage()
	{
		switchDefault();
		switchFrame("gsft_main");
		System.out.println(driver.getTitle());
		if(verifyTitleContains("ServiceNow"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
		
	}
	public SearchIncidentPage enterIncidentNumber(String data) throws InterruptedException
	{
		enterByXpathEnterKey("//input[@class='form-control']",data);
		threadWait();
		return this;
	}
	public IncidentPage clickIncident(){
		clickByXpath("//a[@class = 'linked formlink']");
		return new IncidentPage();
	}	
	public SearchIncidentPage verifyTextIncidentLink(String incidentNum){
		verifyTextContainsByXpath("//a[@class = 'linked formlink']", incidentNum);
		return this;
	}
	public SearchIncidentPage verifyTextIncidentState(String state){
		verifyTextContainsByXpath("//a[@class = 'linked formlink']//following::td[5]", state);
		return this;
	}
	public SearchIncidentPage verifyTextAssignedUser(String user){
		verifyTextContainsByXpath("//a[@class = 'linked formlink']//following::td[8]", user);
		return this;
	}
	public SearchIncidentPage verifyTextErrorMsg(String errorMsg){
		verifyTextContainsByXpath("//*[@id='incident_table']//tbody/tr/td", errorMsg);
		return this;
	}

	
}
