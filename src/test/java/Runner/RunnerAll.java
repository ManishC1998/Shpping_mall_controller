package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {".\\src\\test\\java"},
		glue = "StepDefination",
		dryRun= false,
	monochrome = true,
		plugin = {
				"pretty"//"html:target/htmlreport/report.html"
		}
		
		
		)
public class RunnerAll extends AbstractTestNGCucumberTests{

}
