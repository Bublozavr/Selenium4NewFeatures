package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumWrapper {

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void openPage(String url){
        Log.info("Open page '" + url + "'");
        driver.get(url);
    }

    public void sendKeys(String xpath, String value){
        Log.info("Set value '" + value + "' to element with xpath '" + xpath + "'");
        waitVisibilityOfElement(xpath, 5);
        waitElementClickable(xpath, 5);
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void click(String xpath){
        Log.info("Click to element with xpath '" + xpath + "'");
        waitVisibilityOfElement(xpath, 5);
        waitElementClickable(xpath, 5);
        driver.findElement(By.xpath(xpath)).click();
    }

    private void waitVisibilityOfElement(String xpath, int sec){
        Log.info("Wait element '" + xpath + "' is visible for " + sec + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public boolean isElementVisible(String xpath) {
        Log.info("Check is element present and visible");
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        if(elements.isEmpty()){
            return false; //not present
        } else {
            return elements.get(0).isDisplayed();
        }
    }
    private void waitElementClickable(String xpath, int sec){
        Log.info("Wait element '" + xpath + "' is clickable for " + sec + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public String getTextFromLeftLocator(String tagName, String xpath){
        Log.info("Get text from tag '" + tagName + "' in left side from '" + xpath + "'");
        return driver.findElement(RelativeLocator.with(By.tagName(tagName)).toLeftOf(By.xpath(xpath))).getText();
    }

    public String getTextFromRightLocator(String tagName, String xpath){
        Log.info("Get text from tag '" + tagName + "' in right side from '" + xpath + "'");
        return driver.findElement(RelativeLocator.with(By.tagName(tagName)).toRightOf(By.xpath(xpath))).getText();
    }
    public String getTextFromAboveLocator(String tagName, String xpath){
        Log.info("Get text from tag '" + tagName + "' above from '" + xpath + "'");
        return driver.findElement(RelativeLocator.with(By.tagName(tagName)).above(By.xpath(xpath))).getText();
    }
    public String getTextFromBelowLocator(String tagName, String xpath){
        Log.info("Get text from tag '" + tagName + "' below side from '" + xpath + "'");
        return driver.findElement(RelativeLocator.with(By.tagName(tagName)).below(By.xpath(xpath))).getText();
    }
    public String getTextFromNearLocator(String tagName, String xpath){
        Log.info("Get text from tag '" + tagName + "' near '" + xpath + "'");
        return driver.findElement(RelativeLocator.with(By.tagName(tagName)).near(By.xpath(xpath))).getText();
    }
}
