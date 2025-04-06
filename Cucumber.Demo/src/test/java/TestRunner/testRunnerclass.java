package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/demo/Cucumber/Demo",
		glue = "demo.stepDefinations"
		)
public class testRunnerclass {

	
}
