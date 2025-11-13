package giftCard;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseTest.BaseTest;
import utils.ScrollUtils;
import utils.WaitUtils;

public class GiftCard extends BaseTest {

	WebDriver driver;

	private By giftCardElement = By.xpath("//a[text()='Gift Cards']");
	private By giftTitlesElement = By.xpath("//h2/a");
	

	public GiftCard(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getGiftCard() {
		WaitUtils.waitTillVisibilityOfElement(driver, giftCardElement);
		
		driver.findElement(giftCardElement).click();
		ScrollUtils.scrollDown(driver, 500);
		List<WebElement> giftTitles=driver.findElements(giftTitlesElement);
		log.info("Total " + giftTitles.size() + " Found");
		List<String> gifts = new ArrayList<String>();
		for(WebElement giftTitle:giftTitles) {
			gifts.add(giftTitle.getText());
			log.info(giftTitle.getText());
			
		}
		log.info(gifts);
		return gifts;
	}
	
	public List<Integer> getPrices() {
		List<String> giftTitles= getGiftCard();
		List<Integer> allGiftPrice=new ArrayList<Integer>();
		
		for(String giftTitle:giftTitles) {
			String price=giftTitle.split(" ")[0].replace("$", "");
			allGiftPrice.add(Integer.parseInt(price));
		}
		log.info(allGiftPrice);
		
		int maxPrice=Integer.MIN_VALUE;
		int minPrice=Integer.MAX_VALUE;
		
		int max=0;
		int min=0;
		
		for(int price:allGiftPrice) {
			System.out.println(price +" ARE ");
			if(price>minPrice) {
				max=price;
			}
			
			if(price<maxPrice) {
				min=price;
			}
		}
		
		log.info("Min price is " + min);
		log.info("Max price is " + max);
		
		return allGiftPrice;
	}

}
