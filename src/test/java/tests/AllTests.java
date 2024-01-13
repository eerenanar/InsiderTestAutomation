package tests;

import org.testng.annotations.Test;

import LoggerPackage.Logs;
import pages.*;
import utilities.ConfigReader;
import utilities.Helpers;

import static org.testng.AssertJUnit.*;

import org.testng.Assert;

public class AllTests extends BaseTest {
    HomePage homePage = new HomePage();
    CareerPage careersPage = new CareerPage();
    PositionPage openPositionsPage = new PositionPage();
    Logs loggers = new Logs();
    String HomePageTitle = ConfigReader.getProperty("HomePageTitle");
    String LocationName = ConfigReader.getProperty("LocationName");
    String DepartmentName = ConfigReader.getProperty("DepartmentName");
    String PositionName = ConfigReader.getProperty("PositionName");
    String PreviousUrl = ConfigReader.getProperty("PreviousUrl");
    String QaUrl = ConfigReader.getProperty("QaUrl");


    @Test
    public void AllTestCase() throws InterruptedException {
        assertEquals(driver.getTitle(), HomePageTitle);
        loggers.info(driver.getTitle()+" =" +HomePageTitle+ " / Key Value matched ");
        homePage.clickToCareerBtn();
        Thread.sleep(5000);
        careersPage.careersPage.isDisplayed();
        loggers.info(careersPage.careersPage +" Displayed ");
        careersPage.ourLocation.isDisplayed();
        loggers.info("Our Location Title Displayed ");
        careersPage.allTeamsBlocks.isDisplayed();
        loggers.info("All Teams Blocks Title Displayed ");
        careersPage.lifeAtInsider.isDisplayed();
        loggers.info("Life at Insider Title Displayed ");
        careersPage.clickQaBtn();
        loggers.info( "QA button clicked ");
        assertEquals(QaUrl, driver.getCurrentUrl());
        loggers.info( "Quality Assurance Page opened");
        openPositionsPage.clickSeeAllJobsBtn();
        loggers.info( "See All Jobs Button clicked ");
        openPositionsPage.clickLocations(LocationName);
        loggers.info( "clickLocations ");
        Assert.assertTrue(openPositionsPage.positionTitle(2).contains(PositionName));
        loggers.info(openPositionsPage.positionTitle(2) +" =" +PositionName+ " / Key Value matched ");
        assertEquals(LocationName, openPositionsPage.locationTitle(2));
        loggers.info(openPositionsPage.locationTitle(2) +" = " +LocationName+ " / Key Value matched ");
        assertEquals(DepartmentName, openPositionsPage.departmanTitle(2));
        loggers.info(openPositionsPage.departmanTitle(2) +" = " +DepartmentName+ " / Key Value matched ");       
        openPositionsPage.selectPosition();
        Helpers.switchToWindow(1);
        driver.getCurrentUrl().contains(PreviousUrl);
    }
}