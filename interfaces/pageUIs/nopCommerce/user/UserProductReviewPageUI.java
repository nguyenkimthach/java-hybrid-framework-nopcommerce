package pageUIs.nopCommerce.user;

public class UserProductReviewPageUI {
	public static final String ADD_REVIEW_LINK = "xpath=//div[@class='product-review-links']//a[text()='Add your review']";
	public static final String REVIEW_TITLE = "css=input#AddProductReview_Title";
	public static final String REVIEW_TEXT = "css=textarea#AddProductReview_ReviewText";
	public static final String RATING_POINT_BY_TEXT = "xpath=//div[@class='rating-options']/input[@value='%s']";
	public static final String SUBMIT_REVIEW = "css=button.write-product-review-button";
	public static final String EXISTING_REVIEW_TITLE_BY_TEXT = "xpath=//div[@class='title']//following-sibling::div[1]//div[@class='review-title']/strong[text()='%s']";
	public static final String EXISTING_REVIEW_TEXT_BY_TEXT = "xpath=//div[@class='title']//following-sibling::div[1]//div[@class='text-body' and contains(text(),'%s')]";
	public static final String EXISTING_REVIEW_RATING_BY_TEXT = "xpath=//div[@class='title']//following-sibling::div[1]//div[@class='rating']/div[contains(@style,'%s')]";
}
