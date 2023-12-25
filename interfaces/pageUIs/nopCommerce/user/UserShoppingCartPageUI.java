package pageUIs.nopCommerce.user;

public class UserShoppingCartPageUI {
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//a[@class='product-name' and text()='%s']";
	public static final String INFOR_BY_PRODUCT_NAME = "xpath=//a[@class='product-name' and text()='%s']//following-sibling::div[@class='attributes']";
	public static final String ITEM_BY_PRODUCT_NAME_AND_ATRIBUTE = "xpath=//a[@class='product-name' and text()='%s']/parent::td//following-sibling::td/label[contains(text(),'%s')]//following-sibling::*";
	public static final String TEXT_ON_SHOPPING_CART_LINK = "css=li#topcartlink >a.ico-cart";
	public static final String PRODUCT_EDIT_LINK_BY_PRODUCT_NAME = "xpath=//a[@class='product-name' and text()='%s']//following-sibling::div[@class='edit-item']/a";
	public static final String REMOVE_CHECKBOX_BY_PRODUCT_NAME = "xpath=//a[@class='product-name' and text()='%s']/parent::td//following-sibling::td/button[@class='remove-btn']";
	public static final String MESSAGE_SHOPPING_CART_BY_TEXT = "xpath=//div[@class='page-body']//div[contains(text(),'%s')]";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "css=button#updatecart";
	public static final String GIFT_WRAPPING_DROPDOWN = "xpath=//label[contains(text(),'Gift wrapping')]/parent::dt//following-sibling::dd/select";
	public static final String TERMS_OF_SERVICE_CHECKBOX = "css=input#termsofservice";
	public static final String CHECKOUT_BUTTON = "css=button.checkout-button";
}
