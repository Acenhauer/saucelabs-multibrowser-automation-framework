package src.test.java.master.tests;

import static junit.framework.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import src.test.java.master.framework.RemoteWebDriverHandling;

@Test
public class BasicTest extends RemoteWebDriverHandling {

	private final Logger logger = Logger.getLogger(BasicTest.class);

	@SuppressWarnings("deprecation")
	@Test
	public void testBasic() throws Exception {
		driver = setUp();
		logger.info("BasicTest execution");
		driver.get("http://www.amazon.com/");
		assertEquals(
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
				driver.getTitle());
		tearDown(driver);
	}
}