package ITA.InterviewQnAPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NavigateWindowMethods {

    static WebDriver driver;

    public static  void main (String[] args){

        try{

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize(); //1st step towards fix

            driver.get("https://demoqa.com/browser-windows");

            //cilck new tab
            driver.findElement(By.id("tabButton")).click();

            /*
            // Loop through for..
            //get window handles
            Set<String>  setOfHandles  = driver.getWindowHandles();
            for (String handle : setOfHandles)
            {
                System.out.println(handle);
            }
            */

            // Loop through array
            Object[] handles = driver.getWindowHandles().toArray();

            System.out.println(handles[0].toString());
            System.out.println(handles[1].toString());

            for (int x = 0; x < handles.length; x++){

                System.out.println(handles[x].toString());

            }

            String newTabHandle = handles[handles.length-1].toString();

            driver.switchTo().window(newTabHandle);
            System.out.println(driver.getTitle());

            WebElement expetedText = driver.findElement(By.id("sampleHeading"));
            Assert.assertTrue(expetedText.isDisplayed());

            driver.switchTo().defaultContent();

            System.out.println(driver.getTitle());

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //close browse
            driver.close();
            driver.quit();

        }

    }
}
