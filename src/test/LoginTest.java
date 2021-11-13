package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.setProperty("webdriver.gecko.driver", "chromedriver");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver1 = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		//driver1.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("kl@hu.com");
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("J1nnlkqlkmwq");
		
		WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		Rememberme.click();
		
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();
		
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = Error.getText();
		String ExpectedMsg = "The email or password you have entered is invalid.";
		
		if (ActualMsg.equals(ExpectedMsg)) {
			
			System.out.println("Test Passed");
			
		}else {
			
			System.out.println("Test Failed");
			
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are :" + Links.size());
		
		for(WebElement data : Links) {
			
			//System.out.println(data.getText());
            
			System.out.println("Target Url is: " + data.getAttribute("href"));
     
		}
		
		System.out.println(driver.getTitle());
	    System.out.println(driver.getCurrentUrl());
		
		//WebElement ForgotPass = driver.findElement(By.partialLinkText("Forgot "));
		//ForgotPass.click();
		
		//Thread.sleep(5000);
		
		//driver.quit();
		//driver.close();
		
	}
	
}
