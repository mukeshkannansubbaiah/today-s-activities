package project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLeaf {
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		
		driver.findElement(By.xpath("//table[contains(@class,'dijit dijitReset')]/following::a")).click();
		
		Set<String> firstwindow = driver.getWindowHandles();
		List<String>window=new ArrayList<String>(firstwindow);
		driver.switchTo().window(window.get(0));
		
		driver.switchTo().window(window.get(1));
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		driver.switchTo().window(window.get(0));
		
		driver.findElement(By.xpath("(//div[@class='dijitDownArrowButtonInner']/following::a)[2]")).click();
		Set<String> secondwindow = driver.getWindowHandles();
		List<String>window2=new ArrayList<String>(secondwindow);
	   driver.switchTo().window(window2.get(0));
	    driver.switchTo().window(window2.get(1));
	    
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[5]")).click();
	    driver.switchTo().window(window2.get(0));
	    driver.findElement(By.linkText("Merge")).click();
	    
	    driver.switchTo().alert().accept();
	
	}

}
