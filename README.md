# Cara Android Mobile-Automation

This project automate the [Cara Android Application](https://play.google.com/store/apps/details?id=com.gohidoc.cara). 

------
#### Pre-requsit to run the test

1. Install [Lombok 1.18.2](https://projectlombok.org/) 
2. Install `Cucumber Eclipse plugin` on your `Eclipse` or the alternative for `Intellij`
3. Install [Cara Android Application](https://play.google.com/store/apps/details?id=com.gohidoc.cara)
4. Run Appium server using `Appium Desktop` or by `Appium` command
5. Run `adb devices` over the command line and get the `uuid`, then write the `uuid`  

#### How to Run
There are two different ways to run the test:

1. From `src/test/resources` open the `*.feature`. Right click on it, `Run as > Cucumber feature` 
This approach does not generate any report

2. From `src/test/java/runner` open the `TestRunnerJUnit` class. Right click on it, `Run as > JUnit test` 
This approach generates an HTML report in the **target folder**. 

3. `mvn test`


------
#### Technologies

Technology  | Stack
------------- | -------------
Build Tool  | Maven
Language  | Java 1.8
UI technology  | Selenium / Cucumber / Appium
Test framework  | Junit
Reporting  | [cucumber-extentsreport 3.1.1](https://github.com/email2vimalraj/CucumberExtentReporter)
Manage boilerplate code | [Lombok 1.18.2](https://projectlombok.org/)
IDE | STS 3.9.6.RELEASE

------
#### How code works

Inorder to connect `Hook` to `steps`, we need to use the `cucumber-picocontainer` as dependency:

```{xml}
<dependency>
      <groupId>info.cukes</groupId>
      <artifactId>cucumber-picocontainer</artifactId>
      <version>1.2.5</version>
 </dependency>
```
And then implementation of dependency injection in cucumber and selenium is as below:

The `step` class:  

```{java}
public class *Steps extends Driver{

	Driver driver;


	public *Steps(Driver driver) {

		this.driver = driver;
	}

	public RegisterInsuranceSteps() {}

```

The `Hook` class
```{java}

public class Hooks extends Driver {

    Driver driver;

    public Hooks(Driver driver) {
        this.driver = driver;
    }

    public Hooks() {}

    @Before
    public void testInitializer() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Your-Device-Name");
        cap.setCapability("udid","UUID of Your Device");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","Your Android Version");

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
```

And finally the `Driver` class:

```{java}
public class Driver  {

	//WebDriver driver;
	 AppiumDriver<MobileElement> driver;
}
```
Here is the class diagram of the  `Driver`, `Step` and `Hooks`

![](https://user-images.githubusercontent.com/4312244/76346091-bbccc680-6304-11ea-98d5-4351f86b3322.png)
