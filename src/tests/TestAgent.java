package tests;

public class TestAgent {

	public TestAgent() {
		// TODO Auto-generated constructor stub
	}
	
	public void Sleep(long value){
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
