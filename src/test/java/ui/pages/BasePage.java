package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        this.js = js;
    }

    /**
     * Metoda sprawdza, czy dana strona zostala załadowana
     */
    protected abstract void isPageLoaded();

    /**
     * Sprawdza, czy wyświetla się komunikat o plikach cookie i jeżeli tak, to klika "Zaakceptuj"
     */
    protected void acceptCookie(){
        try {
            wait.until(webDriver -> webDriver.findElement(By.cssSelector(".class")).isDisplayed());
            driver.findElement(By.cssSelector("")).click();
        } catch (Exception ignored){}
    }

    /**
     * Otwiera w przeglądarce podane adres url
     * @param url adres strony www
     */
    public void OpenUrl(String url){
        driver.get(url);
    }
}
