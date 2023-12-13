package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class CrossbrowserFactory {
	private WebDriver driver;
	String browserName;
	String osName;
	String osVersion;
	String browserVersion;

	public CrossbrowserFactory(String browserName, String osName, String osVersion, String browserVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
		this.browserVersion = browserVersion;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", browserVersion);
		capability.setCapability("record_video", "true");

		HashMap<String, String> bitbarOptions = new HashMap<String, String>();
		bitbarOptions.put("project", "NopCommerce");
		bitbarOptions.put("testrun", "automationfc");
		bitbarOptions.put("apiKey", GlobalConstants.getGlobalConstants().getCrossbrowserApiKey());
		bitbarOptions.put("osVersion", osVersion);

		if (osName.contains("Windows")) {
			bitbarOptions.put("screenResolution", "1920x1080");
		} else {
			bitbarOptions.put("resolution", "1280x800");
		}

		bitbarOptions.put("seleniumVersion", "3");
		capability.setCapability("bitbar:options", bitbarOptions);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getCrossbrowserUrl()), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
