package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static String remote_url = "http://localhost:4444/wd/hub";

    public static WebDriver initializeDriver(String browserName){
        return getDriver();
    }

    public static WebDriver initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driverThreadLocal.set(new ChromeDriver());
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
