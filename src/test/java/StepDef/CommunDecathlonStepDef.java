package StepDef;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Helper.Config;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class CommunDecathlonStepDef {

	@After
	public void tearDown (Scenario sc) {
		if (sc.isFailed()) {
		File screenShotSource = ((TakesScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
		String x = sc.getName();
		
		File screenshotdestination = new File("C:\\Users\\HP\\eclipse-workspace\\Decathlon\\"+x+".png");
		
		try {
			FileUtils.copyFile(screenShotSource, screenshotdestination);
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	}
}
