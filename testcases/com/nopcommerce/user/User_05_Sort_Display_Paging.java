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
import pageObjects.nopCommerce.user.UserComputerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class User_05_Sort_Display_Paging extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToLoginLink();

		userLoginPage.inPutToEmailTextbox(Common_01_Register_End_User.emailAddress);
		userLoginPage.inPutToPasswordTextbox(Common_01_Register_End_User.password);
		userHomePage = userLoginPage.clickToLoginButton();

		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Notebooks");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

	}

	@Test
	public void TC_User_01_Sort_With_Name_A_To_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_01_Sort_With_Name_A_To_Z");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Sort - Step 01: Select item in 'Sort by' dropdown is 'Name: A to Z'");
		userComputerPage.selectSortByDropDownByText("Name: A to Z");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Sort - Step 02: Verify product name is sorted by A to Z");
		Assert.assertTrue(userComputerPage.isProductNameSortByAToZ());
	}

	@Test
	public void TC_User_02_Sort_With_Name_Z_To_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_02_Sort_With_Name_Z_To_A");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Sort - Step 01: Select item in 'Sort by' dropdown is 'Name: Z to A'");
		userComputerPage.selectSortByDropDownByText("Name: Z to A");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Sort - Step 02: Verify product name is sorted by Z to A");
		Assert.assertTrue(userComputerPage.isProductNameSortByZToA());
	}

	@Test
	public void TC_User_03_Sort_With_Price_Low_To_High(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_03_Sort_With_Price_Low_To_High");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_03_Sort - Step 01: Select item in 'Sort by' dropdown is 'Price: Low to High'");
		userComputerPage.selectSortByDropDownByText("Price: Low to High");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_03_Sort - Step 02: Verify product price is sorted by Low to High");
		Assert.assertTrue(userComputerPage.isProductPriceSortByLowToHigh());
	}

	@Test
	public void TC_User_04_Sort_With_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_04_Sort_With_Price_High_To_Low");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Sort - Step 01: Select item in 'Sort by' dropdown is 'Price: High to Low'");
		userComputerPage.selectSortByDropDownByText("Price: High to Low");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Sort - Step 02: Verify product price is sorted by High to Low");
		Assert.assertTrue(userComputerPage.isProductPriceSortByHighToLow());
	}

	@Test
	public void TC_User_05_Display_With_3_Products_One_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_05_Display_With_3_Products_One_Page");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Display - Step 01: Select item in 'Display' dropdown is '3'");
		userComputerPage.selectDisplayDropDownByTextNumber("3");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Display - Step 02: Verify the number of products is less than or equal to '3'");
		Assert.assertTrue(userComputerPage.countProductOnDisplayed() <= 3);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Display - Step 03: Verify Paging 'Next Icon' is displayed");
		Assert.assertTrue(userComputerPage.isPagingNextIconDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Display - Step 04: open paging with number is '2'");
		userComputerPage.openPagingByTextNumber("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Display - Step 05: Verify Paging 'previous Icon' is displayed");
		Assert.assertTrue(userComputerPage.isPagingPreviousIconDisplayed());
	}

	@Test
	public void TC_User_06_Display_With_6_Products_One_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_06_Display_With_6_Products_One_Page");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Display - Step 01: Select item in 'Display' dropdown is '6'");
		userComputerPage.selectDisplayDropDownByTextNumber("6");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Display - Step 02: Verify the number of products is less than or equal to '6'");
		Assert.assertTrue(userComputerPage.countProductOnDisplayed() <= 6);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Display - Step 03: Verify Paging 'Next Icon' is undisplayed");
		Assert.assertTrue(userComputerPage.isPagingNextIconUndisplayed());
	}

	@Test
	public void TC_User_07_Display_With_9_Products_One_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_07_Display_With_9_Products_One_Page");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_Display - Step 01: Select item in 'Display' dropdown is '9'");
		userComputerPage.selectDisplayDropDownByTextNumber("9");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_Display - Step 02: Verify the number of products is less than or equal to '9'");
		Assert.assertTrue(userComputerPage.countProductOnDisplayed() <= 9);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_Display - Step 03: Verify Paging 'Next Icon' is undisplayed");
		Assert.assertTrue(userComputerPage.isPagingNextIconUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserComputerPageObject userComputerPage;
}
