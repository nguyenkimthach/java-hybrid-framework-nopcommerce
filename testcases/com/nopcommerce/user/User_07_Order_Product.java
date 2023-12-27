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
import pageObjects.nopCommerce.user.UserCheckOutPageObject;
import pageObjects.nopCommerce.user.UserComputerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOrderInformationPageObject;
import pageObjects.nopCommerce.user.UserProductPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class User_07_Order_Product extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		email = "automationfc1.vn@gmail.com";
		companyName = "Automation FC";
		country = "Viet Nam";
		city = "Da Nang";
		city_1 = "Ho Chi Minh";
		address_1 = "123/04 Le Lai";
		address_2 = "234/05 Hai Phong";
		address_3 = "12/35 Le Loi";
		address_4 = "123/09 Ho Chi Minh";
		zipPostalCode = "550000";
		zipPostalCode_1 = "700000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		creditCardTypes = "Visa";
		cardHolderName = "AUTOMATION FC";
		cardNumber = "374245455400126";
		expireMonth = "05";
		expireYear = "2025";
		cardCode = "123";

		userLoginPage = userHomePage.clickToLoginLink();

		userLoginPage.inPutToEmailTextbox(Common_01_Register_End_User.emailAddress);
		userLoginPage.inPutToPasswordTextbox(Common_01_Register_End_User.password);
		userHomePage = userLoginPage.clickToLoginButton();

		userLoginPage.openPageAtFooterByText("Shopping cart");
		userShoppingCartPage = PageGeneratorManage.getUserShoppingCartPage(driver);
		if (userShoppingCartPage.isMessageShoppingCartByTextUndisplayed("Your Shopping Cart is empty!")) {
			userShoppingCartPage.clickToChechboxRemoveByProductName("Apple MacBook Pro 13-inch");
			Assert.assertTrue(userShoppingCartPage.isMessageShoppingCartByTextDisplayed("Your Shopping Cart is empty!"));
		}
		userShoppingCartPage.openHomePage();

		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Desktops");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);
	}

	@Test
	public void TC_User_01_Add_Product_To_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_01_Add_Product_To_Cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 01: Click to product with name is 'Build your own computer'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Build your own computer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 02: Select item in 'Processor' dropdown is '2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]'");
		userProductPage.selectItemByDropdownNameAndTextValue("Processor", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 03: Select item in 'RAM' dropdown is '8GB [+$60.00]'");
		userProductPage.selectItemByDropdownNameAndTextValue("RAM", "8GB [+$60.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 04: Select item in 'HDD' Radio button is '400 GB [+$100.00]'");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("HDD", "400 GB [+$100.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 04: Select item in 'OS' Radio button is 'Vista Premium [+$60.00]'");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("OS", "Vista Premium [+$60.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 06: Select all item in 'Software' checkbox is");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("Software", "Acrobat Reader [+$10.00]");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("Software", "Total Commander [+$5.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 07: Click to 'ADD TO CART' button");
		userProductPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 08: Verify message is 'The product has been added to your shopping cart' displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your shopping cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 09: Navigate to 'Compare products list' page in footer menu");
		userProductPage.openPageAtFooterByText("Shopping cart");
		userShoppingCartPage = PageGeneratorManage.getUserShoppingCartPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_01_Add_To_Cart - Step 10: Verify The product has been added to your shopping cart success");
		Assert.assertEquals(userShoppingCartPage.getTextOnShoppingCartLink(), "Shopping cart (1)");
		Assert.assertTrue(userShoppingCartPage.isProductNameBytextDisplayed("Build your own computer"));
		Assert.assertEquals(userShoppingCartPage.getInforProductByProductName("Build your own computer"), "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\n" + "RAM: 8GB [+$60.00]\n" + "HDD: 400 GB [+$100.00]\n"
				+ "OS: Vista Premium [+$60.00]\n" + "Software: Microsoft Office [+$50.00]\n" + "Software: Acrobat Reader [+$10.00]\n" + "Software: Total Commander [+$5.00]");
		Assert.assertEquals(userShoppingCartPage.getNumberProductByProductNameAndAtribute("Build your own computer", "Qty"), "1");
		Assert.assertEquals(userShoppingCartPage.getTotalPriceProductByProductNameAndAtribute("Build your own computer", "Total"), "$1,500.00");
	}

	@Test
	public void TC_User_02_Edit_Product_In_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_02_Edit_Product_In_Shopping_Cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 01: Click to 'Edit' link at product with name is 'Build your own computer'");
		userProductPage = userShoppingCartPage.clickToEditLinkByProductName("Build your own computer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 02: Select item in 'Processor' dropdown is '2.2 GHz Intel Pentium Dual-Core E2200'");
		userProductPage.selectItemByDropdownNameAndTextValue("Processor", "2.2 GHz Intel Pentium Dual-Core E2200");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 03: Select item in 'RAM' dropdown is '4GB [+$20.00]'");
		userProductPage.selectItemByDropdownNameAndTextValue("RAM", "4GB [+$20.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 04: Select item in 'HDD' Radio button is '320 GB'");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("HDD", "320 GB");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 05: Select item in 'OS' Radio button is 'Vista Home [+$50.00]'");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("OS", "Vista Home [+$50.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 06: Select all item in 'Software' checkbox is");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("Software", "Acrobat Reader [+$10.00]");
		userProductPage.selectItemByCheckbookOrRadioNameAndTextLabel("Software", "Total Commander [+$5.00]");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 07: input to Qty textbox with text is '2'");
		userProductPage.inputToQtyTextbox("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 08: Click to 'UpDate' button");
		userProductPage.clickToUpDateButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 09: Verify message is 'The product has been added to your shopping cart' displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your shopping cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 10: Navigate to 'Compare products list' page in footer menu");
		userProductPage.openPageAtFooterByText("Shopping cart");
		userShoppingCartPage = PageGeneratorManage.getUserShoppingCartPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_02_Edit_Product - Step 11: Verify The product has been added to your shopping cart success");
		Assert.assertEquals(userShoppingCartPage.getTextOnShoppingCartLink(), "Shopping cart (2)");
		Assert.assertTrue(userShoppingCartPage.isProductNameBytextDisplayed("Build your own computer"));
		Assert.assertEquals(userShoppingCartPage.getInforProductByProductName("Build your own computer"),
				"Processor: 2.2 GHz Intel Pentium Dual-Core E2200\n" + "RAM: 4GB [+$20.00]\n" + "HDD: 320 GB\n" + "OS: Vista Home [+$50.00]\n" + "Software: Microsoft Office [+$50.00]");
		Assert.assertEquals(userShoppingCartPage.getNumberProductByProductNameAndAtribute("Build your own computer", "Qty"), "2");
		Assert.assertEquals(userShoppingCartPage.getTotalPriceProductByProductNameAndAtribute("Build your own computer", "Total"), "$2,640.00");
	}

	@Test
	public void TC_User_03_Remove_Product_from_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_03_Remove_Product_from_Cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_03_Remove_Product - Step 01: Click to 'Remove' checkbox at product with name is 'Build your own computer'");
		userShoppingCartPage.clickToChechboxRemoveByProductName("Build your own computer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_03_Remove_Product - Step 02: Verify Message wishlist is 'Your Shopping Cart is empty!' displayed");
		Assert.assertTrue(userShoppingCartPage.isMessageShoppingCartByTextDisplayed("Your Shopping Cart is empty!"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_03_Remove_Product - Step 03: Verify the product name is 'Build your own computer' undisplayed");
		Assert.assertTrue(userShoppingCartPage.isProductNameByTextUndisplayed("Build your own computer"));
	}

	@Test
	public void TC_User_04_Update_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_04_Update_Shopping_Cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 01: Navigate to 'Home' page");
		userHomePage = userShoppingCartPage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 02: Open submenu 'Desktops' in 'Computers' menu header");
		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Desktops");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 03: Click to product with name is 'Lenovo IdeaCentre 600 All-in-One PC'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 04: Click to 'ADD TO CART' button");
		userProductPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 05: Verify message is 'The product has been added to your shopping cart' displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your shopping cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 06: Navigate to 'Shopping Cart' page in footer menu");
		userProductPage.openPageAtFooterByText("Shopping cart");
		userShoppingCartPage = PageGeneratorManage.getUserShoppingCartPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 07: Verify The 'Total Price' of product is'$500.00'");
		Assert.assertEquals(userShoppingCartPage.getTotalPriceProductByProductNameAndAtribute("Lenovo IdeaCentre 600 All-in-One PC", "Total"), "$500.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 08: input to Qty textbox at product name 'Lenovo IdeaCentre 600 All-in-One PC' with text is '5'");
		userShoppingCartPage.inputToQtyTextboxByProductName("Lenovo IdeaCentre 600 All-in-One PC", "Qty", "5");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 09: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_04_Update_Shopping_Cart - Step 10: Verify The 'Total Price' of product is'$2,500.00'");
		Assert.assertEquals(userShoppingCartPage.getTotalPriceProductByProductNameAndAtribute("Lenovo IdeaCentre 600 All-in-One PC", "Total"), "$2,500.00");
	}

	@Test
	public void TC_User_05_Checkout_Order_With_Payment_Method_BY_Money(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_05_Checkout_Order_With_Payment_Method_BY_Money");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 01: Click to 'Remove' checkbox at product with name is 'LenovoIdeaCentre600All-in-One PC'");
		userShoppingCartPage.clickToChechboxRemoveByProductName("Lenovo IdeaCentre 600 All-in-One PC");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 02: Verify Message wishlist is 'Your Shopping Cart is empty!' displayed");
		Assert.assertTrue(userShoppingCartPage.isMessageShoppingCartByTextDisplayed("Your Shopping Cart is empty!"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 03: Navigate to 'Home' page");
		userHomePage = userComputerPage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 04: Open submenu 'Desktops' in 'Computers' menu header");
		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Notebooks");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 05: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 06: Click to 'ADD TO CART' button");
		userProductPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 07: Verify message is 'The product has been added to your shopping cart'displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your shopping cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 08: Navigate to 'Shopping Cart' page in footer menu");
		userProductPage.openPageAtFooterByText("Shopping cart");
		userShoppingCartPage = PageGeneratorManage.getUserShoppingCartPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 09: Select item in 'Gift wrapping' dropdown is 'No'");
		userShoppingCartPage.selectItemInGiftWrappingDropdownBytext("No");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 10: Check to 'Terms of Service' checkbox");
		userShoppingCartPage.checkToTermsOfServiceCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 11: Click to 'CHECKOUT' button");
		userCheckOutPage = userShoppingCartPage.clickToCheckOutButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 10: unCheck to 'ShipToSameAddress' checkbox");
		userCheckOutPage.unCheckToShipToSameAddressCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 12: Input to 'Billing address' form");
		userCheckOutPage.inputToBillingFirstNameTextbox(firstName);
		userCheckOutPage.inputToBillingLastNameTextbox(lastName);
		userCheckOutPage.inPutToBillingEmailTextbox(email);
		userCheckOutPage.inputToBillingCompanyNameTextbox(companyName);
		userCheckOutPage.selectToBillingCountryDropdownByText(country);
		userCheckOutPage.inputToBillingCityTextbox(city);
		userCheckOutPage.inputToBillingAddress1Textbox(address_1);
		userCheckOutPage.inputToBillingAddress2Textbox(address_2);
		userCheckOutPage.inputToBillingZipPostalCodeTextbox(zipPostalCode);
		userCheckOutPage.inputToBillingPhoneNumberTextbox(phoneNumber);
		userCheckOutPage.inputToBillingFaxNumberTextbox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 13: Click to 'Continue' button");
		userCheckOutPage.clickToContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 14: Click to 'Edit' button");
		userCheckOutPage.clickToEditButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 15: Input to 'Shipping address' form");
		userCheckOutPage.inputToShippingFirstNameTextbox(firstName);
		userCheckOutPage.inputToShippingLastNameTextbox(lastName);
		userCheckOutPage.inPutToShippingEmailTextbox(email);
		userCheckOutPage.inputToShippingCompanyNameTextbox(companyName);
		userCheckOutPage.selectToShippingCountryDropdownByText(country);
		userCheckOutPage.inputToShippingCityTextbox(city);
		userCheckOutPage.inputToShippingAddress1Textbox(address_1);
		userCheckOutPage.inputToShippingAddress2Textbox(address_2);
		userCheckOutPage.inputToShippingZipPostalCodeTextbox(zipPostalCode);
		userCheckOutPage.inputToShippingPhoneNumberTextbox(phoneNumber);
		userCheckOutPage.inputToShippingFaxNumberTextbox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 16: Click to 'Shipping Address Continue' button");
		userCheckOutPage.clickToShippingAddressContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 17: Check to Radio button in 'Shipping method' with label is 'Ground ($0.00)'");
		userCheckOutPage.checkToRadioButtonByTextLabel("Ground ($0.00)");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 18: Click to Shipping Method 'Continue' button");
		userCheckOutPage.clickToShippingMethodContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 19: Check to Radio button in 'Payment method' with label is 'Check / MoneyOrder'");
		userCheckOutPage.checkToRadioButtonByTextLabel("Check / Money Order");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 20: Click to Shipping Payment 'Continue' button");
		userCheckOutPage.clickToShippingPaymentContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 21: Verify Address shipping information");
		Assert.assertEquals(userCheckOutPage.getAddressShippingInfor(), "NOP SOLUTIONS\n" + "your address here,\n" + "New York, NY 10001\n" + "USA");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 22: Click to Payment Infor 'Continue' button");
		userCheckOutPage.clickToPaymentInforContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 23: Verify 'Billing Address' oder infor");
		Assert.assertTrue(userCheckOutPage.getBillingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userCheckOutPage.getBillingAddressEmailInfor().contains(email));
		Assert.assertTrue(userCheckOutPage.getBillingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userCheckOutPage.getBillingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userCheckOutPage.getBillingAddress1Infor().contains(address_1));
		Assert.assertTrue(userCheckOutPage.getBillingAddress2Infor().contains(address_2));
		Assert.assertTrue(userCheckOutPage.getBillingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 24: Verify 'Shipping Address' oder infor");
		Assert.assertTrue(userCheckOutPage.getShippingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userCheckOutPage.getShippingAddressEmailInfor().contains(email));
		Assert.assertTrue(userCheckOutPage.getShippingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userCheckOutPage.getShippingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userCheckOutPage.getShippingAddress1Infor().contains(address_1));
		Assert.assertTrue(userCheckOutPage.getShippingAddress2Infor().contains(address_2));
		Assert.assertTrue(userCheckOutPage.getShippingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 25: Verify 'Payment Method' oder infor");
		Assert.assertTrue(userCheckOutPage.getPaymentMethod().contains("Payment Method: Check / Money Order"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 26: Verify 'Shipping Method' oder infor");
		Assert.assertTrue(userCheckOutPage.getShippingMethod().contains("Shipping Method: Ground"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 27: Verify The product order infor");
		Assert.assertTrue(userCheckOutPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "SKU"), "AP_MBP_13");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Qty"), "2");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Total"), "$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 28: Verify The sumary price order list");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Sub-Total"), "$3,600.00");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Shipping"), "$0.00");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Tax"), "$0.00");
		Assert.assertEquals(userCheckOutPage.getTotalPriceInfor(), "$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 29: Click to 'Confirm' button");
		userCheckOutPage.clickToConfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 30: Verify Product order completed infor");
		Assert.assertEquals(userCheckOutPage.getOrderedSuccessPageTittle(), "Thank you");
		Assert.assertEquals(userCheckOutPage.getOrderedSuccessMessage(), "Your order has been successfully processed!");
		orderNumber = userCheckOutPage.getOrderNumber();
		Assert.assertEquals(userCheckOutPage.getOrderNumberMessage(), "ORDER NUMBER: " + orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 31: Click to Oder Completed 'Continue' button");
		userHomePage = userCheckOutPage.clickToOderCompletedContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 32: Click to 'My Account' link");
		userMyAccountPage = userHomePage.clickMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 33: Navigate to 'Orders' area at My Account page");
		userMyAccountPage.navigateAreaAtMyAccountPageByText("Orders");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 34: Verify text 'Order Number: " + orderNumber + "' displayed");
		Assert.assertTrue(userMyAccountPage.isOrderNumberBytextDisplayed("Order Number: " + orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 33: Click to 'Details' button");
		userOrderInforPage = userMyAccountPage.clickToDetailsButtonByOrderNumber(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 36: Verify 'order-overview' infor");
		Assert.assertEquals(userOrderInforPage.getOrderNumberText(), "ORDER #" + orderNumber);
		Assert.assertEquals(userOrderInforPage.getOrderDate(), "Order Date: " + getYesterdayFormatted());
		Assert.assertEquals(userOrderInforPage.getOrderStatus(), "Order Status: Pending");
		Assert.assertEquals(userOrderInforPage.getOrderTotalPrice(), "Order Total: $3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 37: Verify 'Billing Address' oder infor");
		Assert.assertTrue(userOrderInforPage.getBillingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userOrderInforPage.getBillingAddressEmailInfor().contains(email));
		Assert.assertTrue(userOrderInforPage.getBillingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userOrderInforPage.getBillingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userOrderInforPage.getBillingAddress1Infor().contains(address_1));
		Assert.assertTrue(userOrderInforPage.getBillingAddress2Infor().contains(address_2));
		Assert.assertTrue(userOrderInforPage.getBillingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 38: Verify 'Shipping Address' oder infor");
		Assert.assertTrue(userOrderInforPage.getShippingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userOrderInforPage.getShippingAddressEmailInfor().contains(email));
		Assert.assertTrue(userOrderInforPage.getShippingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userOrderInforPage.getShippingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userOrderInforPage.getShippingAddress1Infor().contains(address_1));
		Assert.assertTrue(userOrderInforPage.getShippingAddress2Infor().contains(address_2));
		Assert.assertTrue(userOrderInforPage.getShippingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 39: Verify 'Payment' oder infor");
		Assert.assertTrue(userOrderInforPage.getPaymentMethod().contains("Payment Method: Check / Money Order"));
		Assert.assertTrue(userOrderInforPage.getPaymentStatus().contains("Payment Status: Pending"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 40: Verify 'Shipping' oder infor");
		Assert.assertTrue(userOrderInforPage.getShippingMethod().contains("Shipping Method: Ground"));
		Assert.assertTrue(userOrderInforPage.getShippingStatus().contains("Shipping Status: Not yet shipped"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 41: Verify The product order infor");
		Assert.assertTrue(userOrderInforPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "SKU"), "AP_MBP_13");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Quantity"), "2");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Total"), "$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_05_Checkout_Order - Step 42: Verify The sumary price order list");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Sub-Total"), "$3,600.00");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Shipping"), "$0.00");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Tax"), "$0.00");
		Assert.assertEquals(userOrderInforPage.getTotalPriceInfor(), "$3,600.00");
	}

	@Test
	public void TC_User_06_Checkout_Order_With_Payment_Method_BY_Card(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_06_Checkout_Order_With_Payment_Method_BY_Card");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 03: Navigate to 'Home' page");
		userHomePage = userOrderInforPage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 04: Open submenu 'Desktops' in 'Computers' menu header");
		userHomePage.openSubmenuPageAtHeaderMenuByName("Computers", "Notebooks");
		userComputerPage = PageGeneratorManage.getUserComputerPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 05: Click to product with name is 'Apple MacBook Pro 13-inch'");
		userProductPage = userComputerPage.clickToProductAtProductsGridByText("Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 06: Click to 'ADD TO CART' button");
		userProductPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 07: Verify message is 'The product has been added to your shopping cart'displayed");
		Assert.assertEquals(userProductPage.getContenMessage(), "The product has been added to your shopping cart");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 08: Navigate to 'Shopping Cart' page in footer menu");
		userProductPage.openPageAtFooterByText("Shopping cart");
		userShoppingCartPage = PageGeneratorManage.getUserShoppingCartPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 09: Select item in 'Gift wrapping' dropdown is 'No'");
		userShoppingCartPage.selectItemInGiftWrappingDropdownBytext("No");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 10: Check to 'Terms of Service' checkbox");
		userShoppingCartPage.checkToTermsOfServiceCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 11: Click to 'CHECKOUT' button");
		userCheckOutPage = userShoppingCartPage.clickToCheckOutButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 12: unCheck to 'ShipToSameAddress' checkbox");
		userCheckOutPage.unCheckToShipToSameAddressCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 13: Click to 'Edit' Billing Address button");
		userCheckOutPage.clickToEditBillingAddressButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 14: Input to 'Billing address' form");
		userCheckOutPage.inputToBillingFirstNameTextbox(firstName);
		userCheckOutPage.inputToBillingLastNameTextbox(lastName);
		userCheckOutPage.inPutToBillingEmailTextbox(email);
		userCheckOutPage.inputToBillingCompanyNameTextbox(companyName);
		userCheckOutPage.selectToBillingCountryDropdownByText(country);
		userCheckOutPage.inputToBillingCityTextbox(city);
		userCheckOutPage.inputToBillingAddress1Textbox(address_1);
		userCheckOutPage.inputToBillingAddress2Textbox(address_2);
		userCheckOutPage.inputToBillingZipPostalCodeTextbox(zipPostalCode);
		userCheckOutPage.inputToBillingPhoneNumberTextbox(phoneNumber);
		userCheckOutPage.inputToBillingFaxNumberTextbox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 15: Click to 'Continue' button");
		userCheckOutPage.clickToContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 16: Click to 'Shipping Address Continue' button");
		userCheckOutPage.clickToShippingAddressContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 17: Check to Radio button in 'Shipping method' with label is 'Ground ($0.00)'");
		userCheckOutPage.checkToRadioButtonByTextLabel("Ground ($0.00)");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 18: Click to Shipping Method 'Continue' button");
		userCheckOutPage.clickToShippingMethodContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 19: Check to Radio button in 'Payment method' with label is 'Credit Card'");
		userCheckOutPage.checkToRadioButtonByTextLabel("Credit Card");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 20: Click to Shipping Payment 'Continue' button");
		userCheckOutPage.clickToShippingPaymentContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 21: input infomation of Credit Card");
		userCheckOutPage.selectItemInCreditCardTypeDropdownByText(creditCardTypes);
		userCheckOutPage.inPutToTextboxByLabeName("Cardholder name", cardHolderName);
		userCheckOutPage.inPutToTextboxByLabeName("Card number", cardNumber);
		userCheckOutPage.selectItemInExpireMonthDropdownByText(expireMonth);
		userCheckOutPage.selectItemInExpireYearDropdownByText(expireYear);
		userCheckOutPage.inPutToTextboxByLabeName("Card code", cardCode);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 22: Click to Payment Infor 'Continue' button");
		userCheckOutPage.clickToPaymentInforContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 23: Verify 'Billing Address' oder infor");
		Assert.assertTrue(userCheckOutPage.getBillingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userCheckOutPage.getBillingAddressEmailInfor().contains(email));
		Assert.assertTrue(userCheckOutPage.getBillingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userCheckOutPage.getBillingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userCheckOutPage.getBillingAddress1Infor().contains(address_1));
		Assert.assertTrue(userCheckOutPage.getBillingAddress2Infor().contains(address_2));
		Assert.assertTrue(userCheckOutPage.getBillingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 24: Verify 'Shipping Address' oder infor");
		Assert.assertTrue(userCheckOutPage.getShippingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userCheckOutPage.getShippingAddressEmailInfor().contains(email));
		Assert.assertTrue(userCheckOutPage.getShippingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userCheckOutPage.getShippingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userCheckOutPage.getShippingAddress1Infor().contains(address_1));
		Assert.assertTrue(userCheckOutPage.getShippingAddress2Infor().contains(address_2));
		Assert.assertTrue(userCheckOutPage.getShippingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 25: Verify 'Payment Method' oder infor");
		Assert.assertTrue(userCheckOutPage.getPaymentMethod().contains("Payment Method: Credit Card"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 26: Verify 'Shipping Method' oder infor");
		Assert.assertTrue(userCheckOutPage.getShippingMethod().contains("Shipping Method: Ground"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 27: Verify The product order infor");
		Assert.assertTrue(userCheckOutPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "SKU"), "AP_MBP_13");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Qty"), "2");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Total"), "$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 28: Verify The sumary price order list");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Sub-Total"), "$3,600.00");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Shipping"), "$0.00");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Tax"), "$0.00");
		Assert.assertEquals(userCheckOutPage.getTotalPriceInfor(), "$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 29: Click to 'Confirm' button");
		userCheckOutPage.clickToConfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 30: handle alert 'Wait serveral second before confirm'");
		userCheckOutPage.aceptAlertBox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 31: Click to 'Confirm' button");
		userCheckOutPage.clickToConfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 32: Verify Product order completed infor");
		Assert.assertEquals(userCheckOutPage.getOrderedSuccessPageTittle(), "Thank you");
		Assert.assertEquals(userCheckOutPage.getOrderedSuccessMessage(), "Your order has been successfully processed!");
		orderNumber = userCheckOutPage.getOrderNumber();
		Assert.assertEquals(userCheckOutPage.getOrderNumberMessage(), "ORDER NUMBER: " + orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 33: Click to Oder Completed 'Continue' button");
		userHomePage = userCheckOutPage.clickToOderCompletedContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 34: Click to 'My Account' link");
		userMyAccountPage = userHomePage.clickMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 35: Navigate to 'Orders' area at My Account page");
		userMyAccountPage.navigateAreaAtMyAccountPageByText("Orders");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 36: Verify text 'Order Number: " + orderNumber + "' displayed");
		Assert.assertTrue(userMyAccountPage.isOrderNumberBytextDisplayed("Order Number: " + orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 37: Click to 'Details' button");
		userOrderInforPage = userMyAccountPage.clickToDetailsButtonByOrderNumber(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 38: Verify 'order-overview' infor");
		Assert.assertEquals(userOrderInforPage.getOrderNumberText(), "ORDER #" + orderNumber);
		Assert.assertEquals(userOrderInforPage.getOrderDate(), "Order Date: " + getYesterdayFormatted());
		Assert.assertEquals(userOrderInforPage.getOrderStatus(), "Order Status: Pending");
		Assert.assertEquals(userOrderInforPage.getOrderTotalPrice(), "Order Total: $3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 39: Verify 'Billing Address' oder infor");
		Assert.assertTrue(userOrderInforPage.getBillingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userOrderInforPage.getBillingAddressEmailInfor().contains(email));
		Assert.assertTrue(userOrderInforPage.getBillingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userOrderInforPage.getBillingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userOrderInforPage.getBillingAddress1Infor().contains(address_1));
		Assert.assertTrue(userOrderInforPage.getBillingAddress2Infor().contains(address_2));
		Assert.assertTrue(userOrderInforPage.getBillingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 40: Verify 'Shipping Address' oder infor");
		Assert.assertTrue(userOrderInforPage.getShippingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userOrderInforPage.getShippingAddressEmailInfor().contains(email));
		Assert.assertTrue(userOrderInforPage.getShippingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userOrderInforPage.getShippingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userOrderInforPage.getShippingAddress1Infor().contains(address_1));
		Assert.assertTrue(userOrderInforPage.getShippingAddress2Infor().contains(address_2));
		Assert.assertTrue(userOrderInforPage.getShippingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 41: Verify 'Payment' oder infor");
		Assert.assertTrue(userOrderInforPage.getPaymentMethod().contains("Payment Method: Credit Card"));
		Assert.assertTrue(userOrderInforPage.getPaymentStatus().contains("Payment Status: Pending"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 42: Verify 'Shipping' oder infor");
		Assert.assertTrue(userOrderInforPage.getShippingMethod().contains("Shipping Method: Ground"));
		Assert.assertTrue(userOrderInforPage.getShippingStatus().contains("Shipping Status: Not yet shipped"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 43: Verify The product order infor");
		Assert.assertTrue(userOrderInforPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "SKU"), "AP_MBP_13");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Quantity"), "2");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Total"), "$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_06_Checkout_Order - Step 44: Verify The sumary price order list");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Sub-Total"), "$3,600.00");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Shipping"), "$0.00");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Tax"), "$0.00");
		Assert.assertEquals(userOrderInforPage.getTotalPriceInfor(), "$3,600.00");
	}

	@Test
	public void TC_User_07_ReOrder_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_User_07_ReOrder_Product");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 01: Click to 'My Account' link");
		userMyAccountPage = userOrderInforPage.clickMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 02: Navigate to 'Orders' area at My Account page");
		userMyAccountPage.navigateAreaAtMyAccountPageByText("Orders");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 03: Verify text 'Order Number: " + orderNumber + "' displayed");
		Assert.assertTrue(userMyAccountPage.isOrderNumberBytextDisplayed("Order Number: " + orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 04: Click to 'Details' button");
		userOrderInforPage = userMyAccountPage.clickToDetailsButtonByOrderNumber(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 05: Click to 'Re-Order' button");
		userShoppingCartPage = userOrderInforPage.clickToReOrderButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 06: input to Qty textbox at product name 'Lenovo IdeaCentre 600 All-in-One PC' with text is '5'");
		userShoppingCartPage.inputToQtyTextboxByProductName("Apple MacBook Pro 13-inch", "Qty", "10");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 07: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 08: Select item in 'Gift wrapping' dropdown is 'No'");
		userShoppingCartPage.selectItemInGiftWrappingDropdownBytext("No");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 09: Check to 'Terms of Service' checkbox");
		userShoppingCartPage.checkToTermsOfServiceCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 10: Click to 'CHECKOUT' button");
		userCheckOutPage = userShoppingCartPage.clickToCheckOutButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 11: unCheck to 'ShipToSameAddress' checkbox");
		userCheckOutPage.unCheckToShipToSameAddressCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 12: Click to 'Edit' Billing Address button");
		userCheckOutPage.clickToEditBillingAddressButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 13: Input to 'Billing address' form");
		userCheckOutPage.inputToBillingFirstNameTextbox(firstName);
		userCheckOutPage.inputToBillingLastNameTextbox(lastName);
		userCheckOutPage.inPutToBillingEmailTextbox(email);
		userCheckOutPage.inputToBillingCompanyNameTextbox(companyName);
		userCheckOutPage.selectToBillingCountryDropdownByText(country);
		userCheckOutPage.inputToBillingCityTextbox(city_1);
		userCheckOutPage.inputToBillingAddress1Textbox(address_3);
		userCheckOutPage.inputToBillingAddress2Textbox(address_4);
		userCheckOutPage.inputToBillingZipPostalCodeTextbox(zipPostalCode_1);
		userCheckOutPage.inputToBillingPhoneNumberTextbox(phoneNumber);
		userCheckOutPage.inputToBillingFaxNumberTextbox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 14: Click to 'Save' button");
		userCheckOutPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 15: Click to 'Continue' button");
		userCheckOutPage.clickToContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 16: Click to 'Shipping Address Continue' button");
		userCheckOutPage.clickToShippingAddressContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 17: Check to Radio button in 'Shipping method' with label is 'Ground ($0.00)'");
		userCheckOutPage.checkToRadioButtonByTextLabel("Next Day Air ($0.00)");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 18: Click to Shipping Method 'Continue' button");
		userCheckOutPage.clickToShippingMethodContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 19: Check to Radio button in 'Payment method' with label is 'Credit Card'");
		userCheckOutPage.checkToRadioButtonByTextLabel("Credit Card");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 20: Click to Shipping Payment 'Continue' button");
		userCheckOutPage.clickToShippingPaymentContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 21: input infomation of Credit Card");
		userCheckOutPage.selectItemInCreditCardTypeDropdownByText(creditCardTypes);
		userCheckOutPage.inPutToTextboxByLabeName("Cardholder name", cardHolderName);
		userCheckOutPage.inPutToTextboxByLabeName("Card number", cardNumber);
		userCheckOutPage.selectItemInExpireMonthDropdownByText(expireMonth);
		userCheckOutPage.selectItemInExpireYearDropdownByText(expireYear);
		userCheckOutPage.inPutToTextboxByLabeName("Card code", cardCode);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 22: Click to Payment Infor 'Continue' button");
		userCheckOutPage.clickToPaymentInforContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 23: Verify 'Billing Address' oder infor");
		Assert.assertTrue(userCheckOutPage.getBillingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userCheckOutPage.getBillingAddressEmailInfor().contains(email));
		Assert.assertTrue(userCheckOutPage.getBillingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userCheckOutPage.getBillingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userCheckOutPage.getBillingAddress1Infor().contains(address_3));
		Assert.assertTrue(userCheckOutPage.getBillingAddress2Infor().contains(address_4));
		Assert.assertTrue(userCheckOutPage.getBillingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 24: Verify 'Shipping Address' oder infor");
		Assert.assertTrue(userCheckOutPage.getShippingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userCheckOutPage.getShippingAddressEmailInfor().contains(email));
		Assert.assertTrue(userCheckOutPage.getShippingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userCheckOutPage.getShippingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userCheckOutPage.getShippingAddress1Infor().contains(address_3));
		Assert.assertTrue(userCheckOutPage.getShippingAddress2Infor().contains(address_4));
		Assert.assertTrue(userCheckOutPage.getShippingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 25: Verify 'Payment Method' oder infor");
		Assert.assertTrue(userCheckOutPage.getPaymentMethod().contains("Payment Method: Credit Card"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 26: Verify 'Shipping Method' oder infor");
		Assert.assertTrue(userCheckOutPage.getShippingMethod().contains("Shipping Method: Next Day Air"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 27: Verify The product order infor");
		Assert.assertTrue(userCheckOutPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "SKU"), "AP_MBP_13");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Qty"), "10");
		Assert.assertEquals(userCheckOutPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Total"), "$18,000.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 28: Verify The sumary price order list");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Sub-Total"), "$18,000.00");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Shipping"), "$0.00");
		Assert.assertEquals(userCheckOutPage.getPriceInforByTextLabel("Tax"), "$0.00");
		Assert.assertEquals(userCheckOutPage.getTotalPriceInfor(), "$18,000.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 29: Click to 'Confirm' button");
		userCheckOutPage.clickToConfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 30: handle alert 'Wait serveral second before confirm'");
		userCheckOutPage.aceptAlertBox();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 31: Click to 'Confirm' button");
		userCheckOutPage.clickToConfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 32: Verify Product order completed infor");
		Assert.assertEquals(userCheckOutPage.getOrderedSuccessPageTittle(), "Thank you");
		Assert.assertEquals(userCheckOutPage.getOrderedSuccessMessage(), "Your order has been successfully processed!");
		orderNumber = userCheckOutPage.getOrderNumber();
		Assert.assertEquals(userCheckOutPage.getOrderNumberMessage(), "ORDER NUMBER: " + orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 33: Click to Oder Completed 'Continue' button");
		userHomePage = userCheckOutPage.clickToOderCompletedContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 34: Click to 'My Account' link");
		userMyAccountPage = userHomePage.clickMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 35: Navigate to 'Orders' area at My Account page");
		userMyAccountPage.navigateAreaAtMyAccountPageByText("Orders");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 36: Verify text 'Order Number: " + orderNumber + "' displayed");
		Assert.assertTrue(userMyAccountPage.isOrderNumberBytextDisplayed("Order Number: " + orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 37: Click to 'Details' button");
		userOrderInforPage = userMyAccountPage.clickToDetailsButtonByOrderNumber(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 38: Verify 'order-overview' infor");
		Assert.assertEquals(userOrderInforPage.getOrderNumberText(), "ORDER #" + orderNumber);
		Assert.assertEquals(userOrderInforPage.getOrderDate(), "Order Date: " + getYesterdayFormatted());
		Assert.assertEquals(userOrderInforPage.getOrderStatus(), "Order Status: Pending");
		Assert.assertEquals(userOrderInforPage.getOrderTotalPrice(), "Order Total: $18,000.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 39: Verify 'Billing Address' oder infor");
		Assert.assertTrue(userOrderInforPage.getBillingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userOrderInforPage.getBillingAddressEmailInfor().contains(email));
		Assert.assertTrue(userOrderInforPage.getBillingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userOrderInforPage.getBillingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userOrderInforPage.getBillingAddress1Infor().contains(address_3));
		Assert.assertTrue(userOrderInforPage.getBillingAddress2Infor().contains(address_4));
		Assert.assertTrue(userOrderInforPage.getBillingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 40: Verify 'Shipping Address' oder infor");
		Assert.assertTrue(userOrderInforPage.getShippingAddressNameInfor().contains(firstName + " " + lastName));
		Assert.assertTrue(userOrderInforPage.getShippingAddressEmailInfor().contains(email));
		Assert.assertTrue(userOrderInforPage.getShippingAddressphoneInfor().contains(phoneNumber));
		Assert.assertTrue(userOrderInforPage.getShippingAddressFaxInfor().contains(faxNumber));
		Assert.assertTrue(userOrderInforPage.getShippingAddress1Infor().contains(address_3));
		Assert.assertTrue(userOrderInforPage.getShippingAddress2Infor().contains(address_4));
		Assert.assertTrue(userOrderInforPage.getShippingAddressCountryInfor().contains(country));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 41: Verify 'Payment' oder infor");
		Assert.assertTrue(userOrderInforPage.getPaymentMethod().contains("Payment Method: Credit Card"));
		Assert.assertTrue(userOrderInforPage.getPaymentStatus().contains("Payment Status: Pending"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 42: Verify 'Shipping' oder infor");
		Assert.assertTrue(userOrderInforPage.getShippingMethod().contains("Shipping Method: Next Day Air"));
		Assert.assertTrue(userOrderInforPage.getShippingStatus().contains("Shipping Status: Not yet shipped"));

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 43: Verify The product order infor");
		Assert.assertTrue(userOrderInforPage.isProductNameBytextDisplayed("Apple MacBook Pro 13-inch"));
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "SKU"), "AP_MBP_13");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Price"), "$1,800.00");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Quantity"), "10");
		Assert.assertEquals(userOrderInforPage.getInforProductByProductNameAndAtribute("Apple MacBook Pro 13-inch", "Total"), "$18,000.00");

		ExtentTestManager.getTest().log(Status.INFO, "TC_User_07_ReOrder - Step 44: Verify The sumary price order list");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Sub-Total"), "$18,000.00");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Shipping"), "$0.00");
		Assert.assertEquals(userOrderInforPage.getPriceInforByTextLabel("Tax"), "$0.00");
		Assert.assertEquals(userOrderInforPage.getTotalPriceInfor(), "$18,000.00");
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
	private UserShoppingCartPageObject userShoppingCartPage;
	private UserComputerPageObject userComputerPage;
	private UserCheckOutPageObject userCheckOutPage;
	private UserMyAccountPageObject userMyAccountPage;
	private UserOrderInformationPageObject userOrderInforPage;
	private String firstName, lastName, orderNumber, email, companyName, country, city, city_1, address_1, address_2, address_3, address_4, zipPostalCode, zipPostalCode_1, phoneNumber, faxNumber;
	private String creditCardTypes, cardHolderName, cardNumber, expireMonth, expireYear, cardCode;
}
