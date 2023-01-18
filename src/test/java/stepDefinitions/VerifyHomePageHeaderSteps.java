package stepDefinitions;

import com.InteractiveTrainingAcademy.pages.HomePageHeader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

        List<Map<String, String>> data = dataTable.asMaps();

        for (int iRow = 0; iRow < data.size(); iRow++) {
            String itemName = data.get(iRow).get("WEBELEMENTS_ON_HEADER");

            if (itemName.contains("ElegantDecors name and Logo")) {

                Assert.assertTrue(homePageHeader.isDisplayed_eleganDecorsNameAndLogo());

            } else if (itemName.contains("Free Next day Delivery message")) {

                Assert.assertTrue(homePageHeader.isDisplayed_freeNextAndDeliveryMsg());
            } else if (itemName.contains("Contact Phone number")) {


                Assert.assertTrue(homePageHeader.isDisplayed_contactPhoneNumber());
            } else if (itemName.contains("menu button")) {

                Assert.assertTrue(homePageHeader.isDisplayed_menuButton());
            } else if (itemName.contains("cart")) {

                Assert.assertTrue(homePageHeader.isDisplayed_cartn());

            } else if (itemName.contains("Product Search box and search symbol")) {


                Assert.assertTrue(homePageHeader.isDisplayed_productSearch());
            }

        }
    }


}
