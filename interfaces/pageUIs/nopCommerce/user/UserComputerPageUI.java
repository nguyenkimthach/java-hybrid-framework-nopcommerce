package pageUIs.nopCommerce.user;

public class UserComputerPageUI {
	public static final String SORTBY_DROPDOWN = "css=select#products-orderby";
	public static final String ALL_PRODUCT_NAME = "css=h2.product-title>a";
	public static final String ALL_PRODUCT_Price = "css=div.prices>span.actual-price";
	public static final String DISPLAY_DROPDOWN = "css=select#products-pagesize";
	public static final String SELECT_PAGE_BY_TEXT_NUMBER = "xpath=//div[@class='pager']//a[@data-page='%s'][1]";
	public static final String ICON_NEXT_PAGE = "css=li.next-page>a";
	public static final String ICON_PREVIOUS_PAGE = "css=li.previous-page>a";
	public static final String BUTTON_ADD_TO_COMPARE_BY_TEXT = "xpath=//a[contains(text(),'%s')]//ancestor::div[@class='details']//button[@class='button-2 add-to-compare-list-button']";
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//h2[@class='product-title']/a[text()='%s']";
}
