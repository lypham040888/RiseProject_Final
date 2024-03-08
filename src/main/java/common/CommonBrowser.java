package common;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import constants.WebInfo;

public class CommonBrowser {
	public WebDriver driver;
	protected int DEFAULT_TIMEOUT = 20000;
	protected int WAIT_INTERVAL = 1000;
	public int loopCount = 0;
	public final int ACTION_REPEAT = 5;
	public Actions action;

	/**
	 * init Driver
	 * 
	 * @param URL
	 */
	public WebDriver initDriverTest(String... URL) {
		String url1 = URL.length > 0 ? URL[0] : WebInfo.test_URL;
		String proName = URL.length > 2 ? URL[2] : "";
		String broName = URL.length > 1 ? URL[1] : "chrome";
		String url2 = System.getProperty("Url");
		String browser = System.getProperty("browser");
		String plaftForm = System.getProperty("platForm");
		WebDriver dr = null;

		if (browser == null) {
			browser = broName;
		}
		ChromeOptions options = new ChromeOptions();
		if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			dr = new ChromeDriver();
		} else if ("iexplorer".equals(browser)) {
			dr = new InternetExplorerDriver();
		} else if ("safari".equals(browser)) {
			dr = new SafariDriver();
		} else {
			if (proName != null && proName != "") {
				FirefoxProfile ffprofile = new FirefoxProfile(new File(proName));
				dr = new FirefoxDriver();
			} else {
				FirefoxProfile fxProfile = new FirefoxProfile();
				File browserAppPath = new File("/usr/bin/geckodriver");
				FirefoxBinary ffBin = new FirefoxBinary(browserAppPath);
				dr = new FirefoxDriver();
			}
		}
		if (url2 != "" && url2 != null) {
			dr.get(url2);
		} else {
			dr.get(url1);
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return dr;
	}

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		// river = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver initFirefoxDriver(String URL) {
		System.out.println("Launching Firefox browser...");
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public WebDriver initEdgeDriver(String URL) {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver initSafariDriver(String URL) {
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public WebDriver setupDriver(String browserName, String url) {
		if (browserName.contains("chrome")) {
			driver = initChromeDriver(url);
		}
		else if (browserName.contains("firefox")) {
			driver = initFirefoxDriver(url);
		}
		else if (browserName.contains("edge")) {
			driver = initEdgeDriver(url);
		} else {
			System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
			driver = initChromeDriver(url);
		}
		return driver;
	}
	/**
	 * 
	 * @param locator
	 * @param opParams
	 */

	/**
	 * quit driver if driver existed
	 * 
	 * @param dr
	 */
	public void closeDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			dr.close();
		}
	}

	public void quitDriver(WebDriver dr) {
		dr.quit();

	}
}
