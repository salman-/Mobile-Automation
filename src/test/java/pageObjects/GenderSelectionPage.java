package pageObjects;

import services.Driver;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class GenderSelectionPage extends  MasterPage{


    String female = "(//android.widget.ImageView)[2]";
    String others = "(//android.widget.ImageView)[3]";
    String male   = "(//android.widget.ImageView)[4]";

    public GenderSelectionPage(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(male);
    }

    public void clickOnGender(String gender){

        if(gender.equals("Male")){
            this.driver.click(male);
        }else if (gender.equals("Female")){
            this.driver.click(female);
        }else{
            this.driver.click(others);
        }
        LOGGER.info("Gender: "+gender);

    }


}
