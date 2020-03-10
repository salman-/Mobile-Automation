package pageObjects;

import services.Driver;

public class CreatingAccount extends MasterPage {


    String emailEditText  = "//android.widget.EditText[@text='Your email address']";
    String notNow = "//android.widget.TextView[@text='Not now']";

    public CreatingAccount(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(emailEditText);
    }

    public void insertEmail(String email){
        driver.insertText(email,emailEditText);
    }

    public void clickOnNotNow(){
        driver.click(notNow);
    }

}
