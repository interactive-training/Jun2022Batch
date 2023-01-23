package stepDefinitions;

import com.InteractiveTrainingAcademy.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.View;
import java.io.FileReader;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    Properties prop = null;

    String baseURL;
    String homePageURL;
    String HomePageURLDirectory;
    String absoluteHomePageURL;
    String homepageName;

    String browserType;

    //create page objects
    private HomePage homePage = null;
    private HomePageHeader homePageHeader = null;
    private HomePageFooter homePageFooter = null;

    private OrderSummaryPage orderSummaryPage = null;
    private PaymentGatewayPage paymentGatewayPage = null;

    private ProductDetailPage productDetailPage = null;

    private SignInPage signInPage = null;

    private ViewCartPage viewCartPage  = null;

    public BaseTest() {

        getConfigValues();
    }

    public HomePageHeader getHomePageHeader() {

        /*
        // using condition, return object
        if (homePageHeader == null)
            return new HomePageHeader(driver);
        else
            return homePageHeader;
        */

        // using ternary operator
        // shortcut way to verify object is valid or not.
        return (homePageHeader == null) ? new HomePageHeader(driver) : homePageHeader;
    }
    public HomePage getHomePage(){

        //verify null object in another way
        return (Objects.isNull(homePage)) ? new HomePage(driver) : homePage;
    }

    public HomePageFooter getHomePageFooter(){
        if (Objects.isNull(homePageFooter)){
            return new HomePageFooter(driver);
        }
        else {
            return homePageFooter;
        }

    }
    public OrderSummaryPage getOrderSummaryPage(){
        return (Objects.isNull(orderSummaryPage)) ? new OrderSummaryPage(driver): orderSummaryPage;
    }
    public PaymentGatewayPage getPaymentGatewayPage(){
        return (Objects.isNull(paymentGatewayPage)) ? new PaymentGatewayPage(driver) : paymentGatewayPage;
    }

    public ProductDetailPage getProductDetailPage(){
        return (Objects.isNull(productDetailPage)) ? new ProductDetailPage(driver) : productDetailPage;
    }

    public SignInPage getSignInPage(){
        return (Objects.isNull(signInPage)) ? new SignInPage(driver) : signInPage;

    }
    public ViewCartPage getViewCartPage(){
        return (Objects.isNull(viewCartPage)) ? new ViewCartPage(driver) : viewCartPage;

    }


    public void waitForElementToAppear_XPath(String elementXPATH){
//        WebDriverWait wait = new WebDriverWait(driver, 5); //selenium 3
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //selenium 4

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPATH)));
    }

    public void waitForElementToAppear_By(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //selenium 4
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementToAppear_WebElementObject(WebElement webElementObject){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElementObject));
    }

    public void getConfigValues() {

        //get the file paths or something which is required to initialize only once in the run life time

        try {

            String userCurrentDir = System.getProperty("user.dir");
            String propertiesFilePath = userCurrentDir + "\\src\\test\\TestConfig.properties";
            FileReader reader = new FileReader(propertiesFilePath);

            prop = new Properties();
            prop.load(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String browserType = prop.getProperty("Browser");
        this.browserType = browserType;

        // home page
        this.baseURL = prop.getProperty("BaseURL");

        //homepageurldierctory
        this.homepageName = prop.getProperty("HomePageName");
//        this.HomePageURLDirectory = HomePageURLDirectory;
        this.homePageURL =  this.baseURL + "/" + this.homepageName;


    }

//    @Before("@db")
//    public void openDatabase(){
//        System.out.println("opening database connection");
//    }

    @Before
    public void setupDriver() {
//        System.out.println("------Before executed.");

        //driver file
        //start new driver
        // start chromedriver


        //instead of driver file setup, we use WebDriverManager()
        if (browserType.toLowerCase().contains("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeoptions = new ChromeOptions();

            String headlessBrowser = prop.get("HeadLessBrowser").toString().toLowerCase();
            if (headlessBrowser.equals("true") || headlessBrowser.equals("yes")) {
                chromeoptions.addArguments("--headless");
            }

            this.driver = new ChromeDriver(chromeoptions);

        } else if (browserType.toLowerCase().contains("firefox".toLowerCase())) {

            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();

        } else if (browserType.toLowerCase().contains("edge".toLowerCase())) {

            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();

        } else {

            System.out.println("Invalid browser");
        }

        //maximize browser if config is passed
        String maximizeBrowser = prop.getProperty("MaximizeBrowser").toLowerCase();
        if (maximizeBrowser.equals("true") || maximizeBrowser.equals("yes")) {
            driver.manage().window().maximize();
        }

        //set implicit wait
        String timeUnitImplicitWait = prop.getProperty("PageTimeoutSeconds", "10");
        Integer timeUnit = Integer.parseInt(timeUnitImplicitWait);
        driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);

        //open home page
        driver.get(homePageURL);

    }

    @After  //scenario level
    public void tearDown() {
//        System.out.println("------After executed.");

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @AfterStep  //hook
    public void afterStepMethod() {

//        System.out.println("After each step");
    // take screenshot


    }


}
