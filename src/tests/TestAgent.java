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
	
	public boolean GoToBlogPostPageCss(WebDriver driver,String css,String itemtocheck){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		return this.driver.findElement(By.cssSelector(css)).getText().contains(itemtocheck);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean GoToBlogPostPageCss(WebDriver driver,String css,String image,String itemtocheck){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		return this.driver.findElement(By.cssSelector(css)).getCssValue(image).contains(itemtocheck);
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean GoToBlogPostPageTag(WebDriver driver,String tag,String itemtocheck){
		Sleep(2000);
		try{
		this.driver=driver;
		this.driver.get(init.GetBlogPostUrl());
		return this.driver.findElement(By.tagName(tag)).getText().equals(itemtocheck);
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
