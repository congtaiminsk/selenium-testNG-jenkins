package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumAspectSupportTest {

    private WebDriver driver;
    private Page page;

    @BeforeTest
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        page = new Page(driver);
    }

    @AfterTest
    public void dropDriver() {
        driver.close();
        driver.quit();
    }

    @Test
    public void simpleTest() {
        driver.get("https://www.baeldung.com");
        page.clickOnSearch();
        System.out.println("DONE");
    }
}