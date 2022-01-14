package ui.tests;

import org.testng.annotations.Test;
import ui.pages.HomePage;

public class contactUsTest extends BaseTest {

    @Test
    public void contactUs(){

        new HomePage(driver)
                .openHomePage()
                .goToContactUsSitePage();

    }
}
