package InterviewQnAPractice;

/*
ref:
https://www.tutorialspoint.com/how-to-check-if-an-alert-exists-using-webdriver

*/


import io.github.bonigarcia.wdm.WebDriverManager;
//import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.apache.log4j.PropertyConfigurator;

import org.testng.Assert;

import java.time.Duration;


public class AlertMethods {

//    private static Logger Log = Logger.getLogger(Log.class.getName());//

    static WebDriver driver = null;

    public static void openDriver(){

        // **** Alert prompt is NOT working in ChromeDriver, but working in FirefoxDriver (Selenium 3)

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

    }

    public static void main(String[] args) {
        // Javascript alerts only.
        openDriver();
        driver.manage().window().maximize(); //1st step towards fix

        driver.get("https://demoqa.com/alerts");
        try{

//            handleAlert_click_OK();
//            handleAlert_click_Cancel_v1(); // error to understand
            handleAlert_click_Cancel_v2(); //error and fixed, go through comments

//            handleAlert_OK_and_Cancel_click_Cancel_or_Ok();
//            handleAlert_Input_Value();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }

    }

    public static void handleAlert_click_OK() throws InterruptedException {
        //click 'ok' button on Alert window
        //simple alert window open and click ok. This kind of alerts are generally warnings/error popups shown in the page

        driver.findElement(By.xpath("//button[@id='alertButton']")).click();

        Thread.sleep(1000);

//        System.out.println(driver.getTitle());

        driver.switchTo().alert().accept();

        Thread.sleep(1000);

        System.out.println("**8 Clicked on ok button on Alert");

    }

    public static void handleAlert_click_Cancel_v1(){

        //demo of error: ElementClickInterceptedException; element click intercepted:...

        //click 'ok' button on Alert window
        //simple alert window open and click ok. This kind of alerts are generally warnings/error popups shown in the page

        driver.findElement(By.id("timerAlertButton")).click();

        //now, when title is opened, get the title , find out the response
        System.out.println(driver.getTitle());

        driver.switchTo().alert().dismiss();

        System.out.println("**8 Clicked on ok button on Alert");

    }

    public static void handleAlert_click_Cancel_v2() throws InterruptedException {

        //fixing error , above error due to synch issue.
        driver.manage().window().maximize(); //1st step towards fix
        //close the advertise window, //2nd try to fix -- but xxx xxxx -> not solved

        //sol 3: - scroll down using javascript (2 ways we can call javascript exector)
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
//        jse.executeScript("document.getElementById('timerAlertButton').scrollIntoView();");

        //        or, jse can be called with paramter as WebElement
        WebElement elmToClick = driver.findElement(By.xpath("//*[@id='timerAlertButton']"));
        jse.executeScript("arguments[0].scrollIntoView();",elmToClick);

//        wait for 1 second (using WebDriver's own built in method)
//        driver.wait(10);

        elmToClick.click(); //alert appeared after 5 seconds


        //now, when title is opened, get the title , find out the response
        System.out.println(driver.getTitle());

        // i know there is an alert appears
        // wait for maxium time, to get the alert, oterwise , fail the test case , as expection is an alert window

//        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (wait.until(ExpectedConditions.alertIsPresent()) == null){
            System.out.println("Alert NOT present");
            //test case failed
        }
        else{
            //alert present, handle the alert
            driver.switchTo().alert().dismiss();

        }

        System.out.println("** Clicked on ok button on Alert");

    }

    public static void handleAlert_OK_and_Cancel_click_Cancel_or_Ok() throws InterruptedException {

        WebElement elmButton = driver.findElement(By.id("confirmButton"));


        //sol 3: - scroll down using javascript (2 ways we can call javascript exector)
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].scrollIntoView();",elmButton);

        elmButton.click();

        //another way (1st method - webdriverwait shown last demo) to find if alert is prsent or not
        // using try catch block

        try{
            //click cancel on Alert
//            driver.switchTo().alert().dismiss();

            //click ok
            driver.switchTo().alert().accept();


        }
        catch(NoAlertPresentException noAlertException){

            //if No Alert, it will come here ,

            //fail the test case if you are expecting alert, but it does not appear

            noAlertException.printStackTrace();
        }

        //if control comes here, then it clicking successfully on Alert
        System.out.println("User clicks on alert button ok or Cancel successfully");

        //is the cancel clicked or ok clicked, find from the message displayed on page
        WebElement elmconfirmResult  = driver.findElement(By.id("confirmResult"));

        if (elmconfirmResult.getText().contains("Cancel")){
            System.out.println("User clicked cancel");
        }
        else
            System.out.println("User clicked OK");

    }

    public static void handleAlert_Input_Value() throws InterruptedException {

        WebElement elmButton = driver.findElement(By.id("promtButton"));


        //sol 3: - scroll down using javascript (2 ways we can call javascript exector)
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].scrollIntoView();",elmButton);

        elmButton.click();

        //another way (1st method - webdriverwait shown last demo) to find if alert is prsent or not
        // using try catch block
        String valueToEnter = "Value Entered in Editbox of Alert";
        Thread.sleep(2000);
        try{
           //enter value

            driver.switchTo().alert().sendKeys(valueToEnter);
//            al.sendKeys(valueToEnter);
            driver.switchTo().alert().accept();

        }
        catch(NoAlertPresentException noAlertException){

            //if No Alert, it will come here ,

            //fail the test case if you are expecting alert, but it does not appear

            noAlertException.printStackTrace();
        }


        //is the cancel clicked or ok clicked, find from the message displayed on page
        WebElement elmpromptResult  = driver.findElement(By.id("promptResult"));

        //Assert that what value you entered in edit box, shows in the page
        Assert.assertEquals(elmpromptResult.getText(), valueToEnter);


    }


}
