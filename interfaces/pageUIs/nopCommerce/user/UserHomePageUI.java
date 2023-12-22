package pageUIs.nopCommerce.user;

public class UserHomePageUI {
	public static final String REGISTER_LINK = "class= ico-register";
	public static final String LOGIN_LINK = "class= ico-login";
	public static final String MY_ACCOUNT_LINK = "css= a.ico-account";
	public static final String PRODUCT_AT_FEATURED_LIST_BY_TEXT = "xpath=//strong[text()='Featured products']//ancestor::div//a[text()='%s']";
	public static final String HEADER_MENU_BY_TEXT = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]";
	public static final String SUBMENU_AT_HEADER_MENU_BY_TEXT = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]//following-sibling::ul[@class='sublist first-level']//a[contains(text(), '%s')]";
}
