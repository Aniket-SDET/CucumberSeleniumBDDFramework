package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/aniket/workspace_old/BDD_Cucumber_Project/src/main/java/features/Multiscenario.feature",
		glue = {"stepDefinitions"},
		plugin = {"pretty","html:target/test-output.html"},
		monochrome = true,
		dryRun = true
		)

public class MultiscenarioTestRunner {


	
}
