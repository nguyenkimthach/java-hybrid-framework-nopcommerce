package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserComparePageUI;

public class UserComparePageObject extends BasePage {
	private WebDriver driver;

	public UserComparePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductNameBytextDisplayed(String productName) {
		waitForElementVisible(UserComparePageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserComparePageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public boolean isRemoveButtonByProductNameDisplayed(String productName) {
		int columIndex = getElementSize(UserComparePageUI.COLUMN_INDEX_BY_NAME, productName);
		waitForElementVisible(UserComparePageUI.REMOVE_BUTTON_BY_COLUM_INDEX, String.valueOf(columIndex));
		return isElementDisPlayed(UserComparePageUI.REMOVE_BUTTON_BY_COLUM_INDEX, String.valueOf(columIndex));
	}

	public boolean isPriceTextByProductNameAtRowNameDisplayed(String productName, String rowName) {
		int columIndex = getElementSize(UserComparePageUI.COLUMN_INDEX_BY_NAME, productName);
		waitForElementVisible(UserComparePageUI.TEXT_BY_ROW_NAME_AND_COLUM_INDEX, rowName, String.valueOf(columIndex));
		return isElementDisPlayed(UserComparePageUI.TEXT_BY_ROW_NAME_AND_COLUM_INDEX, rowName, String.valueOf(columIndex));
	}

	public void clickToClearListButton() {
		waitForElementClickable(UserComparePageUI.CLEARLIST_BUTTON);
		clickToElement(UserComparePageUI.CLEARLIST_BUTTON);
	}

	public boolean isProductNameBytextUndisplayed(String productName) {
		waitForElementUndisplay(UserComparePageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementUndisplayed(UserComparePageUI.PRODUCT_NAME_BY_TEXT, productName);
	}
}
