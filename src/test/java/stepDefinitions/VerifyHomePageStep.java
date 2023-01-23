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
    String homePageName;

    public VerifyHomePageStep(BaseTest baseTest){

        this.driver = baseTest.driver;
        this.homePageName = baseTest.homepageName;
    }

    @Given("I am on homepage")
    public void I_am_on_homepage() {

        Assert.assertTrue(driver.getCurrentUrl().contains(this.homePageName), "Homepage url not matching");

    }

    @Then("Verify the title contains {string}")
    public void verify_the_title_contains(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not matching");

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
