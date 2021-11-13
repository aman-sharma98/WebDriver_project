package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement Header = driver.findElement(By.xpath("//h2"));
		
		if(Header.isDisplayed()) {
			
			System.out.println("Header is Displayed");
		
		}else {
			
			System.out.println("Header is not Displayed");
		
		}
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='email']"));
		
		System.out.println(UserName.getAttribute("placeholder"));
		
		UserName.sendKeys("abc@def.ghi");
		
		WebElement Password = driver.findElement(By.xpath("//input[@name='pass']"));
		Password.sendKeys("abcdefghi");
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[@name='login']"));
		LoginButton.click();
		
	}
	
}
