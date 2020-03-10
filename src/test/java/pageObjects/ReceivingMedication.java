package pageObjects;

import services.Driver;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ReceivingMedication extends MasterPage {

    String yesButton = "//android.widget.TextView[@text='Yes']";
    String noButton  = "//android.widget.TextView[@text='No']";

    public ReceivingMedication(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(noButton);
    }

    public void clickOnButton(String isReceviingMedications){
        if(isReceviingMedications.equals("Yes"))
            driver.click(yesButton);
        else
            driver.click(noButton);
        LOGGER.info("Receiving Medications: "+isReceviingMedications);
    }

}
