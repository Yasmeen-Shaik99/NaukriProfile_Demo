package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.CommonUtil;

public class LoginPage {
	
	  static WebDriver driver;
	  
	  public LoginPage(WebDriver driver){
			 this.driver=driver;
			
		}
	  
	  public static By id=By.id("login_Layer");
	  public static By username=By.xpath("//label[text()='Email ID / Username']/following-sibling::input");
	  public static By password=By.xpath("//input[@type='password']");
	  public static By submit=By.cssSelector("button[type='submit']");
	  public static By name=By.xpath("//div[text()='Yasmeen Shaik']");

	
	 
	
	public static void loginMethod(String user_name, String pass_word) {
		
		 driver.manage().window().maximize();
		 driver.get("https://www.naukri.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 driver.findElement(id).click();
		 driver.findElement(username).sendKeys(user_name);
		 driver.findElement(password).sendKeys(pass_word);
		 driver.findElement(submit).click();
	}
	public static void validateName(String act) throws InterruptedException {
		CommonUtil.waitFOrElement(driver, name);
		CommonUtil.highlightElement(driver, name);
		Thread.sleep(3000);
		String exp=driver.findElement(name).getText();
		System.out.println("expexted" + exp);
		System.out.println("actual "+ act);


		if(act.equals(exp)) {
			System.out.println("name is matching "+ exp);
		}
		else {
			System.out.println("name is not matching "+ exp);

		}
		CommonUtil.removehighlightElement(driver, name);
		Thread.sleep(3000);
		
		
	}
	

}
