package ui.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

public class TestListener implements ITestListener {

//    /**
//     * Zwraca nazwę testowej metody
//     * @param testResult
//     * @return
//     */
//    private static String getTestMethodName(ITestListener testResult){
//        return testResult;
//    }

    @Override
    public void onTestStart(ITestResult result){
        ITestListener.super.onTestStart(result);
        System.out.println("Test started. Test method: " + result.getName() + " Browser: " + DriverFactory.getDriver());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ITestListener.super.onTestSuccess(result);
        System.out.println("Test success. Test method " + result.getName() + " Browser: " + DriverFactory.getDriver());
    }

    @Override
    public void onTestFailure(ITestResult result){
        WebDriver driver = DriverFactory.getDriver();
        System.out.println("Test failed. Test method: " + result.getName() + " Browser: " + driver);
        if(DriverFactory.getDriver() != null){
            saveFailureScreenShot(driver);
        }
    }

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
