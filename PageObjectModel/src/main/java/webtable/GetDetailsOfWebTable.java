package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDetailsOfWebTable {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//Create a Classname and Object
		ChromeDriver driver = new ChromeDriver();
		
		//Create a Method to call the Object
		driver.get("https://erail.in");
		
		//Maximize the Window
		driver.manage().window().maximize();
		
		driver.findElementById("txtStationFrom").clear();;
		driver.findElementById("txtStationFrom").sendKeys("MAS",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("SBC",Keys.TAB);
		Thread.sleep(5000);
		//WebElement table = driver.findElementByXPath("//table[@class = 'DataTable TrainList']");
		
		//WebElement firstrow = rows.get(0);
		//Before Sort
		for (int j=1;j<3;j++){
			
		if (j==2)
		{
			driver.findElementByLinkText("Train Name").click();
			Thread.sleep(5000);
		}
		WebElement table = driver.findElementByXPath("//div[@id = 'divTrainsList']/table[1]");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());		
		for(int i=0;i<(rows.size());i++)
			{
			if (rows.get(i).getText().contains("Below trains not running"))
			continue;
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			//System.out.print(columns.get(1).getText());
			String output = columns.get(1).getText();
			System.out.print(output);
			}
		}
		/*//After Sort
		WebElement table1 = driver.findElementByXPath("//div[@id = 'divTrainsList']/table[1]");
		List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
		System.out.println(rows1.size());
		for(int i=0;i<(rows1.size());i++)
		{
		if (rows1.get(i).getText().contains("Below trains not running"))
		continue;
		List<WebElement> columns1 = rows1.get(i).findElements(By.tagName("td"));
		System.out.print(columns1.get(1).getText());
		}*/
				
	}

}
