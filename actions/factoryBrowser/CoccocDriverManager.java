package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoccocDriverManager implements IBroswserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().driverVersion("117.0.5938.92").setup();
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:" + File.separator + "Program Files" + File.separator + "CocCoc" + File.separator + "Browser" + File.separator + "Application" + File.separator + "browser.exe");
		return new ChromeDriver(options);
	}
}
