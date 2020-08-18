package basicSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BrowserOptions {
	@Test
	public void incognitoMode() {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium All in one\\drivers\\chromedriver83.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(dc);
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
	}

	// @Test
	public static WebDriver ieBrowser() {
		WebDriver driver = null;
		System.setProperty("webdriver.ie.driver",
				"G:/Selenium All in one/drivers/IEDriverServer_Win32_3.8.0/IEDriverServer.exe");
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(dc);
		driver.get("https://www.google.co.in/");
//		driver.manage().window().maximize();
		return driver;
	}

	public void firefoxProfile() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fporfile = profile.getProfile("xyz");
		WebDriver driver = new FirefoxDriver(fporfile);
	}

	// @Test
	public void setBrowserLanguage() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "ja");
		profile.setAcceptUntrustedCertificates(true);

		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.makemytrip.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// get browser name
		System.out.println(js.executeScript("return navigator.appCodeName"));
		System.out.println(js.executeScript("return navigator.userAgent;"));
		driver.quit();
	}
}
