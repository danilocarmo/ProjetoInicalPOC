package br.com.StepDefinition;



import java.io.File;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.Utils.Driver;
import br.com.Utils.MontaEvidencia;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class CucumberHooks {

	
	@After
	public void afterScenario(Scenario scenario) {
		Driver.scenario = scenario;
		
		
		if (Driver.scenario.isFailed()) {
			
			String screenshotName =  scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = MontaEvidencia.getScreenshot();
				
				Driver.destinationPath = new File(System.getProperty("user.dir") + "/cucumber-reports/" + screenshotName + ".png");
				Files.copy(sourcePath, Driver.destinationPath); 
				
				Reporter.addScreenCaptureFromPath(Driver.destinationPath.toString());
			} catch (Exception e) {

			}

		}

	}

}
