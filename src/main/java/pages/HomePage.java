package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Helpers;

public class HomePage extends BasePage {
	
	@FindBy(id = "wt-cli-accept-all-btn")
	public WebElement acceptCookieBtn;

    @FindBy(xpath = "//a[contains(text(), 'Company')]")
    public WebElement companyBtn;

    @FindBy(xpath = "//*[text()='Careers']")
    public WebElement careersBtn;

   
    public void clickToCareerBtn() {
    	Helpers.waitForClickablility(acceptCookieBtn,10);
    	acceptCookieBtn.click();
        companyBtn.click();
        careersBtn.click();
    }
}