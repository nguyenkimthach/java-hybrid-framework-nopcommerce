package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserOrderInformationPageUI;

public class UserOrderInformationPageObject extends BasePage {
	private WebDriver driver;

	public UserOrderInformationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getOrderNumberText() {
		waitForElementVisible(UserOrderInformationPageUI.ORDER_NUMBER);
		return getElementText(UserOrderInformationPageUI.ORDER_NUMBER);
	}

	public String getOrderDate() {
		waitForElementVisible(UserOrderInformationPageUI.ORDER_DATE);
		return getElementText(UserOrderInformationPageUI.ORDER_DATE);
	}

	public String getOrderStatus() {
		waitForElementVisible(UserOrderInformationPageUI.ORDER_STATUS);
		return getElementText(UserOrderInformationPageUI.ORDER_STATUS);
	}

	public String getOrderTotalPrice() {
		waitForElementVisible(UserOrderInformationPageUI.ORDER_TOTAL_PRICE);
		return getElementText(UserOrderInformationPageUI.ORDER_TOTAL_PRICE);
	}

	public String getBillingAddressNameInfor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_NAME_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_NAME_INFOR);
	}

	public String getBillingAddressEmailInfor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_EMAIL_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_EMAIL_INFOR);
	}

	public String getBillingAddressphoneInfor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_PHONE_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_PHONE_INFOR);
	}

	public String getBillingAddressFaxInfor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_FAX_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_FAX_INFOR);
	}

	public String getBillingAddress1Infor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_ADDRESS_1_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_ADDRESS_1_INFOR);
	}

	public String getBillingAddress2Infor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_ADDRESS_2_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_ADDRESS_2_INFOR);
	}

	public String getBillingAddressCountryInfor() {
		waitForElementVisible(UserOrderInformationPageUI.BILLING_COUNTRY_INFOR);
		return getElementText(UserOrderInformationPageUI.BILLING_COUNTRY_INFOR);
	}

	public String getShippingAddressNameInfor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_NAME_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_NAME_INFOR);
	}

	public String getShippingAddressEmailInfor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_EMAIL_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_EMAIL_INFOR);
	}

	public String getShippingAddressphoneInfor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_PHONE_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_PHONE_INFOR);
	}

	public String getShippingAddressFaxInfor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_FAX_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_FAX_INFOR);
	}

	public String getShippingAddress1Infor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_ADDRESS_1_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_ADDRESS_1_INFOR);
	}

	public String getShippingAddress2Infor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_ADDRESS_2_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_ADDRESS_2_INFOR);
	}

	public String getShippingAddressCountryInfor() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_COUNTRY_INFOR);
		return getElementText(UserOrderInformationPageUI.SHIPPING_COUNTRY_INFOR);
	}

	public String getPaymentMethod() {
		waitForElementVisible(UserOrderInformationPageUI.PAYMENT_METHOD);
		return getElementText(UserOrderInformationPageUI.PAYMENT_METHOD);
	}

	public String getPaymentStatus() {
		waitForElementVisible(UserOrderInformationPageUI.PAYMENT_STATUS);
		return getElementText(UserOrderInformationPageUI.PAYMENT_STATUS);
	}

	public String getShippingMethod() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_METHOD);
		return getElementText(UserOrderInformationPageUI.SHIPPING_METHOD);
	}

	public String getShippingStatus() {
		waitForElementVisible(UserOrderInformationPageUI.SHIPPING_STATUS);
		return getElementText(UserOrderInformationPageUI.SHIPPING_STATUS);
	}

	public boolean isProductNameBytextDisplayed(String productName) {
		waitForElementVisible(UserOrderInformationPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementDisPlayed(UserOrderInformationPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public String getInforProductByProductNameAndAtribute(String productName, String atribute) {
		waitForElementVisible(UserOrderInformationPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
		return getElementText(UserOrderInformationPageUI.ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE, productName, atribute);
	}

	public String getPriceInforByTextLabel(String textLabel) {
		waitForElementVisible(UserOrderInformationPageUI.PRICE_INFOR_BY_LABEL, textLabel);
		return getElementText(UserOrderInformationPageUI.PRICE_INFOR_BY_LABEL, textLabel);
	}

	public String getTotalPriceInfor() {
		waitForElementVisible(UserOrderInformationPageUI.PRICE_TOTAL_INFOR);
		return getElementText(UserOrderInformationPageUI.PRICE_TOTAL_INFOR);
	}

	public UserShoppingCartPageObject clickToReOrderButton() {
		waitForElementClickable(UserOrderInformationPageUI.REORDER_BUTTON);
		clickToElement(UserOrderInformationPageUI.REORDER_BUTTON);
		return PageGeneratorManage.getUserShoppingCartPage(driver);
	}
}
