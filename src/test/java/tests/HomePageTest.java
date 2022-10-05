package tests;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{

	@Test(priority=0)
	public void tc_001() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking title matches string");
		Assert.assertEquals(homePage.getTitle(), "W3Schools Online Web Tutorials1", "Title does not match");
		logger.log(LogStatus.PASS, "Title matches with title");

		logger.log(LogStatus.INFO, "Checking if search button worked");
		homePage.enterSearchCondition("Java");
		homePage.clickSearchButton();
		logger.log(LogStatus.PASS, "Search button is normal worked");

	}

	@Test(priority=1)
	public void tc_002() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking title matches string");
		Assert.assertEquals(homePage.getTitle(), "W3Schools Online Web Tutorials", "Title does not match");
		logger.log(LogStatus.PASS, "Title matches with title");

		logger.log(LogStatus.INFO, "Checking if search button worked");
		homePage.enterSearchCondition("Java");
		homePage.clickSearchButton();
		logger.log(LogStatus.PASS, "Search button is normal worked");
	}

}
