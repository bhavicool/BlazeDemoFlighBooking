package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ConfirmationPage;
import pages.FlightSelectionPage;
import pages.HomePage;
import pages.PassengerDetailsPage;
import resources.ApplicationData;

public class TestNGBlazeDemo implements ApplicationData {

	private WebDriver driver;

	HomePage homePage;

	FlightSelectionPage flightSelectionPage;

	PassengerDetailsPage passengerDetailsPage;

	ConfirmationPage confirmationPage; 

	@BeforeMethod()
	public void navigateToApplication()
	{
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();

		homePage=new HomePage(driver);

		flightSelectionPage =new FlightSelectionPage(driver);

		passengerDetailsPage=new PassengerDetailsPage(driver);

		confirmationPage=new ConfirmationPage(driver);

		driver.get(applicationURL);

		driver.manage().window().maximize();
	}

	//Test case for flight booking flow
	@Parameters({"departureCity","destinationCity"} )
	@Test (priority=1)	
	public void successfulFlightBooking(String departureCity,String destinationCity) throws InterruptedException{

		//Entering source and destination details
		homePage.selectCity(departureCity,destinationCity);

		//Selecting flight
		flightSelectionPage.selectFlightAction();

		//Entering Passenger Details
		passengerDetailsPage.enterPassengerDetails(driver);

		//Getting Confirmation Id
		String confirmationId=confirmationPage.confirmDetails();

		//Validating existence of confirmationId
		Assert.assertNotNull(confirmationId);


	}

	//Test case for validating source & destination cities
	@Parameters({"secondDepartureCity","secondDestinationCity"} )
	@Test (priority=2)	
	public void validateFlightCities(String secondDepartureCity,String secondDestinationCity) throws InterruptedException{


		//Entering source and destination details
		homePage.selectCity(secondDepartureCity,secondDestinationCity);

		String expectedFlightCitiesText=flightSelectionPage.flightCityDetails(driver).getText();
		String actualFlightCitiesText="Flights from Paris to New York:";

		//Validating the city details
		Assert.assertEquals(actualFlightCitiesText, expectedFlightCitiesText);

	}

	//Test case for validating price of cheapest flight
	@Parameters({"secondDepartureCity","secondDestinationCity"} )
	@Test (priority=3)	
	public void validateCheapFlightName(String secondDepartureCity,String secondDestinationCity) throws InterruptedException
	{


		//Entering source and destination details
		homePage.selectCity(secondDepartureCity,secondDestinationCity);

		String actualCheapFlight=flightSelectionPage.getCheapestFlight();

		//Validating the cheapest flight amount
		Assert.assertEquals(actualCheapFlight,"200.98");

	}

	//Test case for validating price of expensive flight
	@Parameters({"departureCity","destinationCity"} )
	@Test (priority=3)	
	public void validateExpensiveFlightName(String secondDepartureCity,String secondDestinationCity) throws InterruptedException
	{


		//Entering source and destination details
		homePage.selectCity(secondDepartureCity,secondDestinationCity);

		String actualExpensiveFlight=flightSelectionPage.getExpensiveFlight();

		//Validating the expensive flight amount
		Assert.assertEquals(actualExpensiveFlight,"765.32");
	}

	@AfterMethod
	public void quitDriver() throws Exception {
		driver.quit();
	}


}
