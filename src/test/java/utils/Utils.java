package utils;
import base.DriverHandler;
import com.google.common.base.Function;
import interfaces.iConfigReader;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class Utils {
    WebDriver driver;
    ArrayList<String> list = new ArrayList();
    int noOfElements = 0;

    ConfigFileReader configFileReader = new ConfigFileReader();

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator){
        try{
            driver.findElement(locator).click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //Verify element is displayed
    public boolean isElementPresent(By by){
        boolean bflag = false;
        try{
            WebElement element = driver.findElement(by);
            bflag = element.isDisplayed();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bflag;
    }

    public void elementClick(By by){
        try{
            WebElement element = driver.findElement(by);
            if(element.isDisplayed()){
                element.click();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void ClickIfElementPresent(By by){
        boolean bflag = false;
        try{
            WebElement element = driver.findElement(by);
            if(element.isDisplayed()){
                element.click();
                bflag=true;
            }
            else{
                bflag=true;
            }
            Assert.assertTrue(bflag);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void scrollToElement(WebElement elm){
        try{
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elm);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int sizeOfList(By by){
        int elementsSize = 0;
        try{
            List <WebElement> elements = driver.findElements(by);
            elementsSize = elements.size();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return elementsSize;
    }

    public int CheckDuplicateRecordsInList(List<String> elementList){
        int setSize=0;
        try{
            Set<String> sElement = new HashSet<>(elementList);
            setSize = sElement.size();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return setSize;
    }

    public void waitTillVisibilityOfElm(By by){
        try{
            WebDriverWait wait = new WebDriverWait(driver,configFileReader.getExplicitWait());
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitForTheElement(By by, String sCarouselname) {
        try {
            FluentWait wait = new FluentWait(driver);
            wait.withTimeout(configFileReader.getFluentWaitTimeOut(), TimeUnit.SECONDS);
            wait.pollingEvery(configFileReader.getFluentWaitPollingTime(), TimeUnit.SECONDS);
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            wait.ignoring(StaleElementReferenceException.class);
            wait.until(new Function<WebDriver, WebElement>()
//            WebElement elementTo = (WebElement) wait.until(new Function<WebDriver, WebElement>()
            {
                public WebElement apply(WebDriver driver)
                {
                    WebElement ele = driver.findElement(by);
                    String value = ele.getText().trim();
                    if(value.equalsIgnoreCase(sCarouselname))
                    {
                        return ele;
                    }
                    else{
                        scrollToElement(ele);
                        return null;
                    }
                }
            });
        }
        catch(Exception e){
                e.printStackTrace();
            }
    }
}
