package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import pages.BasePage;
import pages.HomePage;
import pages.MyLearningPage;

public class LoginPageTest extends BasePage{
	HomePage homePage;
	LoginPage loginPage;
	MyLearningPage myLearningPage;

	String URL_AFTER_LOGIN_SUCCESS = "https://my-learning.w3schools.com/";
    String MY_LEARNING_PAGE_TITLE = "My learning";

	@Test(priority=0)
	public void navigateToLoginPage() {
		homePage = new HomePage(driver);
		homePage.clickLogInLink();
		logger.log(LogStatus.INFO, "Clicking 'Log In' button");
		loginPage = new LoginPage(driver);
	}

	@DataProvider(name="invalidAccounts")
	public Object[][] getInvalidLoginAccounts(){
		return new Object[][] {
			{"InvalidEmail@gmail.com", "testing123"}
		};
	}

	@DataProvider(name="validAccounts")
	public Object[][] getValidLoginAccounts(){
		return new Object[][] {
				{"youcanmakeit01@gmail.com", "demologin123Aa@"}
		};
	}
	
	@Test(priority=1, dataProvider="invalidAccounts")
	public void verifyInvalidLoginCredentials(String testUsername, String testPassword) throws InterruptedException {
		loginPage = new LoginPage(driver);

		logger.log(LogStatus.INFO, "Entering invalid username: " + testUsername);
		loginPage.enterUsername(testUsername);

		logger.log(LogStatus.INFO, "Entering invalid password: " + testPassword);
		loginPage.enterPassword(testPassword);

		logger.log(LogStatus.INFO, "Clicking Sign in button");
		loginPage.clickSignIn();
		Thread.sleep(3000L);
		// verify something here
		// if current url and url after login are different, then login is failed, test case is passed
		logger.log(LogStatus.INFO, driver.getCurrentUrl());
		logger.log(LogStatus.INFO, URL_AFTER_LOGIN_SUCCESS);
		Assert.assertNotEquals(driver.getCurrentUrl(), URL_AFTER_LOGIN_SUCCESS);
		logger.log(LogStatus.PASS, "Log in with invalid credentials failed");
//		https://my-learning.w3schools.com/
	}

	@Test(priority=2, dataProvider="validAccounts")
	public void verifyValidLoginCredentials(String testUsername, String testPassword) throws InterruptedException {
		loginPage = new LoginPage(driver);
		Thread.sleep(3000L);
		loginPage.enterUsername(testUsername);
		logger.log(LogStatus.INFO, "Entering invalid username: " + testUsername);
		Thread.sleep(3000L);
		loginPage.enterPassword(testPassword);
		logger.log(LogStatus.INFO, "Entering invalid password: " + testPassword);
		loginPage.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
		// verify something here
		// if current url and url after login are the same, then login is succeed, test case is passed
		myLearningPage = new MyLearningPage(driver);
        myLearningPage.waitUntilTittleContains(MY_LEARNING_PAGE_TITLE);
		logger.log(LogStatus.INFO, driver.getCurrentUrl());
		logger.log(LogStatus.INFO, URL_AFTER_LOGIN_SUCCESS);
		Assert.assertEquals(URL_AFTER_LOGIN_SUCCESS, driver.getCurrentUrl());
		logger.log(LogStatus.PASS, "Log in with valid credentials successful");
	}

	// Another way to put parameter using <parameter name="username" value="passingValue" /> in TestSuite.xml
	@Test(priority=3)
	@Parameters({"username", "password"})
	public void verifyLogin(String username, String password) {
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		logger.log(LogStatus.INFO, "Entering valid username");
		loginPage.enterPassword(password);
		logger.log(LogStatus.INFO, "Entering valid password");
		loginPage.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
		Assert.assertTrue(loginPage.verifyNewPage());
	}
}	
