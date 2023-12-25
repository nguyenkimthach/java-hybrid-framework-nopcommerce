package pageUIs.nopCommerce.user;

public class UserWishlistPageUI {
	public static final String PRODUCT_NAME_BY_TEXT = "xpath=//td[@class='product']/a[text()='%s']";
	public static final String WISHLIST_SHARING_LINK = "css=span.share-label + a";
	public static final String TITLE_TABLE_BY_TEXT = "xpath=//div[@class='page-title']/h1[contains(text(),'%s')]";
	public static final String ADD_TO_CARD_CHECKBOX_BY_TEXT = "xpath=//a[@class='product-name' and text()='%s']//parent::td//preceding-sibling::td[@class='add-to-cart']/input";
	public static final String REMOVE_CHECKBOX_BY_TEXT = "xpath=//a[@class='product-name' and text()='%s']//parent::td//following-sibling::td[@class='remove-from-cart']/button";
	public static final String ADD_TO_CARt_BUTTON = "css=button.wishlist-add-to-cart-button";
	public static final String MESSAGE_WISHLIST_BY_TEXT = "xpath=//div[@class='page-body']//div[contains(text(),'%s')]";
}
