package stepDefinitions;

import com.InteractiveTrainingAcademy.pages.HomePageHeader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.messages.types.Hook;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    String URL;
    String homePageURL;
    String HomePageURLDirectory;
    String absoluteHomePageURL;

    String browser;

    //create page objects
    HomePageHeader homePageHeader;

    public HomePageHeader getHomePageHeader(){
        return new HomePageHeader(driver);
    }

    public BaseTest(){

        getConfigValues();
    }


    public void getConfigValues(){

        //get the file paths or something which is required to initialize only once in the run life time
        Properties prop = null;

        try{

            String userCurrentDir = System.getProperty("user.dir");
            String propertiesFilePath = userCurrentDir + "\\src\\test\\TestConfig.properties";
            FileReader reader= new FileReader(propertiesFilePath);

            prop = new Properties();
            prop.load(reader);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        String browser = prop.getProperty("Browser");
        this.browser = browser;

        // home page
        String domainURL = prop.getProperty("URL");
        this.URL = domainURL;

        //homepageurldierctory
        String HomePageURLDirectory = prop.getProperty("HomePageURLDirectory");
        this.HomePageURLDirectory = HomePageURLDirectory;
        this.absoluteHomePageURL = domainURL + "/" + HomePageURLDirectory;

        //homepage
//        String homePageURL = prop.getProperty("HomePageURL");
        this.homePageURL = absoluteHomePageURL;

    }

//    @Before("@db")
//    public void openDatabase(){
//        System.out.println("opening database connection");
//    }

    @Before
    public void setupDriver()  {
//        System.out.println("------Before executed.");

        //driver file
        //start new driver
        // start chromedriver


        //instead of driver file setup, we use WebDriverManager()
        if(browser.toLowerCase().contains("chrome")){

            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();

        } else if (browser.toLowerCase().contains("firefox".toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();

        } else if (browser.toLowerCase().contains("edge".toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }
        else{
            System.out.println("Invalid browser");
        }

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
    public void afterStepMethod(){

//        System.out.println("After each step");


    }




}
