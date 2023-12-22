package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.user.UserProductPageUI;

public class UserProductPageObject extends BasePage {
	private WebDriver driver;

	public UserProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementClickable(UserProductPageUI.ADD_REVIEW_LINK);
		clickToElement(UserProductPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManage.getUserProductReviewPage(driver);
	}

	public void clickToButtonOverViewByTextName(String textName) {
		waitForElementClickable(UserProductPageUI.BUTTON_OVERVIEW_BY_TEXT, textName);
		clickToElement(UserProductPageUI.BUTTON_OVERVIEW_BY_TEXT, textName);
	}
}
