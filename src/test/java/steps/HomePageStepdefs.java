package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePageObject;

public class HomePageStepdefs {
    private HomePageObject homePageObject;
    private WebDriver driver;
    public HomePageStepdefs(Hook hook) throws Exception{
        this.driver = hook.getDriver();
        homePageObject = new HomePageObject(this.driver);
    }

    @Given("I am on mall.cz page")
    public void iAmOnMallCzPage() {
        homePageObject.landOnHomePage();

    }

    @And("^User has navigated to \"([^\"]*)\"$")
    public void userHasNavigatedTo(String arg0) throws Throwable {
            Thread.sleep(5000);
            homePageObject.navigateToCarousel(arg0);
        }


    @And("each carousel {string} should display {int} unique elements")
    public void eachCarouselShouldDisplayUniqueElements(String arg0, int arg1) {
        homePageObject.verifyElementsNameOfCarousel(arg0,arg1);
    }

    @And("the carousel {string} which has less than {int} elements the test case should fail")
    public void theCarouselWhichHasLessThanElementsTheTestCaseShouldFail(String arg0, int arg1) {
        homePageObject.verifytheNumberOfElementsInCarousel(arg0,arg1);
    }

    @Given("the User close the Web Browser")
    public void theUserCloseTheWebBrowser() {
        homePageObject.closeBrowser();
    }
}

