package common;

import org.openqa.selenium.WebDriver;

public class CommonPage {

    public CommonPage(WebDriver driver) {
        selenium = new SeleniumWrapper(driver);
    }

    protected SeleniumWrapper selenium;
}
