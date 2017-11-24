package tests;

import org.openqa.selenium.WebDriver;

public class ConfirmBlogIsUp extends TestAgent {

	
	public ConfirmBlogIsUp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean Confirm(WebDriver driver,String testname){
		this.driver=driver;
		driver.get(init.GetRegularUrl());
		return RegisterResult(driver.getTitle().equals("My Automation Blog"),testname);
		
	}

}
