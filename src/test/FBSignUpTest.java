package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUpTest {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement SignUp = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		SignUp.click();
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("15");
		//ddDay.selectByValue("12");
		//ddDay.selectByIndex(3);
		
		WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		Male.click();
		
		if(Male.isSelected()) {
			System.out.println("Radio button is selected");
		}else {
			System.out.println("Radio button is not selected");
		}
		
	}
}
