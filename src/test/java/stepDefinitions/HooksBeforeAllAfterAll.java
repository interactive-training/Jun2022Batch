//package stepDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.io.FileReader;
//import java.util.Properties;
//
//public class HooksBeforeAllAfterAll {
//
//    WebDriver driver;
//    String URL;
//    String homePageURL;
//    String browser;
//
//    @BeforeAll
//    public static void beforeAllMethod(){
//
//        System.out.println("BeforeAll executed....");
//
//        //get the file paths or something which is required to initialize only once in the run life time
//        Properties prop = null;
//
//        try{
//
//            String userCurrentDir = System.getProperty("user.dir");
//            String propertiesFilePath = userCurrentDir + "\\src\\test\\TestConfig.properties";
//            FileReader reader= new FileReader(propertiesFilePath);
//
//            prop = new Properties();
//            prop.load(reader);
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//
//        String browser = prop.getProperty("browser");
//        this.browser = browser;
//
//        // home page
//        String domainURL = prop.getProperty("URL");
//        this.URL = domainURL;
//
//
//        String homePageURL = domainURL + "/elegant_decors";
//        this.homePageURL = homePageURL;
//
//    }
//
//
//}
