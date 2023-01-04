package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ViewCartPage {

    private WebDriver driver;
    private HomePage homePage;

    private ProductDetailPage prodDtlPage;


     public ViewCartPage(WebDriver driver){

        this.driver = driver;
        this.prodDtlPage = new ProductDetailPage(driver);
        this.homePage = new HomePage(driver);

//         qty = prodDtlPage.getQuantity();

    }

    public void verifyQtyMsgDisplayedDefault(){
        //verify reached in the Cart page and verify the expected success msg.
        WebElement elmTextAddedToCart = driver.findElement(By.xpath("//div[@class='itemz']"));
        String msgAddToCart = elmTextAddedToCart.getText();
        Assert.assertEquals("You have " + prodDtlPage.getQuantity() + " item in your shopping cart", msgAddToCart, "Message displayed on top is not matching.");
    }

    public void verifyQtyMsgDisplayedOnTop(String qty){
        //verify reached in the Cart page and verify the expected success msg.
        WebElement elmTextAddedToCart = driver.findElement(By.xpath("//div[@class='itemz']"));
        String msgAddToCart = elmTextAddedToCart.getText();
        Assert.assertEquals("You have " + qty + " item in your shopping cart", msgAddToCart, "Message displayed on top is not matching.");
    }

    public void verifyItemNameDisplayed(String itemNameExpected){

//        String itemNameExpected = homePage.getProductName();
        String itemNameActual = driver.findElement(By.xpath("//div[@class='options_a']//li[@class='cz']/span/a")).getText();
        Assert.assertEquals(itemNameExpected, itemNameActual, "Item name is not same");

    }

    public void updateItemQty(String qty) {

        //check if qty is a number -- homework
        WebElement elmEditQty = driver.findElement(By.xpath("//input[@name ='quantity0']"));
        elmEditQty.clear();
        elmEditQty.sendKeys(qty);

        //click update button
        WebElement btnUpdate = driver.findElement(By.xpath("//img[@title = 'Update']"));
        btnUpdate.click();

        //verify msg
        verifyQtyMsgDisplayedOnTop(qty);

        //update the qty variable

    }


    public void verifyOrderTotal(String expectedOrderTotal){
        //verify Total amount is same as previous screen
        WebElement elmTotalAmount_in_SummaryPage = driver.findElement(By.xpath("//table[@id='checkout-review-table']//tr[@class='last']/td[2]//span"));
        String totalAmount_in_SummaryPage = elmTotalAmount_in_SummaryPage.getText();
        Assert.assertEquals(expectedOrderTotal,  totalAmount_in_SummaryPage, "Order total value is not matching" );

    }

    public void checkout(){


        //Click Checkout button
        WebElement elmBtnCheckout = driver.findElement(By.xpath("//div[@id='bottom_con_div_c']//img[@title='Secure Checkout']"));
        elmBtnCheckout.click();

    }
    public void verifyItemSubTotal(String expectedSubTotal){

         String actualSubTotal = driver.findElement(By.xpath("//div[@class='options_a']/ul/li[4]")).getText();
        actualSubTotal = actualSubTotal.trim();
         Assert.assertEquals(expectedSubTotal,  actualSubTotal, "Order sub total value is not matching" );

//  home work
//        //get qty
//        String strQty = prodDtlPage.getQuantity();
//
//        //get item price (from home page)
//        String itemPrice = homePage.getSalePrice();
//
//        //calculate sub total
//        int intQty = 1;
//        float floatItemPrice = 2;
//
//
//        float subTotal = intQty * floatItemPrice;



    }

}

