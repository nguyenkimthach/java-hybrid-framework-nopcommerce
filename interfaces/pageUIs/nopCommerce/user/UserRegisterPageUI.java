package pageUIs.nopCommerce.user;

public class UserRegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_NAME_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD = "xpath=//input[@id='ConfirmPassword']";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='Company']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String FIRST_NAME_ERROR_MESSAGE_BY_TEXT = "xpath=//span[@id='FirstName-error' and text()='%s']";
	public static final String LAST_NAME_ERROR_MESSAGE_BY_TEXT = "xpath=//span[@id='LastName-error' and text()='%s']";
	public static final String EMAIL_ERROR_MESSAGE_BY_TEXT = "xpath=//span[@id='Email-error' and text()='%s']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
	public static final String PASSWORD_ERROR_MESSAGE_BY_TEXT = "xpath=//span[@id='Password-error' and text()='%s']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE_BY_TEXT = "xpath=//span[@id='ConfirmPassword-error' and text()='%s']";
	public static final String REGISTER_SUCCESS_MESSAGE_BY_TEXT = "xpath=//div[@class='result' and text()='%s']";
	public static final String EMAIL_EXISTED_MESSAGE_BY_TEXT = "xpath=//div[@class='message-error validation-summary-errors'] //li[text()='%s']";
	public static final String CONTINUE_BUTTON = "css=a.register-continue-button";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "css=div.message-error li";
	public static final String GENDER_CHECKBOX_BY_TEXT_LABEL = "xpath=//div[@id='gender']//label[text()='%s']//preceding-sibling::input";
	public static final String DAY_DROPDOWN = "xpath=//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";

}
