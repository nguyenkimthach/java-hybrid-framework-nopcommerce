package com.nopcommerce.common;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import utilities.DataHelper;
import utilities.SeverName;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private SeverName severname;
	private DataHelper dataFaker;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private String gender, firstName, lastName, day, month, year, companyName;
	public static String emailAddress, password;

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeTest(description = "Create new common User for all classes Test")
	public void PreconditionRegister(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
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
		companyName = dataFaker.getCompanyName();

		emailAddress = dataFaker.getEmailAddress();
		password = "123456";

		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.selectGenderCheckboxByTextlabel(gender);

		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);

		userRegisterPage.selectItemInDayDropdown(day);
		userRegisterPage.selectItemInMonthDropdown(month);
		userRegisterPage.selectItemInYearDropdown(year);

		userRegisterPage.inPutToEmailTextbox(emailAddress);
		userRegisterPage.inputToCompanyNameTextbox(companyName);
		userRegisterPage.inPutToPasswordTextbox(password);
		userRegisterPage.inPutToConfirmPasswordTextbox(password);

		userRegisterPage.clickToRegisterButton();

		Assert.assertTrue(userRegisterPage.isRegisterSuccessMessageDisplayed("Your registration completed"));

		closeBrowserDriver();
	}
}
