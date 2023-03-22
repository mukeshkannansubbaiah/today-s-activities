package project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesforceArchitectCertificate {
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
		
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		Actions learn=new Actions(driver);
		WebElement learntrail = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		
		learn.moveToElement(learntrail).perform();
		
		WebElement certificate = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		learn.scrollToElement(certificate).click(certificate).perform();
		
		driver.findElement(By.xpath("(//div[@class='roleMenu-item '])[1]")).click();
		WebElement summary = driver.findElement(By.xpath("(//h1[text()='Salesforce Architect']/following::div)[1]"));
		
		System.out.println(summary.getText());
		
		List<WebElement> allarchitectcerti = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement architectceritificate : allarchitectcerti) {
			String text=architectceritificate.getText();
			System.out.println(text);
		}
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		List<WebElement> listofarchitect = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement architect : listofarchitect) {
			
			System.out.println(architect.getText());
			
		}
	}

}
