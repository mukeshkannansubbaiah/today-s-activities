package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		WebElement findElement = driver.findElement(By.xpath("//input[@id='src']"));
		findElement.sendKeys("chennai");
		driver.findElement(By.xpath("(//li[@class='sub-city'])[1]")).click();
		
		driver.findElement(By.id("dest")).sendKeys("bangalore");
		driver.findElement(By.xpath("(//li[@class='sub-city'])[1]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'fl icon-calendar_icon-new icon')]")).click();
		
		driver.findElement(By.xpath("//div[@class='rb-calendar']//table//tr[6]//td[4]")).click();
		
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		
		String text = driver.findElement(By.xpath("(//span[@class='f-bold'])[1]")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("(//li[@class='checkbox']//label[@for='bt_SLEEPER'])[1]")).click();
		
	String text2 = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
	System.out.println(text2);
	
	System.out.println(driver.getTitle());
	
	}

}
