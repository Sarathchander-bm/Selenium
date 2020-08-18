package basicSelenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinkPrintAndBrokenLinkCheck {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// https://www.toolsqa.com/
		// http://www.zlti.com
		String homePage = "https://www.guru99.com/";
		String url = "";
		
		// WebDriver driver = BrowserOptions.ieBrowser();
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium All in one\\drivers\\chromedriver83.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(homePage);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			url = link.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			verifyLink(url);
		}
		driver.quit();

	}

	public static void verifyLink(String urlLink) {
		// Sometimes we may face exception "java.net.MalformedURLException". Keep the
		// code in try catch block to continue the broken link analysis
		try {
			// Use URL Class - Create object of the URL Class and pass the urlLink as
			// parameter
			URL link = new URL(urlLink);
			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			// Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			// connect using connect method
			httpConn.connect();
			// use getResponseCode() to get the response code.
			if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + " - URL is working fine "+ httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() > 400) {
				System.out.println(urlLink + " - URL is broken : " + httpConn.getResponseMessage());
			}
		}
		// getResponseCode method returns = IOException - if an error occurred
		// connecting to the server.
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
