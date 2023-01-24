package stepDefinitions;

import com.InteractiveTrainingAcademy.pages.HomePageHeader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class VerifyHomePageHeaderSteps {

    WebDriver driver;
    HomePageHeader homePageHeader;

    public VerifyHomePageHeaderSteps(BaseTest hooks) {

        this.driver = hooks.driver;
        this.homePageHeader = hooks.getHomePageHeader();

    }


    // Web Elements on header
    @Then("I should see the below items on Home page header")
    public void iShouldSeeTheBelowItemsOnHomePageHeader(DataTable dataTable) {

        SoftAssert sa = new SoftAssert();

        List<Map<String, String>> data = dataTable.asMaps();

        for (int iRow = 0; iRow < data.size(); iRow++) {
            String itemName = data.get(iRow).get("WEBELEMENTS_ON_HEADER");

            if (itemName.contains("ElegantDecors name and Logo")) {

//                Assert.assertTrue(homePageHeader.isDisplayed_eleganDecorsNameAndLogo());
                sa.assertTrue(homePageHeader.isDisplayed_eleganDecorsNameAndLogo(), "Elegan docors name and logo is not displayed.");

            } else if (itemName.contains("Free Next day Delivery message")) {

//                Assert.assertTrue(homePageHeader.isDisplayed_freeNextAndDeliveryMsg());
                sa.assertTrue(homePageHeader.isDisplayed_freeNextAndDeliveryMsg(), "Free next and delivery message is not displayed.");

            } else if (itemName.contains("Contact Phone number")) {

//                Assert.assertTrue(homePageHeader.isDisplayed_contactPhoneNumber());
                sa.assertTrue(homePageHeader.isDisplayed_contactPhoneNumber(), "Contact phone number on homepage is not displayed.");


            } else if (itemName.contains("menu button")) {

//                Assert.assertTrue(homePageHeader.isDisplayed_menuButton());
                sa.assertTrue(homePageHeader.isDisplayed_menuButton(), "Menu button is not displayed.");

            } else if (itemName.contains("cart")) {

//                Assert.assertTrue(homePageHeader.isDisplayed_cartn());
                sa.assertTrue(homePageHeader.isDisplayed_cartn(),"Cart is not displayed on home page.");


            } else if (itemName.contains("Product Search box and search symbol")) {

//                Assert.assertTrue(homePageHeader.isDisplayed_productSearch());
                sa.assertTrue(homePageHeader.isDisplayed_productSearch(), "Product search is not displayed on home page.");

            }

        } //end for loop

        sa.assertAll();

    } //method ends


}
