/**
 * 
 */
package com.parasoft.parabank;

import com.parasoft.parabank.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.page.ParaBankTransferFundsPage;
import com.parasoft.parabank.page.ParaBankWelcomeOnlineBankingPage;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TransferTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://parabank-baseline:8080";
	private static final String CHROME_DRIVER = "/opt/selenium/chromedriver-118.0.5993.70";
	private static final String GRID_URL = "http://selenium-chrome:4444/wd/hub";
	
	private WebDriver driver;

	@BeforeEach
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		ChromeOptions opts = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.geolocation", 2);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		opts.setExperimentalOption("prefs", prefs);
		opts.addArguments("--remote-allow-origins=*");
		opts.addArguments("--start-maximized");
		opts.addArguments("--incognito");
		opts.addArguments("--enable-strict-powerful-feature-restrictions");
		opts.addArguments("--ignore-ssl-errors=yes");
		opts.addArguments("--ignore-certificate-errors");
        //      opts.setBrowserVersion("118.0.5993.70");
		opts.addArguments("--headless"); // Run in headless mode
                opts.addArguments("--disable-gpu"); // Disable GPU for headless
                opts.addArguments("--no-sandbox");
		try {
			driver = new RemoteWebDriver(new URL(GRID_URL), opts);
	        } catch (MalformedURLException e) {
			e.printStackTrace();
	        }
	}

	@AfterEach
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: transfer
	 * Recording file: transfer.json
	 *
	 * Parasoft recorded Selenium test on Sun Sep 03 2023 20:29:18 GMT+0200 (czas środkowoeuropejski letni)
	 */
	@Test
	public void testTransfer() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm?ConnType=JDBC");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickTransferFundsLink();

		ParaBankTransferFundsPage paraBankTransferFundsPage = new ParaBankTransferFundsPage(driver);
		paraBankTransferFundsPage.selectToAccountIdDropdown("12456");
		paraBankTransferFundsPage.setInputField("100");
		paraBankTransferFundsPage.clickTransferButton();
	}

}
