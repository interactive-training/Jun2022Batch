package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.FileReader;

import java.util.List;
import java.util.Map;
import java.util.Properties;


public class VerifyHomePageStep {

    WebDriver driver;

    public VerifyHomePageStep(BaseTest hooks){

        this.driver = hooks.driver;
    }

    @Given("I am on homepage")
    public void I_am_on_homepage() {

        // how to ensure that you are on homepage ?
        //get the current url and validate it. (current url mean - homepage url)...

        System.out.println("valid url");
        String homePageURL = "https://www.bipin.co.uk/elegant_decors/";
        /*
          Pramod - Issue simulation

        //try to get the driver - active driver object
        -- Problem statemet to understand
        - why we cannot create new object which holds driver
        */

//        HooksBeforeAfter h = new HooksBeforeAfter();
//        h.setupDriver();
//        driver = h.driver;


        Assert.assertEquals(driver.getCurrentUrl(), homePageURL, "Homepage url not matching");


    }

    @Then("Verify the title contains {string}")
    public void verify_the_title_contains(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not matching");

    }

    @Then("I should see the below items")
    public void i_should_see_the_below_items(DataTable dataTable) {

        List<Map<String,String>>  data = dataTable.asMaps();

        //1st row , column value
//        int iRow = 0;
//        data.get(iRow).get("webelements_on_header");

        //2nd row
//        iRow = 1;
//        data.get(iRow).get("webelements_on_header");

        //loop through all rows
        for (int iRow = 0; iRow<data.size(); iRow++){

            String linkName = data.get(iRow).get("webelements_on_header");

            if (linkName.contains("ElegantDecors name and Logo")){
                //get the xpath of the element
                String locatorLogo = "//a[@title='Elegant Decors']";
                WebElement elmLogo = driver.findElement(By.xpath(locatorLogo));
                Assert.assertTrue(elmLogo.isDisplayed());

            }
            else if (linkName.contains("Free Next day Delivery message")){

                System.out.println("handle for free next day....");
            }
            else if (linkName.contains("Contact Phone number ")){
                System.out.println("handle for contact phone number....");

            }



        }



    }

    @Then("Verify that the URL should be {string}")
    public void verify_that_the_url_should_be(String urlParam) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String expected = urlParam;
        String actual = driver.getCurrentUrl();

//        Assert.assertEquals(actual, expected, "URL not matching");
        Assert.assertTrue(actual.contains(expected), "not matching - url");
    }



}
