package com.date.mainmathod;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalendarDateDropdown {
	public static WebDriver dr;

	public static void main(String[] args) throws InterruptedException {

		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait myWait = new WebDriverWait(dr, 1000);
		dr.get("https://www.cleartrip.com/");
		
		//CalendarDateDropdown.findFutureDate("may", "20");
		 CalendarDateDropdown.findCurrentDate();
		// CalendarDateDropdown.findPastDate("june", "23");
		CalendarDateDropdown.findFutureDateNext("March", "25");
		CalendarDateDropdown.fromWhereTo("Mumbai", "Dhaka");
		CalendarDateDropdown.clickOnAdults();
		CalendarDateDropdown.clickOnChildren();
		CalendarDateDropdown.clickOnInfants();
		// Thread.sleep(60000);
		// dr.close();

	}
	public static void fromWhereTo(String from, String to) {
		dr.findElement(By.id("FromTag")).sendKeys(from);
		dr.findElement(By.id("ToTag")).sendKeys(to);
	}

	public static void findFutureDate(String m, String d) {
		dr.findElement(By.xpath("//input[@id=\"RoundTrip\"]")).click();// click on RoundTrip
		dr.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);

		for (int i = currentMonth; i >= 1; i++) {
			dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();// next arrow
			String mon = dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
			if (mon.equalsIgnoreCase(m)) {
				dr.findElement(By.linkText(d)).click();
				break;

			}

		}
	}

	public static void findFutureDateNext(String m, String d) throws InterruptedException {
		dr.findElement(By.xpath("//*[@id=\"ReturnDateContainer\"]/dd/div/a/i")).click();// click Calendar
		// dr.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);

		for (int i = currentMonth; i >= 1; i++) {
			dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();// next arrow
			String mon = dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
			if (mon.equalsIgnoreCase(m)) {
				Thread.sleep(2000);
				dr.findElement(By.linkText(d)).click();
				Thread.sleep(7000);
				break;

			}

		}
	}

	public static void findCurrentDate() throws InterruptedException {

		dr.findElement(By.xpath("//input[@id=\"RoundTrip\"]")).click();// click on RoundTrip
		dr.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);
		String cm = String.valueOf(currentMonth);
		int da = cal.get(Calendar.DATE);
		String dat = String.valueOf(da);
		dr.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		Thread.sleep(5000);
		dr.findElement(By.linkText(dat)).click();

	}

	public static void findPastDate(String m, String d) throws InterruptedException {
		dr.findElement(By.xpath("//input[@id=\"RoundTrip\"]")).click();// click on RoundTrip
		dr.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);

		for (int i = currentMonth; i >= 1; i--) {
			Thread.sleep(2000);
			dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();// next arrow
			String mon = dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
			if (mon.equalsIgnoreCase(m)) {
				Thread.sleep(2000);
				dr.findElement(By.linkText(d)).click();
				break;

			}

		}
	}

	public static void clickOnAdults() {

		Select dropdown = new Select(dr.findElement(By.xpath("//select[@id=\"Adults\"]")));

		System.out.println("Adult size   \n= " + dropdown.getOptions().size());

		List<WebElement> options = dropdown.getOptions();
		for (WebElement e : options) {
			String p = e.getText();
			System.out.println(p);

		}
		dropdown.selectByVisibleText("3");

	}

	public static void clickOnChildren() {

		Select dropdown = new Select(dr.findElement(By.xpath("//select[@id=\"Childrens\"]")));

		System.out.println("Children size   \n= " + dropdown.getOptions().size());

		List<WebElement> options = dropdown.getOptions();
		for (WebElement e : options) {
			String p = e.getText();
			System.out.println(p);

		}
		dropdown.selectByVisibleText("2");

	}

	public static void clickOnInfants() {

		Select dropdown = new Select(dr.findElement(By.xpath("//select[@id=\"Infants\"]")));

		System.out.println("Children size   \n= " + dropdown.getOptions().size());

		List<WebElement> options = dropdown.getOptions();
		for (WebElement e : options) {
			String p = e.getText();
			System.out.println(p);

		}
		dropdown.selectByVisibleText("1");

		dr.findElement(By.id("SearchBtn")).click();

	}

	
}
