package src.test.java.master.framework;

import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
		String version = System.getProperty("version");
		String platform = System.getProperty("platform");
		DesiredCapabilities capabillities = DesiredCapabilities.firefox();
		capabillities.setCapability("version", "5");
		capabillities.setCapability("platform", Platform.XP);
		driver = new RemoteWebDriver(
				new URL("http://" + user.toString() + ":" + apikey.toString()
						+ "@ondemand.saucelabs.com:80/wd/hub"), capabillities);
		return driver;
	}

	@After
	public void tearDown(WebDriver driver) throws Exception {
		driver.quit();
	}
}
