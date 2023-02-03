package stepDefinitions;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HomePageSearch;
import pages.ProductListSearchPage;
import pages.ProductDetailPage;
import utility.CommonComponents;

import java.util.List;
import java.util.Map;

public class HomePageSearchSteps {


    HomePageSearch homePageSearch = null;
    CommonComponents commonComponents;

    ProductDetailPage productDetailPage;
    ProductListSearchPage productListSearchPage;


    public HomePageSearchSteps(BaseTest baseTest) {

        this.homePageSearch = baseTest.getHomePageSearch();
        this.productDetailPage = baseTest.getProductDetailPage();

        this.productListSearchPage = baseTest.getProdListSearchPage();

        System.out.println("Home page search created and its name is: " + this.homePageSearch.getClass().getName());
        commonComponents = new CommonComponents(baseTest.driver);

    }

    @When("I type item name as {string} in search edit box")
    public void i_type_item_name_as_in_search_edit_box(String itemName) {

        homePageSearch.enterProductNameInSearchEditBox(itemName);

    }

    @Then("I should see list of Items name containing {string}")
    public void I_should_see_list_of_Items_name_containing(String itemname) {

//        Thread.sleep(2000);
        List<String> lst = homePageSearch.getItemsNameFromSearchDropDown();

        Boolean found = false;

        for(int x=0; x < lst.size(); x++ )
        {

//            if (expeted == actual){
//                found = true;
//                break;
//
//            }
            //get the single item
           String dropdownItem = lst.get(x).toString();
           Assert.assertTrue(dropdownItem.contains(itemname),"item does not contain the word : " + itemname);
//           Assert.assertEquals(dropdownItem,itemname, "item not available");


        } // end for loop


        //verify if found or not
//        Assert.assertTrue(found);



        System.out.println("verify");
    }


    @When("I search a product with name {string} by pressing Enter Key")
    public void i_search_for_a_product_by_pressing_enter_key_in_search_edit_box_with_product_name_as(String productName) {
        homePageSearch.searchProductWithKeyPressEnter(productName);

    }

    @When("I search a product with name {string}")
    public void I_search_for_a_product_for_product_name(String productName) throws InterruptedException {
        Thread.sleep(3000);
        homePageSearch.searchProduct(productName);
    }

    @Then("I should get popup alert window with message {string}")
    public void i_should_get_popup_alert_window_with_message(String expetedAlertMsg) {
        //check if alert window exist or not

        //get alert message
        String alertMessage = commonComponents.getAlertMessage();
        Assert.assertEquals(alertMessage, expetedAlertMsg);

    }


    @Then("I should see below items listed on the search result page")
    public void i_should_see_below_item_s_listed_on_the_search_result_page(DataTable dataTable) {

        List<String> actualProductList = homePageSearch.getProductNameListDisplayedFromSearch();

        //make sure that there are at leaset 1 item displayed after search.
        Assert.assertTrue(actualProductList.size() > 0, "No items available in search section.");

        SoftAssert softAssert = new SoftAssert();

        List<Map<String, String>> expectedItemList = dataTable.asMaps();

        for (int i = 0; i < expectedItemList.size(); i++) {
            String expectedItem = expectedItemList.get(i).get("FULL_ITEM_NAME");
            softAssert.assertTrue(actualProductList.contains(expectedItem), " Item not found: " + expectedItem);

        }

        softAssert.assertAll();
    }


    @When("I select the item {string} to buy in Search page")
    public void i_select_the_item_to_buy_in_search_page(String item_to_buy) {
        // Write code here that turns the phrase above into concrete actions
//        System.out.println(item_to_buy);
        homePageSearch.BuyItemFromSearchResult(item_to_buy);

    }

    @Then("I should see the item {string} in Product detail page")
    public void i_should_see_the_item_in_Product_detail_page(String expectedItemName) {

//        System.out.println("Verify in checkout page");
        Assert.assertEquals(expectedItemName, productDetailPage.productTitle, "Item name is not displayed as expected.");

    }


    @When("I select {string} item to buy from the list on Product search result page")
    public void i_select_item_to_buy_from_the_list_on_product_search_result_page(String position) throws Exception {
        // Write code here that turns the phrase above into concrete actions

        if (position.equalsIgnoreCase("First")){
            productListSearchPage.buyFirstProductFromList();

        }else if (position.equalsIgnoreCase("Last")){
            productListSearchPage.buyLastProductFromList();

        }



    }


    @When("I proceed to buy the product on Product details page")
    public void i_proceed_to_buy_the_product_on_product_details_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
