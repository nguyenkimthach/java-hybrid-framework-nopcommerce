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
import utilities.SeverName;

public class User_01_Register extends BaseTest {
	String gender = "Female";
	String firstName = "John";
	String lastName = "NKT";
	String day = "12";
	String month = "May";
	String year = "1998";
	String validEmail = "JohnNK" + getRandomNumberByDateTime() + "@NKmail.com";
	String invalidEmail = "JohnNK@123@NKmail.com";
	String companyName = "NKT company";
	String password = "123456";
	String confirmPassord = "111111";

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);

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

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 07: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userRegisterPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 08: inPut to 'Password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 09: inPut to 'Confirm password' textbox with text is '" + password + "'");
		userRegisterPage.inPutToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register_01 - Step 10: Click to 'Register' button");
		userRegisterPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register_01 - Step 11: Verify error message on Email textbox is Wrong email displayed ");
		Assert.assertTrue(userRegisterPage.isEmailErrorMessageDisplay("Wrong email"));
	}

	@Test
	public void Register_03_With_Valid_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_03_With_Valid_Data");

	}

	@Test
	public void Register_04(Method method) {
		ExtentTestManager.startTest(method.getName(), "Creaat New Post");
		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 01: Click to 'Post' menu link");
	}

	@Test
	public void Register_05(Method method) {
		ExtentTestManager.startTest(method.getName(), "Creaat New Post");
		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 01: Click to 'Post' menu link");
	}

	@Test
	public void Register_06(Method method) {
		ExtentTestManager.startTest(method.getName(), "Creaat New Post");
		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 01: Click to 'Post' menu link");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	SeverName severname;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
}
