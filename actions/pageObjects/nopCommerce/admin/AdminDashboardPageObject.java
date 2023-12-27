package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isDashboardPageTittleDisplayedByText(String title) {
		waitForElementVisible(AdminDashboardPageUI.DASHBOARD_PAGE_TITLE_BY_TEXT, title);
		return isElementDisPlayed(AdminDashboardPageUI.DASHBOARD_PAGE_TITLE_BY_TEXT, title);
	}

	public void openSubMenuByMenuTypeAndText(String menuType, String subMenu) {
		if (isElementUndisplayed(AdminDashboardPageUI.SUBMENU_TYPE_BY_MENU_TYPE_AND_TEXT, menuType, subMenu)) {
			waitForElementClickable(AdminDashboardPageUI.MENU_TYPE_BY_TEXT, menuType);
			clickToElement(AdminDashboardPageUI.MENU_TYPE_BY_TEXT, menuType);
			sleepInSecond(1);
		}

		waitForElementClickable(AdminDashboardPageUI.SUBMENU_TYPE_BY_MENU_TYPE_AND_TEXT, menuType, subMenu);
		clickToElement(AdminDashboardPageUI.SUBMENU_TYPE_BY_MENU_TYPE_AND_TEXT, menuType, subMenu);
	}

	public void openSearchBox() {
		if (isElementUndisplayed(AdminDashboardPageUI.PRODUCT_FAR_UP_ICON)) {
			waitForElementClickable(AdminDashboardPageUI.PRODUCT_AREA_ICON_SERCH);
			clickToElement(AdminDashboardPageUI.PRODUCT_AREA_ICON_SERCH);
		}
	}

	public void inputToProductNameTextbox(String productName) {
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_NAME_TEXTBOX);
		senkeyToElement(AdminDashboardPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void inputToGoDirectlySKUTextbox(String skuName) {
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_GO_DIRECTLY_TO_SKU_TEXTBOX);
		senkeyToElement(AdminDashboardPageUI.PRODUCT_GO_DIRECTLY_TO_SKU_TEXTBOX, skuName);
	}

	public void clickToProductSearchButton() {
		waitForElementClickable(AdminDashboardPageUI.PRODUCT_SEARCH_BUTTON);
		clickToElement(AdminDashboardPageUI.PRODUCT_SEARCH_BUTTON);
	}

	public String getTextNumberProductOnGrid() {
		sleepInSecond(2);
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_NUMBER_GRID_INFOR);
		return getElementText(AdminDashboardPageUI.PRODUCT_NUMBER_GRID_INFOR);
	}

	public boolean isProductNameByTextDisplayed(String productName) {
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(AdminDashboardPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public String getTextItemByProductNameAndColumName(String productName, String columName) {
		int columIndex = getElementSize(AdminDashboardPageUI.PRODUCT_COLUM_INDEX_BY_NAME, columName) + 1;
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_TEXT_BY_PRODUCT_NAME_AND_COLUM_INDEX, productName, String.valueOf(columIndex));
		return getElementText(AdminDashboardPageUI.PRODUCT_TEXT_BY_PRODUCT_NAME_AND_COLUM_INDEX, productName, String.valueOf(columIndex));
	}

	public boolean isPublicItemCheckedByProductNameDisplayed(String productName) {
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_CHECK_PUBLIC_ICON_BY_PRODUCT_NAME, productName);
		return isElementDisPlayed(AdminDashboardPageUI.PRODUCT_CHECK_PUBLIC_ICON_BY_PRODUCT_NAME, productName);
	}

	public void selectItemInDropdownByLabelName(String labelName, String item) {
		waitForElementClickable(AdminDashboardPageUI.PRODUCT_DROPDOWN_BY_LABEL_NAME, labelName);
		selectItemInDefaultDropDown(AdminDashboardPageUI.PRODUCT_DROPDOWN_BY_LABEL_NAME, item, labelName);
	}

	public void uncheckToSearchSubcategories() {
		waitForElementClickable(AdminDashboardPageUI.PRODUCT_SEARCH_SUBCATEGORIES_CHECKBOX);
		unCheckToDefaultCheckboxRadio(AdminDashboardPageUI.PRODUCT_SEARCH_SUBCATEGORIES_CHECKBOX);
	}

	public void checkToSearchSubcategories() {
		waitForElementClickable(AdminDashboardPageUI.PRODUCT_SEARCH_SUBCATEGORIES_CHECKBOX);
		checkToDefaultCheckboxOrRadio(AdminDashboardPageUI.PRODUCT_SEARCH_SUBCATEGORIES_CHECKBOX);
	}

	public boolean isMessageDataTableDisplayed(String message) {
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_MESSAGE_DATA_TABEL_BY_TEXT, message);
		return isElementDisPlayed(AdminDashboardPageUI.PRODUCT_MESSAGE_DATA_TABEL_BY_TEXT, message);
	}

	public void clickToGoButton() {
		waitForElementClickable(AdminDashboardPageUI.PRODUCT_GO_BUTTON);
		clickToElement(AdminDashboardPageUI.PRODUCT_GO_BUTTON);
	}

	public boolean isHeaderTitleByTextDisplayed(String title) {
		waitForElementVisible(AdminDashboardPageUI.PRODUCT_HEADER_TITLE_BY_TEXT, title);
		return isElementDisPlayed(AdminDashboardPageUI.PRODUCT_HEADER_TITLE_BY_TEXT, title);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_ADD_NEW_BUTTON);
		clickToElement(AdminDashboardPageUI.CUSTOMER_ADD_NEW_BUTTON);
	}

	public void inPutToCustomerAreaTextboxByLabel(String label, String text) {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_TEXTBOX_BY_TEXT_LABEL, label);
		senkeyToElement(AdminDashboardPageUI.CUSTOMER_TEXTBOX_BY_TEXT_LABEL, text, label);
	}

	public void selectGenderRadioButtonByLabel(String label) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_GENDER_RADIO_BY_TEXT_LABEL, label);
		checkToDefaultCheckboxOrRadio(AdminDashboardPageUI.CUSTOMER_GENDER_RADIO_BY_TEXT_LABEL, label);
	}

	public void clickToDeleteRoleButtonByText(String textRole) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_DELETE_ROLE_BUTTON_BY_TEXT, textRole);
		clickToElement(AdminDashboardPageUI.CUSTOMER_DELETE_ROLE_BUTTON_BY_TEXT, textRole);
	}

	public void selectItemInCustomerRolesDropdown(String item) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_ROLE_PARENT_DROPDOWN);
		clickToElement(AdminDashboardPageUI.CUSTOMER_ROLE_PARENT_DROPDOWN);

		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_ROLE_ITEM_IN_DROPDOWN, item);
		clickToElement(AdminDashboardPageUI.CUSTOMER_ROLE_ITEM_IN_DROPDOWN, item);
	}

	public void inPutTAdminCommentTextbox(String text) {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_ADMIN_COMMENT_TEXTBOX);
		senkeyToElementUserClearByDeleteKey(AdminDashboardPageUI.CUSTOMER_ADMIN_COMMENT_TEXTBOX, text);
	}

	public void clickToSaveAndContinueEditButton() {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_SAVE_AND_CONTINUE_EDIT_BUTTON);
		clickToElement(AdminDashboardPageUI.CUSTOMER_SAVE_AND_CONTINUE_EDIT_BUTTON);
	}

	public boolean isUpdateSuccessMessageByTextDispaly(String message) {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_SUCCESS_MESSAGE, message);
		return isElementDisPlayed(AdminDashboardPageUI.CUSTOMER_SUCCESS_MESSAGE, message);
	}

	public String getCustomerTextboxInforByLabel(String label) {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_TEXTBOX_BY_TEXT_LABEL, label);
		return getElementAttribute(AdminDashboardPageUI.CUSTOMER_TEXTBOX_BY_TEXT_LABEL, "value", label);
	}

	public boolean isCustomerGenderRadioButtonByLabelSelected(String label) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_GENDER_RADIO_BY_TEXT_LABEL, label);
		return isElementSelected(AdminDashboardPageUI.CUSTOMER_GENDER_RADIO_BY_TEXT_LABEL, label);
	}

	public boolean isCustomerRoleInforByLabelDisplayed(String tagName) {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_TAG_BY_TEXT, tagName);
		return isElementDisPlayed(AdminDashboardPageUI.CUSTOMER_TAG_BY_TEXT, tagName);
	}

	public String getCustomerAdminComment() {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_ADMIN_COMMENT_TEXTBOX);
		return getElementText(AdminDashboardPageUI.CUSTOMER_ADMIN_COMMENT_TEXTBOX);
	}

	public void clickToBackToCustomerListButton() {
		waitForElementClickable(AdminDashboardPageUI.BACK_TO_CUSTOMER_LIST_BUTTON);
		clickToElement(AdminDashboardPageUI.BACK_TO_CUSTOMER_LIST_BUTTON);
	}

	public void selectItemInCustomerSearchRolesDropdown(String item) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_SEARCH_ROLE_PARENT_DROPDOWN);
		clickToElement(AdminDashboardPageUI.CUSTOMER_SEARCH_ROLE_PARENT_DROPDOWN);

		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_ROLE_ITEM_IN_DROPDOWN, item);
		clickToElement(AdminDashboardPageUI.CUSTOMER_ROLE_ITEM_IN_DROPDOWN, item);
	}

	public void clickToCustomerSearchButton() {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_SEARCH_BUTTON);
		clickToElement(AdminDashboardPageUI.CUSTOMER_SEARCH_BUTTON);
	}

	public boolean isCustomerNameByTextDisplayed(String customertName) {
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_NAME_BY_TEXT, customertName);
		return isElementDisPlayed(AdminDashboardPageUI.CUSTOMER_NAME_BY_TEXT, customertName);
	}

	public String getTextItemByCustomerNameAndColumName(String customertName, String columName) {
		int columIndex = getElementSize(AdminDashboardPageUI.CUSTOMER_COLUM_INDEX_BY_NAME, columName) + 1;
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_TEXT_ITEM_BY_CUSTOMER_NAME_AND_COLUM_INDEX, customertName, String.valueOf(columIndex));
		return getElementText(AdminDashboardPageUI.CUSTOMER_TEXT_ITEM_BY_CUSTOMER_NAME_AND_COLUM_INDEX, customertName, String.valueOf(columIndex));
	}

	public String getTextNumberCustomerOnGrid() {
		sleepInSecond(2);
		waitForElementVisible(AdminDashboardPageUI.CUSTOMER_NUMBER_GRID_INFOR);
		return getElementText(AdminDashboardPageUI.CUSTOMER_NUMBER_GRID_INFOR);
	}

	public void selectItemInMonthDropdown(String month) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_MONTH_DROPDOWN);
		selectItemInDefaultDropDown(AdminDashboardPageUI.CUSTOMER_MONTH_DROPDOWN, month);
	}

	public void selectItemInDayDropdown(String day) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_DAY_DROPDOWN);
		selectItemInDefaultDropDown(AdminDashboardPageUI.CUSTOMER_DAY_DROPDOWN, day);
	}

	public void clickToEditButtonByName(String customerName) {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_EDIT_BUTTON_BY_NAME, customerName);
		clickToElement(AdminDashboardPageUI.CUSTOMER_EDIT_BUTTON_BY_NAME, customerName);
	}

	public void clickToCustomerSaveButton() {
		waitForElementClickable(AdminDashboardPageUI.CUSTOMER_SAVE_BUTTON);
		clickToElement(AdminDashboardPageUI.CUSTOMER_SAVE_BUTTON);
	}

	public void openCustomerBoxByText(String textName) {
		scrollToElement(AdminDashboardPageUI.CUSTOMER_AREA_TITLE_BY_TEXT, textName);
		if (isElementUndisplayed(AdminDashboardPageUI.CUSTOMER_AREA_ICON_MINUS_BY_TEXT, textName)) {
			waitForElementClickable(AdminDashboardPageUI.CUSTOMER_AREA_TITLE_BY_TEXT, textName);
			clickToElement(AdminDashboardPageUI.CUSTOMER_AREA_TITLE_BY_TEXT, textName);
		}
	}

	public void clickToAddNewAddressButton() {
		waitForElementClickable(AdminDashboardPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(AdminDashboardPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void inPutToAddressTextboxByLabel(String label, String text) {
		waitForElementVisible(AdminDashboardPageUI.ADDRESS_TEXTBOX_BY_TEXT_LABEL, label);
		senkeyToElement(AdminDashboardPageUI.ADDRESS_TEXTBOX_BY_TEXT_LABEL, text, label);
	}

	public void selectItemToAddressCountryDropdown(String country) {
		waitForElementClickable(AdminDashboardPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInDefaultDropDown(AdminDashboardPageUI.ADDRESS_COUNTRY_DROPDOWN, country);
	}

	public void clickToAddressSaveButton() {
		waitForElementClickable(AdminDashboardPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(AdminDashboardPageUI.ADDRESS_SAVE_BUTTON);
	}

	public String getAddressTextboxInforByLabel(String label) {
		waitForElementVisible(AdminDashboardPageUI.ADDRESS_TEXTBOX_BY_TEXT_LABEL, label);
		return getElementAttribute(AdminDashboardPageUI.ADDRESS_TEXTBOX_BY_TEXT_LABEL, "value", label);
	}

	public String getAddressCountryDropdownInfor() {
		waitForElementVisible(AdminDashboardPageUI.ADDRESS_COUNTRY_ITEM_SELECTED);
		return getElementText(AdminDashboardPageUI.ADDRESS_COUNTRY_ITEM_SELECTED);
	}

	public void clickToBackToCustomerListDetailsButton() {
		waitForElementClickable(AdminDashboardPageUI.BACK_TO_CUSTOMER_LIST_DETAILS_BUTTON);
		clickToElement(AdminDashboardPageUI.BACK_TO_CUSTOMER_LIST_DETAILS_BUTTON);
	}

	public boolean isEmailAddressByTextDisplayed(String emailAddress) {
		waitForElementVisible(AdminDashboardPageUI.ADDRESS_GRID_EMAIL_BY_TEXT, emailAddress);
		return isElementDisPlayed(AdminDashboardPageUI.ADDRESS_GRID_EMAIL_BY_TEXT, emailAddress);
	}

	public String getTextItemByEmailAndColumName(String emailAddress, String columName) {
		int columIndex = getElementSize(AdminDashboardPageUI.ADDRESS_COLUM_INDEX_BY_NAME, columName) + 1;
		waitForElementVisible(AdminDashboardPageUI.ADDRESS_TEXT_ITEM_BY_EMAIL_AND_COLUM_INDEX, emailAddress, String.valueOf(columIndex));
		return getElementText(AdminDashboardPageUI.ADDRESS_TEXT_ITEM_BY_EMAIL_AND_COLUM_INDEX, emailAddress, String.valueOf(columIndex));
	}

	public void clickToDeleteButtonByName(String emailAddress) {
		waitForElementClickable(AdminDashboardPageUI.ADDRESS_DELETE_BUTTON_BY_NAME, emailAddress);
		clickToElement(AdminDashboardPageUI.ADDRESS_DELETE_BUTTON_BY_NAME, emailAddress);
		sleepInSecond(1);
		acceptAlert();
	}

	public boolean isMessageDataTableByAreaNameAndTextDisplayed(String areaName, String message) {
		waitForElementVisible(AdminDashboardPageUI.ADDRESS_MESSAGE_DATA_TABEL_BY_AREA_NAME_AND_TEXT, areaName, message);
		return isElementDisPlayed(AdminDashboardPageUI.ADDRESS_MESSAGE_DATA_TABEL_BY_AREA_NAME_AND_TEXT, areaName, message);
	}
}
