package InterviewQnAPractice;


import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilitiesUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MobileBrowserDemoTest {

    WebDriver driver;
//    AndroidDriver driver;

//    CapabilitiesUtils cap;
    DesiredCapabilities cap ;

    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException {

//        WebDriverManager.chromedriver().driverVersion("103.0.5060.71").setup(); //same as mobile chrome browser version, not the PC or Host chrome browser.

        // Mobile  emulator, browser - chrome
        cap = new DesiredCapabilities();
//        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
//        desiredCapabilities.setCapability("appium:platformName", "android");
//        desiredCapabilities.setCapability("appium:browser", "chrome");

//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
//        cap.setCapability(MobileCapabilityType.BROWSER_VERSION,"103");
        cap.setCapability("autoAcceptAlerts",true);

//        cap.setCapability("appPackage", "com.android.chrome");
//        cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");

//        cap.setCapability("autoWebview", false);

        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.get("http://www.bipin.co.uk/elegant_decors");
        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        //send

        driver.switchTo().alert().accept();

        driver.switchTo().defaultContent();


        //for Android Driver, opened with App, you have to close with AndroidDriver
//        ((AndroidDriver) driver).closeApp();
        //

        //for Appium Driver
//        driver.close();

        //for appium driver


        driver.quit();

    }

    @Test
    public void testApp() throws MalformedURLException, URISyntaxException {

        System.out.println("test ");
//        driver.get("https://bipin.co.uk/elegant_decors");
//        driver.close();
//        driver.quit();

    }

} // end class
