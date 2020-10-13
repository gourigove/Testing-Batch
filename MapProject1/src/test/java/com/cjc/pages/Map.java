package com.cjc.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Map {
	WebDriver driver;
	@Test
	public void verify()
	{
		System.setProperty("webdriver.chrome.driver", "I:\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.nl/maps");
		driver.manage().window().maximize();
		
		 driver.findElement(By.xpath("//input[@id='searchboxinput']")).sendKeys("London UK");
		  driver.findElement(By.xpath("//button[@id='searchbox-searchbutton']")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//span[.='View more hotels']")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[1]/div[1]/div[1]/div[2]/span/span[1]")).click();  
		 
				 // driver.findElement(By.xpath("//span[@class='widget-pane-date-picker-label'][.='Tue, Sep 22']")).click();  
				  while(!driver.findElement(By.cssSelector("[class='goog-popupdatepicker goog-date-picker'] [class='goog-date-picker-monthyear']")).getText().contains("November 2020"))
					{
					  
					 
					 driver.findElement(By.cssSelector("[class='goog-popupdatepicker goog-date-picker'] [class='goog-date-picker-btn goog-date-picker-nextMonth']")).click();	  
				    }
				  List<WebElement> date=driver.findElements(By.className("goog-date-picker-date"));
				  int count =date.size();
				  System.out.println("count = "+count);
				  for(int i=0;i<=count;i++)
				  {
					  String days=driver.findElements(By.className("goog-date-picker-date")).get(i).getText();
					  if(days.equals("7"))
					  {
						  
						  driver.findElements(By.className("goog-date-picker-date")).get(i).click();
					  }
					  
				  }
				
				
		
	}

}
