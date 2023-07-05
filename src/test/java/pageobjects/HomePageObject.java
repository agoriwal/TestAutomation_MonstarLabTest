package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigFileReader;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject{
    private WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();
    Utils utils;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
        utils =new Utils(this.driver);
    }
    public By tabCarousels = By.xpath("//div[@class='homepage__container']");
    public By homePageLogo = By.xpath("//div[@class='header__big-logo']");
    public By btnAcceptTerms = By.xpath("//span[contains(text(),'Souhlasím')]");

    //Launch mall.cz
    public void landOnHomePage(){
        System.out.println("Browser has been launched");
        driver.manage().window().maximize();
        driver.get(configFileReader.getWebsite());
        try {
            utils.ClickIfElementPresent(btnAcceptTerms);
            Assert.assertTrue(utils.isElementPresent(homePageLogo));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void navigateToCarousel(String sCarouselname) throws InterruptedException {
        WebElement elm = driver.findElement(By.xpath("//h2[contains(text(),'"+sCarouselname+"')]"));
        Thread.sleep(1000);
        utils.scrollToElement(elm);
        utils.waitForTheElement(By.xpath("//h2[contains(text(),'"+sCarouselname+"')]"),sCarouselname);
    }

    public void verifyElementsNameOfCarousel(String arg0, int arg1){
        String actualNoOfElements = "";
        String expectedNoOfElements = "Each carousel on the homepage, displays 15 or less than 15 elements.";

        String actualResult = "";
        String expectedResult = "Carousel has Unique elements.";

        By by = By.xpath("//h2[contains(text(),'"+ arg0 +"')]/ancestor::div[@class='cms-carousel-b']//article");
        By byName = By.xpath("//h2[contains(text(),'"+ arg0 +"')]/ancestor::div[@class='cms-carousel-b']//article//h3[@class='product-box-simple__body__title']");
        List<String> elementName = new ArrayList<>();
        int sizeOfSet = 0;

        try{

            //Check and verify number of elements in each carousel
            List <WebElement> elements = driver.findElements(by);
            int numberOfCarouselElements = elements.size();
            System.out.println("Number of elements in List : " + numberOfCarouselElements);

            if(numberOfCarouselElements<=15){
                actualNoOfElements = "Each carousel on the homepage, displays 15 or less than 15 elements.";
            }
            else{
                actualNoOfElements = "Each carousel on the homepage, displays 15 or less than 15 elements.";
            }
            Assert.assertEquals(expectedNoOfElements,actualNoOfElements);

            //Find element name in each Carousel for duplicates
                for(int i=1; i<=numberOfCarouselElements;i++){
                    String eName = driver.findElement(By.xpath("(//h2[contains(text(),'"+ arg0 +"')]/ancestor::div[@class='cms-carousel-b']//article//h3[@class='product-box-simple__body__title'])["+i+"]")).getText().trim();
                    elementName.add(eName);
                    Thread.sleep(500);
                    String className = driver.findElement(By.xpath("(//h2[contains(text(),'"+ arg0 +"')]/ancestor::div[@class='cms-carousel-b']//li[@id='NaN'])["+ i +"]")).getAttribute("class").trim();
                    if(!className.contains("hooper-slide is-active")){
                        WebElement btnNext = driver.findElement(By.xpath("//h2[contains(text(),'" + arg0 + "')]/ancestor::div[@class='cms-carousel-b']//button[@class='hooper-next']"));
                        Thread.sleep(500);
                        btnNext.click();
                        Thread.sleep(1000);
                    }
                }
            //Check carousel displays unique records
                sizeOfSet = utils.CheckDuplicateRecordsInList(elementName);
                System.out.println("Number of elements in Set : " + sizeOfSet);
            if(elementName.size()==sizeOfSet){
                actualResult="Carousel has Unique elements.";
            }
            else{
                actualResult="Carousel has duplicaate elements.";
            }
            Assert.assertEquals(expectedResult,actualResult);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifytheNumberOfElementsInCarousel(String arg0, int arg1){
        By by = By.xpath("//h2[contains(text(),'"+arg0+"')]/ancestor::div[@class='cms-carousel-b']//article");
        String actualResult = "";
        String expectedResult = "Carousel has 15 Elements";

        try{
            int numberOfCarouselElements = utils.sizeOfList(by);
            if(numberOfCarouselElements<arg1){
                actualResult = "Carousel has less than 15 elements";
            }
            if(numberOfCarouselElements==arg1){
                actualResult = "Carousel has 15 Elements";
            }
            else{
                actualResult = "Carousel has more than 15 elements";
            }
            Assert.assertEquals(expectedResult,actualResult);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeBrowser(){
        this.driver.close();
//        this.driver.quit();
    }
}

