package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.CommonUtil;


public class HomePage {
	
	static WebDriver driver;
	  
	  public HomePage(WebDriver driver){
			 this.driver=driver;
			
		}
	  public static By viewprofile=By.xpath("//div[@class='view-profile-wrapper']/a");
	  public static By icon=By.cssSelector("em.icon.edit");
	  public static By linknumber=By.linkText("Change Mobile Number");
	  public static By actual=By.cssSelector("span[class='fs13']");
	  public static By city=By.xpath("//input[@class='sugInp']");
	  public static By city_suggestion=By.xpath("//div[contains(@class,'Sbtn')]"); 
	  public static By loclity=By.xpath("//input[@id='locality-droopeFor']"); 
	
	  public static By save_button=By.xpath("//button[@id='saveBasicDetailsBtn']");
	 
	  
	
		public void numberValidate() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(viewprofile).click();
			driver.findElement(icon).click();
			driver.findElement(linknumber).click();
			String actual_number=driver.findElement(actual).getText();
			String expected_number="9440644876";
			if(actual_number.equals(expected_number)) {
				System.out.println("Number is updated" + actual_number);
			}
				
		}
		
		public void cityUpdate(String workcity,String locality) throws Exception {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(viewprofile).click();
			driver.findElement(icon).click();
			driver.findElement(city).clear();
			driver.findElement(city).sendKeys(workcity);
			
			CommonUtil.waitFOrElement(driver, city_suggestion);
			driver.findElement(city_suggestion).click();
			driver.findElement(loclity).sendKeys(locality);
			driver.findElement(save_button).click();
						
		}

}
