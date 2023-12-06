package common;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {

    public static ChromeDriver setupBrowser(){

        //paths to drivers (create for others if necessary) for now current is chrome
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "\\Automation\\webdriver\\chromedriver.exe");
        ChromeDriver driver;

        //add chrome options if needed
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
}
