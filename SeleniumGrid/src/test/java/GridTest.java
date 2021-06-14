import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest {
	
	WebDriver driver = null;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws MalformedURLException {

		// define DesiredCapabilities
		DesiredCapabilities cap = new DesiredCapabilities();

		// define Chrome Optios
		ChromeOptions option = new ChromeOptions();
		option.merge(cap);

		String hubURL = "http://192.168.23.137:4444/wd/hub";
		 driver = new RemoteWebDriver(new URL(hubURL), option);

		if (browser.equals("Chrome")) {
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.MAC);

		}

		if (browser.equals("FF")) {
			cap.setBrowserName("FF");
			cap.setPlatform(Platform.WIN10);

		}

	}
	
	@Test
	public void scenarios() {
		driver.get("https://www.udemy.com/course/selenium-webdriver-with-java/learn/lecture/4038444#overview");
		System.out.println(driver.getTitle());
		
	}
	

}
