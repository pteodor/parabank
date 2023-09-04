/**
 * 
 */
package com.parasoft.parabank;

import com.parasoft.parabank.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.page.ParaBankBillPayPage;
import com.parasoft.parabank.page.ParaBankWelcomeOnlineBankingPage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BillPayTest {

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
	 * Name: bill_pay
	 * Recording file: bill_pay.json
	 *
	 * Parasoft recorded Selenium test on Sun Sep 03 2023 20:30:26 GMT+0200 (czas środkowoeuropejski letni)
	 */
	@Test
	public void testBill_pay() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickBillPayLink();

		ParaBankBillPayPage paraBankBillPayPage = new ParaBankBillPayPage(driver);
		paraBankBillPayPage.setPayeeNameField("John");
		paraBankBillPayPage.setPayeeAddressStreetField("street");
		paraBankBillPayPage.setPayeeAddressCityField("city");
		paraBankBillPayPage.setPayeeAddressStateField("state");
		paraBankBillPayPage.setPayeeAddressZipCodeField("zip");
		paraBankBillPayPage.setPayeePhoneNumberField("12345");
		paraBankBillPayPage.setPayeeAccountNumberField("12345");
		paraBankBillPayPage.setVerifyAccountField("12456");
		paraBankBillPayPage.setAmountField("10");
		paraBankBillPayPage.clickForm();
		paraBankBillPayPage.setVerifyAccountField("12345");
		paraBankBillPayPage.clickForm();
		paraBankBillPayPage.clickSendPaymentButton();
	}

}