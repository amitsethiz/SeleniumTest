package Package_1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;




public class CommonMethods{	
	public static WebDriver driver;
	public static String baseUrl;
	public static String nodeURL;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String catchImagePath;
	public static String attachImagePath;
	public static String directoryPath;
	public static SearchPageFactory searchPage;

	public static String generateDataTime() {
		Date now = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		String currentDate = df.format(now).toString().replace("/", "_");
		currentDate = currentDate.toString().replace(" ", "_");
		currentDate = currentDate.toString().replace(":", "_");
		currentDate = currentDate.toString().replace(",", "_");

		return currentDate;

	}

	public static String takeScreenshot(WebDriver driver, String fileName, String directoryPath) throws IOException {
		String currentDate = generateDataTime();
		fileName = fileName + currentDate +".png";		
		//		String directoryPath = "C:\\JavaSelenium\\eclipseworkspace\\SeleniumProject\\Screenshots\\Firefox\\";
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(directoryPath+fileName);
		FileUtils.copyFile(screenshotFile, new File(directoryPath+fileName));
		String destination = directoryPath+fileName;
		return destination;		
	}

	public static WebDriver WebDriverinit(String browserType) throws MalformedURLException {
		if (browserType.equalsIgnoreCase("Firefox")) {
			//			System.setProperty("webdriver.gecko.driver", "C:\\JavaSelenium\\eclipseworkspace\\SeleniumProject\\geckodriver.exe");
			baseUrl = "https://letskodeit.teachable.com/p/practice"; //"https://www.expedia.com/";
			nodeURL = "http://192.168.0.103:5555/wd/hub";
			//			nodeURL = "http://localhost:4444/wd/hub";
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");	
			caps.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), caps);
			//			driver = new FirefoxDriver();

			searchPage = new SearchPageFactory(driver);

			// Maximize the browser's window
			//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);			
		}
		if (browserType.equalsIgnoreCase("chrome")) {
			//			System.setProperty("webdriver.chrome.driver", "C:\\JavaSelenium\\eclipseworkspace\\SeleniumProject\\chromedriver.exe");
			baseUrl = "https://letskodeit.teachable.com/p/practice"; //"https://www.expedia.com/";
			nodeURL = "http://192.168.0.103:5555/wd/hub";
			//			nodeURL = "http://localhost:4444/wd/hub";
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");	
			caps.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), caps);
			searchPage = new SearchPageFactory(driver);

			// Maximize the browser's window
			//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);			
		}

		if (browserType.equalsIgnoreCase("android")) {
			//			System.setProperty("webdriver.chrome.driver", "C:\\JavaSelenium\\eclipseworkspace\\SeleniumProject\\chromedriver.exe");
			baseUrl = "https://letskodeit.teachable.com/p/practice"; //"https://www.expedia.com/";
			nodeURL = "http://127.0.0.1:4723/wd/hub";
			//			nodeURL = "http://localhost:4444/wd/hub";
			DesiredCapabilities caps = DesiredCapabilities.android();
			
			
			
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
			caps.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 4");
//			caps.setCapability(MobileCapabilityType.VERSION, "7.0 NRD90M");
			//			driver = new RemoteWebDriver(new URL(nodeURL), caps);
			driver = new AndroidDriver(new URL(nodeURL), caps);
			searchPage = new SearchPageFactory(driver);

			// Maximize the browser's window
			//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);			
		}

		return driver;

	}

}
