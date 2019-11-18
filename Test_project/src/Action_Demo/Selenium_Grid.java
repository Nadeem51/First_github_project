package Action_Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium_Grid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);
		URL link = new URL("http://192.168.56.1:3334/wd/hub");
		WebDriver d= new RemoteWebDriver(link,dc);
		
		d.get("http://demowebshop.tricentis.com/");
		Thread.sleep(1000);
		d.findElement(By.name("Email")).sendKeys("data@driven.com");
		d.findElement(By.name("Password")).sendKeys("data123");
		
	}

}
