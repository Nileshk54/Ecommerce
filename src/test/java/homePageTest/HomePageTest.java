package homePageTest;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import homePage.HomePage;

public class HomePageTest extends BaseTest{

	@Test
	public void getAllProductType() {
		
		HomePage home=new HomePage(driver);
		home.getAllProductType();
	}
	
	
}
