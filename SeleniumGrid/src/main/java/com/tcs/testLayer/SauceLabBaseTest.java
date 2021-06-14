package com.tcs.testLayer;

	import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

	
	public class SauceLabBaseTest {

		WebDriver driver;

		@Parameters({ "browser", "platform", "version" })
		@BeforeMethod
		public void setUp(String browserName, String platformName, String browserVersion, Method name) {

			System.out.println("browser name is : " + browserName);
			String methodName = name.getName();

			MutableCapabilities sauceOpts = new MutableCapabilities();

			System.out.println("point 1");
			sauceOpts.setCapability("name", methodName);
			sauceOpts.setCapability("build", "Java-W3C-Examples");
			// sauceOpts.setCapability("seleniumVersion", "3.141.59");
			sauceOpts.setCapability("username", "ZebaTcs");
			sauceOpts.setCapability("accessKey", "794ce0a6-6823-4bf6-99d2-484b507a10f8");
			sauceOpts.setCapability("tags", "w3c-chrome-tests");
			System.out.println("point 2");
			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability("sauce:options", sauceOpts);
			cap.setCapability("browserVersion", "latest");
			cap.setCapability("platformName", "Windows 10");
			// cap.setCapability("browserName", browserName);

			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				cap.setCapability("browserName", "chrome");
			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				cap.setCapability("browserName", "firefox");
			}

			System.out.println("point 4");
			// https://ZebaTcs:794ce0a6-6823-4bf6-99d2-484b507a10f8@ondemand.us-west-1.saucelabs.com:443/wd/hub
			try {

				driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}

		@AfterMethod(alwaysRun = true)
		public void tearDown() {
		//	driver.close();
		}
	}


