package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SpacePage;

public class SpacePageTest extends BasePage{

	HomePage homePage;
	SpacePage spacePage;

	@Test(priority=1)
	public void tc_002() {
		homePage = new HomePage(driver);

		String winHandleBefore = driver.getWindowHandle();
		logger.log(LogStatus.WARNING, "before switch: " + driver.getTitle());
		homePage.clickFreeWebsiteButton();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		spacePage = new SpacePage(driver);
		logger.log(LogStatus.WARNING, "after switch: " + spacePage.getTitle());
	}
}
