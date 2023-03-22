package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		
		
		driver.findElement(By.xpath("//li[@class='sc-hizQCF dSgOQo']//span[text()='Hyderabad']")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//div[@class='sc-kxynE gLkGwh']//div//span[2]")).click();
		driver.findElement(By.xpath("//div[@class='sc-jTzLTM sc-cfWELz ggLWHF']/input")).sendKeys("dada");
		
		driver.findElement(By.xpath("(//div[@class='sc-dXfzlN iPwaRU']/span)[1]")).click();
		
	}

}
