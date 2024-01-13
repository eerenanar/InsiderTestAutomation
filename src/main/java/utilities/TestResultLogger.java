package utilities;


import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import LoggerPackage.Logs;

public class TestResultLogger extends TestListenerAdapter {

    Logs log = new Logs();

    @Override
    public void onTestSuccess(ITestResult result) {
    	String testName = result.getName();
        log.info(testName + "PASSED");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String testFailCause = result.getThrowable().getMessage();
        log.error(testName + "Failed cause" + testFailCause);
    }
}
