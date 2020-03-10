package runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.vimalselvam.cucumber.listener.Reporter;


@RunWith(Cucumber.class)
@CucumberOptions(
		features 			= {"src/test/resources/features" }, 
		monochrome = true,
		plugin 				= {
				"pretty",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/report.html"
		},

		glue 				= {"stepDefinitions"}
		)
public class TestRunnerJUnit {

	@AfterClass
	public static void setup() {
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}