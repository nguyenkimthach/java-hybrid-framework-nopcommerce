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
import pageObjects.nopCommerce.user.UserSearchPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class User_04_Search_And_Advance_Search extends BaseTest {

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

		userHomePage.openPageAtFooterByText("Search");
		userSearchPage = PageGeneratorManage.getUserSearchPage(driver);
	}

	@Test
	public void TC_01_Search_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_01_With_Empty_Data");

		ExtentTestManager.getTest().log(Status.INFO, "Search_01 - Step 01: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_01 - Step 02: Verify search message with text 'Search term minimum length is 3 characters' displayed");
		Assert.assertTrue(userSearchPage.isSearchMessageInforDisplay("Search term minimum length is 3 characters"));
	}

	@Test
	public void TC_02_Search_With_Data_Not_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_02_With_Data_Not_Exist");

		ExtentTestManager.getTest().log(Status.INFO, "Register_02 - Step 01: inPut to 'Search Keyword' textbox with text is 'Macbook Pro 2050'");
		userSearchPage.inputToSearchKeywordTextbox("Macbook Pro 2050");

		ExtentTestManager.getTest().log(Status.INFO, "Search_02 - Step 02: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_02 - Step 03: Verify search message with text 'No products were found that matched your criteria.' displayed");
		Assert.assertTrue(userSearchPage.isSearchMessageInforDisplay("No products were found that matched your criteria."));
	}

	@Test
	public void TC_03_Search_With_Relative_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_03_With_Relative_Product_Name");

		ExtentTestManager.getTest().log(Status.INFO, "Search_03 - Step 01: inPut to 'Search Keyword' textbox with text is 'lenovo'");
		userSearchPage.inputToSearchKeywordTextbox("Lenovo");

		ExtentTestManager.getTest().log(Status.INFO, "Search_03 - Step 02: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_03 - Step 03: Verify two result product displayed");
		Assert.assertEquals(userSearchPage.getCountNumberProductsOnDisplayed("Lenovo"), 2);
		Assert.assertTrue(userSearchPage.isResultProductByTitleTextDisplay("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(userSearchPage.isResultProductByTitleTextDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void TC_04_Search_With_Absolute_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_04_With_Relative_Product_Name");

		ExtentTestManager.getTest().log(Status.INFO, "Search_04 - Step 01: inPut to 'Search Keyword' textbox with text is 'Thinkpad X1 Carbon'");
		userSearchPage.inputToSearchKeywordTextbox("Thinkpad X1 Carbon");

		ExtentTestManager.getTest().log(Status.INFO, "Search_04 - Step 02: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_04 - Step 03: Verify one result product displayed");
		Assert.assertEquals(userSearchPage.getCountNumberProductsOnDisplayed("Thinkpad X1 Carbon"), 1);
		Assert.assertTrue(userSearchPage.isResultProductByTitleTextDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void TC_05_Advanced_Search_With_Parent_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_05_Advanced_With_Parent_Categories");

		ExtentTestManager.getTest().log(Status.INFO, "Search_05 - Step 01: inPut to 'Search Keyword' textbox with text is 'Apple MacBook Pro'");
		userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");

		ExtentTestManager.getTest().log(Status.INFO, "Search_05 - Step 02: Check to 'Advance search' checkbox");
		userSearchPage.checkToCheckboxByTextName("Advanced search");

		ExtentTestManager.getTest().log(Status.INFO, "Search_05 - Step 03: Select item in 'Category' dropdown is 'Computers'");
		userSearchPage.selectItemInDropdownByLabelText("Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "Search_05 - Step 04: Uncheck to 'Automatically search sub categories' checkbox");
		userSearchPage.unCheckToCheckboxByTextName("Automatically search sub categories");

		ExtentTestManager.getTest().log(Status.INFO, "Search_05 - Step 05: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_05 - Step 06: Verify search message with text 'No products were found that matched your criteria.' displayed");
		Assert.assertTrue(userSearchPage.isSearchMessageInforDisplay("No products were found that matched your criteria."));
	}

	@Test
	public void TC_06_Advanced_Search_With_Sub_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_06_Advanced_With_Sub_Categories");

		ExtentTestManager.getTest().log(Status.INFO, "Search_06 - Step 01: inPut to 'Search Keyword' textbox with text is 'Apple MacBook Pro'");
		userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");

		ExtentTestManager.getTest().log(Status.INFO, "Search_06 - Step 02: Check to 'Advance search' checkbox");
		userSearchPage.checkToCheckboxByTextName("Advanced search");

		ExtentTestManager.getTest().log(Status.INFO, "Search_06 - Step 03: Select item in 'Category' dropdown is 'Computers'");
		userSearchPage.selectItemInDropdownByLabelText("Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "Search_06 - Step 04: Check to 'Automatically search sub categories' checkbox");
		userSearchPage.checkToCheckboxByTextName("Automatically search sub categories");

		ExtentTestManager.getTest().log(Status.INFO, "Search_06 - Step 05: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_06 - Step 06: Verify one result product displayed");
		Assert.assertEquals(userSearchPage.getCountNumberProductsOnDisplayed("Apple MacBook Pro"), 1);
		Assert.assertTrue(userSearchPage.isResultProductByTitleTextDisplay("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_07_Advanced_Search_With_Incorrect_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_07_Advanced_With_Incorrect_Manufacturer");

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 01: inPut to 'Search Keyword' textbox with text is 'Apple MacBook Pro'");
		userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 02: Check to 'Advance search' checkbox");
		userSearchPage.checkToCheckboxByTextName("Advanced search");

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 03: Select item in 'Category' dropdown is 'Computers'");
		userSearchPage.selectItemInDropdownByLabelText("Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 04: Check to 'Automatically search sub categories' checkbox");
		userSearchPage.checkToCheckboxByTextName("Automatically search sub categories");

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 05: Select item in 'Manufacturer' dropdown is 'HP'");
		userSearchPage.selectItemInDropdownByLabelText("Manufacturer", "HP");

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 06: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_07 - Step 07: Verify search message with text 'No products were found that matched your criteria.' displayed");
		Assert.assertTrue(userSearchPage.isSearchMessageInforDisplay("No products were found that matched your criteria."));
	}

	@Test
	public void TC_08_Advanced_Search_With_Correct_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search_08_Advanced_With_Correct_Manufacturer");

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 01: inPut to 'Search Keyword' textbox with text is 'Apple MacBook Pro'");
		userSearchPage.inputToSearchKeywordTextbox("Apple MacBook Pro");

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 02: Check to 'Advance search' checkbox");
		userSearchPage.checkToCheckboxByTextName("Advanced search");

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 03: Select item in 'Category' dropdown is 'Computers'");
		userSearchPage.selectItemInDropdownByLabelText("Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 04: Check to 'Automatically search sub categories' checkbox");
		userSearchPage.checkToCheckboxByTextName("Automatically search sub categories");

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 05: Select item in 'Manufacturer' dropdown is 'Apple'");
		userSearchPage.selectItemInDropdownByLabelText("Manufacturer", "Apple");

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 06: Click to 'Search' button");
		userSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Search_08 - Step 07: Verify one result product displayed");
		Assert.assertEquals(userSearchPage.getCountNumberProductsOnDisplayed("Apple MacBook Pro"), 1);
		Assert.assertTrue(userSearchPage.isResultProductByTitleTextDisplay("Apple MacBook Pro 13-inch"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserSearchPageObject userSearchPage;
}
