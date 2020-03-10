package pageObjects;

import services.Driver;

public class HowDidYouHearAboutApp extends  MasterPage{

    String playStore = "//android.widget.TextView[@text='Play Store']";
    String onlineAds = "//android.widget.TextView[@text='Online ads']";
    String internetSearch = "//android.widget.TextView[@text='Internet search']";

    public HowDidYouHearAboutApp(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(playStore);
    }


    public void clickOnOption(String option){

        driver.click(playStore);

    }


}
