package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProductDetailPage;
import pages.ProductListSearchPage;

public class VerifyProductDetailSteps {

    WebDriver driver;
    ProductDetailPage productDetailPage;
    ProductListSearchPage productListSearchPage;

    public VerifyProductDetailSteps(BaseTest base){
        this.driver = base.driver;
        productDetailPage = base.getProductDetailPage();
        productListSearchPage = base.getProdListSearchPage();

    }


    @When("I update Qty as {string} in Product details page")
    public void I_update_Qty_as_in_Product_details_page(String Qty){
        productDetailPage.updateQuantity(Qty);

    }

    @Then("I should be on Product details page")
    public void I_should_be_on_Product_details_page(){

        Assert.assertTrue(productDetailPage.get_AddToCartButton().isDisplayed() ==true, "Product details page does not appear");

    }

    @Then("I proceed with Buy Now in Product details page")
    public void i_proceed_with_buy_now_in_product_details_page() {
        productDetailPage.buyNow();
    }
    @Then("I proceed with Add to Cart in Product details page")
    public void i_proceed_with_add_to_cart_in_product_details_page() {
        productDetailPage.addToCart();
    }

    @Then("The Product name should be displayed on Product detail page as expected")
    public void the_product_name_should_be_displayed_on_product_detail_page_as_expected() {

        String expeted_ProdName = productListSearchPage.productFullName;
        String actual_ProdName = productDetailPage.getProductNameDisplayed();

        Assert.assertEquals(actual_ProdName, expeted_ProdName, "product name is not displayed correctly on product detail page.");
    }


}
