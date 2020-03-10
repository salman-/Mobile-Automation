package pageObjects;

import services.Driver;
import lombok.Data;

@Data
public class MasterPage {

    Driver driver;
    String nextButton = "//android.widget.TextView[@text='Next']";

    public  void clickOnNext(){
        driver.waitForTheElement(nextButton);
        driver.click(nextButton);
    }
}
