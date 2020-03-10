package pageObjects;

import services.Driver;

public class HowOldAreYouPage extends MasterPage {

    String ageInput = "//android.widget.EditText[@text='Age']";

    public HowOldAreYouPage(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(ageInput);
    }

    public void insertAge(String age){
        driver.insertText(age,ageInput);
    }


}
