package TestAutomation.TestNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class practiceDemo {
	@Test
	public void firstMethod() {
		System.out.println("I will execute first");		
	}
	@Test(groups= {"Testing"})
	public void secondMethod() {
		System.out.println("I will execute second");
		
	}
	@BeforeTest
	public void thirdMethod() {
		System.out.println("I am  before test ");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}