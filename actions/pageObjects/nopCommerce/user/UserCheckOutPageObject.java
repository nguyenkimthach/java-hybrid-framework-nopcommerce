package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserCheckOutPageUI;

public class UserCheckOutPageObject extends BasePage {
	private WebDriver driver;

	public UserCheckOutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void unCheckToShipToSameAddressCheckbox() {
		waitForElementClickable(UserCheckOutPageUI.SHIP_TO_ADDRESS_CHECKBOX);
		unCheckToDefaultCheckboxRadio(UserCheckOutPageUI.SHIP_TO_ADDRESS_CHECKBOX);
	}

	public void inputToBillingFirstNameTextbox(String firstName) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_FIRST_NAME_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToBillingLastNameTextbox(String lastName) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_LAST_NAME_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_LAST_NAME_TEXTBOX, lastName);
	}

	public void inPutToBillingEmailTextbox(String emailAddress) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_EMAIL_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToBillingCompanyNameTextbox(String companyName) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_COMPANY_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_COMPANY_TEXTBOX, companyName);
	}

	public void selectToBillingCountryDropdownByText(String country) {
		waitForElementClickable(UserCheckOutPageUI.BILLING_COUNTRY_DROPDOWN);
		selectItemInDefaultDropDown(UserCheckOutPageUI.BILLING_COUNTRY_DROPDOWN, country);
	}

	public void inputToBillingCityTextbox(String city) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_CITY_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_CITY_TEXTBOX, city);
	}

	public void inputToBillingAddress1Textbox(String address_1) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_ADDRESS_1_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_ADDRESS_1_TEXTBOX, address_1);
	}

	public void inputToBillingAddress2Textbox(String address_2) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_ADDRESS_2_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_ADDRESS_2_TEXTBOX, address_2);
	}

	public void inputToBillingZipPostalCodeTextbox(String zipPostalCode) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_ZIP_POSTAL_CODE_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
	}

	public void inputToBillingPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_PHONE_NUMBER_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToBillingFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(UserCheckOutPageUI.BILLING_FAX_NUMBER_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.BILLING_FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(UserCheckOutPageUI.SAVE_BUTTON);
		clickToElement(UserCheckOutPageUI.SAVE_BUTTON);
	}

	public void clickToContinueButton() {
		waitForElementClickable(UserCheckOutPageUI.CONTINUE_BUTTON);
		clickToElement(UserCheckOutPageUI.CONTINUE_BUTTON);
	}

	public void clickToShippingMethodContinueButton() {
		waitForElementClickable(UserCheckOutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(UserCheckOutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
	}

	public void clickToShippingAddressContinueButton() {
		waitForElementClickable(UserCheckOutPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(UserCheckOutPageUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
	}

	public void clickToShippingPaymentContinueButton() {
		waitForElementClickable(UserCheckOutPageUI.SHIPPING_PAYMENT_CONTINUE_BUTTON);
		clickToElement(UserCheckOutPageUI.SHIPPING_PAYMENT_CONTINUE_BUTTON);
	}

	public void clickToPaymentInforContinueButton() {
		waitForElementClickable(UserCheckOutPageUI.PAYMENT_INFOR_CONTINUE_BUTTON);
		clickToElement(UserCheckOutPageUI.PAYMENT_INFOR_CONTINUE_BUTTON);
	}

	public void clickToEditButton() {
		waitForElementClickable(UserCheckOutPageUI.EDIT_ADDRESS_BUTTON);
		clickToElement(UserCheckOutPageUI.EDIT_ADDRESS_BUTTON);
	}

	public void inputToShippingFirstNameTextbox(String firstName) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_FIRST_NAME_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToShippingLastNameTextbox(String lastName) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_LAST_NAME_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_LAST_NAME_TEXTBOX, lastName);
	}

	public void inPutToShippingEmailTextbox(String emailAddress) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_EMAIL_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToShippingCompanyNameTextbox(String companyName) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_COMPANY_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_COMPANY_TEXTBOX, companyName);
	}

	public void selectToShippingCountryDropdownByText(String country) {
		waitForElementClickable(UserCheckOutPageUI.SHIPPING_COUNTRY_DROPDOWN);
		selectItemInDefaultDropDown(UserCheckOutPageUI.SHIPPING_COUNTRY_DROPDOWN, country);
	}

	public void inputToShippingCityTextbox(String city) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_CITY_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_CITY_TEXTBOX, city);
	}

	public void inputToShippingAddress1Textbox(String address_1) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_ADDRESS_1_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_ADDRESS_1_TEXTBOX, address_1);
	}

	public void inputToShippingAddress2Textbox(String address_2) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_ADDRESS_2_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_ADDRESS_2_TEXTBOX, address_2);
	}

	public void inputToShippingZipPostalCodeTextbox(String zipPostalCode) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_ZIP_POSTAL_CODE_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
	}

	public void inputToShippingPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_PHONE_NUMBER_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToShippingFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_FAX_NUMBER_TEXTBOX);
		senkeyToElement(UserCheckOutPageUI.SHIPPING_FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void checkToRadioButtonByTextLabel(String label) {
		waitForElementClickable(UserCheckOutPageUI.RADIO_BUTTON_BY_LABEL_NAME, label);
		checkToDefaultCheckboxOrRadio(UserCheckOutPageUI.RADIO_BUTTON_BY_LABEL_NAME, label);
	}

	public String getAddressShippingInfor() {
		waitForElementVisible(UserCheckOutPageUI.ADDRESS_SHIPPING_INFOR);
		return getElementText(UserCheckOutPageUI.ADDRESS_SHIPPING_INFOR);
	}

	public String getBillingAddressNameInfor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_NAME_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_NAME_INFOR);
	}

	public String getBillingAddressEmailInfor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_EMAIL_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_EMAIL_INFOR);
	}

	public String getBillingAddressphoneInfor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_PHONE_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_PHONE_INFOR);
	}

	public String getBillingAddressFaxInfor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_FAX_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_FAX_INFOR);
	}

	public String getBillingAddress1Infor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_ADDRESS_1_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_ADDRESS_1_INFOR);
	}

	public String getBillingAddress2Infor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_ADDRESS_2_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_ADDRESS_2_INFOR);
	}

	public String getBillingAddressCountryInfor() {
		waitForElementVisible(UserCheckOutPageUI.BILLING_COUNTRY_INFOR);
		return getElementText(UserCheckOutPageUI.BILLING_COUNTRY_INFOR);
	}

	public String getShippingAddressNameInfor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_NAME_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_NAME_INFOR);
	}

	public String getShippingAddressEmailInfor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_EMAIL_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_EMAIL_INFOR);
	}

	public String getShippingAddressphoneInfor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_PHONE_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_PHONE_INFOR);
	}

	public String getShippingAddressFaxInfor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_FAX_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_FAX_INFOR);
	}

	public String getShippingAddress1Infor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_ADDRESS_1_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_ADDRESS_1_INFOR);
	}

	public String getShippingAddress2Infor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_ADDRESS_2_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_ADDRESS_2_INFOR);
	}

	public String getShippingAddressCountryInfor() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_COUNTRY_INFOR);
		return getElementText(UserCheckOutPageUI.SHIPPING_COUNTRY_INFOR);
	}

	public String getPaymentMethod() {
		waitForElementVisible(UserCheckOutPageUI.PAYMENT_METHOD);
		return getElementText(UserCheckOutPageUI.PAYMENT_METHOD);
	}

	public String getShippingMethod() {
		waitForElementVisible(UserCheckOutPageUI.SHIPPING_METHOD);
		return getElementText(UserCheckOutPageUI.SHIPPING_METHOD);
	}

	public boolean isProductNameBytextDisplayed(String productName) {
		waitForElementVisible(UserCheckOutPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserCheckOutPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public String getInforProductByProductNameAndAtribute(String productName, String atribute) {
		waitForElementVisible(UserCheckOutPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
		return getElementText(UserCheckOutPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
	}

	public String getPriceInforByTextLabel(String textLabel) {
		waitForElementVisible(UserCheckOutPageUI.PRICE_INFOR_BY_LABEL, textLabel);
		return getElementText(UserCheckOutPageUI.PRICE_INFOR_BY_LABEL, textLabel);
	}

	public String getTotalPriceInfor() {
		waitForElementVisible(UserCheckOutPageUI.PRICE_TOTAL_INFOR);
		return getElementText(UserCheckOutPageUI.PRICE_TOTAL_INFOR);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(UserCheckOutPageUI.CONFIRM_BUTTON);
		clickToElement(UserCheckOutPageUI.CONFIRM_BUTTON);
	}

	public String getOrderedSuccessPageTittle() {
		sleepInSecond(2);
		waitForElementVisible(UserCheckOutPageUI.ODER_SUCCESS_PAGE_TITLE);
		return getElementText(UserCheckOutPageUI.ODER_SUCCESS_PAGE_TITLE);
	}

	public String getOrderedSuccessMessage() {
		waitForElementVisible(UserCheckOutPageUI.ODER_SUCCESS_MESSAGE);
		return getElementText(UserCheckOutPageUI.ODER_SUCCESS_MESSAGE);
	}

	public String getOrderNumberMessage() {
		waitForElementVisible(UserCheckOutPageUI.ODER_NUMBER_MESSAGE);
		return getElementText(UserCheckOutPageUI.ODER_NUMBER_MESSAGE);
	}

	public String getOrderNumber() {
		return getOrderNumberMessage().split(":", 2)[1].trim();
	}

	public UserHomePageObject clickToOderCompletedContinueButton() {
		waitForElementClickable(UserCheckOutPageUI.ODER_COMPLETED_BUTTON);
		clickToElement(UserCheckOutPageUI.ODER_COMPLETED_BUTTON);
		return PageGeneratorManage.getUserHomePage(driver);
	}

	public void selectItemInCreditCardTypeDropdownByText(String creditCardTypes) {
		waitForElementClickable(UserCheckOutPageUI.CREDIT_CARD_TYPE_DROPDOWN, creditCardTypes);
		selectItemInDefaultDropDown(UserCheckOutPageUI.CREDIT_CARD_TYPE_DROPDOWN, creditCardTypes);
	}

	public void inPutToTextboxByLabeName(String label, String cardHolderName) {
		waitForElementVisible(UserCheckOutPageUI.CREDIT_CARD_TEXTBOX_BY_TEXT_LABEL, label);
		senkeyToElement(UserCheckOutPageUI.CREDIT_CARD_TEXTBOX_BY_TEXT_LABEL, cardHolderName, label);
	}

	public void selectItemInExpireMonthDropdownByText(String expireMonth) {
		waitForElementClickable(UserCheckOutPageUI.EXPIRE_MONTH_DROPDOWN, expireMonth);
		selectItemInDefaultDropDown(UserCheckOutPageUI.EXPIRE_MONTH_DROPDOWN, expireMonth);
	}

	public void selectItemInExpireYearDropdownByText(String expireYear) {
		waitForElementClickable(UserCheckOutPageUI.EXPIRE_YEAR_DROPDOWN, expireYear);
		selectItemInDefaultDropDown(UserCheckOutPageUI.EXPIRE_YEAR_DROPDOWN, expireYear);
	}

	public void clickToEditBillingAddressButton() {
		waitForElementClickable(UserCheckOutPageUI.EDIT_BILLING_ADDRESS_BUTTON);
		clickToElement(UserCheckOutPageUI.EDIT_BILLING_ADDRESS_BUTTON);
	}

	public void aceptAlertBox() {
		acceptAlert();
		sleepInSecond(15);
	}
}
