package com.date.udmy;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.browser.udemy.Browser;

public class DateDemo extends Browser{
	
	public WebDriver dr;
	
	

	@Test
	public void openBrowser(){
		String d="10";
		String m="JuLY";
	
		
		dr.get("https://www.cleartrip.com/");
		dr.findElement(By.xpath("//input[@id=\"RoundTrip\"]")).click();//click on RoundTrip
		
		
		dr.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		Calendar cal= Calendar.getInstance();
		int currentMonth=cal.get(Calendar.MONTH);
		//String date=String.valueOf(d);
		//dr.findElement(By.linkText(date)).click();//for Current Date
		
		for(int i=currentMonth;i>=1;i++) {
			dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();//next arrow
			String mon=dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div/span[1]")).getText();
		if (mon.equalsIgnoreCase(m)) {
			dr.findElement(By.linkText(d)).click();
			break;
		}
		
		}
		

	}



}
