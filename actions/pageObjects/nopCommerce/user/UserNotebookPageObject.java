package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserNotebookPageUI;

public class UserNotebookPageObject extends BasePage {
	private WebDriver driver;

	public UserNotebookPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectSortByDropDownByText(String itemValue) {
		waitForElementClickable(UserNotebookPageUI.SORTBY_DROPDOWN);
		selectItemInDefaultDropDown(UserNotebookPageUI.SORTBY_DROPDOWN, itemValue);
	}

	public boolean isProductNameSortByAToZ() {
		waitForAllElementVisible(UserNotebookPageUI.ALL_PRODUCT_NAME);
		return isAllItemHaveTextNameSortByAscending(UserNotebookPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductNameSortByZToA() {
		waitForAllElementVisible(UserNotebookPageUI.ALL_PRODUCT_NAME);
		return isAllItemHaveTextNameSortByDescending(UserNotebookPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductPriceSortByLowToHigh() {
		waitForAllElementVisible(UserNotebookPageUI.ALL_PRODUCT_Price);
		return isAllItemHavePrice$SortByAscending(UserNotebookPageUI.ALL_PRODUCT_Price);
	}

	public boolean isProductPriceSortByHighToLow() {
		waitForAllElementVisible(UserNotebookPageUI.ALL_PRODUCT_Price);
		return isAllItemHavePrice$SortByDescending(UserNotebookPageUI.ALL_PRODUCT_Price);
	}

	public void selectDisplayDropDownByTextNumber(String textNumber) {
		waitForElementClickable(UserNotebookPageUI.DISPLAY_DROPDOWN);
		selectItemInDefaultDropDown(UserNotebookPageUI.DISPLAY_DROPDOWN, textNumber);
	}

	public int countProductOnDisplayed() {
		sleepInSecond(GlobalConstants.getGlobalConstants().getRetryTestFail());
		waitForAllElementVisible(UserNotebookPageUI.ALL_PRODUCT_NAME);
		return getElementSize(UserNotebookPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isPagingNextIconDisplayed() {
		waitForElementVisible(UserNotebookPageUI.ICON_NEXT_PAGE);
		return isElementDisPlayed(UserNotebookPageUI.ICON_NEXT_PAGE);
	}

	public boolean isPagingNextIconUndisplayed() {
		waitForElementUndisplay(UserNotebookPageUI.ICON_NEXT_PAGE);
		return isElementUndisplayed(UserNotebookPageUI.ICON_NEXT_PAGE);
	}

	public void openPagingByTextNumber(String textNumber) {
		waitForElementClickable(UserNotebookPageUI.SELECT_PAGE_BY_TEXT_NUMBER, textNumber);
		clickToElement(UserNotebookPageUI.SELECT_PAGE_BY_TEXT_NUMBER, textNumber);
	}

	public boolean isPagingPreviousIconDisplayed() {
		waitForElementVisible(UserNotebookPageUI.ICON_PREVIOUS_PAGE);
		return isElementDisPlayed(UserNotebookPageUI.ICON_PREVIOUS_PAGE);
	}

	public void clickToAddToCompareButtonByProductName(String productName) {
		waitForElementClickable(UserNotebookPageUI.BUTTON_ADD_TO_COMPARE_BY_TEXT, productName);
		clickToElement(UserNotebookPageUI.BUTTON_ADD_TO_COMPARE_BY_TEXT, productName);
	}

	public UserProductPageObject clickToProductAtProductsGridByText(String productName) {
		waitForElementClickable(UserNotebookPageUI.PRODUCT_NAME_BY_TEXT, productName);
		clickToElement(UserNotebookPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return PageGeneratorManage.getUserProductPage(driver);
	}
}
