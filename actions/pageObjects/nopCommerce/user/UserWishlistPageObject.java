package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage {
	private WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductNameBytextDisplayed(String productName) {
		waitForElementVisible(UserWishlistPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserWishlistPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public void clickToWishlistSharingLink() {
		waitForElementClickable(UserWishlistPageUI.WISHLIST_SHARING_LINK);
		clickToElement(UserWishlistPageUI.WISHLIST_SHARING_LINK);
	}

	public boolean isTitleTableProductsByTextDispaly(String titleTable) {
		waitForAllElementVisible(UserWishlistPageUI.TITLE_TABLE_BY_TEXT, titleTable);
		return isElementDisPlayed(UserWishlistPageUI.TITLE_TABLE_BY_TEXT, titleTable);
	}

	public void checkToCheckboxAddToCartByProductName(String productName) {
		waitForElementClickable(UserWishlistPageUI.ADD_TO_CARD_CHECKBOX_BY_TEXT, productName);
		checkToDefaultCheckboxOrRadio(UserWishlistPageUI.ADD_TO_CARD_CHECKBOX_BY_TEXT, productName);
	}

	public UserShoppingCartPageObject clickToAddToCartButton() {
		waitForElementClickable(UserWishlistPageUI.ADD_TO_CARt_BUTTON);
		clickToElement(UserWishlistPageUI.ADD_TO_CARt_BUTTON);
		return PageGeneratorManage.getUserShoppingCartPage(driver);
	}

	public boolean isProductNameBytextUndisplayed(String productName) {
		waitForElementUndisplay(UserWishlistPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementUndisplayed(UserWishlistPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public void clickToCheckboxRemoveByProductName(String productName) {
		waitForElementClickable(UserWishlistPageUI.REMOVE_CHECKBOX_BY_TEXT, productName);
		clickToElement(UserWishlistPageUI.REMOVE_CHECKBOX_BY_TEXT, productName);
	}

	public boolean isMessageWishlistByTextDispaly(String message) {
		waitForAllElementVisible(UserWishlistPageUI.MESSAGE_WISHLIST_BY_TEXT, message);
		return isElementDisPlayed(UserWishlistPageUI.MESSAGE_WISHLIST_BY_TEXT, message);
	}

}
