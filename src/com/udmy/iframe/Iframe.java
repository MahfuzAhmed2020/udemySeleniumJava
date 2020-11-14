package com.udmy.iframe;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe {

	public class Browser {

		public WebDriver dr;
		
		

		@Test
		public void openBrowser() throws InterruptedException {
			String m="2";
			String D="25";

			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait myWait = new WebDriverWait(dr, 1000);
			//dr.get("https://demo.automationtesting.in/frames.html");
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
			if (mon.equalsIgnoreCase("2")) {
				dr.findElement(By.linkText("22")).click();
				break;
			}
			
			}
			

		}

		@AfterMethod
		public void closeB() {

			//dr.quit();
		}

	}
}
