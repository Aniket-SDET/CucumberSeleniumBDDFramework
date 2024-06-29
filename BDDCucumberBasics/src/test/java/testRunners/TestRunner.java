package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/aniket/workspace_old/BDD_Cucumber_Project/src/main/java/features/login.feature", //path of feature file
		glue={"stepDefinitions"}, //path of step definition file
		plugin= {"pretty"},
		dryRun = false,
		monochrome = true
		)

public class TestRunner {
	
	

}
