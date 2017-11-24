package tests;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


import utilities.TestAutomationGlobalInit;

public class LogoutOfBlog extends TestAgent {

	
	public LogoutOfBlog() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Logout(WebDriver driver,String testname){
		try{
		this.driver=driver;
		this.driver.get(init.GetSignedInUrl());
		this.driver.navigate().refresh();
		Sleep(2000);
		this.driver.findElement(By.cssSelector(".gh-nav-menu.ember-view.closed")).click();
		this.driver.findElement(By.xpath("//a[@href='/ghost/signout/']")).click();
		Sleep(2000);
		return RegisterResult(driver.getCurrentUrl().contains(init.GetSignInUrl()),testname);
		
		}catch(WebDriverException e){
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
