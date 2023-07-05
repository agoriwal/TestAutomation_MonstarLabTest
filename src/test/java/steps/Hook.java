package steps;

import base.DriverHandler;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Hook {

    private WebDriver driver;
    public Scenario scenario;

    public WebDriver getDriver() {
        return DriverHandler.GetInstanceDriverHandler().getDriver();
    }

    //Cucumber hook to Initialise Webdriver
    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("Running Scenario: " + scenario.getName());
        this.scenario = scenario;
        driver = DriverHandler.GetInstanceDriverHandler().getDriver();
    }

    //Cucumber hook to take screenshot if scenario is failed
    @After
    public void CaptureScreenshotIfFailAndCloseBrowser(Scenario scenario) {
        try{
        //Add screenshot
            if (scenario.isFailed()) {
                TakesScreenshot screen = (TakesScreenshot) getDriver();
                byte[] screenshot = screen.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image.png", "page screenshot");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            try {
//                File sourcePath = ((TakesScreenshot) DriverHandler
//                        .GetInstanceDriverHandler().getDriver()).getScreenshotAs(OutputType.FILE);
//
//                File destinationPath = new File(System.getProperty("user.dir") + "/report/screenshots/" + screenshotName + ".png");
//                Files.copy(sourcePath, destinationPath);
//                Reporter.addScreenCaptureFromPath(destinationPath.toString());
//
//            } catch (IOException e) {
//            }
//        }
//    }




