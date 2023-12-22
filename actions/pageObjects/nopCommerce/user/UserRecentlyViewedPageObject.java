package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.nopCommerce.user.UserRecentlyViewedPageUI;

public class UserRecentlyViewedPageObject extends BasePage {
	private WebDriver driver;

	public UserRecentlyViewedPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public int countProductOnDisplayed() {
		sleepInSecond(GlobalConstants.getGlobalConstants().getRetryTestFail());
		waitForAllElementVisible(UserRecentlyViewedPageUI.ALL_PRODUCT_NAME);
		return getElementSize(UserRecentlyViewedPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductNameAtRecentlyViewedBytextDisplayed(String productName) {
		waitForElementVisible(UserRecentlyViewedPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserRecentlyViewedPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}
}
