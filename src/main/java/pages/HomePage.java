package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	

	By freeSpaceButton = By.xpath("/html/body/div[3]/div[2]/a[1]");
	By searchButton = By.id("learntocode_searchicon");
	By searchCondition = By.id("search2");
	By loginLink = By.id("w3loginbtn");
	By communityTab = By.id("u_0_15");
	By supportTab = By.id("u_0_17");
	By oculusQuest = By.cssSelector("#u_0_10");
	By buyNowButton = By.xpath("//button[@class='_8166 _4pg_ _3hmq _4phk _4ph1']//span[contains(text(), 'Buy Now')]");
	By oneTwentyEightGB = By.cssSelector("div>.modal__button-wrapper-128");
	By checkoutButton = By.cssSelector("._4ju3._4pg_._3hmq._4phk");
	By navigationLinks = By.cssSelector("._2xvt._wjv._2xvr");
	By containers = By.xpath("//div[@class='_2xvt _wjv _2xvr']/span/a[contains(@data-testid, 'navlink-')]");
	By headsetsDropdown = By.xpath("//div[@class='_2xvy _8yxy _2xvr _7ujs _8yxz']");
	By headsetsDropdownResults = By.xpath("//div[@class='_2xvy _8yxy _2xvr _7ujs _8yxz']/span/a[contains(@data-testid, 'navlink-')]");
	By forumsTab = By.cssSelector("#u_0_17");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public void waitUntilTittleIs(String title) {
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void hoverOverCommunityTab() {
		new Actions(driver).moveToElement(driver.findElement(communityTab)).perform();
	}
	
	public void clickOnForumsTab() {
		driver.findElement(forumsTab).click();
	}
	
	public void switchTabs() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public void clickLogInLink() {
		driver.findElement(loginLink).click();
	}
	
	public List<WebElement> headsetsDropdownResults(){
		return driver.findElement(headsetsDropdown).findElements(headsetsDropdownResults);
	}

	public void clickOculusQuest() {
		driver.findElement(oculusQuest).click();
	}
	
	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(buyNowButton));
		driver.findElement(buyNowButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(oneTwentyEightGB));
		driver.findElement(oneTwentyEightGB).click();
	}
	
	public boolean isCartPageLoaded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).isDisplayed();
	}

	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}

	public void enterSearchCondition(String textToSearch) {
		driver.findElement(searchCondition).sendKeys(textToSearch);
	}

	public void clickFreeWebsiteButton() {
		driver.findElement(freeSpaceButton).click();
	}
}
