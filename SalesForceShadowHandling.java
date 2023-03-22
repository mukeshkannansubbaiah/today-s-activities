package project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForceShadowHandling {
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(" https://login.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		Set<String> win1 = driver.getWindowHandles();
		List<String>win2=new ArrayList<String>(win1);
		driver.switchTo().window(win2.get(1));
		//driver.switchTo().window(win2.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		Actions learn=new Actions(driver);
		WebElement learntrail = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		
		learn.moveToElement(learntrail).perform();
		
		WebElement certificate = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		learn.scrollToElement(certificate).click(certificate).perform();
		
	    driver.findElement(By.xpath("//div[@class='roleMenu-item roleMenu_active']/a")).click();
	    System.out.println(driver.getTitle());
	    
	    List<WebElement> allcertificate = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	   for (WebElement listofcertificate : allcertificate) {
		   String text = listofcertificate.getText();
		System.out.println(text);
	}
		   
		   
		
	}
		
	}


