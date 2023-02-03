package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProductDetailPage;
import pages.ProductViewCartPage;

import java.text.DecimalFormat;

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

    @When("I Update Qty as {string} on View Cart Page")
    public void i_update_qty_as_on_view_cart_page(String Qty) {
        // Write code here that turns the phrase above into concrete actions
        productViewCartPage.updateQuanity_ByRow(0,Qty);


    }

    @Then("The Product Image should be displayed as expected on View Cart Page")
    public void the_product_image_should_be_displayed_as_expected_on_view_cart_page() throws Exception {

        Assert.assertTrue(productViewCartPage.isProductImageDisplayed_ByRow(0),"Image is not displayed correctly for the product."); // these are all assuming having 1 record only.
    }

    @Then("The Product Name should be displayed as expected on View Cart Page")
    public void the_product_name_should_be_displayed_as_expected_on_view_cart_page() {
        //product name should be same as product name in product details page

        String expected_ProdName = productDetailPage.productTitle;
        String actual_ProdName = productViewCartPage.getProductName_ByRow(0);

        Assert.assertEquals(actual_ProdName, expected_ProdName, "Product name is not displayed correctly.");
    }
    @Then("The Product Sale Price should be displayed as expected on View Cart Page")
    public void the_product_sale_price_should_be_displayed_as_expected_on_view_cart_page() {

        String expected_SalePrice = productDetailPage.prodSalePrice;
        String actual_SalePrice = productViewCartPage.getProductSalePrice_ByRow(0);

        Assert.assertEquals(actual_SalePrice, expected_SalePrice, "Sales price is not displayed as expected.");

    }
    @Then("The Product SubTotal should be displayed as expected on View Cart Page")
    public void the_product_sub_total_should_be_displayed_as_expected_on_view_cart_page() {
        //sub total

        //get sale price in numbers only
        String salePrice = productViewCartPage.getProductSalePrice_Without_CurrencySymbol_ByRow(0);
        float salePrice_float = 0;
        if (NumberUtils.isParsable(salePrice))
            salePrice_float = Float.parseFloat(salePrice);

        //get Quantity price in numbers only
        String prodQty = productViewCartPage.getProductQtyEditBox_ByRow(0).getAttribute ("value");
        int qty = 0;
        if (NumberUtils.isParsable(prodQty))
            qty = Integer.parseInt(prodQty);

        DecimalFormat df = new DecimalFormat("0.00");

        Float f_expected_SubTotal = (salePrice_float * qty);
        String expected_SubTotal = String.format("£%.2f",f_expected_SubTotal); //adding £ sign to left to the decimal

        String actual_SubTotal = productViewCartPage.getProductSubTotal_ByRow(0);

        Assert.assertEquals(actual_SubTotal, expected_SubTotal, "Sub total values is not displayed as expected.");

    }
    @Then("The Delete option should be available to delete the Item on View Cart Page")
    public void the_delete_option_should_be_available_to_delete_the_item_on_view_cart_page() {
        Assert.assertTrue(productViewCartPage.getProductDeleteButton_ByRow(0).isDisplayed());
    }


    @Then("The Product OrderTotal should be displayed as expected on View Cart Page")
    public void the_product_order_total_should_be_displayed_as_expected_on_view_cart_page() {

        float f_expected_OrderTotal = 0;

        //calculate order total
        for (int x=0; x < productViewCartPage.getRows(); x++){
            //get subtotal
            String rowSubTotal = productViewCartPage.getProductSubTotal_ByRow(x).toString();
            rowSubTotal = rowSubTotal.replace("£","");

            float f_SubTotal = 0;

            //convert to decimal
            if (NumberUtils.isParsable(rowSubTotal))
                f_SubTotal = Float.parseFloat(rowSubTotal);

            f_expected_OrderTotal = f_expected_OrderTotal + f_SubTotal;


        }

        String expected_OrderTotal = String.format("£%.2f", f_expected_OrderTotal);
        String actual_OrderTotal =  productViewCartPage.getProductOrderTotal();

        Assert.assertEquals(actual_OrderTotal, expected_OrderTotal, "Order total value is not matching.");

    }



}
