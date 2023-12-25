package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserComputerPageUI;

public class UserComputerPageObject extends BasePage {
	private WebDriver driver;

	public UserComputerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectSortByDropDownByText(String itemValue) {
		waitForElementClickable(UserComputerPageUI.SORTBY_DROPDOWN);
		selectItemInDefaultDropDown(UserComputerPageUI.SORTBY_DROPDOWN, itemValue);
	}

	public boolean isProductNameSortByAToZ() {
		waitForAllElementVisible(UserComputerPageUI.ALL_PRODUCT_NAME);
		return isAllItemHaveTextNameSortByAscending(UserComputerPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductNameSortByZToA() {
		waitForAllElementVisible(UserComputerPageUI.ALL_PRODUCT_NAME);
		return isAllItemHaveTextNameSortByDescending(UserComputerPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isProductPriceSortByLowToHigh() {
		waitForAllElementVisible(UserComputerPageUI.ALL_PRODUCT_Price);
		return isAllItemHavePrice$SortByAscending(UserComputerPageUI.ALL_PRODUCT_Price);
	}

	public boolean isProductPriceSortByHighToLow() {
		waitForAllElementVisible(UserComputerPageUI.ALL_PRODUCT_Price);
		return isAllItemHavePrice$SortByDescending(UserComputerPageUI.ALL_PRODUCT_Price);
	}

	public void selectDisplayDropDownByTextNumber(String textNumber) {
		waitForElementClickable(UserComputerPageUI.DISPLAY_DROPDOWN);
		selectItemInDefaultDropDown(UserComputerPageUI.DISPLAY_DROPDOWN, textNumber);
	}

	public int countProductOnDisplayed() {
		sleepInSecond(GlobalConstants.getGlobalConstants().getRetryTestFail());
		waitForAllElementVisible(UserComputerPageUI.ALL_PRODUCT_NAME);
		return getElementSize(UserComputerPageUI.ALL_PRODUCT_NAME);
	}

	public boolean isPagingNextIconDisplayed() {
		waitForElementVisible(UserComputerPageUI.ICON_NEXT_PAGE);
		return isElementDisPlayed(UserComputerPageUI.ICON_NEXT_PAGE);
	}

	public boolean isPagingNextIconUndisplayed() {
		waitForElementUndisplay(UserComputerPageUI.ICON_NEXT_PAGE);
		return isElementUndisplayed(UserComputerPageUI.ICON_NEXT_PAGE);
	}

	public void openPagingByTextNumber(String textNumber) {
		waitForElementClickable(UserComputerPageUI.SELECT_PAGE_BY_TEXT_NUMBER, textNumber);
		clickToElement(UserComputerPageUI.SELECT_PAGE_BY_TEXT_NUMBER, textNumber);
	}

	public boolean isPagingPreviousIconDisplayed() {
		waitForElementVisible(UserComputerPageUI.ICON_PREVIOUS_PAGE);
		return isElementDisPlayed(UserComputerPageUI.ICON_PREVIOUS_PAGE);
	}

	public void clickToAddToCompareButtonByProductName(String productName) {
		waitForElementClickable(UserComputerPageUI.BUTTON_ADD_TO_COMPARE_BY_TEXT, productName);
		clickToElement(UserComputerPageUI.BUTTON_ADD_TO_COMPARE_BY_TEXT, productName);
	}

	public UserProductPageObject clickToProductAtProductsGridByText(String productName) {
		waitForElementClickable(UserComputerPageUI.PRODUCT_NAME_BY_TEXT, productName);
		clickToElement(UserComputerPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return PageGeneratorManage.getUserProductPage(driver);
	}
}
