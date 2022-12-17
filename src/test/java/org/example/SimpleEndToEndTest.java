package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.web.WebErrorEvent;
import javafx.util.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleEndToEndTest {

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
        java.time.Duration.ofSeconds(10);

    }

//    @Test
//    public void Purchase_Product() throws InterruptedException {
//        System.out.printf("TEST method");
//
//        //navigate to home page
//        driver.get("https://www.bipin.co.uk/elegant_decors/");
//
//
//        //search a product
//        // type search string : ex: Home
//        // click on search button
//
//        WebElement editSearch = driver.findElement(By.xpath("//input[@name = 'q']"));
//        editSearch.clear();
//        editSearch.sendKeys("Home");
//
//        WebElement btnSearch = driver.findElement(By.xpath("//input[@id= 'search_butn']"));
//        btnSearch.click();
//
//        //select a product from the search items
//        List<WebElement>  products = driver.findElements(By.xpath("//div[@id='divgrid']/div/div[@class='newcategory_box']"));
//        System.out.println("products count " + products.size());
//
//        //1st product
//        System.out.println(products .get(0).getText());
//
////        products.get(1)
////        products.get(2)
////        products.get(4)
//        //in search view page, add this product to cart
//
//
//        //in cart page, confirm for payment
//
//    }

    //    sign in as existing customer
//    @Test
//    public void Logon_and_Buy_Product() throws InterruptedException {
//
//        //navigate to homepage
//        driver.get("https://www.bipin.co.uk/elegant_decors/");
//
//        Thread.sleep(5000);
//
//        //mouse hover  menu item,
//
//        WebElement elmMenu = driver.findElement(By.xpath("//div [@id='topbar']//img"));
//        Actions myActions   = new Actions(driver);
//        myActions.moveToElement(elmMenu).perform();
//
//        // click sign in sub menu
//        driver.findElement(By.cssSelector("a[title='Sign In']")).click();
//
////      Thread.sleep(100000);
//
//        //enter username
//        WebElement elmUserName = driver.findElement(By.xpath("//input[@id='user']"));
//        elmUserName.sendKeys("testemail@mailinator.com");
//
//        //enter password
//        WebElement editPassword = driver.findElement(By.xpath("//input[@id='pwd']"));
//        editPassword.sendKeys("Welcome123");
//
//        //submit the page
//        WebElement btnLogon = driver.findElement(By.xpath("//div[@class='forgot_r']/input[@name='image']"));
//        btnLogon.click();
//
//        //user landed on search page ------------>
//        System.out.println("The title of page is : " + driver.getTitle());
//        Thread.sleep(5000);
////        Getting page is not working error. it is not working. get the url and verify and make it pass
//
//        String expectedURL = "https://www.bipin.co.uk/elegant_decors/success.php";
//        String actualURL = driver.getCurrentUrl();
//        Assert.assertEquals(actualURL,expectedURL,"URLs are not matching");
//
//    }

    @Test
    public void Search_BuyProduct_Login_and_Pay() throws InterruptedException {

        //navigate to homepage
        driver.get("https://www.bipin.co.uk/elegant_decors/");

        //step 2 - search for product with search string
        WebElement editSearch = driver.findElement(By.xpath("//input[@name='q']"));
        editSearch.clear();
        editSearch.sendKeys("Home");

        driver.findElement(By.xpath("//input[@id='search_butn']")).click();

        ////    step 3 - select the product from a product name

        //usage of fiindElements ****

        String itemToPurchase = "Dome Top Going Home Keepsake Urn Red";

        List<WebElement> elmItems = driver.findElements(By.xpath("//div[@id='divgrid']//div[@class='newcategory_box']/a"));
        System.out.println("Items count : " + elmItems.size());
        System.out.println("Items list and printing .................");

        for (int x = 0; x <= elmItems.size(); x++) {
            WebElement elmCurrentItem = elmItems.get(x);
            String itemName = elmCurrentItem.getAttribute("title");

            System.out.println("Item name is :" + itemName);

            if (itemName.contains(itemToPurchase)) {
                //Yes, this item to purchase

                //get the item's link to click , so that user can move to cart page
                elmCurrentItem.click();
                break;

            }
        }

        // step 4 - add the product to the cart , qty = 2 (product details paga)
        String QTY_TO_ENTER = "2";
        WebElement elm = driver.findElement(By.xpath("//select[@name='quantity']"));
        Select qty = new Select(elm);
        qty.selectByVisibleText(QTY_TO_ENTER);

        //click Add to cart button (product details page)
        WebElement btnAddToCart = driver.findElement(By.xpath("//input[@id='add_to_cart']"));
        btnAddToCart.click();

        //------------------ View CART Page ----------------

        //verify text msg displayed as ...number of items added to the cart.... ex: You have 2 item in your shopping cart
        //**** homework - make it variable as qty - 2 / 3/ 4...

        //verify reached in the Cart page and verify the expected success msg.
        WebElement elmTextAddedToCart = driver.findElement(By.xpath("//div[@class='itemz']"));
        String msgAddToKart = elmTextAddedToCart.getText();
        Assert.assertEquals("You have 2 item in your shopping cart", msgAddToKart);


        //verify that the qty in editbox is same as qty selected in last page
        WebElement elmQty = driver.findElement(By.xpath("//input[@id='quantity0']"));
        String qtyDisplayed = elmQty.getAttribute("value");
        Assert.assertEquals(qtyDisplayed, QTY_TO_ENTER, "Quantity is not matching after updating it.");

        //verify same text msg and editbox value after updating to qty > 1
        //homework


        //click update button
        WebElement elmUpdateButton = driver.findElement(By.xpath("//img[@title='Update']"));
        elmUpdateButton.click();

        //verify qty is updated  correctly with  a message
        // * hint for xxpath *
        //can be validaeted different ways
        //1. construct a string with replacing the qty in the text , get the element by using any locator, get its full text and compare.
        //2. get the element with some text contains and get the full text, search the Qty exist in the text (use getText() method of element)
        //3. get the element with exact text in xpath with metbhod wrapping text()  ex: //*[normalize-space(text()) = 'Welcome'], because the text does not contain exact a single space inbetween it.
        //Homework

        //verify total amount updated correctly in View Cart page
        //homework


        //verify Subtotal displayed correctly
        //homework
            /* , find the 'sale price' with different xpath

            Option 1;
            //div[@id='wrapper']//p[contains(text(),'Sale Price')]/span

            Option 2: (given by Seletors hub, but Option 1 is more relevant)
            //div[@id='wrapper']//p[1]//span[1]

            Option 3:
            /html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/b[1]/div[2]/div[1]/ul[1]/li[2]/p[1]/span[1]

            */

        //click Checkout button
        WebElement elmBtnCheckout = driver.findElement(By.xpath("//div[@id='bottom_con_div_c']//img[@title='Secure Checkout']"));
        elmBtnCheckout.click();

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
        // homework

        //Login with the existing customer *********
        //enter username
        WebElement elmUserName = driver.findElement(By.xpath("//input[@id='user']"));
        elmUserName.sendKeys("testemail@mailinator.com");

        //enter password
        WebElement editPassword = driver.findElement(By.xpath("//input[@id='pwd']"));
        editPassword.sendKeys("Welcome123");

        //submit the page
        WebElement btnLogon = driver.findElement(By.xpath("//div[@class='forgot_r']/input[@name='image']"));
        btnLogon.click();

        //************

        ////////  *********** Order summary page **********************

        // step 1 - Billing information

        // Mr.
        WebElement elmOptTitle = driver.findElement(By.xpath("//select[@name='Title']"));
        Select optTitle = new Select(elmOptTitle);
        optTitle.selectByVisibleText("Mr");

        // First name
        WebElement elmFirstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
        elmFirstName.clear();
        elmFirstName.sendKeys("BillingFirstName");

        //Middle name
        WebElement elmMiddleName = driver.findElement(By.xpath("//input[@name='MiddleName']"));
        elmMiddleName.clear();
        elmMiddleName.sendKeys("BillingMiddleName");

        //Last name
        WebElement elmLastName = driver.findElement(By.xpath("//input[@name='LastName']"));
        elmLastName.clear();
        elmLastName.sendKeys("Test");

//        //Billing email id
//        WebElement elmEmail = driver.findElement(By.xpath("//input[@name='EmailID']"));
//        elmEmail.clear();
//        elmEmail.sendKeys("test@BillingMail.com");

        //Home  phone number
        WebElement elmHomePhone = driver.findElement(By.xpath("//input[@name='Home']"));
        elmHomePhone.clear();
        elmHomePhone.sendKeys("242244223233");

        //Street name
        WebElement elmStreetName = driver.findElement(By.xpath("//input[@name='StreetName']"));
        elmStreetName.clear();
        elmStreetName.sendKeys("Arboretum place");

        //City
        WebElement elmCity = driver.findElement(By.xpath("//input[@name='City']"));
        elmCity.clear();
        elmCity.sendKeys("London");

        //County
        WebElement elmCounty = driver.findElement(By.xpath("//input[@name='County']"));
        elmCounty.clear();
        elmCounty.sendKeys("Essex");

        //Country
        WebElement elmCountry = driver.findElement(By.xpath("//select[@name='Country']"));
        Select optCountry = new Select(elmCountry);
        optCountry.selectByVisibleText("United Kingdom");

        // Zip code
        WebElement elmZip = driver.findElement(By.xpath("//input[@name='ZipCode']"));
        elmZip.clear();
        elmZip.sendKeys("IS15 12M");


        // ============  STEP 2 : DELIVERY INFORMATION ============


        // ============  STEP 3 : ORDER SUMMARY ============
        //verify Total amount is same as previous screen
        WebElement elmTotalAmount_in_SummaryPage = driver.findElement(By.xpath("//table[@id='checkout-review-table']//tr[@class='last']/td[2]//span"));
        String totalAmount_in_SummaryPage = elmTotalAmount_in_SummaryPage.getText();
        Assert.assertEquals(totalAmount_in_SummaryPage, "49.98");


        //click 'proceed to payment' button
        WebElement btnProceedToPayment = driver.findElement(By.xpath("//img[@id='pay_button']"));
        btnProceedToPayment.click();
        Thread.sleep(2000);


        // ************

        ////// ***********  Choose a way to pay ************

        // Pay with my PayPal account


        // Pay with my debit or credit card
        //card type
        WebElement elmCardType = driver.findElement(By.xpath("//select[@id='credit_card_type']"));
        Select optCardType = new Select(elmCardType);
        optCardType.selectByVisibleText("Visa/Delta/Electron");

        //card number
        WebElement elmCardNumber = driver.findElement(By.xpath("//input[@name='creditCardNumber']"));
        elmCardNumber.sendKeys("7373 3738 8484 4848");

        //Expiry date
        WebElement elmExpiryDate_MM = driver.findElement(By.xpath("//input[@name='expiryMonth']"));
        elmExpiryDate_MM.sendKeys("12");

        WebElement elmExpiryDate_YY = driver.findElement(By.xpath("//input[@name='expiryYear']"));
        elmExpiryDate_MM.sendKeys("24");

        //CSC
        WebElement elmCSC = driver.findElement(By.xpath("//input[@name='cvv2']"));
        elmCSC.sendKeys("111");

        //Click button 'Pay now'
        WebElement btnPayNow = driver.findElement(By.xpath("//input[@name='_eventId_pay']"));
        btnPayNow.click();

        //getting error - on this page , expected

        //verify total
        WebElement elmTotal_in_Payment_page = driver.findElement(By.xpath("//div[@id='orderSummaryTotal']//span[@class='amount']"));
        String total_in_Payment_page = elmTotal_in_Payment_page.getText();
        Assert.assertEquals(total_in_Payment_page, totalAmount_in_SummaryPage);

        //********

        Assert.assertTrue(true);

    } // end of Test method

//     checkout product


//     pay for the product and verify the order is submitted


    //close the browser
    @AfterClass
    public void TearDown() {
        driver.quit();
    }


}
