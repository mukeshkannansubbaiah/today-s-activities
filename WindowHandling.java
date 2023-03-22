package project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {
	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/");
        driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
        
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles) {
        	//driver.switchTo().window(string);
			
		}
        List<String>name=new ArrayList<String>(windowHandles);
        driver.switchTo().window(name.get(1));
        System.out.println(driver.getTitle());
       
        driver.close();
        
        driver.switchTo().window(name.get(0));
       System.out.println(driver.getTitle());
	}

}
