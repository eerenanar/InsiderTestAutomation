package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {



    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public static String getScreenshot(String name) throws IOException {
		// naming the screenshot with the current date to avoid duplication
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// TakesScreenshot is an interface of selenium that takes the screenshot
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		// full path to the screenshot location
		String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
		File finalDestination = new File(target);
		// save the screenshot to the path given
		FileUtils.copyFile(source, finalDestination);
		return target;
	}


}