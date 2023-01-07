package org.example;

import com.InteractiveTrainingAcademy.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SubmitProductPurchaseTest {

    WebDriver driver;

    //open the browser
    @BeforeClass
    public void openBrowser() {
        System.out.println("Opening browser chrome");

        WebDriverManager.chromedriver().setup();

//      System.setProperty("webdriver.chrome.driver","D://Training//Tools_Software//ChromeDriver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //add implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void Search_BuyProduct_Login_and_Pay() {
        //navigate to homepage
//        driver.get("https://www.bipin.co.uk/elegant_decors/");

        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();

        //step 2 - search for product with search string
        homePage.searchProduct("Home");

        ////    step 3 - select the product to purchase from the product list
        String itemToPurchase = "Dome Top Going Home Keepsake Urn Red";
        homePage.pickTheProductToPurchase(itemToPurchase);

        //============================== Product detail page ====================
        ProductDetailPage prodDetailPage = new ProductDetailPage(driver);

        String prodName = homePage.getProductName();
        prodDetailPage.verifyProductNameIsDisplayedCorrectly(prodName);

        //verify default qty is displayed as 1 in Product detail page
        prodDetailPage.verifyQtyDisplayed();

        //verify default rate displayed correctly in Product detail page
        String productRate = homePage.getSalePrice();
        prodDetailPage.getItemPrice();

//        //Update Quanity
//        String QTY_TO_UPDATE = "1";
//        prodDetailPage.updateQuantity(QTY_TO_UPDATE);

        //verify the quantity is displayed correctly
        prodDetailPage.verifyQtyDisplayed(); //default 1

        //add to cart
        prodDetailPage.addToCart();

        //======================= View CART Page ====================

        ViewCartPage viewCartPage = new ViewCartPage(driver);

        //verify default msg displayed //homework, make these 2 methods as one method  - method overloading
        viewCartPage.verifyQtyMsgDisplayedDefault();

        //Verify default item name displayed compared to last page
        viewCartPage.verifyItemNameDisplayed(homePage.getProductName());

        //verify  quantity updated in EDIT box works fine and all msg displayed correctly
        String PROD_QTY = "3";
        viewCartPage.updateItemQty(PROD_QTY);
        viewCartPage.verifyQtyMsgDisplayedOnTop(PROD_QTY);

        //verify sub total is displayed / calcualted correctly
        viewCartPage.verifyItemSubTotal("£74.97");

        // click checkout button
        viewCartPage.checkout();
//        viewCartPage.verifyOrderTotal();
//        viewCartPage.verifyDeleteOneItem();
//        viewCartPage.verifyDeleteAllItems();


        //-------------Order summary page / Sign in page ---------------

        //verify 'order summary' page appears
        WebElement lblOrderSummary = driver.findElement(By.xpath("//button[@id='acc0id']"));
        String orderSummaryText = lblOrderSummary.getText();
        System.out.println(orderSummaryText);
        Assert.assertTrue(orderSummaryText.contains("Order Summary"), "Order summary page does not appear");

        //homework
        //verify item name is displayed on the page

        //homework
        //verify subtotal is displayed as expected (take value from last page)

        //verify subtotal is calculated correctly for each item  /// tricky - Xpath Sibling ,or parent can be used, explore various wa to find it.
//        homework

        //verify the total amount is calculated correctly
        // Sign In
        SignInPage signIn = new SignInPage(driver);
        signIn.login("testemail@mailinator.com", "Welcome123");

        ////////  *********** Order summary page **********************
        OrderSummaryPage orderSummary = new OrderSummaryPage(driver);
        orderSummary.fillUpStep1BillingInformation();
        orderSummary.fillUpStep2DeliveryInformation();
        orderSummary.verifyStep3OrderSummary("£74.97");
        orderSummary.proceedToPayment();

        //// *********** Payment page *****************
        PaymentGatewayPage paymentPage = new PaymentGatewayPage(driver);
        paymentPage.verfyOrderSummaryDetailSection("74.97"); // defect - $ sign is not displayed for the amount only in this page.
        paymentPage.payByCardTypeVisa();


//        Assert.assertTrue(true);

    } // end of Test method


    //close the browser
    @AfterClass
    public void TearDown() {

        driver.quit();
    }


}
