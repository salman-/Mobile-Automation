package stepDefinitions;

import services.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks extends Driver {

    Driver driver;

    public Hooks(Driver driver) {
        this.driver = driver;
    }

    public Hooks() {}

    @Before
    public void testInitializer() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "SM-G950F");
        cap.setCapability("udid","ce031713c0cce4750d");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","9");

        cap.setCapability("appPackage","com.gohidoc.cara");
        cap.setCapability("appActivity","com.gohidoc.cara.MainActivity");

        AppiumDriver<MobileElement> dr = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        driver.setDriver(dr);

    }


    @After
    public void tearDownTest(Scenario scenario){

        driver.closeTheApp();
    }

}
