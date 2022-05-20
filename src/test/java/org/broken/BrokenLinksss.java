package org.broken;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksss {
	
	
public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	
	driver.manage().window().maximize();
	driver.findElement(By.id("Sridhar"));
	
	List<WebElement> alllinks = driver.findElements(By.tagName("a"));
	int brokenCount = 0;
	for (int i = 0; i < alllinks.size(); i++) {
		WebElement els = alllinks.get(i);
		String attribute = els.getAttribute("href");
		URL url = new URL(attribute);
		URLConnection openConnection = url.openConnection();
		HttpsURLConnection connection = (HttpsURLConnection)openConnection;
		
        int rc = connection.getResponseCode();			
        
        if (rc != 200)
        
        
        {
        	brokenCount++;
			System.out.println(attribute);
		}
	
}      
	
	System.out.println(brokenCount);
		
	
			
		}
		
	}