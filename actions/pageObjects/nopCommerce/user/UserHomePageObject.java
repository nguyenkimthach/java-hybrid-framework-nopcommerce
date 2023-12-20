package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(UserHomePageUI.REGISTER_LINK);
		clickToElement(UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManage.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(UserHomePageUI.LOGIN_LINK);
		clickToElement(UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManage.getUserLoginPage(driver);
	}

	public boolean isMyaccountLinkDisplayed() {
		waitForElementVisible(UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisPlayed(UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public UserMyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManage.getMyAccountPage(driver);
	}

	public UserProductPageObject clickToProductAtFeaturedProductsListByText(String productName) {
		waitForElementClickable(UserHomePageUI.PRODUCT_AT_FEATURED_LIST_BY_TEXT, productName);
		clickToElement(UserHomePageUI.PRODUCT_AT_FEATURED_LIST_BY_TEXT, productName);
		return PageGeneratorManage.getUserProductPage(driver);
	}
}
