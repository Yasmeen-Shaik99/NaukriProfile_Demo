package TestAutomation.TestNGpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	static WebDriver driver;

	@BeforeMethod
	public static void initializeDriver() throws Throwable {
		
		String filePath = "src/main/resources/config.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties prop = new Properties();
        prop.load(fis);
        String browser=prop.getProperty("browser");
        if(browser.equals("chrome")) {
        	driver=new ChromeDriver();
        }
        
		
	}
	
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
