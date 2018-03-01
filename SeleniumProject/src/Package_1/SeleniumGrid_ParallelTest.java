package Package_1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumGrid_ParallelTest {
	private WebDriver driver;
	String directoryPath;
	ExtentReports reports;
	ExtentTest test;
	SearchPageFactory searchPage;
	String catchImagePath;
	String attachImagePath;
	
	@BeforeClass
	@Parameters({"browserType"})
	public void beforeClass(String browserType) throws MalformedURLException {
		String currentDate = CommonMethods.generateDataTime();
		searchPage = new SearchPageFactory(driver);
		directoryPath = "C:\\Users\\Amit Sethi\\git\\SeleniumTest\\SeleniumProject\\Screenshots\\Firefox\\";
		reports = new ExtentReports("C:\\Users\\Amit Sethi\\git\\SeleniumTest\\SeleniumProject\\Screenshots\\Firefox\\firefoxTest_"+currentDate+".html");
		test = reports.startTest("Module Name");
		driver = CommonMethods.WebDriverinit(browserType);
		searchPage = new SearchPageFactory(driver);
	}

	@Test
	public void radioButton() throws IOException {
		searchPage.radioButton.click();
		test.log(LogStatus.INFO, "Test Case 2 Completed");
		catchImagePath = CommonMethods.takeScreenshot(driver, "TestCase2", directoryPath);
		attachImagePath = test.addScreenCapture(catchImagePath);
		test.log(LogStatus.PASS, "Test Case 2 Passed", attachImagePath);		
	}

	@Test
	public void dropDown() throws IOException {
		Select dropDown = new Select(searchPage.dropDown);
		dropDown.selectByIndex(1);
		test.log(LogStatus.INFO, "Test Case 3 Completed");
		catchImagePath = CommonMethods.takeScreenshot(driver, "TestCase3", directoryPath);
		attachImagePath = test.addScreenCapture(catchImagePath);
		test.log(LogStatus.PASS, "Test Case 3 Passed", attachImagePath);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		reports.endTest(test);
		reports.flush();
	}
}