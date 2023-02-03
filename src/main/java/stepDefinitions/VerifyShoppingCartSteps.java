package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProductDetailPage;
import pages.ProductViewCartPage;

public class VerifyShoppingCartSteps {

//    WebDriver driver;
    ProductDetailPage productDetailPage;
    ProductViewCartPage productViewCartPage;


    public VerifyShoppingCartSteps(BaseTest base){
//        driver = base.getDriver();
        productDetailPage = base.getProductDetailPage();

        productViewCartPage = base.getProductViewCartPage();

    }

    @Then("I should be on View Cart Page")
    public void i_should_be_on_view_cart_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Assert.assertTrue(productViewCartPage.isViewCartPageDisplayed());


    }
    @Then("The Product Image should be displayed as expected on View Cart Page")
    public void the_product_image_should_be_displayed_as_expected_on_view_cart_page() throws Exception {

        Assert.assertTrue(productViewCartPage.isProductImageDisplayed_ByRow(0),"Image is not displayed correctly for the product."); // these are all assuming having 1 record only.
    }
    @Then("The Product Name should be displayed as expected  on View Cart Page")
    public void the_product_name_should_be_displayed_as_expected_on_view_cart_page() {
        //product name should be same as product name in product details page

        String expected_ProdName = productDetailPage.getProductNameDisplayed();
        String actual_ProdName = productViewCartPage.getProductName_ByRow(0);

        Assert.assertEquals(actual_ProdName, expected_ProdName, "Product name is not displayed correctly.");
    }
    @Then("The Product Sale Price should be displayed as expected  on View Cart Page")
    public void the_product_sale_price_should_be_displayed_as_expected_on_view_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The Product SubTotal should be displayed as expected  on View Cart Page")
    public void the_product_sub_total_should_be_displayed_as_expected_on_view_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The Delete option should be available to delete the Item  on View Cart Page")
    public void the_delete_option_should_be_available_to_delete_the_item_on_view_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
