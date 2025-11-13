package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.BaseTest;

public class WaitUtils extends BaseTest{

	public static void waitTillVisibilityOfElement(WebDriver driver,By element) {
		log.info("Waiting for Element " + element);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		log.info("Wait Completed for Element " + element);
	}
	
}
