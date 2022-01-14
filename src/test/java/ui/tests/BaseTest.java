package ui.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ui.utils.DriverFactory;

public class BaseTest {
    public WebDriver driver;
    public SoftAssert softAssert;

    @BeforeSuite
    public void setupTest(){
        // np. miejsce na endpointy
    }

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional String browser){
        if (browser != null) driver = DriverFactory.initializeDriver(browser);
        else {
            driver = DriverFactory.initializeDriver();
        }
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
