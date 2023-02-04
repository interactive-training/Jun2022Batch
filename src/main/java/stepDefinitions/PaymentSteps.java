package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.OrderSummaryPage;
import pages.PaymentPage;

public class PaymentSteps {

    PaymentPage paymentPage;
    OrderSummaryPage orderSummaryPage;

    public PaymentSteps(BaseTest base){
        paymentPage = base.getPaymentGatewayPage();
        orderSummaryPage = base.getOrderSummaryPage();

    }

    @Then("I should see Order Total amount in Order Summay section on Payment page as expected")
    public void i_should_see_order_total_amount_in_order_summay_section_on_payment_page_as_expected() {

        String expected_OrderTotal = orderSummaryPage.getOrderTotal(); // may throw error
        String actual_OrderTotal = paymentPage.getOrderTotal();

        Assert.assertEquals(actual_OrderTotal, expected_OrderTotal, "order summary total amount is not matching between Order summay and payment page.");
    }

//    @Given("I am on Payment page")
//    public void i_am_on_payment_page() {
//
//        Assert.assertTrue(paymentPage.getPageHeaderText().equalsIgnoreCase("Choose a way to pay"),"Payment Page header does not show as expected.");
//
//    }

    @When("I select to pay by card type as {string}")
    public void i_select_to_pay_by_card_type_as(String cardType) {

        paymentPage.choosePayByCard(cardType);

    }

    @When("I fill up all required details")
    public void i_fill_up_all_required_details() {
        // Write code here that turns the phrase above into concrete actions
        paymentPage.fillupDetailsForCardTypeVisa();
    }

    @When("I proceed to pay")
    public void i_proceed_to_pay() {
        paymentPage.payNow();

    }
    @Then("The payment should success")
    public void the_payment_should_success() {

        //failing it intentionally (as the applicatino is not woring)

        Assert.assertTrue(false, "Not implemented in app...... failed test..");

        // not implemented in application itself.. ****

    }
    @Then("The order should be confirmed")
    public void the_order_should_be_confirmed() {

        System.out.println("This test will not execute , skipped.");

    }





}
