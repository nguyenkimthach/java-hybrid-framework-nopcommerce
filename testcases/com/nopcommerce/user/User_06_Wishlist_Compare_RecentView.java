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
import pageObjects.nopCommerce.user.UserComparePageObject;
import pageObjects.nopCommerce.user.UserComputerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserProductPageObject;
import pageObjects.nopCommerce.user.UserRecentlyViewedPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class User_06_Wishlist_Compare_RecentView extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);

		userLoginPage = userHomePage.clickToLoginLink();

		System.out.println("email " + Common_01_Register_End_User.emailAddress);
		userLoginPage.inPutToEmailTextbox(Common_01_Register_End_User.emailAddress);
		userLoginPage.inPutToPasswordTextbox(Common_01_Register_End_User.password);
		userHomePage = userLoginPage.clickToLoginButton();

		userProductPage = userHomePage.clickToProductAtFeaturedProductsListByText("Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_01_Add_To_Whislist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Add_To_Whislist");

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Whislist - Step 01: Click to buton 'Add to wishlist' at over view button menu");
		userProductPage.clickToButtonOverViewByTextName("Add to wishlist");

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Whislist - Step 02: Verify message is 'The product has been added to your wishlist' displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your wishlist");

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Whislist - Step 03: Navigate to 'wishlist' page");
		userWishlistPage = userProductPage.openWishlistPage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Whislist - Step 04: Verify the product name is 'Apple MacBook Pro 13-inch' displayed");
		Assert.assertTrue(userWishlistPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Whislist - Step 05: Click to 'Your wishlist URL for sharing' link");
		userWishlistPage.clickToWishlistSharingLink();

		ExtentTestManager.getTest().log(Status.INFO, "TC_01_Whislist - Step 06: Verify title have text 'Wishlist of' displayed");
		Assert.assertTrue(userWishlistPage.isTitleTableProductsByTextDispaly("Wishlist of"));
	}

	@Test
	public void TC_02_Add_To_Cart_To_Cart_From_Whislist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Add_To_Cart_To_Cart_From_Whislist");

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Add_To_Cart_To_Cart - Step 01: Navigate to 'wishlist' page");
		userWishlistPage.openWishlistPage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Add_To_Cart - Step 02: Check to checkbox 'Add to wishlist' at over view button menu");
		userWishlistPage.checkToCheckboxAddToCartByProductName("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Add_To_Cart - Step 3: Click to 'Add to cart' button");
		userShoppingCartPage = userWishlistPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Add_To_Cart - Step 04: Verify the product name is 'Apple MacBook Pro 13-inch' displayed");
		Assert.assertTrue(userShoppingCartPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Add_To_Cart - Step 05: Navigate to 'wishlist' page");
		userWishlistPage = userShoppingCartPage.openWishlistPage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_02_Add_To_Cart - Step 06: Verify the product name is 'Apple MacBook Pro 13-inch' undisplayed");
		Assert.assertTrue(userWishlistPage.isProductNameBytextUndisplayed("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_03_Remove_Product_In_Whislist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Remove_Product_In_Whislist");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Remove_Product - Step 01: Navigate to 'Home' page");
		userHomePage = userWishlistPage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Remove_Product - Step 02: Select product at 'Feature Products List'with product name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userHomePage.clickToProductAtFeaturedProductsListByText("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Remove_Product - Step 03: Click to buton 'Add to wishlist' at over view button menu");
		userProductPage.clickToButtonOverViewByTextName("Add to wishlist");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Remove_Product - Step 04: Navigate to 'wishlist' page");
		userWishlistPage = userProductPage.openWishlistPage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Remove_Product - Step 05: click checkbox 'Remove' at products table");
		userWishlistPage.clickToCheckboxRemoveByProductName("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_03_Remove_Product - Step 06: Verify Message wishlist is 'The wishlist is empty!' displayed");
		Assert.assertTrue(userWishlistPage.isMessageWishlistByTextDispaly("The wishlist is empty!"));
	}

	@Test
	public void TC_04_Add_Product_To_Compare(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Add_Product_To_Compare");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 01: Navigate to 'Home' page");
		userHomePage = userWishlistPage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 02: Open submenu 'Notebooks' in 'Computers' menu header");
		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Notebooks");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 03: Click to button 'Add to compare' with product name is 'Apple MacBook Pro 13-inch'");
		userComputerPage.clickToAddToCompareButtonByProductName("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 04: Verify 'Add to compare' with product name is 'Apple MacBook Pro 13-inch'");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your product comparison");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 05: Click to button 'Add to compare' with product name is 'Asus N551JK-XO076H Laptop'");
		userComputerPage.clickToAddToCompareButtonByProductName("Asus N551JK-XO076H Laptop");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 06: Verify message is 'The product has been added to your product comparison' displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your product comparison");

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 07: Navigate to 'Compare products list' page in footer menu");
		userComputerPage.openPageAtFooterByText("Compare products list");
		userComparePage = PageGeneratorManage.getUserComparePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 08: Verify information on compare list displayed");
		Assert.assertTrue(userComparePage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(userComparePage.isRemoveButtonByProductNameDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(userComparePage.isPriceTextByProductNameAtRowNameDisplayed("Apple MacBook Pro 13-inch", "Price"));

		Assert.assertTrue(userComparePage.isProductNameBytextDisplayed("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(userComparePage.isRemoveButtonByProductNameDisplayed("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(userComparePage.isPriceTextByProductNameAtRowNameDisplayed("Asus N551JK-XO076H Laptop", "Price"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 09: Click to 'Clear List' button");
		userComparePage.clickToClearListButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_04_Add_To_Compare - Step 10: Verify information on compare list undisplayed");
		Assert.assertTrue(userComparePage.isProductNameBytextUndisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(userComparePage.isProductNameBytextUndisplayed("Asus N551JK-XO076H Laptop"));
	}

	@Test
	public void TC_05_Recently_Viewed_Products(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Recently_Viewed_Products");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 01: Navigate to 'Home' page");
		userHomePage = userComparePage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 02: Open submenu 'Notebooks' in 'Computers' menu header");
		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Notebooks");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 03: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 04: navigate back to 'Notebooks'page in 'Categories' page");
		userProductPage.navigateToPreviousPage();
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 05: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Asus N551JK-XO076H Laptop");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 06: navigate back to 'Notebooks'page in 'Categories' page");
		userProductPage.navigateToPreviousPage();
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 07: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("HP Envy 6-1180ca 15.6-Inch Sleekbook");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 08: navigate back to 'Notebooks'page in 'Categories' page");
		userProductPage.navigateToPreviousPage();
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 09: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("HP Spectre XT Pro UltraBook");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 10: navigate back to 'Notebooks'page in 'Categories' page");
		userProductPage.navigateToPreviousPage();
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 11: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Lenovo Thinkpad X1 Carbon Laptop");

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 12: Navigate to 'Recently viewed products' page in footer menu");
		userProductPage.openPageAtFooterByText("Recently viewed products");
		userRecentlyViewedPage = PageGeneratorManage.getUsergetUserShoppingCartPagePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_05_Recently_Viewed - Step 13: Verify only 3 Product is displayed");
		Assert.assertTrue(userRecentlyViewedPage.countProductOnDisplayed() == 3);
		Assert.assertTrue(userRecentlyViewedPage.isProductNameAtRecentlyViewedBytextDisplayed("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
		Assert.assertTrue(userRecentlyViewedPage.isProductNameAtRecentlyViewedBytextDisplayed("HP Spectre XT Pro UltraBook"));
		Assert.assertTrue(userRecentlyViewedPage.isProductNameAtRecentlyViewedBytextDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserProductPageObject userProductPage;
	private UserWishlistPageObject userWishlistPage;
	private UserShoppingCartPageObject userShoppingCartPage;
	private UserComputerPageObject userComputerPage;
	private UserComparePageObject userComparePage;
	private UserRecentlyViewedPageObject userRecentlyViewedPage;
}
