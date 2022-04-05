package uk.nhs.nhsbsa.services.cucumber;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import uk.nhs.nhsbsa.services.propertyreader.PropertyReader;
import uk.nhs.nhsbsa.services.utility.Utility;

import java.io.IOException;

public class Hooks extends Utility {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Kajal");
    }
    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            String screenShotPath = Utility.getScreenshot(driver,scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }
}
