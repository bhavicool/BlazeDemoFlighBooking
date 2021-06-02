package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends Page {
	
	public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

	
	public WebElement getConfirmationId(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//td[text()='Id']/following-sibling::td")));
	}
	
	
	public String confirmDetails() throws InterruptedException
	{

		waitForElement(driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")));
		
		return getElementText(getConfirmationId(driver));
		
	}
}
