package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	private WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductNameBytextDisplayed(String productName) {
		waitForElementVisible(UserShoppingCartPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserShoppingCartPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public String getInforProductByProductName(String productName) {
		sleepInSecond(2);
		waitForElementVisible(UserShoppingCartPageUI.INFOR_BY_PRODUCT_NAME, productName);
		return getElementText(UserShoppingCartPageUI.INFOR_BY_PRODUCT_NAME, productName);
	}

	public String getTextOnShoppingCartLink() {
		waitForElementVisible(UserShoppingCartPageUI.TEXT_ON_SHOPPING_CART_LINK);
		return getElementText(UserShoppingCartPageUI.TEXT_ON_SHOPPING_CART_LINK);
	}

	public String getNumberProductByProductNameAndAtribute(String productName, String atribute) {
		waitForElementVisible(UserShoppingCartPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
		return getElementAttribute(UserShoppingCartPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, "value", productName, atribute);
	}

	public String getTotalPriceProductByProductNameAndAtribute(String productName, String atribute) {
		waitForElementVisible(UserShoppingCartPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
		return getElementText(UserShoppingCartPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
	}

	public UserProductPageObject clickToEditLinkByProductName(String productName) {
		waitForElementClickable(UserShoppingCartPageUI.PRODUCT_EDIT_LINK_BY_PRODUCT_NAME, productName);
		clickToElement(UserShoppingCartPageUI.PRODUCT_EDIT_LINK_BY_PRODUCT_NAME, productName);
		return PageGeneratorManage.getUserProductPage(driver);
	}

	public void clickToChechboxRemoveByProductName(String productName) {
		waitForElementClickable(UserShoppingCartPageUI.REMOVE_CHECKBOX_BY_PRODUCT_NAME, productName);
		clickToElement(UserShoppingCartPageUI.REMOVE_CHECKBOX_BY_PRODUCT_NAME, productName);
	}

	public boolean isMessageShoppingCartByTextDisplayed(String message) {
		waitForElementVisible(UserShoppingCartPageUI.MESSAGE_SHOPPING_CART_BY_TEXT, message);
		return isElementDisPlayed(UserShoppingCartPageUI.MESSAGE_SHOPPING_CART_BY_TEXT, message);
	}

	public boolean isMessageShoppingCartByTextUndisplayed(String message) {
		waitForElementUndisplay(UserShoppingCartPageUI.MESSAGE_SHOPPING_CART_BY_TEXT, message);
		return isElementUndisplayed(UserShoppingCartPageUI.MESSAGE_SHOPPING_CART_BY_TEXT, message);
	}

	public boolean isProductNameByTextUndisplayed(String productName) {
		waitForElementUndisplay(UserShoppingCartPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementUndisplayed(UserShoppingCartPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public void inputToQtyTextboxByProductName(String productName, String atribute, String qty) {
		waitForElementVisible(UserShoppingCartPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
		sendkeyToElement(UserShoppingCartPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, qty, productName, atribute);
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public void selectItemInGiftWrappingDropdownBytext(String textValue) {
		waitForElementVisible(UserShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
		selectItemInDefaultDropDown(UserShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN, textValue);
	}

	public void checkToTermsOfServiceCheckbox() {
		waitForElementClickable(UserShoppingCartPageUI.TERMS_OF_SERVICE_CHECKBOX);
		checkToDefaultCheckboxOrRadio(UserShoppingCartPageUI.TERMS_OF_SERVICE_CHECKBOX);
	}

	public UserCheckOutPageObject clickToCheckOutButton() {
		waitForElementClickable(UserShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(UserShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManage.getUserCheckOutPage(driver);
	}

	public void isShoppingCartEmpty() {
		if (isMessageShoppingCartByTextUndisplayed("Your Shopping Cart is empty!")) {
			clickToChechboxRemoveByProductName("Apple MacBook Pro 13-inch");
		}
	}
}
