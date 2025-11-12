package homePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseTest.BaseTest;

public class HomePage extends BaseTest{

	WebDriver driver;
	By totalOptions=By.xpath("//nav[@class='menu-container menu-dropdown']/div[2]/child::div");
	By totalDropdownProduct=By.xpath("//nav[@class='menu-container menu-dropdown']//div[@tabindex='-1']/a");
	By totalDirectProduct=By.xpath("//nav[@class='menu-container menu-dropdown']/div[2]/child::div[@class='menu__item']/a");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getAllProductType() {
		List <WebElement> allOptions=driver.findElements(totalOptions);
		log.info(allOptions.size() + " No of options present" );
		
		List<WebElement> dropdownList=driver.findElements(totalDropdownProduct);
		log.info(dropdownList.size() + " Dropdown found ");
		
		for(WebElement dropdown:dropdownList) {
			log.info(dropdown.getText());
		}
		
		List<WebElement> directProduts=driver.findElements(totalDirectProduct);
		log.info(directProduts.size() +" No of Direct Option Present ");
		
		for(WebElement directProduct:directProduts) {
			log.info(directProduct.getText());
		}
	}
	
}
