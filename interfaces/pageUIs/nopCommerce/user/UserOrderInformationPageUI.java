package pageUIs.nopCommerce.user;

public class UserOrderInformationPageUI {
	public static final String ORDER_NUMBER = "css=div.order-overview div.order-number strong";
	public static final String ORDER_DATE = "css=div.order-overview li.order-date";
	public static final String ORDER_STATUS = "css=div.order-overview li.order-status";
	public static final String ORDER_TOTAL_PRICE = "css=div.order-overview li.order-total";

	public static final String BILLING_NAME_INFOR = "css=div.billing-info li.name";
	public static final String BILLING_EMAIL_INFOR = "css=div.billing-info li.email";
	public static final String BILLING_COMPANY_INFOR = "css=div.billing-info li.company";
	public static final String BILLING_COUNTRY_INFOR = "css=div.billing-info li.country";
	public static final String BILLING_ADDRESS_1_INFOR = "css=div.billing-info li.address1";
	public static final String BILLING_ADDRESS_2_INFOR = "css=div.billing-info li.address2";
	public static final String BILLING_ZIP_POSTAL_CODE_INFOR = "css=div.billing-info li.city-state-zip";
	public static final String BILLING_PHONE_INFOR = "css=div.billing-info li.phone";
	public static final String BILLING_FAX_INFOR = "css=div.billing-info li.fax";

	public static final String SHIPPING_NAME_INFOR = "css=div.shipping-info li.name";
	public static final String SHIPPING_EMAIL_INFOR = "css=div.shipping-info li.email";
	public static final String SHIPPING_COMPANY_INFOR = "css=div.shipping-info li.company";
	public static final String SHIPPING_COUNTRY_INFOR = "css=div.shipping-info li.country";
	public static final String SHIPPING_ADDRESS_1_INFOR = "css=div.shipping-info li.address1";
	public static final String SHIPPING_ADDRESS_2_INFOR = "css=div.shipping-info li.address2";
	public static final String SHIPPING_ZIP_POSTAL_CODE_INFOR = "css=div.shipping-info li.city-state-zip";
	public static final String SHIPPING_PHONE_INFOR = "css=div.shipping-info li.phone";
	public static final String SHIPPING_FAX_INFOR = "css=div.shipping-info li.fax";

	public static final String PAYMENT_METHOD = "css=li.payment-method";
	public static final String PAYMENT_STATUS = "css=li.payment-method-status";
	public static final String SHIPPING_METHOD = "css=li.shipping-method";
	public static final String SHIPPING_STATUS = "css=li.shipping-status";

	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//td[@class='product']//a[text()='%s']";
	public static final String ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE = "xpath=//td[@class='product']//a[text()='%s']//ancestor::tr//td/label[contains(text(),'%s')]//following-sibling::*";
	public static final String CART_OPTION_INFOR = "css=div.options>div";
	public static final String PRICE_INFOR_BY_LABEL = "xpath=//label[contains(text(),'%s')]/parent::td//following-sibling::td[1]/span";
	public static final String PRICE_TOTAL_INFOR = "xpath=//label[text()='Order Total:']/parent::td//following-sibling::td[1]/span/strong";
	public static final String REORDER_BUTTON = "css=button.re-order-button";
}
