package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.nopCommerce.user.UserNoteBookPageUI;

public class UserNoteBookPageObject extends BasePage {
	private WebDriver driver;

	public UserNoteBookPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectSortByDropDownByText(String itemValue) {
		waitForElementClickable(UserNoteBookPageUI.SORTBY_DROPDOWN);
		selectItemInDefaultDropDown(UserNoteBookPageUI.SORTBY_DROPDOWN, itemValue);
	}

	public boolean isProductNameSortByAToZ() {
		waitForAllElementVisible(UserNoteBookPageUI.ALL_PRODUCT_NAME);
		return isAllItemHaveTextNameSortByAscending(UserNoteBookPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductNameSortByZToA() {
		waitForAllElementVisible(UserNoteBookPageUI.ALL_PRODUCT_NAME);
		return isAllItemHaveTextNameSortByDescending(UserNoteBookPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductPriceSortByLowToHigh() {
		waitForAllElementVisible(UserNoteBookPageUI.ALL_PRODUCT_Price);
		return isAllItemHavePrice$SortByAscending(UserNoteBookPageUI.ALL_PRODUCT_Price);
	}

	public boolean isProductPriceSortByHighToLow() {
		waitForAllElementVisible(UserNoteBookPageUI.ALL_PRODUCT_Price);
		return isAllItemHavePrice$SortByDescending(UserNoteBookPageUI.ALL_PRODUCT_Price);
	}

	public void selectDisplayDropDownByTextNumber(String textNumber) {
		waitForElementClickable(UserNoteBookPageUI.DISPLAY_DROPDOWN);
		selectItemInDefaultDropDown(UserNoteBookPageUI.DISPLAY_DROPDOWN, textNumber);
	}

	public int countProductOnDisplayed() {
		sleepInSecond(GlobalConstants.getGlobalConstants().getRetryTestFail());
		waitForAllElementVisible(UserNoteBookPageUI.ALL_PRODUCT_NAME);
		return getElementSize(UserNoteBookPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isPagingNextIconDisplayed() {
		waitForElementVisible(UserNoteBookPageUI.ICON_NEXT_PAGE);
		return isElementDisPlayed(UserNoteBookPageUI.ICON_NEXT_PAGE);
	}

	public boolean isPagingNextIconUndisplayed() {
		waitForElementInvisible(UserNoteBookPageUI.ICON_NEXT_PAGE);
		return isElementUndisplayed(UserNoteBookPageUI.ICON_NEXT_PAGE);
	}

	public void openPagingByTextNumber(String textNumber) {
		waitForElementClickable(UserNoteBookPageUI.SELECT_PAGE_BY_TEXT_NUMBER, textNumber);
		clickToElement(UserNoteBookPageUI.SELECT_PAGE_BY_TEXT_NUMBER, textNumber);
	}

	public boolean isPagingPreviousIconDisplayed() {
		waitForElementVisible(UserNoteBookPageUI.ICON_PREVIOUS_PAGE);
		return isElementDisPlayed(UserNoteBookPageUI.ICON_PREVIOUS_PAGE);
	}
}
