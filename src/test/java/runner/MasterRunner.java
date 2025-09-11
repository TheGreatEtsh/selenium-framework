package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
		features = { 
		"src/test/java/features/UserRegistration.feature",
		"src/test/java/features/EndToEnd.feature" 
		}, 
		glue = {"steps" }, 
		plugin = { 
				"pretty", 
				"html:target/cucumber-report.html", 
				"json:target/cucumber.json" 
				}
		)
public class MasterRunner extends TestBase {

}
