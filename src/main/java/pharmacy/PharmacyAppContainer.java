package pharmacy;

import org.openqa.selenium.WebDriver;
import pharmacy.pages.MainPage.MainPage;

public class PharmacyAppContainer {

    WebDriver driver;
    public PharmacyAppContainer(WebDriver driver) {
        mainPage = new MainPage(driver);
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }
    public MainPage mainPage;
}
