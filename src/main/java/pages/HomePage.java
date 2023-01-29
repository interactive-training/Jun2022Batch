package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class HomePage {

    //banner
    final By BANNER = By.xpath("//div[@id='slider']");


    //menuItems ,
    // declaring webelemets like this, throws error, could not create homepage objet from baseTest, need to analyse
    //so, ceating By objects only here, and create methods to return thease objects
    final By BANNER_ACTIVE_IMAGE_ADULT_URNS = By.xpath("//div[@id='slider']/a[contains(@href,'adult-urns') and @style='display: block;']");
    final By BANNER_ACTIVE_IMAGE = By.xpath("//div[@id='slider']/a[@style='display: block;']/img");
    final By BANNER_ALL_IMAGES = By.xpath("//div[@id='slider']/a/img");
    By MENU_HOME = By.xpath("//ul[@class='rmm-main-list']/li/a[@title='Home']");
    By CREMATION_URNS = By.xpath("//ul[@class='rmm-main-list']/li/a[@title='Cremation Urns']");
    By HOME_DECORS = By.xpath("//ul[@class='rmm-main-list']/li/a[@title='Home Decors']");
    By NEW_ARRIVALS = By.xpath("//a[@title='New Arrivals']");
    private final WebDriver driver;


    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menuHome() {
        return driver.findElement(this.MENU_HOME);

    }

    public WebElement cremationUrns() {
        return driver.findElement(this.CREMATION_URNS);

    }

    public WebElement homeDecors() {
        return driver.findElement(this.HOME_DECORS);

    }

    public WebElement newArrivals() {
        return driver.findElement(this.NEW_ARRIVALS);

    }

    public List<WebElement> getBannerImages() {
        //banner xpath

        List<WebElement> elms = driver.findElements(BANNER_ALL_IMAGES);


        return elms;

    }

    public int getBannerTotalImagesAvailable() {
        //banner xpath

        List<WebElement> elms = driver.findElements(By.xpath("//div[@id='slider']/a"));
        return elms.size();

    }

    public WebElement getBannerActiveImage() {
        //xpath
        WebElement elmImage = driver.findElement(BANNER_ACTIVE_IMAGE);
        return elmImage;
    }

    public void moveMouseInToBanner() {
        //move mouse using action class
        Actions action = new Actions(driver);

        WebElement elmBanner = driver.findElement(BANNER);

        action.moveToElement(elmBanner);

        //execute the action
        action.build().perform();

    }

    public void moveMouseOutOfBanner() {

        //implement this, homework
        Actions action = new Actions(driver);

//        WebElement elmBanner = driver.findElement(BANNER);

        action.moveByOffset(0, 0); //just move to top left corner of the page
        action.build().perform();

    }

    //methods
    public void goToHomePage() {
        driver.get("https://www.bipin.co.uk/elegant_decors/");

    }


}
