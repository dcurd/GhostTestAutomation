package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import utilities.TestAutomationGlobalInit;

public class EditPost extends TestAgent {
	
	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	public EditPost() {
		// TODO Auto-generated constructor stub
	}
	
	public void Edit(WebDriver driver, String testname){
		try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys("HI");		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
		}catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	
	public void EditHtml(WebDriver driver, String testname){
		try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys(init.GetHtml());		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
	}catch(WebDriverException e){
		e.printStackTrace();
	}
	}
	
	public void EditImage(WebDriver driver, String testname){
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
		}catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	
	public void EditMarkup(WebDriver driver, String testname){
	try{
		this.driver=driver;
		this.driver.findElement(By.cssSelector("textarea")).clear();
		this.driver.findElement(By.cssSelector("textarea")).click();
		this.driver.findElement(By.cssSelector("textarea")).sendKeys("HI");		
		this.driver.findElement(By.cssSelector(".btn.btn-sm.js-publish-button.btn-blue.ember-view")).click();
	}catch(WebDriverException e){
		e.printStackTrace();
	}
	}

}
