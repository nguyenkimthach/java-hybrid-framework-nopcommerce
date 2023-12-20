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
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserProductPageObject;
import pageObjects.nopCommerce.user.UserProductReviewPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class User_03_MyAccount extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		userHomePage = PageGeneratorManage.getUserHomePage(driver);

		gender = "Female";
		firstName = "Automation";
		lastName = "FC";
		day = "1";
		month = "January";
		year = "1999";
		updateEmail = "automationfc1.vn@gmail.com";
		newPassword = "654321";
		companyName = "Automation FC";
		country = "Viet Nam";
		city = "Da Nang";
		address_1 = "123/04 Le Lai";
		address_2 = "234/05 Hai Phong";
		zipPostalCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";

		userLoginPage = userHomePage.clickToLoginLink();

		userLoginPage.inPutToEmailTextbox(Common_01_Register_End_User.emailAddress);
		userLoginPage.inPutToPasswordTextbox(Common_01_Register_End_User.password);
		userHomePage = userLoginPage.clickToLoginButton();

		userMyAccountPage = userHomePage.clickMyAccountLink();
	}

	 @Test
	public void MyAccount_01_Update_Customer_Info(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_01_Update_Customer_Info");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 01: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		userMyAccountPage.selectGenderCheckboxByTextlabel(gender);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		userMyAccountPage.inputToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		userMyAccountPage.inputToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 04: Select item in 'Day' dropdown is '" + day + "'");
		userMyAccountPage.selectItemInDayDropdown(day);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 05: Select item in 'Month' dropdown is '" + month + "'");
		userMyAccountPage.selectItemInMonthDropdown(month);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 06: Select item in 'Year' dropdown is '" + year + "'");
		userMyAccountPage.selectItemInYearDropdown(year);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 07: inPut to 'Email' textbox with text is '" + updateEmail + "'");
		userMyAccountPage.inPutToEmailTextbox(updateEmail);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 08: inPut to 'Company name' textbox with text is '" + companyName + "'");
		userMyAccountPage.inputToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 09: Click to 'Save' infor button");
		userMyAccountPage.clickToSaveInforButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 10: Update success message with text 'The customer info has been updated successfully.' is displayed");
		Assert.assertTrue(userMyAccountPage.isUpdateSuccessMessageDisplayed("The customer info has been updated successfully."));
	}

	 @Test
	public void MyAccount_02_Add_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_02_Add_Address");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 01: Navigate to 'Addresses' area at My Account page");
		userMyAccountPage.navigateAreaAtMyAccountPageByText("Addresses");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 02: Click to 'AddNew' button");
		userMyAccountPage.clickToAddNewButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 03: Input to 'First name' textbox with text is '" + firstName + "'");
		userMyAccountPage.inputToAddressFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 04: Input to 'Last name' textbox with text is '" + lastName + "'");
		userMyAccountPage.inputToAddressLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 05: Input to 'Email' textbox with text is '" + updateEmail + "'");
		userMyAccountPage.inPutToAddressEmailTextbox(updateEmail);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 06: Input to 'Company' textbox with text is '" + companyName + "'");
		userMyAccountPage.inputToAddressCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 07: Select 'Country' drodown with value is '" + country + "'");
		userMyAccountPage.selectAddressCountryDropdownByText(country);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 08: Input to 'City' textbox with text is '" + city + "'");
		userMyAccountPage.inputToAddressCityTextbox(city);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 09: Input to 'Address 1' textbox with text is '" + address_1 + "'");
		userMyAccountPage.inputToAddress1Textbox(address_1);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 10: Input to 'Address 2' textbox with text is '" + address_2 + "'");
		userMyAccountPage.inputToAddress2Textbox(address_2);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 11: Input to 'Zip / postal code' textbox with text is '" + zipPostalCode + "'");
		userMyAccountPage.inputToAddressZipPostalCodeTextbox(zipPostalCode);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 12: Input to 'Phone number' textbox with text is '" + phoneNumber + "'");
		userMyAccountPage.inputToAddressPhoneNumberTextbox(phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 13: Input to 'Fax number' textbox with text is '" + faxNumber + "'");
		userMyAccountPage.inputToAddressFaxNumberTextbox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_02 - Step 14: Click to 'Save' button");
		userMyAccountPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_01 - Step 15: Update success message with text 'The customer info has been updated successfully.' is displayed");
		Assert.assertTrue(userMyAccountPage.isUpdateSuccessMessageDisplayed("The new address has been added successfully."));
	}

	 @Test
	public void MyAccount_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_03_Change_Password");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 01: Navigate to 'Change password' area at My Account page");
		userMyAccountPage.navigateAreaAtMyAccountPageByText("Change password");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 02: inPut to 'Old password' textbox with text is '" + Common_01_Register_End_User.password + "'");
		userMyAccountPage.inPutToOldPasswordTextbox(Common_01_Register_End_User.password);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 04: inPut to 'New password' textbox with text is '" + newPassword + "'");
		userMyAccountPage.inPutToNewPasswordTextbox(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 05: inPut to 'New password' textbox with text is '" + newPassword + "'");
		userMyAccountPage.inPutToConfirmNewPasswordTextbox(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 06: Click to 'Change password' button");
		userMyAccountPage.clickToChangePasswordButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 07: Click to 'Logout' link");
		userLoginPage = userMyAccountPage.openLoginPage();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 08: inPut to 'Email' textbox with text is '" + updateEmail + "'");
		userLoginPage.inPutToEmailTextbox(updateEmail);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 09: inPut to 'Password' textbox with old password is '" + Common_01_Register_End_User.password + "'");
		userLoginPage.inPutToPasswordTextbox(Common_01_Register_End_User.password);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 10: Click to 'Login' button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 11: Verify sumary error message with 'Please correct the errors and try again.The credentials provided are incorrect' is displayed ");
		Assert.assertEquals(userLoginPage.getVaidationSumaryError(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 12: inPut to 'Password' textbox with text is '" + newPassword + "'");
		userLoginPage.inPutToPasswordTextbox(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 13: Click to 'Login' button");
		userHomePage = userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_03 - Step 14: Verify 'My account' link is displayed ");
		Assert.assertTrue(userHomePage.isMyaccountLinkDisplayed());
	}

	@Test
	public void MyAccount_04_At_Review_To_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_04_At_Review_To_Product");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 01: Navigate to 'User Home Page' from My Account page");
		userHomePage = userMyAccountPage.openHomePage();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 02: Click to product at 'Featured products list' with name is 'Build your own computer'");
		productPage = userHomePage.clickToProductAtFeaturedProductsListByText("Build your own computer");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 03: Click to 'Add your review' link");
		userProductReviewPage = productPage.clickToAddYourReviewLink();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 04: Input to 'Review title' textbox with text is 'Best product'");
		userProductReviewPage.inputToReviewTitleTextbox("Best product");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 05: Input to 'Review text' textbox with text is 'Product so great'");
		userProductReviewPage.inputToReviewTextTextbox("Product so great");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 06: Chech to 'raiting' checkbox with point is '4'");
		userProductReviewPage.checkToRattingCheckboxByValue("4");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 07: Click to 'Submit Revew' link");
		userProductReviewPage.clickToSubmitRevewButton();

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 07: is 'Review Title' with text 'Best product' displayed");
		Assert.assertTrue(userProductReviewPage.isReviewTitleByTextDisplayed("Best product"));

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 07: is 'Review text' with text 'Product so great' displayed");
		Assert.assertTrue(userProductReviewPage.isReviewTextByTextDisplayed("Product so great"));

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount_04 - Step 07: is 'Review rating'  displayed");
		Assert.assertTrue(userProductReviewPage.isReviewRatingByIntergerDisplayed(String.valueOf(4 / 5 * 100)));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserMyAccountPageObject userMyAccountPage;
	private UserProductPageObject productPage;
	private UserProductReviewPageObject userProductReviewPage;
	private String gender, firstName, lastName, day, month, year, updateEmail, newPassword, companyName;
	private String country, city, address_1, address_2, zipPostalCode, phoneNumber, faxNumber;
}
