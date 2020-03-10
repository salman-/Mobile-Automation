package pageObjects;

import services.Driver;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class WhichSymptomsAreYouSuffering extends MasterPage{


    String bloating    = "(//android.widget.ImageView)[2]";
    String stomachPain = "(//android.widget.ImageView)[3]";
    String heartBurn    = "(//android.widget.ImageView)[4]";

    public WhichSymptomsAreYouSuffering(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(bloating);
    }

    public void clickOnSymptom(String symptom){

        if(symptom.equals("Bloating")){
            this.driver.click(bloating);
        }if (symptom.equals("Stomach pain")){
            this.driver.click(stomachPain);
        }if (symptom.equals("Heartburn")){
            this.driver.click(heartBurn);
        }
        LOGGER.info("Receiving symptom: "+symptom);

    }
}
