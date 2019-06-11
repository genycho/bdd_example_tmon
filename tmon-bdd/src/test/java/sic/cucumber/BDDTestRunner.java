package sic.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		format = {"junit:target/junit.xml","pretty", "html:target/Destination"}, deprecated
		features = "classpath:sic/cucumber/features", 
		plugin = { "pretty", "html:target/cucumber-reports"},//,"junit:target/cucumber-reports/Cucumber.xml"
		monochrome = true)
public class BDDTestRunner {

}
