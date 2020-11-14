package com.resources.udemy;
//                         (WebElement ele)  verifyHomePage
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class Shared {
	

	WebDriver dr;
	public Shared() {
		this.dr=dr;
		
	}

	public void myClick(WebDriver dr, String xpath) {

		dr.findElement(By.xpath(xpath)).click();

	}

	public void myClick(WebElement ele) { 

		ele.click();

	}

	public void myClick(WebDriver dr, By by) {

		dr.findElement(by).click();

	}

	public void sendKey(WebDriver dr, String xpath, String value) {

		dr.findElement(By.xpath(xpath)).sendKeys(value);

	}

	public void sendKey(WebElement ele, String value) {

		ele.sendKeys(value);

	}

	public void sendKey(WebDriver dr, By by, String value) {

		dr.findElement(by).sendKeys(value);

	}

	public void verifyTitle(WebDriver dr, String exTitle) {
		String expectedTitle = exTitle;
		String actualTitle = dr.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	public void verifyHomePage(WebDriver dr, By by) {

		boolean b = dr.findElement(by).isDisplayed();

		Assert.assertTrue(b);
	}

}
