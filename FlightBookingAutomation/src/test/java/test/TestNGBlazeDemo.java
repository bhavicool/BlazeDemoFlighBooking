package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ConfirmationPage;
import pages.FlightSelectionPage;
import pages.HomePage;
import pages.PassengerDetailsPage;

public class TestNGBlazeDemo {

	private WebDriver driver;

	HomePage homePage=new HomePage();

	FlightSelectionPage flightSelectionPage =new FlightSelectionPage();

	PassengerDetailsPage passengerDetailsPage=new PassengerDetailsPage();

	ConfirmationPage confirmationPage=new ConfirmationPage(); 

	/*@BeforeTest(alwaysRun=true)
	public void initDriver() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();	
	}*/
	
	@BeforeMethod()
	public void navigateToApplication()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
	}

	@Parameters({"departureCity","destinationCity"} )
	@Test (priority=1)	
	public void successfulFlightBooking(String departureCity,String destinationCity){

		try
		{
			//Entering source and destination details
			homePage.selectCity(driver,departureCity,destinationCity);

			//Selecting flight
			flightSelectionPage.selectFlightAction(driver);

			//Entering Passenger Details
			passengerDetailsPage.enterPassengerDetails(driver);

			//Getting Confirmation Id
			String confirmationId=confirmationPage.confirmDetails(driver);
			System.out.println("The confirmation Id is:"+confirmationId);
			
			//Validating existence of confirmationId
			Assert.assertNotNull(confirmationId);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something went wrong with error message:"+e.getMessage());
		}
	}
	
	@Parameters({"secondDepartureCity","secondDestinationCity"} )
	@Test (priority=2)	
	public void validateFlightCities(String secondDepartureCity,String secondDestinationCity){

		try
		{
			//Entering source and destination details
			homePage.selectCity(driver,secondDepartureCity,secondDestinationCity);
			
			String expectedFlightCitiesText=flightSelectionPage.flightCityDetails(driver).getText();
			String actualFlightCitiesText="Flights from Paris to New York:";
			
			//Validating the city details
			Assert.assertEquals(actualFlightCitiesText, expectedFlightCitiesText);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something went wrong with error message:"+e.getMessage());
		}
	}
	
	@AfterMethod
	public void quitDriver() throws Exception {
		driver.quit();
	}

	/*@AfterTest
	public void quitDriver() throws Exception {
		driver.quit();
	}*/
}
