package pageUIs.nopCommerce.user;

public class UserSearchPageUI {
	public static final String SEARCH_BUTTON = "css=button.search-button";
	public static final String SEARCH_KEYWORD_TEXTBOX = "css=input.search-text";
	public static final String SEARCH_MESSAGE_INFOR_BY_TEXT = "xpath=//div[@class='products-wrapper']/div[text()='%s']";
	public static final String PRODUCTS_TITLE_BY_TEXT = "xpath=//div[@class='products-wrapper']//div[@class='product-item']//h2/a[contains(text(),'%s')]";
	public static final String LIST_PRODUCTS_TITLE_BY_TEXT = "xpath=//div[@class='products-wrapper']//h2[@class='product-title']/a[contains(text(),'%s')]";
	public static final String ADVANCE_SEARCH_CHECKBOX_BY_TEXT_NAME = "xpath=//label[contains(text(),'%s')]//preceding-sibling::input[@type='checkbox']";
	public static final String DROPDOWN_BY_LABEL_TEXT = "xpath=//label[contains(text(),'%s')]//following-sibling::select";
}
