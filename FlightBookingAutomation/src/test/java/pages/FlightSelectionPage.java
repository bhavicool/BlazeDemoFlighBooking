package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage {

	public WebElement selectFlight(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//td[text()='United Airlines']"
				+ "/ancestor::tr/td/input[@type='submit']")));
	}
	
	public WebElement flightCityDetails(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//table[@class='table']/ancestor::div/h3")));
	}
	
	

	public void selectFlightAction(WebDriver driver) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='United Airlines']"
				+ "/ancestor::tr/td/input[@type='submit']")));

		selectFlight(driver).click();

	}
}



