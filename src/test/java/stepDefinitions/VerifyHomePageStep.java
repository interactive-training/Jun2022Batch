package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

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

        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.chrome.driver","D://Training//Tools_Software//ChromeDriver//chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(validURL);
        //driver.manage().window().maximize();
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    @Then("Verify the title contains {string}")
    public void verify_the_title_contains(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Title is not matching");


    }
    // Web Elements on header
        @Then("I should see the below items on Home page header")
        public void iShouldSeeTheBelowItemsOnHomePageHeader(DataTable dataTable) {
            System.out.println(dataTable);
            System.out.println("--------------");
        System.out.println(dataTable.asMaps());
        System.out.println("*******************");
        System.out.println(dataTable.asLists());
            System.out.println("**********");
            List<Map<String, String>> data = dataTable.asMaps();
            for(int iRow=0; iRow<data.size(); iRow++){
                String itemName = data.get(iRow).get("WebElements_on_header");
                //System.out.println(itemName);
                if(itemName.contains("ElegantDecors name and Logo")){
                    //get ElegantDecors Logo xpath
                    String LocatorLogo = "//a[@title='Elegant Decors']";
                    WebElement elmLogo = driver.findElement(By.xpath(LocatorLogo));
                    Assert.assertTrue(elmLogo.isDisplayed());
                } else if (itemName.contains("Free Next day Delivery message")) {
                    String LocatorMsg = "//div[@class='nextdeltext']";
                    WebElement elmLogo = driver.findElement(By.xpath(LocatorMsg));
                    Assert.assertTrue(elmLogo.isDisplayed());
                }
                else if (itemName.contains("Contact Phone number")) {
                    String LocatorPhn = "//div[@id='rightbar']/div[@Class='phone']";
                    WebElement elmLogo = driver.findElement(By.xpath(LocatorPhn));
                    Assert.assertTrue(elmLogo.isDisplayed());
                }
                else if (itemName.contains("menu button")){
                    String LocatorItem = "//div/ul/li/img";
                    WebElement elmItem = driver.findElement(By.xpath(LocatorItem));
                    Assert.assertTrue(elmItem.isDisplayed());
                }
                else if( itemName.contains("cart")){
                    String LocatorItem = "//div[@class='viewcart']";
                    WebElement elmItem = driver.findElement(By.xpath(LocatorItem));
                    Assert.assertTrue(elmItem.isDisplayed());
                }
                else if(itemName.contains("Product Search box and search symbol")){
                    String LocatorItem = "//div[@class='pattren']";
                    WebElement elmItem = driver.findElement(By.xpath(LocatorItem));
                    Assert.assertTrue(elmItem.isDisplayed());
                }

            }
        }

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();

    // Web Elements on menubar
    @Then("I should see the below items on menubar")
    public void iShouldSeeTheBelowItemsOnMenubar(DataTable dataTable) {
        System.out.println(dataTable);
    }
    //Banner web elements
    @Then("I should see below banners dynamically changing")
    public void iShouldSeeBelowBannersDynamicallyChanging(DataTable dataTable) {
        System.out.println(dataTable);
    }
    //Web Elements of TopCategory items
    @Then("I should see below items")
    public void iShouldSeeBelowItems(DataTable dataTable) {
        System.out.println(dataTable);
        System.out.println(dataTable.asMaps());
        System.out.println("*******************");
        System.out.println(dataTable.asLists());
    }
    //Why choose Bipin message
    @Then("I should see {string} message and description")
    public void iShouldSeeMessageAndDescription(String arg0) {
        System.out.println("Verified the message Why Choose Bipin");
    }

    @And("scroll down to footer of the page")
    public void scrollDownToFooterOfThePage() {

    }
    //ElegantDecors address
    @Then("I should see ElegantDecors address under {string} heading")
    public void iShouldSeeElegantDecorsAddressUnderHeading(String arg0) {
        System.out.println("Verify Contact us message");
    }
    //Links on footer
    @Then("I should see following links")
    public void iShouldSeeFollowingLinks(DataTable dataTable) {
        System.out.println(dataTable);
    }
    //PayPal link
    @Then("I should see {string} link")
    public void iShouldSeeLink(String arg0) {
        System.out.println("Verify Paypal link");
    }
}
