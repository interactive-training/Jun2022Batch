package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utility.CommonComponents;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private CommonComponents commonComponents = null;
    //    static Logger log = Logger.getLogger(BaseTest.class);
    WebDriver driver;
    Properties prop = null;
    String baseURL;
    String homePageURL;
    String HomePageURLDirectory;
    String absoluteHomePageURL;
    String homepageName;
    String browserType;
    //create page objects
    private final HomePage homePage = null;
    private final HomePageHeader homePageHeader = null;
    private final HomePageFooter homePageFooter = null;
    private final HomePageSearch homePageSearch = null;
    private final OrderSummaryPage orderSummaryPage = null;
    private final PaymentGatewayPage paymentGatewayPage = null;
    private final ProductDetailPage productDetailPage = null;
    private final SignInPage signInPage = null;
    private final ViewCartPage viewCartPage = null;

    public BaseTest() {


//        PropertyConfigurator.configure (System.getProperty("user.dir") + "/src/test/resources/log4j.properties");
//        log = Logger.getLogger(BaseTest.class);

        //get test config values
        getConfigValues();  //sets the driver here

        // initialize common components
        if (Objects.isNull(commonComponents)) {
            commonComponents = new CommonComponents(driver);

        }
    }

    public CommonComponents getCommonComponents() {
        if (Objects.isNull(commonComponents)) {
            commonComponents = new CommonComponents(driver);
            return commonComponents;

        } else {
            return commonComponents;

        }

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

    public HomePage getHomePage() {

        //verify null object in another way
        return (Objects.isNull(homePage)) ? new HomePage(driver) : homePage;
    }

    public HomePageFooter getHomePageFooter() {
        if (Objects.isNull(homePageFooter)) {
            return new HomePageFooter(driver);
        } else {
            return homePageFooter;
        }

    }

    public HomePageSearch getHomePageSearch() {

        if (Objects.isNull(homePageSearch)) {
            return new HomePageSearch(driver);
        } else {
            return homePageSearch;
        }
    }

    public OrderSummaryPage getOrderSummaryPage() {
        return (Objects.isNull(orderSummaryPage)) ? new OrderSummaryPage(driver) : orderSummaryPage;
    }

    public PaymentGatewayPage getPaymentGatewayPage() {
        return (Objects.isNull(paymentGatewayPage)) ? new PaymentGatewayPage(driver) : paymentGatewayPage;
    }

    public ProductDetailPage getProductDetailPage() {
        return (Objects.isNull(productDetailPage)) ? new ProductDetailPage(driver) : productDetailPage;
    }

    public SignInPage getSignInPage() {
        return (Objects.isNull(signInPage)) ? new SignInPage(driver) : signInPage;

    }

    public ViewCartPage getViewCartPage() {
        return (Objects.isNull(viewCartPage)) ? new ViewCartPage(driver) : viewCartPage;

    }


    public void waitForElementToAppear_XPath(String elementXPATH) {
//        WebDriverWait wait = new WebDriverWait(driver, 5); //selenium 3
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //selenium 4

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPATH)));
    }

    public void waitForElementToAppear_By(By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //selenium 4
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementToAppear_WebElementObject(WebElement webElementObject) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElementObject));
    }

    public void getConfigValues() {

        //get the file paths or something which is required to initialize only once in the run life time

        try {

            String userCurrentDir = System.getProperty("user.dir");
            String propertiesFilePath = userCurrentDir + "\\src\\test\\Config.properties";
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
        this.homePageURL = this.baseURL + "/" + this.homepageName;

    }

//    @Before("@db")
//    public void openDatabaseConnection(){
//        System.out.println("opening database connection");
//    }

    @Before
    public void setupDriver() throws MalformedURLException {

        System.out.println("------Before executed.");

        //starting chrome browser with RemoteWebDriver

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), cap);


//        //instead of driver file setup, we use WebDriverManager()
//        if (browserType.toLowerCase().contains("chrome")) {
//
//            WebDriverManager.chromedriver().setup();
//
//            ChromeOptions chromeoptions = new ChromeOptions();
//
//            String headlessBrowser = prop.get("HeadLessBrowser").toString().toLowerCase();
//
//            if (headlessBrowser.contains("true") || headlessBrowser.contains("yes")) {
//                chromeoptions.addArguments("--headless");
//            }
//
//            this.driver = new ChromeDriver(chromeoptions);
//
//        } else if (browserType.toLowerCase().contains("firefox".toLowerCase())) {
//
//            WebDriverManager.firefoxdriver().setup();
//            this.driver = new FirefoxDriver();
//
//        } else if (browserType.toLowerCase().contains("edge".toLowerCase())) {
//
//            WebDriverManager.edgedriver().setup();
//            this.driver = new EdgeDriver();
//
//        } else {
//
//            System.out.println("Invalid browser");
//        }


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

    @AfterStep
    public void afterStepMethod(Scenario scenario) {

        System.out.println("------AfterStep executed.");

        // take screenshot -- if test failed
        if (scenario.isFailed()) {
            System.out.println("Step is failed, taking screenshot");
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] byteScreenshot = ts.getScreenshotAs(OutputType.BYTES); // stores image inside the html file
            String fileName = "screenshot_" + commonComponents.RandomUniqueString() + ".png";
            scenario.attach(byteScreenshot, "image/png", fileName);

        }

    }

    @After  //scenario level
    public void tearDown(Scenario scenario) {

        System.out.println("------After executed.");

        //Write extent report
//            Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));

        if (driver != null) {

            driver.close();
            driver.quit();
        }
    }


}
