package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.List;
import java.util.Map;

public class HomePageStep {

    WebDriver driver;
    String homePageName;

    HomePage homePage;

    public HomePageStep(BaseTest baseTest) {

        this.driver = baseTest.driver;
        this.homePage = baseTest.getHomePage();
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

    @Then("I should see the below items on menubar")
    public void i_should_see_the_below_items_on_menubar(DataTable dataTable) {

        System.out.println(dataTable);

        List<Map<String, String>> listitems = dataTable.asMaps();

        //using soft Assertions
        SoftAssert softAssert = new SoftAssert();

        for (int rowNum = 0; rowNum < listitems.size(); rowNum++) {
            String sItemName = listitems.get(rowNum).get("MENUBAR_ITEMS");

            // get xpath of item
            switch (sItemName) {
                case "Home":
                    System.out.println("get xpath for Home");
                    softAssert.assertTrue(homePage.menuHome().isDisplayed());

                case "Cremation Urns":
                    System.out.println("Cremation Urns");
                    softAssert.assertTrue(homePage.cremationUrns().isDisplayed());

                case "Home Decors":
                    System.out.println("Home Decors");
                    softAssert.assertTrue(homePage.homeDecors().isDisplayed());

                case "New Arrivals":
                    System.out.println("New Arrivals");
                    softAssert.assertTrue(homePage.newArrivals().isDisplayed());

            } //switch case

        } //for next loop

        //after all items complete, execute Assert

        softAssert.assertAll(); //This line will throw error if any

    } //method closing


    @Then("I should see below banner images available")
    public void I_should_see_below_banner_images_available(DataTable dataTable) throws InterruptedException {

//        ****  REPLACE THIS LOGIN WITH FLUENT WAIT ****

        List<Map<String, String>> data = dataTable.asMaps();

        homePage.getBannerTotalImagesAvailable();

        //to proceed, I should have the number of images more than the number of expected images
        // expected images > actual images

        int expectedNumberOfImages = data.size();
        int actualNumberOfImages = homePage.getBannerTotalImagesAvailable();

        Assert.assertTrue(expectedNumberOfImages <= actualNumberOfImages, "Expected number of images are more than expected number of images ");

        //================= 2nd validation =========

        //verify the image (with soft assert, as it loops through various elements)


        for (int x = 0; x < data.size(); x++) {
            String expected_image_text = data.get(x).get("BANNERS_IMAGE_ALT_TEXT");

            //verify the item's name exist in the list of image under banner div
            boolean isTextFound = false;

            List<WebElement> elms = homePage.getBannerImages();

            for (WebElement elm : elms) {

                String actual_image_alt_text = elm.getAttribute("alt");
                if (actual_image_alt_text.contains(expected_image_text)) {
                    //found expected value
                    isTextFound = true;
                    break;
                }
            } // closing  inner - for loop

            Assert.assertTrue(isTextFound, "Image does not exist. for : " + expected_image_text);
        } //close outer - for loop

    } //closing step method


} // closing CLASS
