package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class Driver {
    private static WebDriver driver;

    public Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = (System.getProperty("browser"));;
            switch (browser) {
            	case "safari":
            		SafariOptions options = new SafariOptions();
            		options.setCapability("safari:useAutomaticExtension", false);
            	    options.setCapability("safari:automaticInspection", false);
            	    options.setCapability("safari:automaticProfiling", false);
            	    options.setCapability("safari:allowAllDevices", true);
            	    // Disable cookies
            	    options.setCapability("safari:cookies", false);
            	    // Disable extensions
            	    options.setCapability("safari:extension", false);
            		WebDriverManager.safaridriver().setup();
            		driver=new SafariDriver();
            		break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions optionsChrome = new ChromeOptions();
                    optionsChrome.addArguments("--disable-cookies");
                    optionsChrome.addArguments("--disable-extensions");
                    optionsChrome.addArguments("--disable-notifications");

                    driver = new ChromeDriver(optionsChrome);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                
                default:
    				WebDriverManager.safaridriver().setup();
    				driver=new SafariDriver();

            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
