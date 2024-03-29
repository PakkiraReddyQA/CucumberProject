 package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		
		features=".//features/vTigerApp.feature",
		glue="stepDefiniations",
		dryRun = false,// Test Definitions will Execute if FALSE   Else True It will show steps in console
		monochrome=true,//Remove unneccssary comments
//		plugin= {"pretty","html:target/cucumber-reports/Reports.html"}//For HTML Reports
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
//		tags= "regression"

	    
		)

public class TestRunnerTest {
	
	
}
