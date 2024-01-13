package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;
import utilities.Helpers;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(System.getProperty("url"));
        driver.manage().deleteAllCookies();

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            Helpers.getScreenshot(iTestResult.getName());
            System.out.println("Screenshot added.");
        }
        Driver.getDriver().quit();
    }
}