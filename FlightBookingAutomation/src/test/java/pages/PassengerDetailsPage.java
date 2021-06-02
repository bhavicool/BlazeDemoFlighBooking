package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PassengerDetailsPage extends Page {
	
	public PassengerDetailsPage(WebDriver driver) {
        super(driver);
    }

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
		
		waitForElement(passengerName(driver));

		sendValue(passengerName(driver),"Simon Stewart");

		sendValue(passengerAddress(driver),"Vanlose 2720");

		sendValue(passengerCity(driver),"Glostrup");

		sendValue(passengerState(driver),"Zealand");

		sendValue(passengerZipCode(driver),"2600");

		Select cardType = new Select(passengerCard(driver));
		cardType.selectByValue("amex");

		sendValue(passengerCreditCardNumber(driver),123456789);

		sendValue(passengerCreditCardYear(driver),2029);
		
		sendValue(passengerCreditCardMonth(driver),8);

		sendValue(passengerCreditCardName(driver),"James Gosling");

		selectElement(purchaseFlight(driver));

	}
}
