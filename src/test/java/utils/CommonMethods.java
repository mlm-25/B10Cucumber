package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;

    public void  openBrowser() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickAbility(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickMethod(WebElement element){
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    //class 4 methods
    //to take screenshot
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName+" "
                    + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }

    public static String getTimeStamp (String pattern){
        Date date = new Date();
        // pattern YYYY-MM-DD-HH-MM-SS-MS
        // to format the date according to our choice we have a function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public void calenderMethod(WebElement element, WebElement monthElement, List<WebElement> dayElements, String month, String day) {
        element.click();

        Select select = new Select(monthElement);
        select.selectByVisibleText(month);

        for (WebElement dayElement : dayElements) {
            if (dayElement.getText().equals(day)) {
                dayElement.click();
                break;
            }
        }

    }

    public void tearDown(){
        driver.quit();
    }
}
