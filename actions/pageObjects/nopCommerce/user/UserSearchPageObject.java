package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	private WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(UserSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isSearchMessageInforDisplay(String message) {
		waitForElementVisible(UserSearchPageUI.SEARCH_MESSAGE_INFOR_BY_TEXT, message);
		return isElementDisPlayed(UserSearchPageUI.SEARCH_MESSAGE_INFOR_BY_TEXT, message);
	}

	public void inputToSearchKeywordTextbox(String keyword) {
		waitForElementVisible(UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		senkeyToElement(UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, keyword);
	}

	public int getCountNumberProductsOnDisplayed(String keyword) {
		waitForAllElementVisible(UserSearchPageUI.LIST_PRODUCTS_TITLE_BY_TEXT, keyword);
		return getElementSize(UserSearchPageUI.LIST_PRODUCTS_TITLE_BY_TEXT, keyword);
	}

	public boolean isResultProductByTitleTextDisplay(String productTitle) {
		waitForAllElementVisible(UserSearchPageUI.PRODUCTS_TITLE_BY_TEXT, productTitle);
		return isElementDisPlayed(UserSearchPageUI.PRODUCTS_TITLE_BY_TEXT, productTitle);
	}

	public void checkToCheckboxByTextName(String textName) {
		waitForElementClickable(UserSearchPageUI.ADVANCE_SEARCH_CHECKBOX_BY_TEXT_NAME, textName);
		checkToDefaultCheckboxOrRadio(UserSearchPageUI.ADVANCE_SEARCH_CHECKBOX_BY_TEXT_NAME, textName);
	}

	public void unCheckToCheckboxByTextName(String textName) {
		waitForElementClickable(UserSearchPageUI.ADVANCE_SEARCH_CHECKBOX_BY_TEXT_NAME, textName);
		unCheckToDefaultCheckboxRadio(UserSearchPageUI.ADVANCE_SEARCH_CHECKBOX_BY_TEXT_NAME, textName);
	}

	public void selectItemInDropdownByLabelText(String dropdownLabel, String textItem) {
		waitForElementClickable(UserSearchPageUI.DROPDOWN_BY_LABEL_TEXT, dropdownLabel);
		selectItemInDefaultDropDown(UserSearchPageUI.DROPDOWN_BY_LABEL_TEXT, textItem, dropdownLabel);
	}

}
