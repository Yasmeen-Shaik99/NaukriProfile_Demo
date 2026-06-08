package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {
	
	public static void waitFOrElement(WebDriver driver,By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public static void highlightElement(WebDriver driver,By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", driver.findElement(element));
	}
	
	public static void removehighlightElement(WebDriver driver,By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', '');", driver.findElement(element));
	}
 
}
