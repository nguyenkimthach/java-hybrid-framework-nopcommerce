package com.nopcommerce.admin;

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
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class Admin_01_Search_Product extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appAdminUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		adminLoginPage = PageGeneratorManage.getAdminLoginPage(driver);

		adminLoginPage.inPutToEmailTextbox("admin@yourstore.com");
		adminLoginPage.inPutToPasswordTextbox("admin");
		adminLoginPage.selectRememberCheckbox();

		adminDashboardPage = adminLoginPage.clickToRegisterButton();

		Assert.assertTrue(adminDashboardPage.isDashboardPageTittleDisplayedByText("Dashboard"));

		adminDashboardPage.openSubMenuByMenuTypeAndText("Catalog", "Products");

		adminDashboardPage.openSearchBox();
	}

	@Test
	public void TC_01_Search_With_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Search_With_Product_Name");

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Search - Step 01: input to 'Product name' textbox at product area with text is 'Lenovo IdeaCentre 600 All-in-One PC'");
		adminDashboardPage.inputToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Search - Step 02: click to button 'Search' at product area");
		adminDashboardPage.clickToProductSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Search - Step 03: verify have 1 product display in grid product with name is 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertTrue(adminDashboardPage.getTextNumberProductOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isProductNameByTextDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "SKU"), "LE_IC_600");
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "Price"), "500");
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "Stock quantity"), "10000");
		Assert.assertTrue(adminDashboardPage.isPublicItemCheckedByProductNameDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
	}

	@Test
	public void TC_02_Search_With_Product_Name_And_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Search_With_Product_Name_And_Category");

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Search - Step 01: input to 'Product name' textbox at product area with text is 'Lenovo IdeaCentre 600 All-in-One PC'");
		adminDashboardPage.inputToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Search - Step 02: Select item in 'Category' dropdown is 'Computers'");
		adminDashboardPage.selectItemInDropdownByLabelName("Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Search - Step 03: Uncheck to 'Search subcategories'checkbox ");
		adminDashboardPage.uncheckToSearchSubcategories();

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Search - Step 04: click to button 'Search' at product area");
		adminDashboardPage.clickToProductSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Search - Step 05: verify have no product display");
		Assert.assertTrue(adminDashboardPage.isMessageDataTableDisplayed("No data available in table"));

	}

	@Test
	public void TC_03_Search_With_Product_Name_And_Category_And_Subcategory_Checked(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Search_With_Product_Name_And_Category_And_Subcategory_Checked");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Search - Step 01: input to 'Product name' textbox at product area with text is 'Lenovo IdeaCentre 600 All-in-One PC'");
		adminDashboardPage.inputToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Search - Step 02: Select item in 'Category' dropdown is 'Computers'");
		adminDashboardPage.selectItemInDropdownByLabelName("Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Search - Step 03: Uncheck to 'Search subcategories'checkbox ");
		adminDashboardPage.checkToSearchSubcategories();

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Search - Step 04: click to button 'Search' at product area");
		adminDashboardPage.clickToProductSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Search - Step 05: verify have 1 product display in grid product with name is 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertTrue(adminDashboardPage.getTextNumberProductOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isProductNameByTextDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "SKU"), "LE_IC_600");
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "Price"), "500");
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "Stock quantity"), "10000");
		Assert.assertTrue(adminDashboardPage.isPublicItemCheckedByProductNameDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));

	}

	@Test
	public void TC_04_Search_With_Product_Name_And_Child_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Search_With_Product_Name_And_Child_Category");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 01: input to 'Product name' textbox at product area with text is 'Lenovo IdeaCentre 600 All-in-One PC'");
		adminDashboardPage.inputToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 02: Select item in 'Category' dropdown is 'Computers'");
		adminDashboardPage.selectItemInDropdownByLabelName("Category", "Computers >> Desktops");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 03: Uncheck to 'Search subcategories'checkbox ");
		adminDashboardPage.uncheckToSearchSubcategories();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 04: click to button 'Search' at product area");
		adminDashboardPage.clickToProductSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Search - Step 05: verify have 1 product display in grid product with name is 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertTrue(adminDashboardPage.getTextNumberProductOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isProductNameByTextDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "SKU"), "LE_IC_600");
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "Price"), "500");
		Assert.assertEquals(adminDashboardPage.getTextItemByProductNameAndColumName("Lenovo IdeaCentre 600 All-in-One PC", "Stock quantity"), "10000");
		Assert.assertTrue(adminDashboardPage.isPublicItemCheckedByProductNameDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));

	}

	@Test
	public void TC_05_Search_With_Product_Name_And_Child_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Search_With_Product_Name_And_Child_Category");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 01: input to 'Product name' textbox at product area with text is 'Lenovo IdeaCentre 600 All-in-One PC'");
		adminDashboardPage.inputToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 02: Select item in 'Category' dropdown is 'Computers'");
		adminDashboardPage.selectItemInDropdownByLabelName("Category", "All");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 03: Uncheck to 'Search subcategories'checkbox ");
		adminDashboardPage.uncheckToSearchSubcategories();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 04: Select item in 'Category' dropdown is 'Computers'");
		adminDashboardPage.selectItemInDropdownByLabelName("Manufacturer", "Apple");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 05: click to button 'Search' at product area");
		adminDashboardPage.clickToProductSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 06: verify have no product display");
		Assert.assertTrue(adminDashboardPage.isMessageDataTableDisplayed("No data available in table"));

	}

	@Test
	public void TC_06_Search_With_Product_Name_And_Child_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Search_With_Product_Name_And_Child_Category");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 01: input to 'Go directly to product SKU' textbox at product area with text is 'LE_IC_600'");
		adminDashboardPage.inputToGoDirectlySKUTextbox("LE_IC_600");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 05: click to button 'Search' at product area");
		adminDashboardPage.clickToGoButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Search - Step 06: verify have no product display");
		Assert.assertTrue(adminDashboardPage.isHeaderTitleByTextDisplayed("Edit product details - Lenovo IdeaCentre 600 All-in-One PC"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
}
