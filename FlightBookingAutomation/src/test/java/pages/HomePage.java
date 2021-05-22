package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

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



	public void selectCity(WebDriver driver,String departureCityName, String destinationCityName) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fromPort")));

		Select departureCity = new Select(departureCity(driver));
		departureCity.selectByValue(departureCityName);

		Select destinationCity = new Select(destinationCity(driver));
		destinationCity.selectByValue(destinationCityName);

		findFlights(driver).click();
		

	}
}
