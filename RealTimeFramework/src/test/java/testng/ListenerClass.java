package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{
	// this class has to override all the abstract methods of ITestListener interface

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart results are: " + result.getName());
		//getName() method gets the method name of that test()
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSucess results are: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure results are: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped results are: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage results are: " + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout results are: " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart results are: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish results are: " + context.getName());
	}
	
	
	
	
	
	
	
}
