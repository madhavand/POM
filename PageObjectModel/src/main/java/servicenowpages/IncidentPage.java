package servicenowpages;

import wrappers.ServiceNowWrappers;

public class IncidentPage extends ServiceNowWrappers{

	public IncidentPage()
	{
		switchDefault();
		switchFrame("gsft_main");
		System.out.println(driver.getTitle());
		if(verifyTitleContains("ServiceNow"))
		{
			reportStep("This is NOT Home Page", "FAIL");
		}
		
	}
	public IncidentPage getIncidentNumber()
	{
		incidentNumber = getAttributeById("incident.number","value");
		System.out.println(incidentNumber);
		return this;
		
	}
	public IncidentPage enterCallerId(String data)
	{
		enterById("sys_display.incident.caller_id", data);
		enterByIdTab("sys_display.incident.caller_id");
		return this;
	}
	
	public IncidentPage enterDescription(String data){
		enterById("incident.short_description", data);
		return this;
	}
	public IncidentPage clearDescription() throws InterruptedException{
		textFieldValueClear("incident.short_description");
		threadWait();
		return this;
	}
	public IncidentPage userAsssignedTo(String user) throws InterruptedException{
		enterByIdEnterKey("sys_display.incident.assigned_to", user);
		threadWait();
		return this;
	}
	
	public IncidentPage incidentStateChange(String state){
		selectVisibileTextById("incident.state", state);
		return this;
	}
		
	public SearchIncidentPage clickSubmit(){
		clickByIdNoSnap("sysverb_insert");
		return new SearchIncidentPage();
		}
	public SearchIncidentPage clickUpdate(){
		clickByIdNoSnap("sysverb_update");	
		return new SearchIncidentPage();
		}
	public IncidentPage clickUpdateAlert(){
		clickByIdNoSnap("sysverb_update");	
		return this;
		}
	
	public UserPopupPage clickUserAsssignedTo() throws InterruptedException{
		clickByIdNoSnap("lookup.incident.assigned_to");
		return new UserPopupPage();
	}
	public IncidentPage acceptAlertMsg(){
		acceptAlert();
		return this;
	}
	
}
