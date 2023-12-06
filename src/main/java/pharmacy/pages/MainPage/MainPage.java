package pharmacy.pages.MainPage;

import common.CommonPage;
import common.Log;
import org.openqa.selenium.WebDriver;

public class MainPage extends CommonPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private String searchField = "//*[@id='search']";
    private String submitButton = "//*[@class='relative']//*[@type='submit']";
    private String qtyOfFoundedProducts = "//*[@id='toolbar-amount']";
    private String acceptCookie = "//*[@data-role='action'][1]";


    public void clickSubmitButton() {
        selenium.click(submitButton);
    }

    public void closeCookiesMessageIfVisible(){
        if(selenium.isElementVisible(acceptCookie)){
            selenium.click(acceptCookie);
        }
    }

    public void fillSearchField(String value){
        selenium.click(searchField);
        selenium.sendKeys(searchField, value);
    }

    public void openEntryPoint(){
        selenium.openPage("https://galen.bg");
    }

    public void checkLeftLocator() {
        String text = selenium.getTextFromLeftLocator("select", qtyOfFoundedProducts);
        Log.info("Left element from " + qtyOfFoundedProducts + " is '" + text + "'");
    }

    public void checkRightLocator() {
        String text = selenium.getTextFromRightLocator("label", qtyOfFoundedProducts);
        Log.info("Right element from " + qtyOfFoundedProducts + " is '" + text + "'");
    }

    public void checkAboveLocator() {
        String text = selenium.getTextFromAboveLocator("h1", qtyOfFoundedProducts);
        Log.info("Above element from " + qtyOfFoundedProducts + " is '" + text + "'");
    }

    public void checkBelowLocator() {
        String text = selenium.getTextFromBelowLocator("span", qtyOfFoundedProducts);
        Log.info("Below element from " + qtyOfFoundedProducts + " is '" + text + "'");
    }

    public void checkNearLocator() {
        String text = selenium.getTextFromNearLocator("select", qtyOfFoundedProducts);
        Log.info("Near element from " + qtyOfFoundedProducts + " is '" + text + "'");
    }

}
