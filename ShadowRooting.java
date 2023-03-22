package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class ShadowRooting {
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='kils']").sendKeys("mukesh");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("", );
		
		//shadow.findElementByXPath("//a[text()='Click to practice iframe inside shadow dom scenario']").click();
		

	}

}
