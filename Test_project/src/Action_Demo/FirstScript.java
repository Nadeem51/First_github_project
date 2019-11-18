package Action_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Wait;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:/Nadeem/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Accenture");
		driver.findElement(By.name("btnK")).submit();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div[1]/a/h3/span")).click();
		/*
		driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		//driver.wait(20);
		//System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		driver.close();
	}

}
