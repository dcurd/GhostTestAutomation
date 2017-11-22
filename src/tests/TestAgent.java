package tests;

import org.openqa.selenium.WebDriver;

import utilities.TestAutomationGlobalInit;

public class TestAgent {

	WebDriver driver;
	public TestAgent() {
		// TODO Auto-generated constructor stub
	}
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	
	public void Sleep(long value){
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void RegisterResult(Boolean result, String testname){		
		init.AddToResults(testname, result);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
