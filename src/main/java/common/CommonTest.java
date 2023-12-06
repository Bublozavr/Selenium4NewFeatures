package common;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
import pharmacy.PharmacyAppContainer;


import java.util.HashMap;
import java.util.Map;

public class CommonTest {

    private static Map<String, WebDriver> browsersByThread = new HashMap<>();
    private static Map<String, PharmacyAppContainer> appForThread = new HashMap<>();

    public PharmacyAppContainer app() {
        String thread = Thread.currentThread().getName();
        if (!browsersByThread.containsKey(thread)){
            browsersByThread.put(thread, BrowserSetup.setupBrowser());
        }
        if (!appForThread.containsKey(thread)){
            appForThread.put(thread, new PharmacyAppContainer(browsersByThread.get(thread)));
        }
        return appForThread.get(thread);
    }

    protected DevTools createDevToolsObject(){
        DevTools devTools =((ChromeDriver)app().getDriver()).getDevTools();
        return devTools;
    }

    @AfterMethod
    public void close(){
        browsersByThread.get(Thread.currentThread().getName()).close();
    }
}
