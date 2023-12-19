package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isFirstnameErrorMessageDisplay(String message) {
		waitForElementVisible(UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE_BY_TEXT, message);
	}

	public boolean isLastnameErrorMessageDisplay(String message) {
		waitForElementVisible(UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE_BY_TEXT, message);
	}

	public boolean isEmailErrorMessageDisplay(String message) {
		waitForElementVisible(UserRegisterPageUI.EMAIL_ERROR_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.EMAIL_ERROR_MESSAGE_BY_TEXT, message);
	}

	public boolean isPasswordErrorMessageDisplay(String message) {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_ERROR_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.PASSWORD_ERROR_MESSAGE_BY_TEXT, message);
	}

	public boolean isConfirmPassordErrorMessageDisplay(String message) {
		waitForElementVisible(UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_BY_TEXT, message);
	}

	public void selectGenderCheckboxByTextlabel(String gender) {
		waitForElementClickable(UserRegisterPageUI.GENDER_CHECKBOX_BY_TEXT_LABEL, gender);
		checkToDefaultCheckboxOrRadio(UserRegisterPageUI.GENDER_CHECKBOX_BY_TEXT_LABEL, gender);
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitForElementVisible(UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(UserRegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(UserRegisterPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	public void selectItemInDayDropdown(String day) {
		waitForElementClickable(UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropDown(UserRegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectItemInMonthDropdown(String month) {
		waitForElementClickable(UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropDown(UserRegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectItemInYearDropdown(String year) {
		waitForElementClickable(UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropDown(UserRegisterPageUI.YEAR_DROPDOWN, year);
	}

	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(UserRegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
		senkeyToElement(UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void inPutToPasswordTextbox(String password) {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inPutToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(UserRegisterPageUI.CONFIRM_PASSWORD);
		senkeyToElement(UserRegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
	}

	public boolean isRegisterSuccessMessageDisplayed(String message) {
		waitForElementVisible(UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE_BY_TEXT, message);
	}

	public boolean isEmailExistedMessageDisplayed(String message) {
		waitForElementVisible(UserRegisterPageUI.EMAIL_EXISTED_MESSAGE_BY_TEXT, message);
		return isElementDisPlayed(UserRegisterPageUI.EMAIL_EXISTED_MESSAGE_BY_TEXT, message);
	}

	public UserHomePageObject clickToContinueButton() {
		waitForElementClickable(UserRegisterPageUI.CONTINUE_BUTTON);
		clickToElement(UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManage.getUserHomePage(driver);
	}

	public String getTextPasswordErrorMessageDisplay() {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

}
