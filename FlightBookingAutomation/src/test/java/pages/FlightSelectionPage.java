package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FlightSelectionPage extends Page {
	
	public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

	public WebElement selectFlight(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//td[text()='United Airlines']"
				+ "/ancestor::tr/td/input[@type='submit']")));
	}
	
	public WebElement flightCityDetails(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//table[@class='table']/ancestor::div/h3")));
	}
	
	public List<WebElement> flightPrice(WebDriver driver)
	{
		return (driver.findElements(By.xpath("//table[@class='table']/ancestor::div/descendant::table/descendant::tr/descendant::td[6]")));
	}

	public void selectFlightAction() throws InterruptedException
	{

		waitForElement(selectFlight(driver));
		
		selectElement(selectFlight(driver));
    }
	
	public String getCheapestFlight()
	{
		
		List<WebElement> priceWebList=flightPrice(driver);
		List<String> actualPriceList=new ArrayList<String>();
		for(WebElement d:priceWebList)
		{
			actualPriceList.add(d.getText().replace('$',' ').trim());
		}
		
		Collections.sort(actualPriceList);
		return actualPriceList.get(0);
		
	}
	
	public String getExpensiveFlight()
	{
		
		List<WebElement> priceWebList=flightPrice(driver);
		List<String> actualPriceList=new ArrayList<String>();
		for(WebElement d:priceWebList)
		{
			actualPriceList.add(d.getText().replace('$',' ').trim());
		}
		
		Collections.sort(actualPriceList);
		return actualPriceList.get(actualPriceList.size()-1);
		
	}
	
	
}



