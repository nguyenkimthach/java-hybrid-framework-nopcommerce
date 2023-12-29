package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserHomePageUI;
import pageUIs.nopCommerce.user.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public UserProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(UserHomePageUI.REGISTER_LINK);
		clickToElement(UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManage.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(UserHomePageUI.LOGIN_LINK);
		clickToElement(UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManage.getUserLoginPage(driver);
	}

	public boolean isMyaccountLinkDisplayed() {
		waitForElementVisible(UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisPlayed(UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public UserMyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManage.getMyAccountPage(driver);
	}

	public UserProductPageObject clickToProductAtFeaturedProductsListByText(String productName) {
		waitForElementClickable(UserHomePageUI.PRODUCT_AT_FEATURED_LIST_BY_TEXT, productName);
		clickToElement(UserHomePageUI.PRODUCT_AT_FEATURED_LIST_BY_TEXT, productName);
		return PageGeneratorManage.getUserProductPage(driver);
	}

	public void inputToReviewTitleTextbox(String textTitle) {
		waitForElementVisible(UserProductReviewPageUI.REVIEW_TITLE);
		sendkeyToElement(UserProductReviewPageUI.REVIEW_TITLE, textTitle);
	}

	public void inputToReviewTextTextbox(String textReview) {
		waitForElementVisible(UserProductReviewPageUI.REVIEW_TEXT);
		sendkeyToElement(UserProductReviewPageUI.REVIEW_TEXT, textReview);
	}

	public void checkToRattingCheckboxByValue(String ratingPoint) {
		waitForElementClickable(UserProductReviewPageUI.RATING_POINT_BY_TEXT, ratingPoint);
		checkToDefaultCheckboxOrRadio(UserProductReviewPageUI.RATING_POINT_BY_TEXT, ratingPoint);
	}

	public void clickToSubmitRevewButton() {
		waitForElementClickable(UserProductReviewPageUI.SUBMIT_REVIEW);
		clickToElement(UserProductReviewPageUI.SUBMIT_REVIEW);
	}

	public boolean isReviewTitleByTextDisplayed(String textTitle) {
		waitForElementVisible(UserProductReviewPageUI.EXISTING_REVIEW_TITLE_BY_TEXT, textTitle);
		return isElementDisPlayed(UserProductReviewPageUI.EXISTING_REVIEW_TITLE_BY_TEXT, textTitle);
	}

	public boolean isReviewTextByTextDisplayed(String textReview) {
		waitForElementVisible(UserProductReviewPageUI.EXISTING_REVIEW_TEXT_BY_TEXT, textReview);
		return isElementDisPlayed(UserProductReviewPageUI.EXISTING_REVIEW_TEXT_BY_TEXT, textReview);
	}

	public boolean isReviewRatingByIntergerDisplayed(String ratingPecent) {
		waitForElementVisible(UserProductReviewPageUI.EXISTING_REVIEW_RATING_BY_TEXT, ratingPecent);
		return isElementDisPlayed(UserProductReviewPageUI.EXISTING_REVIEW_RATING_BY_TEXT, ratingPecent);
	}

}
