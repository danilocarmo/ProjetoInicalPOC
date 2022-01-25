package br.com.TestRunner;

import br.com.StepDefinition.TestngHooks;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/features",
				 glue = "br.com.StepDefinition",
				 plugin = "com.cucumber.listener.ExtentCucumberFormatter:cucumber-reports/report.html",
				 monochrome = true)

public class _Test extends TestngHooks {

}