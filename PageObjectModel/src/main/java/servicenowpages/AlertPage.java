package servicenowpages;

import wrappers.ServiceNowWrappers;

public class AlertPage extends ServiceNowWrappers{
	
	public AlertPage(){
		
		if (isAlertPresent() == false){
			reportStep("Alert not found", "FAIL");
		}		
	}
	
	
	
	
	
	
	
	
	

}
