package pageUIs.nopCommerce.user;

public class UserCheckOutPageUI {
	public static final String SHIP_TO_ADDRESS_CHECKBOX = "css=input#ShipToSameAddress";

	public static final String BILLING_FIRST_NAME_TEXTBOX = "css=input#BillingNewAddress_FirstName";
	public static final String BILLING_LAST_NAME_TEXTBOX = "css=input#BillingNewAddress_LastName";
	public static final String BILLING_EMAIL_TEXTBOX = "css=input#BillingNewAddress_Email";
	public static final String BILLING_COMPANY_TEXTBOX = "css=input#BillingNewAddress_Company";
	public static final String BILLING_COUNTRY_DROPDOWN = "css=select#BillingNewAddress_CountryId";
	public static final String BILLING_CITY_TEXTBOX = "css=input#BillingNewAddress_City";
	public static final String BILLING_ADDRESS_1_TEXTBOX = "css=input#BillingNewAddress_Address1";
	public static final String BILLING_ADDRESS_2_TEXTBOX = "css=input#BillingNewAddress_Address2";
	public static final String BILLING_ZIP_POSTAL_CODE_TEXTBOX = "css=input#BillingNewAddress_ZipPostalCode";
	public static final String BILLING_PHONE_NUMBER_TEXTBOX = "css=input#BillingNewAddress_PhoneNumber";
	public static final String BILLING_FAX_NUMBER_TEXTBOX = "css=input#BillingNewAddress_FaxNumber";

	public static final String CONTINUE_BUTTON = "css=button.new-address-next-step-button";
	public static final String SAVE_BUTTON = "css=button#save-billing-address-button";
	public static final String SHIPPING_PAYMENT_CONTINUE_BUTTON = "css=button.payment-method-next-step-button";
	public static final String PAYMENT_INFOR_CONTINUE_BUTTON = "css=button.payment-info-next-step-button";
	public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "css=button.shipping-method-next-step-button";
	public static final String SHIPPING_ADDRESS_CONTINUE_BUTTON = "xpath=(//button[@class='button-1 new-address-next-step-button'])[2]";
	public static final String EDIT_ADDRESS_BUTTON = "css=button#edit-shipping-address-button";
	public static final String EDIT_BILLING_ADDRESS_BUTTON = "css=button#edit-billing-address-button";

	public static final String SHIPPING_FIRST_NAME_TEXTBOX = "css=input#ShippingNewAddress_FirstName";
	public static final String SHIPPING_LAST_NAME_TEXTBOX = "css=input#ShippingNewAddress_LastName";
	public static final String SHIPPING_EMAIL_TEXTBOX = "css=input#ShippingNewAddress_Email";
	public static final String SHIPPING_COMPANY_TEXTBOX = "css=input#ShippingNewAddress_Company";
	public static final String SHIPPING_COUNTRY_DROPDOWN = "css=select#ShippingNewAddress_CountryId";
	public static final String SHIPPING_CITY_TEXTBOX = "css=input#ShippingNewAddress_City";
	public static final String SHIPPING_ADDRESS_1_TEXTBOX = "css=input#ShippingNewAddress_Address1";
	public static final String SHIPPING_ADDRESS_2_TEXTBOX = "css=input#ShippingNewAddress_Address2";
	public static final String SHIPPING_ZIP_POSTAL_CODE_TEXTBOX = "css=input#ShippingNewAddress_ZipPostalCode";
	public static final String SHIPPING_PHONE_NUMBER_TEXTBOX = "css=input#ShippingNewAddress_PhoneNumber";
	public static final String SHIPPING_FAX_NUMBER_TEXTBOX = "css=input#ShippingNewAddress_FaxNumber";

	public static final String RADIO_BUTTON_BY_LABEL_NAME = "xpath=//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String ADDRESS_SHIPPING_INFOR = "xpath=//div[@class='info']//td/p[2]";

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
	public static final String SHIPPING_METHOD = "css=li.shipping-method";

	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//a[@class='product-name' and text()='%s']";
	public static final String ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE = "xpath=//a[@class='product-name' and text()='%s']//ancestor::tr//td/label[contains(text(),'%s')]//following-sibling::*";
	public static final String CART_OPTION_INFOR = "css=div.cart-options>div";
	public static final String PRICE_INFOR_BY_LABEL = "xpath=//label[contains(text(),'%s')]/parent::td//following-sibling::td[1]/span";
	public static final String PRICE_TOTAL_INFOR = "xpath=//label[text()='Total:']/parent::td//following-sibling::td[1]/span/strong";
	public static final String CONFIRM_BUTTON = "css=button.confirm-order-next-step-button";

	public static final String ODER_SUCCESS_PAGE_TITLE = "css=div.page-title>h1";
	public static final String ODER_SUCCESS_MESSAGE = "css=div.title>strong";
	public static final String ODER_NUMBER_MESSAGE = "css=div.order-number>strong";
	public static final String ODER_COMPLETED_BUTTON = "css=button.order-completed-continue-button";

	public static final String CREDIT_CARD_TYPE_DROPDOWN = "css=select#CreditCardType";
	public static final String CREDIT_CARD_TEXTBOX_BY_TEXT_LABEL = "xpath=//label[contains(text(),'%s')]/parent::td//following-sibling::td[1]/input";
	public static final String EXPIRE_MONTH_DROPDOWN = "css=select#ExpireMonth";
	public static final String EXPIRE_YEAR_DROPDOWN = "css=select#ExpireYear";
}
