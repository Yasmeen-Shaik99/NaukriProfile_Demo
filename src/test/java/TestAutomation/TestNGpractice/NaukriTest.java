package TestAutomation.TestNGpractice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class NaukriTest extends BaseTest {
	

	
	@Test(enabled=true)
	public static void login() throws InterruptedException {
		
		 LoginPage login= new LoginPage(driver);
		 login.loginMethod();
		 login.validateName("Yasmeen Shaik");
		 
		 
	}
	
	@Test(enabled=false)
	public static void NumberUpdate() throws Exception {
		
		
		HomePage hp=new HomePage(driver);
		LoginPage login= new LoginPage(driver);
		 login.loginMethod(); 
		hp.cityUpdate("Chennai","Velachery");
			
	}
	
	
}
