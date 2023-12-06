package Selenium4Tests;

import common.CommonTest;
import org.testng.annotations.Test;

public class CheckRelativeLocators extends CommonTest {

    @Test
    public void checkRelativeLocatorsFeature(){
        //open Entry point
        app().mainPage.openEntryPoint();
        //close cookie message
        app().mainPage.closeCookiesMessageIfVisible();
        //fill Pampers name in Search field
        app().mainPage.fillSearchField("Пелени Pampers Premium Care Размер 4");
        //click Submit button
        app().mainPage.clickSubmitButton();
        //check Relative locators: toLeftOf, toRightOf, above, below, near
        app().mainPage.checkLeftLocator();
        app().mainPage.checkRightLocator();
        app().mainPage.checkAboveLocator();
        app().mainPage.checkBelowLocator();
        app().mainPage.checkNearLocator();
    }
}
