package ui.pages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "div#contact-link > a")
    private WebElement contactUsButton;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void isPageLoaded() {

    }

    /**
     * Otwiera stronę główną sklepu "Automationpractice"
     * @return zwraca wyszukiwarkę
     */
    public HomePage openHomePage(){
        driver.get(Urls.getApUrl());

        return this;
    }

    public SearchEnginePage openHomePageWithRedirectToSearchEngine(){
        driver.get(Urls.getApUrl());

        return new SearchEnginePage(driver);
    }

    /**
     * Otwiera stronę "Contact us"
     */
    public void goToContactUsSitePage(){
        contactUsButton.click();
    }
}
