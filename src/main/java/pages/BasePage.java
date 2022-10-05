package pages;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	public static WebDriver driver;
	public static ExtentTest logger = new ExtentTest("sample", "sample");
	public static ExtentReports report;

	@BeforeClass(alwaysRun=true)
	public void setup(ITestContext context) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration();
        config.load("application.yml");
        String baseUrl = config.getString("baseUrl");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		context.setAttribute("WebDriver", driver);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
