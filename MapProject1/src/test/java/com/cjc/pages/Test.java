package com.cjc.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	WebDriver driver;
	public void check() 
	
	  {
		  System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.google.nl/maps");
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//input[@id='searchboxinput']")).sendKeys("London UK");
		  driver.findElement(By.xpath("//button[@id='searchbox-searchbutton']")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//span[.='View more hotels']")).click();
		  
		  driver.findElement(By.xpath("//span[@class='widget-pane-date-picker-label'][.='Tue, Sep 22']")).click();  
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
		  driver.findElement(By.xpath("//td[@class='goog-date-picker-date goog-date-picker-wkend-end section-date-range-selection-end-date'][.='8']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//button[@class='tuPVDR7ouq5__button gm2-hairline-border section-input-chip-button tuPVDR7ouq5__text-color-google-blue-600 tuPVDR7ouq5__vertical-spacing-less']")).click();
		  driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[4]/div[2]/div[2]")).click();
		  driver.findElement(By.xpath("//input[@id='section-filters-checkbox-id-1']")).click();
		  driver.findElement(By.xpath("//input[@id='section-filters-checkbox-id-7']")).click();
		  driver.findElement(By.xpath("//button[@class='section-header-button section-header-back-button noprint maps-sprite-common-arrow-back-white']")).click();
	/*	  WebElement drop=  driver.findElement(By.xpath("//div[@class='tuPVDR7ouq5__dropdown-icon']"));
		 Select sel =new Select(drop);
		 sel.selectByIndex(1);
	*/
		  
		  driver.findElement(By.xpath("//h3[@class='section-result-title']/span[.='St Martins Lane London, A House Of Originals Hotel']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  JavascriptExecutor js= (JavascriptExecutor)driver;
		  js.executeScript("scrollBy(0,500)");
		 WebElement address= driver.findElement(By.xpath("//div[@class='ugiz4pqJLAG__primary-text gm2-body-2'][.='14 James St, Covent Garden, London WC2E 8BU, United Kingdom']"));
		String add=address.getText();
		System.out.println("Address is ="+ add);
		WebElement mob = driver.findElement(By.xpath("//div[@class='ugiz4pqJLAG__primary-text gm2-body-2'][.='+44 20 7420 5856']"));
		String mo=mob.getText();
		long a= Integer.parseInt(mo);
		System.out.println(a);
		
	  }
	}

	


