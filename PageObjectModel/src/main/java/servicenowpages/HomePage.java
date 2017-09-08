package servicenowpages;

import wrappers.ServiceNowWrappers;

public class HomePage extends ServiceNowWrappers{

	public HomePage()
	{
		switchDefault();
		if(verifyTitleContains("ServiceNow"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	public HomePage typeIncident(String data)
	{
		enterById("filter", data);
		return this;
	}
	public IncidentPage clickNew()
	{
		//clickByXpathNoSnap("(//div[text() = 'Create New'])[1]");
		clickByLinkNoSnap("Create New");
		return new IncidentPage();
	}
	public SearchIncidentPage clickOpen()
	{
		//clickByXpathNoSnap("//div[text() = 'Open']");
		clickByLinkNoSnap("Open");

		return new SearchIncidentPage();
	}
	public SearchIncidentPage clickUnassigned()
	{
		//clickByXpathNoSnap("//div[text() = 'Open - Unassigned']");
		clickByLinkNoSnap("Open - Unassigned");

		return new SearchIncidentPage();
	}
	public SearchIncidentPage clickResolved()
	{
		//clickByXpathNoSnap("//div[text() = 'Resolved']");
		clickByLinkNoSnap("Resolved");

		return new SearchIncidentPage();
	}
	
}
