package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyLearningPage {

	WebDriver driver;
	WebDriverWait wait;

	public MyLearningPage(WebDriver driver) {
		this.driver=driver; 
		wait = new WebDriverWait(driver, 10);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void waitUntilTittleContains(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}
}
