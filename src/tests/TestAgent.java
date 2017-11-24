package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import utilities.TestAutomationGlobalInit;

public class TestAgent {

	WebDriver driver;
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	public TestAgent() {
	}
	
	
	public void Sleep(long value){
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean GoToBlogPostPageCss(WebDriver driver,String css,String itemtocheck,String testname){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		this.driver.navigate().refresh();
		Sleep(2000);
		return RegisterResult(this.driver.findElement(By.cssSelector(css)).getText().contains(itemtocheck),testname);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean GoToBlogPostPageCssText(WebDriver driver,String css,String value,String itemtocheck,String testname){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		this.driver.navigate().refresh();
		Sleep(2000);
		return RegisterResult(this.driver.findElement(By.cssSelector(css)).getText().contains(itemtocheck),testname);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean GoToBlogPostPageCss(WebDriver driver,String css,String value,String itemtocheck,String testname){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		this.driver.navigate().refresh();
		Sleep(2000);
		return RegisterResult(this.driver.findElement(By.cssSelector(css)).getCssValue(value).contains(itemtocheck),testname);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean GoToBlogPostPageTag(WebDriver driver,String tag,String itemtocheck,String testname){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		this.driver.navigate().refresh();
		return RegisterResult(this.driver.findElement(By.tagName(tag)).getText().equals(itemtocheck),testname);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
		
	}
		
	public void GoToWorkingUrl(WebDriver driver){
		this.driver=driver;
		this.driver.get(init.GetWorkingUrl());
		Sleep(2000);
	}
	
	public boolean RegisterResult(Boolean result, String testname){
		System.out.println(result);
		return init.SetResult(testname, result);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
