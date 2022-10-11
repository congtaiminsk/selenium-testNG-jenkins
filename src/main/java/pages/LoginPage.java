package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	By usernameField = By.id("modalusername");
	By passwordField = By.id("current-password");
	By signInButton = By.xpath("/html/body/div[1]/div/div/div[4]/div[1]/div/div[4]/div[1]/button");

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver; 
		wait = new WebDriverWait(driver, 10);
	}
	
	public void enterUsername(String username) {
		wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
	
	public boolean verifyNewPage() {
		wait.until(ExpectedConditions.urlToBe("https://my-learning.w3schools.com/"));
		return driver.getTitle().contains("My Learning");
	}

}
