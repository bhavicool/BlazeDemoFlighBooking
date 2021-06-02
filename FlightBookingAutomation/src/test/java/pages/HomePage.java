package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends Page{
	
	public HomePage(WebDriver driver) {
        super(driver);
    }
	

	public WebElement departureCity(WebDriver driver)
	{

		return (driver.findElement(By.name("fromPort")));
	}

	public WebElement destinationCity(WebDriver driver)
	{
		return (driver.findElement(By.name("toPort")));
	}
	
	public WebElement findFlights(WebDriver driver)
	{
		return (driver.findElement(By.xpath("//input[@value='Find Flights']")));
	}



	public void selectCity(String departureCityName, String destinationCityName) throws InterruptedException
	{

		waitForElement(driver.findElement(By.name("fromPort")));

		Select departureCity = new Select(departureCity(driver));
		departureCity.selectByValue(departureCityName);

		Select destinationCity = new Select(destinationCity(driver));
		destinationCity.selectByValue(destinationCityName);

		selectElement(findFlights(driver));
		
		

	}
}
