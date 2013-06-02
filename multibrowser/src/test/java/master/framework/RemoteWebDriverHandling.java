package src.test.java.master.framework;

import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * RemoteWebDriver handling class for tests on Sauce On Demand infrastructure
 * 
 * @author Guillem Hernandez Sola
 */
public class RemoteWebDriverHandling {

	public static WebDriver driver;
	private final Logger logger = Logger
			.getLogger(RemoteWebDriverHandling.class);

	@Before
	public WebDriver setUp() throws Exception {
		String user = System.getProperty("user");
		String apikey = System.getProperty("apikey");
		String browser = System.getProperty("browser");
		// Not yet implemented, but pom.xml is prepared for these variables
		// String version = System.getProperty("version");
		// String platform = System.getProperty("platform");
		DesiredCapabilities caps = null;
		switch (browser.toString()) {
		case "chrome":
			caps = DesiredCapabilities.chrome();
			caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			caps.setCapability("platform", Platform.XP);
			caps.setCapability("version", "26");
			break;
		case "ie":
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			caps.setCapability("platform", Platform.XP);
			caps.setCapability("version", "8");
			break;
		case "firefox":
			caps = DesiredCapabilities.firefox();
			caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			caps.setCapability("platform", Platform.XP);
			caps.setCapability("version", "21");
			break;
		case "ipad":
			caps = DesiredCapabilities.ipad();
			break;
		case "iphone":
			caps = DesiredCapabilities.iphone();
			break;
		case "android":
			caps = DesiredCapabilities.android();
			caps.setCapability(CapabilityType.BROWSER_NAME, "android");
			caps.setCapability("platform", "Linux");
			caps.setCapability("version", "4");
			break;
		case "htmlunit":
			caps = DesiredCapabilities.htmlUnit();
			break;
		case "opera":
			caps = DesiredCapabilities.opera();
			caps.setCapability(CapabilityType.BROWSER_NAME, "opera");
			caps.setCapability("platform", Platform.XP);
			caps.setCapability("version", "12");
			break;
		case "safari":
			caps = DesiredCapabilities.safari();
			caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
			caps.setCapability("platform", "OS X 10.6");
			caps.setCapability("version", "5");
			break;
		default:
			caps = DesiredCapabilities.firefox();
			caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			caps.setCapability("platform", Platform.XP);
			caps.setCapability("version", "21");
			break;
		}
		driver = new RemoteWebDriver(new URL("http://" + user.toString() + ":"
				+ apikey.toString() + "@ondemand.saucelabs.com:80/wd/hub"),
				caps);
		logger.info("Starting Webdriver " + caps.getBrowserName().toString()
				+ " version " + caps.getVersion().toString() + " on "
				+ caps.getPlatform().toString());
		return driver;
	}

	@After
	public void tearDown(WebDriver driver) throws Exception {
		driver.quit();
	}
}
