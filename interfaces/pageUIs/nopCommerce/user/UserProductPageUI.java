package pageUIs.nopCommerce.user;

public class UserProductPageUI {
	public static final String ADD_REVIEW_LINK = "xpath=//div[@class='product-review-links']//a[text()='Add your review']";
	public static final String BUTTON_OVERVIEW_BY_TEXT = "xpath=//div[@class='overview-buttons']//button[text()= '%s']";
	public static final String DORPDOWN_BY_TEXT = "xpath=//label[contains(text(),'%s')]//parent::dt//following-sibling::dd[1]/select";
	public static final String CHECKBOX_OR_RADIO_BY_LABEL_AND_TEXT_VALUE = "xpath=//label[contains(text(),'%s')]//parent::dt//following-sibling::dd[1]//label[contains(text(),'%s')]";
	public static final String ADD_TO_CART_BUTTON = "css=button.add-to-cart-button";
	public static final String UPDATE_BUTTON = "css=button.add-to-cart-button";
	public static final String QTY_PRODUCT_TEXTBOX = "css=input#product_enteredQuantity_1";
}
