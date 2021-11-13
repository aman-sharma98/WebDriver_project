package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		
		//int cnt = table_row.size();
		System.out.println("No of row are:"+ rows.size());
		System.out.println("No of columns are:"+ columns.size());
		
		WebElement data =  driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		System.out.println(data.getText());
		
		for(int i=2; i<rows.size();i++) {
			
			WebElement data1 =  driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+ i +"]/td[1]"));
			System.out.println(data1.getText());
		}
		
		WebElement elem = driver.findElement(By.xpath("//*[text()='Define an HTML Table']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elem);
		}
	}