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
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;
import utilities.SeverName;

public class User_02_Login extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();

		registeredEmail = Common_01_Register_End_User.emailAddress;
		unregisteredEmail = dataFaker.getEmailAddress();
		invalidEmail = "123@" + registeredEmail;

		registeredPassword = Common_01_Register_End_User.password;
		invalidPassword = "123@" + registeredPassword;

		userLoginPage = userHomePage.openLoginPage();
	}

	@Test
	public void TC_01_Login_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Login_With_Empty_Data");

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Login - Step 01: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Login - Step 02: Verify error message on mandantory field");
		Assert.assertTrue(userLoginPage.isEmailErrorMessageDisplay("Please enter your email"));

	}

	@Test
	public void TC_02_Login_With_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_With_Invalid_Email");

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Login - Step 01: inPut to 'Email' textbox with text is '" + invalidEmail + "'");
		userLoginPage.inPutToEmailTextbox(invalidEmail);

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Login - Step 02: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Login - Step 03: Verify error message on mandantory field");
		Assert.assertTrue(userLoginPage.isEmailErrorMessageDisplay("Wrong email"));
	}

	@Test
	public void TC_03_Login_With_Unregistered_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Login_With_Unregistered_Email");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Login - Step 01: inPut to 'Email' textbox with text is '" + unregisteredEmail + "'");
		userLoginPage.inPutToEmailTextbox(unregisteredEmail);

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Login - Step 02: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Login - Step 03: Verify sumary error message with 'Please correct the errors and try again.No customer account found' is displayed ");
		Assert.assertEquals(userLoginPage.getVaidationSumaryError(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Login_With_Registered_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Login_With_Registered_Email");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Login - Step 01: inPut to 'Email' textbox with text is '" + registeredEmail + "'");
		userLoginPage.inPutToEmailTextbox(registeredEmail);

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Login - Step 02: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Login - Step 03: Verify sumary error message with 'Please correct the errors and try again.The credentials provided are incorrect' is displayed ");
		Assert.assertEquals(userLoginPage.getVaidationSumaryError(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_With_Registered_Email_And_Invalid_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Login_With_Registered_Email_And_Invalid_Password");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Login - Step 01: inPut to 'Email' textbox with text is '" + registeredEmail + "'");
		userLoginPage.inPutToEmailTextbox(registeredEmail);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Login - Step 02: inPut to 'Password' textbox with text is '" + invalidPassword + "'");
		userLoginPage.inPutToPasswordTextbox(invalidPassword);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Login - Step 03: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Login - Step 04: Verify sumary error message with 'Please correct the errors and try again.The credentials provided are incorrect' is displayed ");
		Assert.assertEquals(userLoginPage.getVaidationSumaryError(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_With_Registered_Email_And_Valid_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Login_With_Registered_Email_And_Valid_Password");

		ExtentTestManager.getTest().log(Status.INFO, "TC_06_Login - Step 01: inPut to 'Email' textbox with text is '" + registeredEmail + "'");
		userLoginPage.inPutToEmailTextbox(registeredEmail);

		ExtentTestManager.getTest().log(Status.INFO, "TC_06_Login - Step 02: inPut to 'Password' textbox with text is '" + registeredPassword + "'");
		userLoginPage.inPutToPasswordTextbox(registeredPassword);

		ExtentTestManager.getTest().log(Status.INFO, "TC_06_Login - Step 03: Click to 'Login' button");
		userHomePage = userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_06_Login - Step 04: Verify 'My account' link is displayed ");
		Assert.assertTrue(userHomePage.isMyaccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private DataHelper dataFaker;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private String registeredEmail, invalidEmail, unregisteredEmail, registeredPassword, invalidPassword;
}
