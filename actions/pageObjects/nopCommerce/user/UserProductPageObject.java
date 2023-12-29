package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserProductPageUI;

public class UserProductPageObject extends BasePage {
	private WebDriver driver;

	public UserProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementClickable(UserProductPageUI.ADD_REVIEW_LINK);
		clickToElement(UserProductPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManage.getUserProductReviewPage(driver);
	}

	public void clickToButtonOverViewByTextName(String textName) {
		waitForElementClickable(UserProductPageUI.BUTTON_OVERVIEW_BY_TEXT, textName);
		clickToElement(UserProductPageUI.BUTTON_OVERVIEW_BY_TEXT, textName);
	}

	public void selectItemByDropdownNameAndTextValue(String name, String textValue) {
		waitForElementClickable(UserProductPageUI.DORPDOWN_BY_TEXT, name);
		selectItemInDefaultDropDown(UserProductPageUI.DORPDOWN_BY_TEXT, textValue, name);
	}

	public void selectItemByCheckbookOrRadioNameAndTextLabel(String label, String textValue) {
		waitForElementClickable(UserProductPageUI.CHECKBOX_OR_RADIO_BY_LABEL_AND_TEXT_VALUE, label, textValue);
		checkToDefaultCheckboxOrRadio(UserProductPageUI.CHECKBOX_OR_RADIO_BY_LABEL_AND_TEXT_VALUE, label, textValue);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(UserProductPageUI.ADD_TO_CART_BUTTON);
		clickToElement(UserProductPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToUpDateButton() {
		waitForElementClickable(UserProductPageUI.UPDATE_BUTTON);
		clickToElement(UserProductPageUI.UPDATE_BUTTON);
	}

	public void inputToQtyTextbox(String qty) {
		waitForElementVisible(UserProductPageUI.QTY_PRODUCT_TEXTBOX);
		sendkeyToElement(UserProductPageUI.QTY_PRODUCT_TEXTBOX, qty);
	}
}
