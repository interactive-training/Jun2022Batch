package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

public class OrderSummarySteps {

    WebDriver driver;

    OrderSummaryPage orderSummaryPage;
    ProductViewCartPage prodViewCartPage;

    SignInPage signInPage;
    ProductDetailPage productDetailPage;

    CheckOutPage checkOutPage;

    public OrderSummarySteps(BaseTest base){
        driver = base.getDriver();
        orderSummaryPage = base.getOrderSummaryPage();
        prodViewCartPage = base.getProductViewCartPage();
        productDetailPage = base.getProductDetailPage();

        signInPage = base.getSignInPage();
        checkOutPage = base.getCheckOutPage();

    }

    @Then("Order Summary header is expanded by default")
    public void order_summary_header_is_expanded_by_default() {

        Assert.assertTrue(orderSummaryPage.isOrderSummaryHeaderExpanded(), "The order summary product list section is not expanded by default.");

    }

    @Then("The Product Name should be displayed as expected on Order Summary page")
    public void the_product_name_should_be_displayed_as_expected_on_order_summary_page() {

        //open the section if closed
        orderSummaryPage.expand_OrderSummaryHeader_if_closed();

        //get the stored product name from view cart page (Now I am i order summary page)
//        Object prodNameList = prodViewCartPage.prodNameList.get(0);


        String expectedProdName = prodViewCartPage.prodNameList.get(0);
        String actualProdName = orderSummaryPage.getProductName_byRow(0);

        /* Note:
        Got values with ... in actual page, so not matching with Equal , using conains.

        Aluminium Bird Nest Tree Jewelry Stand Organizer
        Aluminium Bird Nest Tree Jewelry Stand Organizer ...

         */
        Assert.assertTrue(actualProdName.contains(expectedProdName), "product name is/are not displayed as expected  for prod: " + expectedProdName);

    }

    @Then("The Product Sale Price should be displayed as expected on Order Summary page")
    public void the_product_sale_price_should_be_displayed_as_expected_on_order_summary_page() {

        orderSummaryPage.expand_OrderSummaryHeader_if_closed();

        String expectedProdSalePrice = prodViewCartPage.prodSalePriceList.get(0);
        String actualProdsalePrice = orderSummaryPage.getProductSalePrice_ByRow(0);

        Assert.assertEquals(actualProdsalePrice, expectedProdSalePrice, "product sale price is not displayed as expected.");
    }

    @Then("The Product SubTotal should be displayed as expected on Order summary page")
    public void the_product_sub_total_should_be_displayed_as_expected_on_order_summary_page() {

        orderSummaryPage.expand_OrderSummaryHeader_if_closed();

        String expected_OrderSubTotal = prodViewCartPage.prodSubTotalList.get(0);
        String actual_OrderSubtotal = orderSummaryPage.getProductSubTotal_ByRow(0);
        Assert.assertEquals(actual_OrderSubtotal, expected_OrderSubTotal, "Sub total price is not displayed as expected.");

    }


    @Then("The Product OrderTotal should be displayed as expected on Order Summary page")
    public void the_product_order_total_should_be_displayed_as_expected_on_order_summary_page() {

        orderSummaryPage.expand_OrderSummaryHeader_if_closed();

        String expected_OrderTotal = prodViewCartPage.prodOrderTotal;
        String actual_Ordertotal = orderSummaryPage.getOrderTotal();
        Assert.assertEquals(actual_Ordertotal, expected_OrderTotal, "Order total is not displayed as expected.");

    }

    @When("I Press the product link on Order Summary page")
    public void i_press_the_product_link_on_order_summary_page() {

        orderSummaryPage.clickProductName_byRow(0);
    }

    @Then("I should be on Product details page in a new tab")
    public void i_should_be_on_product_details_page_in_a_new_tab() {

       orderSummaryPage.verify_ProductDetailsPage_opens_on_new_tab(productDetailPage);

    }

    @When("I logged in as existing customer with valid credentials as {string} and {string}")
    public void i_logged_in_as_existing_customer_with_valid_credentials_as_and(String username, String password) {

        signInPage.login(username, password);
    }
    @Then("Verify Order Total Amount in footer and header section should be equal")
    public void verify_order_total_amount_in_footer_and_header_section_should_be_equal() {

        Assert.assertEquals(orderSummaryPage.getOrderTotal().replace("£",""), orderSummaryPage.getOrderTotal_FooterSection().replace("£",""), "Order Total amount is not same in header and footer section.");

    }



}
