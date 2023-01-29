package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonComponents {

    WebDriver driver;

    //constructor
    public CommonComponents(WebDriver driver) {
        this.driver = driver;

    }

    public String RandomUniqueString() {

        LocalDateTime objDateTime = LocalDateTime.now();

        //how to format
        DateTimeFormatter objDTFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss_ms");

        //now formaat the above date
//        System.out.println(objDateTime.format(objDTFormatter));
        return objDateTime.format(objDTFormatter);

    }

    public String getAlertMessage() {

        String msg = "";

        //wait for 1 second alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert();
        msg = driver.switchTo().alert().getText();

        //close the alert
        driver.switchTo().alert().accept();

        //return back to original window
        driver.switchTo().defaultContent();


        return msg;
    }

}
