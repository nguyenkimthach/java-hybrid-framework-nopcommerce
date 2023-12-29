package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inPutToPasswordTextbox(String password) {
		waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void selectRememberCheckbox() {
		waitForElementClickable(AdminLoginPageUI.REMEMBER_ME_CHECKBOX);
		checkToDefaultCheckboxOrRadio(AdminLoginPageUI.REMEMBER_ME_CHECKBOX);
	}

	public AdminDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManage.getAdminDashboardPage(driver);
	}
}
