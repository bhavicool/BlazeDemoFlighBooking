package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {

	
	public WebElement getConfirmationId(WebDriver driver)
	{

		return (driver.findElement(By.xpath("//td[text()='Id']/following-sibling::td")));
	}
	
	
	public String confirmDetails(WebDriver driver) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")));

		return getConfirmationId(driver).getText();
		
	}
}
