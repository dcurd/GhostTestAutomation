package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import utilities.TestAutomationGlobalInit;

public class EditPost extends TestAgent {
	
	public EditPost() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Edit(WebDriver driver, String testname){
		try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys("HI");		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return true;
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean EditHtml(WebDriver driver, String testname){
		try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(init.GetHtml());		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return true;
	}catch(WebDriverException e){
		e.printStackTrace();
		return false;
	}
	}
	
	public boolean EditImage(WebDriver driver, String testname){
		try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector(".post-settings")).click();
		Sleep(1000);
		this.driver.findElement(By.cssSelector(".icon-link")).click();
		this.driver.findElement(By.cssSelector(".url.ember-view.gh-input")).sendKeys(init.GetImage());
		this.driver.findElement(By.cssSelector(".btn.btn-blue.gh-input")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ESCAPE);
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return true;
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean EditMarkup(WebDriver driver, String testname){
	try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys("HI");		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		return true;
	}catch(WebDriverException e){
		e.printStackTrace();
		return false;
	}
	}

}
