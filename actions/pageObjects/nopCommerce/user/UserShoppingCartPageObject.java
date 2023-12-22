package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	private WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductNameBytextDisplayed(String productName) {
		waitForAllElementVisible(UserShoppingCartPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserShoppingCartPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}
}
