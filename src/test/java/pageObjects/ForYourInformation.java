package pageObjects;

import services.Driver;

public class ForYourInformation extends MasterPage {

    String oKButton = "//android.widget.TextView[@text='OK']";

    public ForYourInformation(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(oKButton);
    }

    public void clickOnOK(){
        driver.click(oKButton);
    }

}
