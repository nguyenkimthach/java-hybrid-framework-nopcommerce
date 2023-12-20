package pageUIs.nopCommerce.user;

public class UserMyAccountPageUI {
	public static final String GENDER_CHECKBOX_BY_TEXT_LABEL = "xpath=//div[@class='gender']//label[text()='%s']//preceding-sibling::input";
	public static final String FIRST_NAME_TEXTBOX = "css=input#FirstName";
	public static final String LAST_NAME_TEXTBOX = "css=input#LastName";
	public static final String DAY_DROPDOWN = "xpath=//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "css=input#Email";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='Company']";
	public static final String INFOR_SAVE_BUTTON = "css=button#save-info-button";
	public static final String UPDATE_SUCCESS_MESSAGE_BY_TEXT = "xpath=//p[@class='content' and text()='%s']";

	public static final String DYNAMIC_AREA_MY_ACCOUNT_PAGE_BY_TEXT = "xpath=//div[@class='block block-account-navigation']//li/a[text()='%s']";
	public static final String ADDRESS_ADD_NEW_BUTTON = "css=button.add-address-button";
	public static final String ADDRESS_FIRST_NAME_TEXTBOX = "css=input#Address_FirstName";
	public static final String ADDRESS_LAST_NAME_TEXTBOX = "css=input#Address_LastName";
	public static final String ADDRESS_EMAIL_TEXTBOX = "css=input#Address_Email";
	public static final String ADDRESS_COMPANY_TEXTBOX = "css=input#Address_Company";
	public static final String ADDRESS_COUNTRY_DROPDOWN = "xpath=//select[@id='Address_CountryId']";
	public static final String ADDRESS_COUNTRY_DROPDOWN_TEXT_ITEM = "xpath=//select[@id='Address_CountryId']/option";
	public static final String ADDRESS_CITY_TEXTBOX = "css=input#Address_City";
	public static final String ADDRESS_ADDRESS_1_TEXTBOX = "css=input#Address_Address1";
	public static final String ADDRESS_ADDRESS_2_TEXTBOX = "css=input#Address_Address2";
	public static final String ADDRESS_ZIP_POSTAL_CODE_TEXTBOX = "css=input#Address_ZipPostalCode";
	public static final String ADDRESS_PHONE_NUMBER_TEXTBOX = "css=input#Address_PhoneNumber";
	public static final String ADDRESS_FAX_NUMBER_TEXTBOX = "css=input#Address_FaxNumber";
	public static final String ADDRESS_SAVE_BUTTON = "css=button.save-address-button";

	public static final String CHANGE_PASS_OLD_PASSWORD = "css=input#OldPassword";
	public static final String CHANGE_PASS_NEW_PASSWORD = "css=input#NewPassword";
	public static final String CHANGE_PASS_CONFIRM_NEW_PASSWORD = "css=input#ConfirmNewPassword";
	public static final String CHANGE_PASSWORD_BUTTON = "css=button.change-password-button";
}
