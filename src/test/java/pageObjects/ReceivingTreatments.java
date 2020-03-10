package pageObjects;

import services.Driver;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ReceivingTreatments extends MasterPage {

    String yesButton = "//android.widget.TextView[@text='Yes']";
    String noButton  = "//android.widget.TextView[@text='No']";

    public ReceivingTreatments(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(noButton);
    }

    public void clickOnButton(String isReceviingTreatment){
        if(isReceviingTreatment.equals("Yes"))
            driver.click(yesButton);
        else
            driver.click(noButton);
        LOGGER.info("Receiving Treatment: "+isReceviingTreatment);
    }

}
