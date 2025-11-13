package giftCardTest;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import giftCard.GiftCard;

public class GiftCardTest extends BaseTest{

	@Test(enabled = false)
	public void getGiftCards() {
		GiftCard gift=new GiftCard(driver);
		gift.getGiftCard();
	}
	
	@Test
	public void getGiftPrices() {
		GiftCard gift=new GiftCard(driver);
		gift.getPrices();
	}
	
	
}
