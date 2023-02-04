package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckOutPage;
import pages.PaymentPage;

public class CheckoutSteps {

    WebDriver driver;
    CheckOutPage checkoutPage;
    PaymentPage paymentPage;


    public CheckoutSteps(BaseTest base){
        driver = base.getDriver();
        checkoutPage = base.getCheckOutPage();
        paymentPage = base.getPaymentGatewayPage();

    }

    @Then("I Proceed to Payment on Checkout page")
    public void i_proceed_to_payment_on_order_summary_page() {
        // Write code here that turns the phrase above into concrete actions
        checkoutPage.proceedToPayment();
    }


    @Then("I fill up billing information on Checkout page")
    public void i_fill_up_billing_information_on_order_summary_page() {

        CheckOutPage checkout = new CheckOutPage(driver);
        checkout.fillUpStep1BillingInformation();

    }
    @Then("I fill up delivery information on Order Summary Page")
    public void i_fill_up_delivery_information_on_order_summary_page() {
        CheckOutPage checkout = new CheckOutPage(driver);
        checkout.fillUpStep2DeliveryInformation();

    }

    @Then("I am on Payment gateway page")
    public void I_am_on_Payment_gateway_page(){

        Assert.assertTrue(paymentPage.getPageTitle().contains("PayPal"), "Payment Gateway page not appeared.");
        Assert.assertTrue(paymentPage.getPageHeaderText().equalsIgnoreCase("Choose a way to pay"),"Payment Page header does not show as expected.");


    }
}
