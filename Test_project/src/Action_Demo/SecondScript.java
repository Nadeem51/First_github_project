package Action_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SecondScript {

static WebDriver driver;
static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		// Opening a new browser and launching demo website
		System.setProperty("webdriver.chrome.driver","C:/Nadeem/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Actions act= new Actions(driver);
		
		//for storing xpath of computers link and hovering over the element
		element=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
		act.moveToElement(element).build().perform();
		Thread.sleep(3000);
		
		//for clicking the first list item under the drop down 
		element=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
		act.moveToElement(element).click().build().perform();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Desktops");
		System.out.println(driver.getTitle());
		System.out.println("The test case is passed");
		driver.close();
	}

}
