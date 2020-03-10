package pageObjects;

import services.Driver;
import lombok.Data;

@Data
public class WelcomePage {

    Driver driver;
    String GetStartedButton = "//android.widget.TextView[@text='Get started']";

    public WelcomePage(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(GetStartedButton);
    }

    public void clickOnGetStartedButton(){

        driver.click(GetStartedButton);
    }
}
