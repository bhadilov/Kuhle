package test;

import com.thoughtworks.selenium.*;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class example {
	
	private WebDriver driver;

	SeleniumTest sel = new SeleniumTest();
	
	@Before
	public void openBrowser(){
		driver  = new FirefoxDriver();
		driver.get("http://hrm.seleniumminutes.com");

	}
	@Test
	public void testWebsite(){
		Assert.assertEquals("Verify Title", driver.getTitle(), "OrangeHRM");
		login();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());	
		
	}
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();
		Utility.captureScreenshot(driver, "say cheeeeeese");
	}

	@After
	public void saveScreenshotAndCloseBrowser() throws IOException{
		//screenshotHelper.sa
		driver.quit();
		
	}
	
}