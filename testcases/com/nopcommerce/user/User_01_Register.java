package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;
import utilities.SeverName;

public class User_01_Register extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();

		firstName = dataFaker.getFirstname();
		lastName = dataFaker.getLastname();
		gender = dataFaker.getGenderMaleAndFemale();
		day = dataFaker.getTimeDay();
		month = dataFaker.getTimeMonthChacrater();
		year = dataFaker.getTimeYear();
		validEmail = dataFaker.getEmailAddress();
		invalidEmail = "123@#123@" + validEmail;
		companyName = dataFaker.getCompanyName();
		password = "123456";
		passwordLess6Character = "11111";

		userRegisterPage = userHomePage.openRegisterPage();
	}

	@Test
	public void Register_01_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_01_With_Empty_Data");

		ExtentTestManager.getTest().log(Status.INFO, "Register_01 - Step 01: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_01 - Step 02: Verify error message on mandantory field");
		Assert.assertTrue(userRegisterPage.isFirstnameErrorMessageDisplay("First name is required."));
		Assert.assertTrue(userRegisterPage.isLastnameErrorMessageDisplay("Last name is required."));
		Assert.assertTrue(userRegisterPage.isEmailErrorMessageDisplay("Email is required."));
		Assert.assertTrue(userRegisterPage.isPasswordErrorMessageDisplay("Password is required."));
		Assert.assertTrue(userRegisterPage.isConfirmPassordErrorMessageDisplay("Password is required."));

	}

	@Test
	public void Register_02_With_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_02_With_Invalid_Email");

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 01: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		userRegisterPage.selectGenderCheckboxByTextlabel(gender);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 04: Select item in 'Day' dropdown is '" + day + "'");
		userRegisterPage.selectItemInDayDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 05: Select item in 'Month' dropdown is '" + month + "'");
		userRegisterPage.selectItemInMonthDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 06: Select item in 'Year' dropdown is '" + year + "'");
		userRegisterPage.selectItemInYearDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 07: inPut to 'Email' textbox with text is '" + invalidEmail + "'");
		userRegisterPage.inPutToEmailTextbox(invalidEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 07: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userRegisterPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 08: inPut to 'Password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 09: inPut to 'Confirm password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 10: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 11: Verify error message on Email textbox is 'Wrong email' displayed ");
		Assert.assertTrue(userRegisterPage.isEmailErrorMessageDisplay("Wrong email"));
	}

	@Test
	public void Register_03_With_Valid_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_03_With_Valid_Data");

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 01: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		userRegisterPage.selectGenderCheckboxByTextlabel(gender);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 04: Select item in 'Day' dropdown is '" + day + "'");
		userRegisterPage.selectItemInDayDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 05: Select item in 'Month' dropdown is '" + month + "'");
		userRegisterPage.selectItemInMonthDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 06: Select item in 'Year' dropdown is '" + year + "'");
		userRegisterPage.selectItemInYearDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 07: inPut to 'Email' textbox with text is '" + validEmail + "'");
		userRegisterPage.inPutToEmailTextbox(validEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 07: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userRegisterPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 08: inPut to 'Password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 09: inPut to 'Confirm password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 10: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 11: Verify register sucess message with 'Your registration completed' is displayed ");
		Assert.assertTrue(userRegisterPage.isRegisterSuccessMessageDisplayed("Your registration completed"));
	}

	@Test
	public void Register_04_With_Existing_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_04_With_Existing_Email");

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 01: Click to 'continue' button");
		userHomePage = userRegisterPage.clickToContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 02: Open 'regiter' page");
		userRegisterPage = userHomePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 03: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		userRegisterPage.selectGenderCheckboxByTextlabel(gender);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 04: inPut to 'First name' textbox with text is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 05: inPut to 'Last name' textbox with text is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 06: Select item in 'Day' dropdown is '" + day + "'");
		userRegisterPage.selectItemInDayDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 07: Select item in 'Month' dropdown is '" + month + "'");
		userRegisterPage.selectItemInMonthDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 08: Select item in 'Year' dropdown is '" + year + "'");
		userRegisterPage.selectItemInYearDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 09: inPut to 'Email' textbox with text is '" + validEmail + "'");
		userRegisterPage.inPutToEmailTextbox(validEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 10: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userRegisterPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 11: inPut to 'Password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 12: inPut to 'Confirm password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 13: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_04 - Step 14: Verify error message on Email textbox is 'Wrong email' displayed ");
		Assert.assertTrue(userRegisterPage.isEmailExistedMessageDisplayed("The specified email already exists"));
	}

	@Test
	public void Register_05_With_Password_Less_Than_6_Characters(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_05_With_Password_Less_Than_6_Characters");

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 01: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		userRegisterPage.selectGenderCheckboxByTextlabel(gender);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 04: Select item in 'Day' dropdown is '" + day + "'");
		userRegisterPage.selectItemInDayDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 05: Select item in 'Month' dropdown is '" + month + "'");
		userRegisterPage.selectItemInMonthDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 06: Select item in 'Year' dropdown is '" + year + "'");
		userRegisterPage.selectItemInYearDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 07: inPut to 'Email' textbox with text is '" + validEmail + "'");
		userRegisterPage.inPutToEmailTextbox(validEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 07: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userRegisterPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 08: inPut to 'Password' textbox with text is '" + passwordLess6Character + "'");
		userRegisterPage.inPutToPasswordTextbox(passwordLess6Character);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 09: inPut to 'Confirm password' textbox with text is '" + passwordLess6Character + "'");
		userRegisterPage.inPutToConfirmPasswordTextbox(passwordLess6Character);

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 10: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_05 - Step 11: Verify register sucess message with 'Password must meet the following rules: must have at least 6 characters' is displayed ");
		Assert.assertEquals(userRegisterPage.getTextPasswordErrorMessageDisplay(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_With_ConfirmPassword_Does_Not_Match_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_06_With_ConfirmPassword_Does_Not_Match_Password");

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 01: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		userRegisterPage.selectGenderCheckboxByTextlabel(gender);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 04: Select item in 'Day' dropdown is '" + day + "'");
		userRegisterPage.selectItemInDayDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 05: Select item in 'Month' dropdown is '" + month + "'");
		userRegisterPage.selectItemInMonthDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 06: Select item in 'Year' dropdown is '" + year + "'");
		userRegisterPage.selectItemInYearDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 07: inPut to 'Email' textbox with text is '" + validEmail + "'");
		userRegisterPage.inPutToEmailTextbox(validEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 07: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userRegisterPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 08: inPut to 'Password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 09: inPut to 'Confirm password' textbox with text is '" + passwordLess6Character + "'");
		userRegisterPage.inPutToConfirmPasswordTextbox(passwordLess6Character);

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 10: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_03 - Step 11: Verify register sucess message with 'Your registration completed' is displayed ");
		Assert.assertTrue(userRegisterPage.isConfirmPassordErrorMessageDisplay("The password and confirmation password do not match."));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private DataHelper dataFaker;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private String gender, firstName, lastName, day, month, year, validEmail, invalidEmail, companyName, password, passwordLess6Character;
}
