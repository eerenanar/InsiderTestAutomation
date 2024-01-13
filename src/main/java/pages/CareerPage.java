package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Helpers;

public class CareerPage extends BasePage {

   // @FindBy(id = "page-head")
    @FindBy(xpath = "//router[contains(@class,'career-page')]")
    public WebElement careersPage;
    
    @FindBy(xpath = "//*[text()='See all teams']")
    public WebElement seeAllTeamsButton;

    @FindBy(id = "career-find-our-calling")
    public WebElement allTeamsBlocks;

    @FindBy(id = "career-our-location")
    public WebElement ourLocation;

    @FindBy(xpath = "//*[text()='Life at Insider']")
    public WebElement lifeAtInsider;

    @FindBy(xpath = "//*[text()='Quality Assurance']")
    public WebElement qualityAssuranceBtn;

    public void clickQaBtn() throws InterruptedException {
    	
        Helpers.clickWithJavascript(seeAllTeamsButton);        
        Helpers.clickWithJavascript(qualityAssuranceBtn);
        Thread.sleep(2000);
    }
}