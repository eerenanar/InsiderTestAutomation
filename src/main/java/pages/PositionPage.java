package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.Helpers;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class PositionPage extends BasePage {
	JavascriptExecutor jre = (JavascriptExecutor) Driver.getDriver();

	@FindBy(id = "select2-filter-by-location-container")
	public WebElement locationDropdown;

	@FindBy(xpath = "//li[@class='select2-results__option' and text()='Istanbul, Turkey']")
	public WebElement locationElement;

	@FindBy(id = "filter-by-department")
	public WebElement departmentDropdown;

	@FindBy(xpath = "//*[text()='View Role']")
	public List<WebElement> viewRoleBtns;

	@FindBy(xpath = "//span[@class='select2-selection__arrow']")
	public WebElement dropdownArrowBtn;

	@FindBy(xpath = "//*[@data-team='qualityassurance']")
	public List<WebElement> qualityARole;

	@FindBy(xpath = "//*[@id='select2-filter-by-location-results']")
	public List<WebElement> locationResult;

	@FindBy(id = "jobs-list")
	public List<WebElement> jobList;
	
	@FindBy(xpath = "//*[text()='See all QA jobs']")
    public WebElement seeAllJobsBtn;

	@FindBy(css = "span.select2-selection__clear")
	private WebElement clearSelectionElement;

	@FindBy(xpath = "//div[@id='jobs-list']//div[contains(@class, 'position-list-item')]//p[contains(@class, 'position-title')]")
	private List<WebElement> positionTitles;

	@FindBy(xpath = "//div[@id='jobs-list']//div[contains(@class, 'position-list-item')]//span[contains(@class, 'position-department')]")
	private List<WebElement> positionDepartments;

	@FindBy(xpath = "//div[@id='jobs-list']//div[contains(@class, 'position-list-item')]//div[contains(@class, 'position-location')]")
	private List<WebElement> positionLocations;
	
	public WebElement getPositionElement(String location) {

		String dynamicXPath = "//li[@class='select2-results__option' and text()='" + location + "']";
		WebElement locationElement = Driver.getDriver().findElement(By.xpath(dynamicXPath));
		return locationElement;
	}

	public List<WebElement> getPositionTitles() {
		return positionTitles;
	}

	public List<WebElement> getPositionDepartments() {
		return positionDepartments;
	}

	public List<WebElement> getPositionLocations() {
		return positionLocations;
	}

	public String positionTitle(int i) {
		List<WebElement> titles = getPositionTitles();
		String titleText = titles.get(i).getText();
		return titleText;
	}

	public String departmanTitle(int i) {
		List<WebElement> departments = getPositionDepartments();
		String departmentText = departments.get(i).getText();
		return departmentText;
	}

	public String locationTitle(int i) {
		List<WebElement> locations = getPositionLocations();
		String locationText = locations.get(i).getText();
		return locationText;
	}

	public void clickLocations(String location) throws InterruptedException {
		Thread.sleep(1000);
		Helpers.waitForClickablility(locationDropdown, 10).click();
		Helpers.waitForClickablility(getPositionElement(location), 10).click();
		Thread.sleep(2000);

	}
	 public void clickSeeAllJobsBtn() throws InterruptedException{
	        seeAllJobsBtn.click();
	        Thread.sleep(3000);
	    }

	public void selectPosition() {
		Random random = new Random();
		int randomNmbr = random.nextInt(3);
		Helpers.scrollToElement(qualityARole.get(randomNmbr));
		Helpers.clickWithJavascript(viewRoleBtns.get(randomNmbr));
	}

	public void switchToNewTab() {
		Set<String> windowHandles = Driver.getDriver().getWindowHandles();
		Driver.getDriver().switchTo().window(windowHandles.toArray()[1].toString());
	}

}