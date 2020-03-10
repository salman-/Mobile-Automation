package pageObjects;

import services.Driver;

import static org.junit.Assert.assertTrue;

public class Dashboard  extends MasterPage {

    String dashboard = "//android.widget.TextView[@text='Dashboard']";

    public Dashboard(Driver driver){
        this.driver = driver;
        this.driver.waitForTheElement(dashboard);
    }

    public void findDashboard(){
        assertTrue(driver.DoesElementExist(dashboard));
    }

}
