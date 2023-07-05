package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigFileReader;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitHelper extends ConfigFileReader {

    private WebDriver driver;

    public WaitHelper(WebDriver driver){
        this.driver = driver;
    }

    public void setImplicitWait(long timeout, TimeUnit unit){
        driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    public void waitForElementVisible(By locator, int timeOutInSeconds){
        setImplicitWait(1, TimeUnit.SECONDS);
        WebDriverWait wait = getWait(timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    private WebDriverWait getWait(int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofSeconds(getExplicitWait()));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait;
    }
}
