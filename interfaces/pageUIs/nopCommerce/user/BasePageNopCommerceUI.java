package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String HOMEPAGE_LINK = "https://demo.nopcommerce.com/";
	public static final String REGISTER_LINK = "https://demo.nopcommerce.com/register/";
	public static final String LOGIN_LINK = "https://demo.nopcommerce.com/login/";
	public static final String WISHLIST_LINK = "https://demo.nopcommerce.com/wishlist/";
	public static final String LOGOUT_LINK = "css=a.ico-logout";
	public static final String CONTEN_MESSAGE = "css=p.content";
	public static final String UPLOAD_FILE = "xpath=//input[@type='file']";

	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";

	public static final String DYNAMIC_LINK_PAGE_AT_FOOTER_BY_TEXT = "xpath=//div[@class='footer-upper']//li/a[text()='%s']";
}
