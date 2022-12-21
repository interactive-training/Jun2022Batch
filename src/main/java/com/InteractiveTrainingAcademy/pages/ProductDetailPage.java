package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductDetailPage {

    WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;

    }

    public void verifyProductNameIsDisplayedCorrectly(String expectedProdName){

        WebElement elmProdName = driver.findElement(By.xpath("//div[@class='prodductdetails']/div[@class='htag']/h1"));
        Assert.assertEquals(expectedProdName,elmProdName.getText(), "Product name is not matching in product detail page.");

    }
    public void verifyQtyDisplayed(Integer expQty){

        WebElement elmQtyDisplayed = driver.findElement(By.xpath("//select[@name='quantity']"));
        Select selectQty = new Select(elmQtyDisplayed);
        String actQty = selectQty.getFirstSelectedOption().getText();
        Assert.assertEquals(actQty, expQty, "Quanity does not match.");

    }

    public void verifyRateDisplayed(String expectedSalePrice){
        WebElement elmPrice = driver.findElement(By.xpath("//span[@class='price']"));
        Assert.assertEquals(elmPrice.getText(),expectedSalePrice, "The sale price is not matching");


    }

    public void updateQuantity(Integer qty){
        // step 4 - add the product to the cart , qty = 2 (product details paga)
//        String QTY_TO_ENTER = "2";
        WebElement elm = driver.findElement(By.xpath("//select[@name='quantity']"));
        Select qtyDropdown = new Select(elm);
        qtyDropdown.selectByVisibleText(qty.toString());

    }


    public void addToCart(){

        //click Add to cart button (product details page)
        WebElement btnAddToCart = driver.findElement(By.xpath("//input[@id='add_to_cart']"));
        btnAddToCart.click();
    }

}
