package TestAutomation.TestNGpractice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ExcelReader;

public class NaukriTest extends BaseTest {
	

	@Test(enabled=true,dataProvider = "dynamicExcelProvider", dataProviderClass = ExcelReader.class)
	public static void login(String username, String password) throws InterruptedException {
		
		 LoginPage login= new LoginPage(driver);
		 login.loginMethod(username,password);
		 login.validateName("Yasmeen Shaik");
		 
		 
	}
	
	@Test(enabled=false,dataProvider = "dynamicExcelProvider", dataProviderClass = ExcelReader.class)
	public static void NumberUpdate(String username, String password) throws Exception {
		
		
		HomePage hp=new HomePage(driver);
		LoginPage login= new LoginPage(driver);
		 login.loginMethod(username,password);
		hp.cityUpdate("Chennai","Velachery");
			
	}
	
	
}
