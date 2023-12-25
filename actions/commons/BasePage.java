package commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void openPageUrl(String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}

	protected String getPageUrl() {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode() {
		return driver.getPageSource();
	}

	protected void refreshCurrentPage() {
		driver.navigate().refresh();
	}

	protected Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}

	protected void setCookies(Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	protected void backToPage() {
		driver.navigate().back();
	}

	protected Alert waitForAlertPresence() {
		WebDriverWait explicitwait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		return explicitwait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert() {
		waitForAlertPresence().accept();
	}

	protected void cancelAlert() {
		waitForAlertPresence().dismiss();
	}

	protected String getlAlertText() {
		return waitForAlertPresence().getText();
	}

	protected void sendKeyTolAlert(String textValue) {
		waitForAlertPresence().sendKeys(textValue);
	}

	protected void switchToWindowByID(String WindowsID) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(WindowsID)) {
				driver.switchTo().window(id);
			}
		}
	}

	protected void switchToWindowByPageTitle(String tabTitle) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			driver.switchTo().window(id);
			String actuaPageTitle = driver.getTitle();
			if (actuaPageTitle.equals(tabTitle)) {
				break;
			}
		}
	}

	protected void closeAllWindow_WithoutParent(String parentID) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	private By getByLocator(String locatorType) {
		By by = null;
		String[] locatorParts = locatorType.split("=", 2);
		if (locatorParts.length != 2) {
			throw new IllegalArgumentException("Invalid locator format");
		}
		String typeLocator = locatorParts[0].trim().toLowerCase();
		String locator = locatorParts[1].trim();

		switch (typeLocator) {
		case "id":
			by = By.id(locator);
			break;
		case "class":
			by = By.className(locator);
			break;
		case "name":
			by = By.name(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		case "css":
			by = By.cssSelector(locator);
			break;
		default:
			throw new IllegalArgumentException("LocatorType is not supported");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... value) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) value);
		}
		return locatorType;
	}

	private WebElement getWebElement(String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElement(String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	protected void clickToElement(String locatorType) {
		WebElement element = driver.findElement(getByLocator(locatorType));
		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(locatorType);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}

	protected void clickToElement(String locatorType, String... dynamicValues) {
		WebElement element = driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValues)));
		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(locatorType, dynamicValues);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}

	protected void senkeyToElement(String locatorType, String textValue) {
		WebElement element = getWebElement(locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	protected void senkeyToElement(String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	protected void senkeyToElementUserClearByDeleteKey(String locatorType, String textValue) {
		WebElement element = getWebElement(locatorType);
		waitForElementClickable(locatorType);
		clickToElement(locatorType);
		clearValueInElementByDeleteKey(locatorType);
		element.sendKeys(textValue);
	}

	protected void senkeyToElementUserClearByDeleteKey(String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValues));
		waitForElementClickable(getDynamicXpath(locatorType, dynamicValues));
		clickToElement(getDynamicXpath(locatorType, dynamicValues));
		clearValueInElementByDeleteKey(getDynamicXpath(locatorType, dynamicValues));
		element.sendKeys(textValue);
	}

	protected void clearValueInElementByDeleteKey(String locatorType) {
		WebElement element = getWebElement(locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	protected void selectItemInDefaultDropDown(String locatorType, String textItem) {
		Select select = new Select(getWebElement(locatorType));
		select.selectByVisibleText(textItem);
	}

	protected void selectItemInDefaultDropDown(String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	protected String getSelectedItemDefaultDropdown(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.isMultiple();
	}

	protected void SelectItemInCustomDropdown(String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(parentXpath).click();
		sleepInSecond(1);

		WebDriverWait explicitwait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		List<WebElement> speeDropdownItems = explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		;
		for (WebElement item : speeDropdownItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getElementAttribute(String locatorType, String attributeName) {
		return getWebElement(locatorType).getAttribute(attributeName);
	}

	protected String getElementAttribute(String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	protected String getElementText(String locatorType) {
		return getWebElement(locatorType).getText();
	}

	protected String getElementText(String locatorType, String... dynamicValues) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	protected String getElementCssValue(String locatorType, String propertyName) {
		return getWebElement(locatorType).getCssValue(propertyName);
	}

	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(String locatorType) {
		return getListWebElement(locatorType).size();
	}

	protected int getElementSize(String locatorType, String... dynamicValues) {
		return getListWebElement(getDynamicXpath(locatorType, dynamicValues)).size();
	}

	protected void checkToDefaultCheckboxOrRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkToDefaultCheckboxOrRadio(String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void unCheckToDefaultCheckboxRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void unCheckToDefaultCheckboxRadio(String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisPlayed(String locatorType) {
		try {
			return getWebElement(locatorType).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean isElementDisPlayed(String locatorType, String... dynamicValues) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	protected boolean isElementUndisplayed(String locatorType) {
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getShortTimeOut());
		List<WebElement> elements = getListWebElement(locatorType);
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getLongTimeOut());

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isElementUndisplayed(String locatorType, String... dynamicValues) {
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getShortTimeOut());
		List<WebElement> elements = getListWebElement(getDynamicXpath(locatorType, dynamicValues));
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getLongTimeOut());

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	protected void overrideImplicitTimeout(long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	protected boolean isElementEnable(String locatorType) {
		return getWebElement(locatorType).isEnabled();
	}

	protected boolean isElementSelected(String locatorType) {
		return getWebElement(locatorType).isSelected();
	}

	protected boolean isElementSelected(String locatorType, String... dynamicValues) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}

	protected void switchToFrameIframe(String locatorType) {
		driver.switchTo().frame(getWebElement(locatorType));
	}

	protected void switchToDefaultContent(String locatorType) {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locatorType)).perform();
	}

	protected void hoverMouseToElement(String locatorType, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(getDynamicXpath(locatorType, dynamicValues))).perform();
	}

	protected void pressKeyToElement(String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(locatorType), key).perform();
	}

	protected void pressKeyToElement(String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	protected void scrollToBottomPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(String locatorType) {
		WebElement element = getWebElement(locatorType);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(locatorType));
	}

	protected void clickToElementByJS(String locatorType, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(getDynamicXpath(locatorType, dynamicValues)));
	}

	protected void scrollToElement(String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(locatorType));
	}

	protected String getElementValueByJSXpath(String xpathLocator) {
		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
		if (xpathLocator.startsWith("xpath=")) {
			xpathLocator = xpathLocator.replace("xpath=", "");
		}
		return (String) jsExcutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	protected void removeAttributeInDOM(String locatorType, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected WebElement getShadowDOM(String locatorType) {
		return (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot;", getWebElement(locatorType));
	}

	protected String getElementValidationMessage(String locatorType) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(locatorType));
	}

	protected boolean isImageLoaded(String locatorType) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isImageLoaded(String locatorType, String... dynamicValues) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(getDynamicXpath(locatorType, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected void waitForElementVisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getLongTimeOut());
	}

	protected void waitForElementVisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	protected void waitForElementInvisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getMediumTimeOut());
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementInvisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getMediumTimeOut());
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	protected void waitForAllElementVisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	protected void waitForAllElementVisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	protected void waitForAllElementInvisible(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getMediumTimeOut());
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(locatorType)));
	}

	protected void waitForAllElementInvisible(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getMediumTimeOut());
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(getDynamicXpath(locatorType, dynamicValues))));
	}

	/**
	 * Wait for element undisplayed in DOM or not in DOM and override implicit timeout
	 * 
	 * @author ThachNk
	 * @param driver
	 * @param locatorType
	 */
	protected void waitForElementUndisplay(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getShortTimeOut());
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getShortTimeOut());
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getLongTimeOut());
	}

	/**
	 * Wait for dynamic element undisplayed in DOM or not in DOM and override implicit timeout
	 * 
	 * @author ThachNk
	 * @param locatorType
	 * @param dynamicValues
	 */
	protected void waitForElementUndisplay(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getShortTimeOut());
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getShortTimeOut());
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getLongTimeOut());
	}

	protected void waitForElementClickable(String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	protected void waitForElementClickable(String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeOut());
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	protected void uploadMultipleFiles(String... fileNames) {
		// Đường dẫn của thư muc Upload file : Windows\ Mac\ Linux
		String filePath = GlobalConstants.getGlobalConstants().getUploadFile();

		// Đường dẩn của all File
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(BasePageNopCommerceUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	protected boolean isAllItemHaveTextNameSortByAscending(String locatorType) {
		sleepInSecond(3);
		List<WebElement> elementLists = getListWebElement(locatorType);
		List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		System.out.println("Sorted list (sortedNames): " + sortedNames);
		return names.equals(sortedNames);
	}

	protected boolean isAllItemHaveTextNameSortByDescending(String locatorType) {
		sleepInSecond(3);
		List<WebElement> elementLists = getListWebElement(locatorType);
		List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);

	}

	protected boolean isAllItemHavePrice$SortByAscending(String locatorType) {
		sleepInSecond(3);
		List<WebElement> elementLists = getListWebElement(locatorType);
		List<Float> names = elementLists.stream().map(n -> Float.valueOf(n.getText().replace(",", "").replace("$", ""))).collect(Collectors.toList());
		List<Float> sortedNames = new ArrayList<Float>(names);
		Collections.sort(sortedNames);
		return names.equals(sortedNames);
	}

	protected boolean isAllItemHavePrice$SortByDescending(String locatorType) {
		sleepInSecond(3);
		List<WebElement> elementLists = getListWebElement(locatorType);
		List<Float> names = elementLists.stream().map(n -> Float.valueOf(n.getText().replace(",", "").replace("$", ""))).collect(Collectors.toList());
		List<Float> sortedNames = new ArrayList<Float>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);
	}

	protected boolean isAllItemHaveDateSortByAscending(String locatorType) {
		sleepInSecond(3);
		List<WebElement> elementLists = getListWebElement(locatorType);
		List<Date> dates = elementLists.stream().map(n -> convertStringToDate(n.getText())).collect(Collectors.toList());
		List<Date> sortedDates = dates.stream().sorted().collect(Collectors.toList());
		return dates.equals(sortedDates);
	}

	protected boolean isAllItemHaveDateSortByDescending(String locatorType) {
		sleepInSecond(3);
		List<WebElement> elementLists = getListWebElement(locatorType);
		List<Date> dates = elementLists.stream().map(n -> convertStringToDate(n.getText())).collect(Collectors.toList());
		List<Date> sortedDates = dates.stream().sorted((d1, d2) -> d2.compareTo(d1)).collect(Collectors.toList());
		return dates.equals(sortedDates);
	}

	/**
	 * Convert String text(like fomat "Oct 30, 2018" ) to Date fomat
	 * 
	 * @author ThachNk
	 * @param dateInString
	 */
	private Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Enter to dynamic textbox by id
	 * 
	 * @author ThachNK
	 * @param driver
	 * @param textBoxID
	 * @param value
	 */
	public void inPutToTextboxByID(String textBoxID, String value) {
		waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textBoxID);
		senkeyToElement(BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textBoxID);
	}

	/**
	 * Click to dynamic button by text
	 * 
	 * @author ThachNk
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	/**
	 * Select item in dropdown by name atribute
	 * 
	 * @author ThachNk
	 * @param driver
	 * @param dropdownAtributeName
	 * @param itemValue
	 */
	public void selectToDropdownByName(String dropdownAtributeName, String itemValue) {
		waitForElementClickable(BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAtributeName);
		selectItemInDefaultDropDown(BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAtributeName);
	}

	/**
	 * Click To dynamic radio button by label name
	 * 
	 * @author ThachNk
	 * @param driver
	 * @param checkBoxLabelname
	 */
	public void clickToRadioButtonByLabel(String checkBoxLabelname) {
		waitForElementClickable(BasePageNopCommerceUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, checkBoxLabelname);
		checkToDefaultCheckboxOrRadio(BasePageNopCommerceUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, checkBoxLabelname);
	}

	/**
	 * Click To dynamic checkbox by label name
	 * 
	 * @author ThachNk
	 * @param driver
	 * @param checkBoxLabelname
	 */
	public void clickToCheckboxByLabel(String checkBoxLabelname) {
		waitForElementClickable(BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelname);
		checkToDefaultCheckboxOrRadio(BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelname);
	}

	/**
	 * Get value in textbox by textboxID
	 * 
	 * @author ThachNk
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	public String getTextboxValueByID(String textboxID) {
		waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	public void navigateToPreviousPage() {
		backToPage();
	}

	public UserHomePageObject openHomePage() {
		openPageUrl(BasePageNopCommerceUI.HOMEPAGE_LINK);
		return PageGeneratorManage.getUserHomePage(driver);
	}

	public UserRegisterPageObject openRegisterPage() {
		openPageUrl(BasePageNopCommerceUI.REGISTER_LINK);
		return PageGeneratorManage.getUserRegisterPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		openPageUrl(BasePageNopCommerceUI.LOGIN_LINK);
		return PageGeneratorManage.getUserLoginPage(driver);
	}

	public UserWishlistPageObject openWishlistPage() {
		openPageUrl(BasePageNopCommerceUI.WISHLIST_LINK);
		return PageGeneratorManage.getUserWishlistPage(driver);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(BasePageNopCommerceUI.LOGOUT_LINK);
		clickToElement(BasePageNopCommerceUI.LOGOUT_LINK);
		return PageGeneratorManage.getUserHomePage(driver);
	}

	public UserMyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		clickToElement(BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		return PageGeneratorManage.getMyAccountPage(driver);
	}

	public void openPageAtFooterByText(String page) {
		waitForElementClickable(BasePageNopCommerceUI.DYNAMIC_LINK_PAGE_AT_FOOTER_BY_TEXT, page);
		clickToElement(BasePageNopCommerceUI.DYNAMIC_LINK_PAGE_AT_FOOTER_BY_TEXT, page);
	}

	public String getContenMessage() {
		waitForElementVisible(BasePageNopCommerceUI.CONTEN_MESSAGE);
		return getElementText(BasePageNopCommerceUI.CONTEN_MESSAGE);
	}
}
