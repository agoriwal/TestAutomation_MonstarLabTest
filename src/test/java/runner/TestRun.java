package runner;

import base.DriverHandler;
import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.*;
import utils.ConfigFileReader;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/VerifyCarouselOnHomepage.feature"}
                , glue = {"steps"}
                , tags = "@test123"
                , monochrome = true
                , plugin = {"pretty","json:target/cucumber-json/cucumber.json","html:target/cucumber-json/cucumber.html"}
//                , plugin = {"pretty","html:target/cucumber-json/cucumber.html"}
//                , plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRun {

    //to implement extent report
//    @BeforeClass
//    public static void initExtentReport() {
//
//    }
//
//    @AfterClass
//    public static void writeExtentReport () {
//        try {
//            Reporter.loadXMLConfig(ConfigFileReader.getInstance().getReportConfigPath());
//            Reporter.setSystemInfo("user", System.getProperty("user.name"));
//            Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//            Reporter.setSystemInfo("Machine", "Windows");
//            Reporter.setSystemInfo("Selenium", "3.141.59");
//            Reporter.setSystemInfo("Maven", "3.9.3");
//            Reporter.setSystemInfo("Java Version", "20");
//            Reporter.setTestRunnerOutput("Sample test runner output message");
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//   }
//
//   //Annotation to allow closing the browser at the end
//   @AfterSuite
//       public static void tearDown() {
//       DriverHandler.GetInstanceDriverHandler().TearDown();
//     }


}