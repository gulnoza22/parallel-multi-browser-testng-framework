package com.cbt.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;
	// @prameters  --> means that this method will expect an argument
	// from the xml file
	// name of the parameter in the xlm file is browser
	// @optional --> we use this if we dont want to
	// provide paramters in xml all the time

	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional String browser) {
		driver = Driver.getDriver(browser);
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		Driver.closeDriver();
	}

}






