/**
 * 
 */
package com.parasoft.parabank;

import com.parasoft.parabank.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.page.ParaBankTransferFundsPage;
import com.parasoft.parabank.page.ParaBankWelcomeOnlineBankingPage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TransferTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://localhost:18080";
	private static final String CHROME_DRIVER = "C:\\home\\files\\chromedriver\\116\\chromedriver.exe";
	
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
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
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