package services;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    AppiumDriver<MobileElement> driver;

    public void setDriver( AppiumDriver<MobileElement> driver ) { this.driver = driver; }

    public void click(String xPath) {
        driver.findElementByXPath(xPath).click();
    }

    public void waitForTheElement(String element){
        WebDriverWait wait= new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void closeTheApp() {
        driver.closeApp();
    }

    public void insertText(String text,String xPath) {
        driver.findElementByXPath(xPath).sendKeys(text);
    }

    public Boolean DoesElementExist(String xPathElement) {
        return driver.findElementsByXPath(xPathElement).size() > 0 ? true : false;
    }
}
