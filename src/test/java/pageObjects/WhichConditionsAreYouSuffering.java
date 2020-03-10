package pageObjects;

import services.Driver;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class WhichConditionsAreYouSuffering extends MasterPage{


    String ibs  = "(//android.widget.ImageView)[2]";
    String gerd = "(//android.widget.ImageView)[3]";


    public WhichConditionsAreYouSuffering(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(ibs);
    }

    public void clickOnConditions(String symptom){

        if(symptom.equals("IBS")){
            this.driver.click(ibs);
        }if (symptom.equals("GERD")){
            this.driver.click(gerd);
        }
        LOGGER.info("Symptom: "+symptom);

    }
}
