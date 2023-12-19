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
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;
import utilities.SeverName;

public class User_01_Login extends BaseTest {

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
		unregisteredEmail = dataFaker.getEmailAddress();
		validEmail = dataFaker.getEmailAddress();
		invalidEmail = "123@#123@" + validEmail;
		companyName = dataFaker.getCompanyName();
		password = "123456";
		passwordLess6Character = "11111";

		userLoginPage = userHomePage.clickToLoginLink();
	}

	@Test
	public void Login_01_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_01_With_Empty_Data");

		ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 01: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 02: Verify error message on mandantory field");
		Assert.assertTrue(userLoginPage.isEmailErrorMessageDisplay("Please enter your email"));

	}

	@Test
	public void Login_02_With_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_02_With_Invalid_Email");

		ExtentTestManager.getTest().log(Status.INFO, "Login_02 - Step 01: inPut to 'invalidEmail' textbox with text is '" + invalidEmail + "'");
		userLoginPage.inPutToEmailTextbox(invalidEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Login_02 - Step 02: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login_01 - Step 03: Verify error message on mandantory field");
		Assert.assertTrue(userLoginPage.isEmailErrorMessageDisplay("Wrong email"));
	}

	@Test
	public void Login_03_With_Unregistered_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_03_With_Unregistered_Email");

		ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 01: inPut to 'unregistered email' textbox with text is '" + unregisteredEmail + "'");
		userLoginPage.inPutToEmailTextbox(unregisteredEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 02: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login_03 - Step 03: Verify register sucess message with 'Please correct the errors and try again.\nNo customer account found' is displayed ");
		Assert.assertEquals(userLoginPage.getVaidationSumaryError(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	SeverName severname;
	private DataHelper dataFaker;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	private String gender, firstName, lastName, day, month, year, validEmail, invalidEmail, unregisteredEmail, companyName, password, passwordLess6Character;

}
