package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDriverManager implements IBroswserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		// WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().driverVersion("120.0.6099.71").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1366x768");
		return new ChromeDriver(options);
	}
}
