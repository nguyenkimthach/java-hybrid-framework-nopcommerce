package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserMyAccountPageUI;

public class UserMyAccountPageObject extends BasePage {
	private WebDriver driver;

	public UserMyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectGenderCheckboxByTextlabel(String gender) {
		waitForElementClickable(UserMyAccountPageUI.GENDER_CHECKBOX_BY_TEXT_LABEL, gender);
		checkToDefaultCheckboxOrRadio(UserMyAccountPageUI.GENDER_CHECKBOX_BY_TEXT_LABEL, gender);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(UserMyAccountPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(UserMyAccountPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void selectItemInDayDropdown(String day) {
		waitForElementClickable(UserMyAccountPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropDown(UserMyAccountPageUI.DAY_DROPDOWN, day);
	}

	public void selectItemInMonthDropdown(String month) {
		waitForElementClickable(UserMyAccountPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropDown(UserMyAccountPageUI.MONTH_DROPDOWN, month);
	}

	public void selectItemInYearDropdown(String year) {
		waitForElementClickable(UserMyAccountPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropDown(UserMyAccountPageUI.YEAR_DROPDOWN, year);
	}

	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(UserMyAccountPageUI.EMAIL_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(UserMyAccountPageUI.COMPANY_NAME_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveInforButton() {
		waitForElementClickable(UserMyAccountPageUI.INFOR_SAVE_BUTTON);
		clickToElement(UserMyAccountPageUI.INFOR_SAVE_BUTTON);
	}

	public boolean isUpdateSuccessMessageDisplayed(String message) {
		waitForElementVisible(UserMyAccountPageUI.UPDATE_SUCCESS_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserMyAccountPageUI.UPDATE_SUCCESS_MESSAGE_BY_TEXT, message);
	}

	public void navigateAreaAtMyAccountPageByText(String areaText) {
		waitForElementClickable(UserMyAccountPageUI.DYNAMIC_AREA_MY_ACCOUNT_PAGE_BY_TEXT, areaText);
		clickToElement(UserMyAccountPageUI.DYNAMIC_AREA_MY_ACCOUNT_PAGE_BY_TEXT, areaText);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(UserMyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
		clickToElement(UserMyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
	}

	public void inputToAddressFirstNameTextbox(String firstName) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToAddressLastNameTextbox(String lastName) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX, lastName);
	}

	public void inPutToAddressEmailTextbox(String emailAddress) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToAddressCompanyNameTextbox(String companyName) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_COMPANY_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_COMPANY_TEXTBOX, companyName);
	}

	public void selectAddressCountryDropdownByText(String country) {
		waitForElementClickable(UserMyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInCustomDropdown(UserMyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN, UserMyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN_TEXT_ITEM, country);
	}

	public void inputToAddressCityTextbox(String city) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_CITY_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address_1) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_ADDRESS_1_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_ADDRESS_1_TEXTBOX, address_1);
	}

	public void inputToAddress2Textbox(String address_2) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_ADDRESS_2_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_ADDRESS_2_TEXTBOX, address_2);
	}

	public void inputToAddressZipPostalCodeTextbox(String zipPostalCode) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_ZIP_POSTAL_CODE_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
	}

	public void inputToAddressPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToAddressFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(UserMyAccountPageUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		senkeyToElement(UserMyAccountPageUI.ADDRESS_FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(UserMyAccountPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(UserMyAccountPageUI.ADDRESS_SAVE_BUTTON);
	}

	public void inPutToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(UserMyAccountPageUI.CHANGE_PASS_OLD_PASSWORD);
		senkeyToElement(UserMyAccountPageUI.CHANGE_PASS_OLD_PASSWORD, oldPassword);
	}

	public void inPutToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(UserMyAccountPageUI.CHANGE_PASS_NEW_PASSWORD);
		senkeyToElement(UserMyAccountPageUI.CHANGE_PASS_NEW_PASSWORD, newPassword);
	}

	public void inPutToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(UserMyAccountPageUI.CHANGE_PASS_CONFIRM_NEW_PASSWORD);
		senkeyToElement(UserMyAccountPageUI.CHANGE_PASS_CONFIRM_NEW_PASSWORD, confirmNewPassword);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(UserMyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(UserMyAccountPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public boolean isOrderNumberBytextDisplayed(String textOrderNumber) {
		waitForElementVisible(UserMyAccountPageUI.ORDER_NUMBER_BY_TEXT, textOrderNumber);
		return isElementDisPlayed(UserMyAccountPageUI.ORDER_NUMBER_BY_TEXT, textOrderNumber);
	}

	public UserOrderInformationPageObject clickToDetailsButtonByOrderNumber(String orderNumber) {
		waitForElementClickable(UserMyAccountPageUI.DETAILS_BUTTON_BY_ORDER_NUMBER, orderNumber);
		clickToElement(UserMyAccountPageUI.DETAILS_BUTTON_BY_ORDER_NUMBER, orderNumber);
		return PageGeneratorManage.getUserOrderInformationPage(driver);
	}
}
