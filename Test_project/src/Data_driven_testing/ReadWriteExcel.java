package Data_driven_testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadWriteExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		XSSFWorkbook wb;
		XSSFSheet sh;
		String d1, d2;
		String xlmsg;
		FileInputStream FRead;
		FileOutputStream FWrite;
		int rowval;
		int rowcount;
		
		System.setProperty("webdriver.chrome.driver","C:/Nadeem/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		FRead = new FileInputStream("C:/Nadeem/Data_Driven_Testing.xlsx");
		wb = new XSSFWorkbook(FRead);
		sh = wb.getSheetAt(0);
		//d1=sh.getRow(0).getCell(0).getStringCellValue();
		//d2=sh.getRow(0).getCell(1).getStringCellValue();
		//System.out.println(d1);
		//System.out.println(d2);
		
		rowcount = sh.getPhysicalNumberOfRows();
		String username;
		String password;
		String webmessage;
		String pass = "Test is passed";
		String fail = "Test is failed";
		
		username = sh.getRow(1).getCell(0).getStringCellValue();
		password = sh.getRow(1).getCell(1).getStringCellValue();
		xlmsg = sh.getRow(1).getCell(2).getStringCellValue();
		
		driver.get("http://demowebshop.tricentis.com/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Thread.sleep(1000);
		webmessage = driver.findElement(By.cssSelector("a.account")).getText();
		System.out.println(webmessage);
		
		
		System.out.println("Login id is " + username);
		System.out.println("password id is " + password);
		System.out.println("webmessage id is " + webmessage);
		
		if(webmessage.equals(xlmsg))
			
		{
			System.out.println("test case passed");
		}
		
		else
			
		{
			System.out.println("test case failed");
		}
		
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(1000);
		FWrite=new FileOutputStream("C:/Nadeem/Data_Driven_Testing.xlsx");
		sh.getRow(1).createCell(3).setCellValue(webmessage);
		
		if(webmessage.equals(xlmsg))
		{
			System.out.println(pass);
			sh.getRow(1).createCell(4).setCellValue(pass);
		}
		else
			
		{
			System.out.println(fail);
			sh.getRow(1).createCell(4).setCellValue(fail);
		}
		
		wb.write(FWrite);
		for (rowval=1;rowval<rowcount;rowval++)
			
		{
			username=sh.getRow(rowval).getCell(0).getStringCellValue();
			password=sh.getRow(rowval).getCell(1).getStringCellValue();
			xlmsg=sh.getRow(rowval).getCell(2).getStringCellValue();
		}
	}
	
}
