package pageObjects;

import services.Driver;


public class WhatIsYourNamePage extends  MasterPage{


    String nameElement = "//android.widget.EditText[@text='Your name or pseudonym']";


    public WhatIsYourNamePage(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(nameElement);
    }

    public void writeAge(String name){
        driver.insertText(name,nameElement);
    }




}
