package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEnginePage extends BasePage {

    /**
     * Pole na tekst w wyszukiwarce
     */
    @FindBy(css = "form input.search_query")
    private WebElement searchEngineInput;

    @FindBy(css = ".button-search")
    private WebElement searchButton;

    public SearchEnginePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void isPageLoaded() {
        try {
            wait.until(drive -> searchEngineInput.isEnabled());
        } catch (Exception e){
            System.out.println("Wyszukiwarka nie wyświetliła się poprawnie: " + e);
        }
    }

    /**
     * Wpisuje nazwę przedmiotu i klika w przycisk z ikonką "Lupy" w wyszukiwarce
     * @param itemName nazwa przedmiotu
     * @return stronę z wynikiem wyszukiwania
     */
    @Step("Wyszukaj podany przedmiot przez użytkownika")
    public SearchResultPage searchItem(String itemName){
        searchEngineInput.sendKeys(itemName);
        searchButton.click();

        return new SearchResultPage(driver);
    }
}
