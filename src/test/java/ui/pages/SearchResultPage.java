package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {
    @FindBy(css = "ul.product_list > li .product-name")
    private WebElement[] productsPreviewCards;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        isPageLoaded();
    }

    @Override
    protected void isPageLoaded() {
    try {
        wait.until(driver -> driver.findElement(By.className("lighter")).isDisplayed());
    } catch (Exception e) {
        System.out.println("Strona rezultatów wyszukiwania nie załadowała się poprawnie: " + e);
        }
    }


    /**
     * Sprawdza, czy w wyniku wyszukiwania lista produktów zwraca przedmioty zawierające słowa "Printed" i "Dress"
     * @param productName nazwa wszykanego productu
     * @return
     */
    public boolean getProductsPreviewCards(String productName){
        String productCardPreviewName = null;
        for (WebElement productCardPreview : productsPreviewCards){
            productCardPreviewName = productCardPreview.getText();
            if(productCardPreview.getText().contains("Printed")
                    && productCardPreview.getText().contains("Dress"))

            return true;
        }
        return false;
    }
}
