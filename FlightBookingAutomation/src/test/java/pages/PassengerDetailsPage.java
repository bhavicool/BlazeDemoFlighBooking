package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerDetailsPage {

	public WebElement passengerName(WebDriver driver)
	{

		return (driver.findElement(By.id("inputName")));
	}

	public WebElement passengerAddress(WebDriver driver)
	{

		return (driver.findElement(By.cssSelector("#address")));
	}

	public WebElement passengerCity(WebDriver driver)
	{

		return (driver.findElement(By.id("city")));
	}

	public WebElement passengerState(WebDriver driver)
	{

		return (driver.findElement(By.id("state")));
	}

	public WebElement passengerZipCode(WebDriver driver)
	{

		return (driver.findElement(By.id("zipCode")));
	}

	public WebElement passengerCard(WebDriver driver)
	{

		return (driver.findElement(By.name("cardType")));
	}

	public WebElement passengerCreditCardNumber(WebDriver driver)
	{

		return (driver.findElement(By.id("creditCardNumber")));
	}

	public WebElement passengerCreditCardYear(WebDriver driver)
	{

		return (driver.findElement(By.id("creditCardYear")));
	}

	public WebElement passengerCreditCardMonth(WebDriver driver)
	{

		return (driver.findElement(By.cssSelector("#creditCardMonth")));
	}

	public WebElement passengerCreditCardName(WebDriver driver)
	{

		return (driver.findElement(By.id("nameOnCard")));
	}

	public WebElement purchaseFlight(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//input[@value='Purchase Flight']")));
	}

	public void enterPassengerDetails(WebDriver driver) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputName")));

		passengerName(driver).sendKeys("Simon Stewart");

		passengerAddress(driver).sendKeys("Vanlose 2720");

		passengerCity(driver).sendKeys("Glostrup");

		passengerState(driver).sendKeys("Zealand");

		passengerZipCode(driver).sendKeys("2600");

		Select cardType = new Select(passengerCard(driver));
		cardType.selectByValue("amex");

		passengerCreditCardNumber(driver).sendKeys("123456789");

		passengerCreditCardYear(driver).clear();
		
		passengerCreditCardYear(driver).sendKeys("2029");

		passengerCreditCardMonth(driver).clear();

		passengerCreditCardMonth(driver).sendKeys("08");

		passengerCreditCardName(driver).sendKeys("James Gosling");

		purchaseFlight(driver).click();

	}
}
