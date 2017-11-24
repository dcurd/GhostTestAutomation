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
		List<WebElement>listOfElements=this.driver.findElements(By.cssSelector("header"));
		
		for(WebElement e : listOfElements){
			if(e.getAttribute("role")!=null && e.getAttribute("role").contains("button")){
				e.click();
				Sleep(2000);
				this.driver.findElement(By.xpath("//a[@href='/ghost/signout/']")).click();
				Sleep(2000);
				break;
			}
		}
		}catch(WebDriverException e){
			e.printStackTrace();
		}
		return RegisterResult(driver.getCurrentUrl().contains(init.GetSignInUrl()),testname);
		
		
		
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
