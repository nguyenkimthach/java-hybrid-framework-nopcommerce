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
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import reportConfig.ExtentTestManager;
import utilities.SeverName;

public class Admin_02_Customers extends BaseTest {

	@Parameters({ "envName", "severName", "browserName", "ipAddress", "portNumber", "osName", "osVersion", "browserVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome") String browserName, @Optional("192.168.1.2") String ipAddress, @Optional("5555") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("120") String browserVersion) {
		ConfigFactory.setProperty("env", severName);
		severname = ConfigFactory.create(SeverName.class);
		driver = getBrowserDriverAll(envName, severname.appAdminUrl(), browserName, ipAddress, portNumber, osName, osVersion, browserVersion);
		adminLoginPage = PageGeneratorManage.getAdminLoginPage(driver);

		randomNumber = String.valueOf(getRandomNumberByDateTime());
		emailAddress = "automationfc" + randomNumber + ".vn@gmail.com";
		password = "123456";
		firstName = "Automation" + randomNumber;
		lastName = "FC";
		customerName = firstName + " " + lastName;
		gender = "Male";
		dateOfBirth = "1/1/2000";
		companyName = "Automation" + randomNumber + " FC";
		country = "Viet Nam";
		city = "Da Nang";
		address_1 = "123/04 Le Lai";
		address_2 = "234/05 Hai Phong";
		zipPostalCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";

		editEmailAddress = "Edit" + emailAddress;
		editFirstName = "Edit" + firstName;
		editCompanyName = "Edit" + companyName;
		editCustomerName = "Edit" + customerName;
		editCountry = "Afghanistan";
		editCity = "Ha Noi";
		editAddress_1 = "123 Le Thanh Tong";
		editAddress_2 = "234 Ho Chi Minh";
		editZipPostalCode = "700000";
		editPhoneNumber = "3683683686";
		editFaxNumber = "6868686868";

		adminLoginPage.inPutToEmailTextbox("admin@yourstore.com");
		adminLoginPage.inPutToPasswordTextbox("admin");
		adminLoginPage.selectRememberCheckbox();

		adminDashboardPage = adminLoginPage.clickToRegisterButton();

		Assert.assertTrue(adminDashboardPage.isDashboardPageTittleDisplayedByText("Dashboard"));

		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		adminDashboardPage.openSearchBox();
	}

	@Test
	public void TC_Admin_07_Create_New_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_Admin_07_Create_New_Customer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 01: click to 'Add new' button at customers area");
		adminDashboardPage.clickToAddNewButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 02: inPut to 'Email' textbox with text is '" + emailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 03: inPut to 'password' textbox with text is '" + password + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Password", password);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 04: inPut to 'First name' textbox with text is '" + firstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 05: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 06: Check to 'Gender'checkbox by text lable is '" + gender + "'");
		adminDashboardPage.selectGenderRadioButtonByLabel("Male");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 07: inPut to 'Date of birth' textbox with text is '" + dateOfBirth + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Date of birth", dateOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 08: inPut to 'Company name' textbox with text is '" + companyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company name", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 01: click to 'delete role' button with text is 'Registered'");
		adminDashboardPage.clickToDeleteRoleButtonByText("Registered");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 10: Select 'Customer roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 11: inPut to 'Admin Comment' area textbox with text is 'Add new customer (Guest)'");
		adminDashboardPage.inPutTAdminCommentTextbox("Add new customer (Guest)");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 12: click to 'Save and Continue Edit' button at customers area");
		adminDashboardPage.clickToSaveAndContinueEditButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 13: Verify success mesage have text 'The new customer has been added successfully.' displayed");
		Assert.assertTrue(adminDashboardPage.isUpdateSuccessMessageByTextDispaly("The new customer has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_05_Checkout_Order - Step 14: Verify 'Customer'created infor");
		Assert.assertEquals(adminDashboardPage.getCustomerTextboxInforByLabel("Email"), emailAddress);
		Assert.assertEquals(adminDashboardPage.getCustomerTextboxInforByLabel("First name"), firstName);
		Assert.assertEquals(adminDashboardPage.getCustomerTextboxInforByLabel("Last name"), lastName);
		Assert.assertTrue(adminDashboardPage.isCustomerGenderRadioButtonByLabelSelected("Male"));
		Assert.assertEquals(adminDashboardPage.getCustomerTextboxInforByLabel("Date of birth"), dateOfBirth);
		Assert.assertEquals(adminDashboardPage.getCustomerTextboxInforByLabel("Company name"), companyName);
		Assert.assertTrue(adminDashboardPage.isCustomerRoleInforByLabelDisplayed("Guests"));
		Assert.assertEquals(adminDashboardPage.getCustomerAdminComment(), "Add new customer (Guest)");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 15: click to 'back to customer list' button at customers area");
		adminDashboardPage.clickToBackToCustomerListButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 16: Select 'Customer Search roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 17: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_07_Create_New_Customer - Step 18: verify have customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.isCustomerNameByTextDisplayed(customerName));
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Customer roles"), "Guests");
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Company name"), companyName);
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Email"), "Guest");
	}

	@Test
	public void TC_Admin_08_Search_Customer_With_Email(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_08_Search_Customer_With_Email");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_08_Search_Customer - Step 01: inPut to 'Email' textbox with text is '" + emailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_08_Search_Customer - Step 02: Select 'Customer Search roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_08_Search_Customer - Step 03: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_08_Search_Customer - Step 04: verify have 1 customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.getTextNumberCustomerOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isCustomerNameByTextDisplayed(customerName));
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Customer roles"), "Guests");
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Company name"), companyName);
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Email"), "Guest");
	}

	@Test
	public void TC_Admin_09_Search_Customer_With_FirstName_And_LastName(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_09_Search_Customer_With_FirstName_And_LastName");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_09_Search_Customer - Step 01: inPut to 'Email' textbox with text is '" + emailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", "");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_09_Search_Customer - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_09_Search_Customer - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_09_Search_Customer - Step 04: Select 'Customer Search roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_09_Search_Customer - Step 05: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_09_Search_Customer - Step 06: verify have 1 customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.getTextNumberCustomerOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isCustomerNameByTextDisplayed(customerName));
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Customer roles"), "Guests");
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Company name"), companyName);
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Email"), "Guest");
	}

	@Test
	public void TC_Admin_10_Search_Customer_With_Company(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_10_Search_Customer_With_Company");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 01: inPut to 'Email' textbox with text is '" + emailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", "");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", "");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", "");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 04: inPut to 'Company name' textbox with text is '" + companyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 05: Select 'Customer Search roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 06: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_10_Search_Customer - Step 07: verify have 1 customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.getTextNumberCustomerOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isCustomerNameByTextDisplayed(customerName));
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Customer roles"), "Guests");
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Company name"), companyName);
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Email"), "Guest");
	}

	@Test
	public void TC_Admin_11_Search_Customer_With_Full_Data(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_11_Search_Customer_With_Full_Data");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 01: inPut to 'Email' textbox with text is '" + emailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 05: Select item in 'Month' dropdown is '1");
		adminDashboardPage.selectItemInMonthDropdown("1");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 04: Select item in 'Day' dropdown is '1'");
		adminDashboardPage.selectItemInDayDropdown("1");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 06: inPut to 'Company name' textbox with text is '" + companyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 07: Select 'Customer Search roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 08: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_11_Search_Customer - Step 09: verify have 1 customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.getTextNumberCustomerOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isCustomerNameByTextDisplayed(customerName));
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Customer roles"), "Guests");
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Company name"), companyName);
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(customerName, "Email"), "Guest");
	}

	@Test
	public void TC_Admin_12_Edit_Customer(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_12_Edit_Customer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 01: inPut to 'Email' textbox with text is '" + emailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 02: inPut to 'First name' textbox with text is '" + firstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 05: Select item in 'Month' dropdown is '1");
		adminDashboardPage.selectItemInMonthDropdown("1");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 04: Select item in 'Day' dropdown is '1'");
		adminDashboardPage.selectItemInDayDropdown("1");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 06: inPut to 'Company name' textbox with text is '" + companyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 07: Select 'Customer Search roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 08: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 09: click to button 'Edit' at customer name is'" + customerName + "'");
		adminDashboardPage.clickToEditButtonByName(customerName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 10: inPut to 'Email' textbox with text is '" + editEmailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", editEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 11: inPut to 'First name' textbox with text is '" + editFirstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", editFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 12: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 13: inPut to 'Date of birth' textbox with text is '2/2/2020'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Date of birth", "2/2/2020");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 14: inPut to 'Company name' textbox with text is '" + editCompanyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company name", editCompanyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 15: inPut to 'Admin comment' area textbox with text is 'Edit customer (Guest)'");
		adminDashboardPage.inPutTAdminCommentTextbox("Edit customer (Guest)");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 16: click to 'Save' button at customers area");
		adminDashboardPage.clickToCustomerSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 17: Verify success mesage have text 'The new customer has been added successfully.' displayed");
		Assert.assertTrue(adminDashboardPage.isUpdateSuccessMessageByTextDispaly("The new customer has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 18: inPut to 'Email' textbox with text is '" + editEmailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", editEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 19: inPut to 'First name' textbox with text is '" + editFirstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", editFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 20: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 21: Select item in 'Month' dropdown is '2");
		adminDashboardPage.selectItemInMonthDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 22: Select item in 'Day' dropdown is '2'");
		adminDashboardPage.selectItemInDayDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 23: inPut to 'Company name' textbox with text is '" + editCompanyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", editCompanyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 24: Select 'Customer roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 25: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_12_Edit_Customer - Step 26: verify have 1 customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.getTextNumberCustomerOnGrid().contains("1 items"));
		Assert.assertTrue(adminDashboardPage.isCustomerNameByTextDisplayed(editCustomerName));
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(editCustomerName, "Customer roles"), "Guests");
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(editCustomerName, "Company name"), editCompanyName);
		Assert.assertEquals(adminDashboardPage.getTextItemByCustomerNameAndColumName(editCustomerName, "Email"), "Guest");
	}

	@Test
	public void TC_Admin_13_Add_New_Address_Customer(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_13_Add_New_Address_Customer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 01: inPut to 'Email' textbox with text is '" + editEmailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", editEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 02: inPut to 'First name' textbox with text is '" + editFirstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", editFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 04: Select item in 'Month' dropdown is '2");
		adminDashboardPage.selectItemInMonthDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 05: Select item in 'Day' dropdown is '2'");
		adminDashboardPage.selectItemInDayDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 06: inPut to 'Company name' textbox with text is '" + editCompanyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", editCompanyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 07: Select 'Customer roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 08: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 09: click to button 'Edit' at customer name is'" + editCustomerName + "'");
		adminDashboardPage.clickToEditButtonByName(editCustomerName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 10: Open 'Addresses' area box'");
		adminDashboardPage.openCustomerBoxByText("Addresses");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 11: click to button 'Add new address'at customer area");
		adminDashboardPage.clickToAddNewAddressButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 12: Input to 'customer address' form");
		adminDashboardPage.inPutToAddressTextboxByLabel("First name", firstName);
		adminDashboardPage.inPutToAddressTextboxByLabel("Last name", lastName);
		adminDashboardPage.inPutToAddressTextboxByLabel("Email", emailAddress);
		adminDashboardPage.inPutToAddressTextboxByLabel("Company", companyName);
		adminDashboardPage.selectItemToAddressCountryDropdown(country);
		adminDashboardPage.inPutToAddressTextboxByLabel("City", city);
		adminDashboardPage.inPutToAddressTextboxByLabel("Address 1", address_1);
		adminDashboardPage.inPutToAddressTextboxByLabel("Address 2", address_2);
		adminDashboardPage.inPutToAddressTextboxByLabel("Zip / postal code", zipPostalCode);
		adminDashboardPage.inPutToAddressTextboxByLabel("Phone number", phoneNumber);
		adminDashboardPage.inPutToAddressTextboxByLabel("Fax number", faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 13: click to button 'Save'at Address area");
		adminDashboardPage.clickToAddressSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 14: Verify success mesage have text 'The new address has been added successfully.' displayed");
		Assert.assertTrue(adminDashboardPage.isUpdateSuccessMessageByTextDispaly("The new address has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 15: Verify 'Address'created infor");
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("First name"), firstName);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Last name"), lastName);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Email"), emailAddress);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Company"), companyName);
		Assert.assertEquals(adminDashboardPage.getAddressCountryDropdownInfor(), country);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("City"), city);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Address 1"), address_1);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Address 2"), address_2);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Zip / postal code"), zipPostalCode);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Phone number"), phoneNumber);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Fax number"), faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 16: click to 'back to customer list Details' button at customers area");
		adminDashboardPage.clickToBackToCustomerListDetailsButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 17: Open 'Addresses' area box'");
		adminDashboardPage.openCustomerBoxByText("Addresses");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_13_Add_Address - Step 18: verify have address display in grid address with email is '" + emailAddress + "'");
		Assert.assertTrue(adminDashboardPage.isEmailAddressByTextDisplayed(emailAddress));
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(emailAddress, "First name"), firstName);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(emailAddress, "Last name"), lastName);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(emailAddress, "Phone number"), phoneNumber);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(emailAddress, "Fax number"), faxNumber);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(emailAddress, "Address"), companyName + "\n" + address_1 + "\n" + address_2 + "\n" + city + "," + zipPostalCode + "\n" + country);
	}

	@Test
	public void TC_Admin_14_Edit_Address_Customer(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_14_Edit_Address_Customer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 01: inPut to 'Email' textbox with text is '" + editEmailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", editEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 02: inPut to 'First name' textbox with text is '" + editFirstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", editFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 04: Select item in 'Month' dropdown is '2");
		adminDashboardPage.selectItemInMonthDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 05: Select item in 'Day' dropdown is '2'");
		adminDashboardPage.selectItemInDayDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 06: inPut to 'Company name' textbox with text is '" + editCompanyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", editCompanyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 07: Select 'Customer roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 08: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 09: click to button 'Edit' at customer name is'" + editCustomerName + "'");
		adminDashboardPage.clickToEditButtonByName(editCustomerName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 10: click to button 'Edit' at email is'" + emailAddress + "'");
		adminDashboardPage.clickToEditButtonByName(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 11: Input to 'customer address' form");
		adminDashboardPage.inPutToAddressTextboxByLabel("First name", editFirstName);
		adminDashboardPage.inPutToAddressTextboxByLabel("Last name", lastName);
		adminDashboardPage.inPutToAddressTextboxByLabel("Email", editEmailAddress);
		adminDashboardPage.inPutToAddressTextboxByLabel("Company", editCompanyName);
		adminDashboardPage.selectItemToAddressCountryDropdown(editCountry);
		adminDashboardPage.inPutToAddressTextboxByLabel("City", editCity);
		adminDashboardPage.inPutToAddressTextboxByLabel("Address 1", editAddress_1);
		adminDashboardPage.inPutToAddressTextboxByLabel("Address 2", editAddress_2);
		adminDashboardPage.inPutToAddressTextboxByLabel("Zip / postal code", editZipPostalCode);
		adminDashboardPage.inPutToAddressTextboxByLabel("Phone number", editPhoneNumber);
		adminDashboardPage.inPutToAddressTextboxByLabel("Fax number", editFaxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 12: click to button 'Save'at Address area");
		adminDashboardPage.clickToAddressSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 13: Verify success mesage have text 'The new address has been added successfully.' displayed");
		Assert.assertTrue(adminDashboardPage.isUpdateSuccessMessageByTextDispaly("The address has been updated successfully."));

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 14: Verify 'Address'created infor");
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("First name"), editFirstName);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Last name"), lastName);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Email"), editEmailAddress);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Company"), editCompanyName);
		Assert.assertEquals(adminDashboardPage.getAddressCountryDropdownInfor(), editCountry);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("City"), editCity);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Address 1"), editAddress_1);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Address 2"), editAddress_2);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Zip / postal code"), editZipPostalCode);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Phone number"), editPhoneNumber);
		Assert.assertEquals(adminDashboardPage.getAddressTextboxInforByLabel("Fax number"), editFaxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 15: click to 'back to customer list Details' button at customers area");
		adminDashboardPage.clickToBackToCustomerListDetailsButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 16: Open 'Addresses' area box'");
		adminDashboardPage.openCustomerBoxByText("Addresses");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_14_Edit_Address - Step 17: verify have 1 customer display in grid customer with name is '" + customerName + "'");
		Assert.assertTrue(adminDashboardPage.isEmailAddressByTextDisplayed(editEmailAddress));
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(editEmailAddress, "First name"), editFirstName);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(editEmailAddress, "Last name"), lastName);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(editEmailAddress, "Phone number"), editPhoneNumber);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(editEmailAddress, "Fax number"), editFaxNumber);
		Assert.assertEquals(adminDashboardPage.getTextItemByEmailAndColumName(editEmailAddress, "Address"), editCompanyName + "\n" + editAddress_1 + "\n" + editAddress_2 + "\n" + editCity + "," + editZipPostalCode + "\n" + editCountry);
	}

	@Test
	public void TC_Admin_15_Delete_Address_Customer(Method method) {
		adminDashboardPage.openSubMenuByMenuTypeAndText("Customers", "Customers");

		ExtentTestManager.startTest(method.getName(), "TC_Admin_15_Delete_Address_Customer");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 01: inPut to 'Email' textbox with text is '" + editEmailAddress + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Email", editEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 02: inPut to 'First name' textbox with text is '" + editFirstName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("First name", editFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 03: inPut to 'Last name' textbox with text is '" + lastName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 04: Select item in 'Month' dropdown is '2");
		adminDashboardPage.selectItemInMonthDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 05: Select item in 'Day' dropdown is '2'");
		adminDashboardPage.selectItemInDayDropdown("2");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 06: inPut to 'Company name' textbox with text is '" + editCompanyName + "'");
		adminDashboardPage.inPutToCustomerAreaTextboxByLabel("Company", editCompanyName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 07: Select 'Customer roles' dropdown with value is 'Guests'");
		adminDashboardPage.selectItemInCustomerSearchRolesDropdown("Guests");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 08: click to button 'Search' at customer area");
		adminDashboardPage.clickToCustomerSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 09: click to button 'Edit' at customer name is'" + editCustomerName + "'");
		adminDashboardPage.clickToEditButtonByName(editCustomerName);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 10: Open 'Addresses' area box'");
		adminDashboardPage.openCustomerBoxByText("Addresses");

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 11: click to button 'Delete' at email is'" + emailAddress + "'");
		adminDashboardPage.clickToDeleteButtonByName(editEmailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC_Admin_15_Delete_Address - Step 12: verify have no Address on grid display");
		Assert.assertTrue(adminDashboardPage.isMessageDataTableByAreaNameAndTextDisplayed("Addresses", "No data available in table"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private SeverName severname;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String randomNumber, customerName, gender, firstName, lastName, dateOfBirth, companyName, password, emailAddress, country, city, address_1, address_2, zipPostalCode, phoneNumber, faxNumber;
	private String editEmailAddress, editFirstName, editCompanyName, editCustomerName, editCountry, editCity, editAddress_1, editAddress_2, editZipPostalCode, editPhoneNumber, editFaxNumber;

}
