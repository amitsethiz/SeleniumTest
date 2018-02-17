package Package_1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	static final Logger log = LogManager.getLogger(TestClass.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location= 'https://letskodeit.teachable.com/p/practice';");
		log.info("Chrome Browser Opened using JavascriptExecutor");
		long browserHeight = (long) js.executeScript("return window.innerHeight");
		long browserWidth = (long) js.executeScript("return window.innerWidth");
		//Display height and width of Browser
		System.out.println("Height: "+browserHeight);
		System.out.println("Width: "+browserWidth);
		driver.quit();
		log.info("Website Opened");
		
	}
}
