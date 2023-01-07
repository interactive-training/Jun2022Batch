package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import org.testng.Assert;

public class VerifyHomePageStep {

    WebDriver driver;
    String validURL;

    @Given("I have a valid URL for {string}")
    public void i_have_a_valid_url_for(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("valid url ");
         validURL = "https://www.bipin.co.uk/elegant_decors/";

    }

    @When("I open home page")
    public void i_open_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        //open a browser -- what type of browser u need ? chrome/firefox

        // navigate to that page (home page)

        System.setProperty("webdriver.chrome.driver","D://Training//Tools_Software//ChromeDriver//chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(validURL);


    }

    @Then("Close the browser")
    public void close_the_browser(){
        driver.quit();
    }

    @Then("Verify the title contains {string}")
    public void verify_the_title_contains(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle,"Title is not matching");



    }

    @Then("I should see the below items")
    public void i_should_see_the_below_items(DataTable dataTable) {


        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();

    }
}
