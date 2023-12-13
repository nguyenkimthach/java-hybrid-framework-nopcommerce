package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class LambdaFactory {
	private WebDriver driver;
	String browserName;
	String osName;
	String browserVersion;

	public LambdaFactory(String browserName, String osName, String browserVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.browserVersion = browserVersion;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", browserVersion);

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("platformName", osName);
		ltOptions.put("project", "Project");
		capability.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getLambdaUrl()), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
