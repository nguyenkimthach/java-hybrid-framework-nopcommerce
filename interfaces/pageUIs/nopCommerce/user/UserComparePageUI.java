package pageUIs.nopCommerce.user;

public class UserComparePageUI {
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//tr[@class='product-name']//a[text()='%s']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr[@class='product-name']//a[text()='%s']//parent::td//preceding-sibling::td";
	public static final String TEXT_BY_ROW_NAME_AND_COLUM_INDEX = "xpath=//tr//label[text()='%s']//parent::td//following-sibling::td[%s]";
	public static final String REMOVE_BUTTON_BY_COLUM_INDEX = "xpath=//tr//td[@class='empty']//following-sibling::td[%s]";
	public static final String CLEARLIST_BUTTON = "css=a.clear-list";
}
