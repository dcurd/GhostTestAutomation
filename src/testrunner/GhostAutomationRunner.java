package testrunner;

import metatests.AnalyzeMyTest;
import metatests.MyTest;
import utilities.TestAutomationGlobalInit;

public class GhostAutomationRunner {
	TestAutomationGlobalInit globalInit= TestAutomationGlobalInit.getInstance();
	MyTest test= new MyTest();
	AnalyzeMyTest analyze= new AnalyzeMyTest();
	public GhostAutomationRunner() {
		
	}
	
	public void RunAndAnalyze(){
		test.run();
		analyze.run();
	}

	public static void main(String[] args) {
		GhostAutomationRunner runner = new GhostAutomationRunner();
		runner.RunAndAnalyze();

	}

}
