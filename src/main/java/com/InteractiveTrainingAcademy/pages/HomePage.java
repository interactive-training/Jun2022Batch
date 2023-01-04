package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class HomePage {

    WebDriver driver;
    String productSalePrice;
    String productFullName;

    //locators


    //constructor
    public  HomePage(WebDriver driver){
        this.driver = driver;
    }

    //methods
    public void goToHomePage(){
        driver.get("https://www.bipin.co.uk/elegant_decors/");

    }

    public void searchProduct(String searchProductName){

        WebElement editSearch = driver.findElement(By.xpath("//input[@name='q']"));
        editSearch.clear();
        editSearch.sendKeys(searchProductName);

        driver.findElement(By.xpath("//input[@id='search_butn']")).click();

    }

    public void pickTheProductToPurchase(String productName){

        List<WebElement> elmItems = driver.findElements(By.xpath("//div[@id='divgrid']//div[@class='newcategory_box']/a"));
        System.out.println("Items count : " + elmItems.size());
        System.out.println("Items list and printing .................");


        for (int x = 0; x <= elmItems.size(); x++) {
            WebElement elmCurrentItem = elmItems.get(x);
            String itemName = elmCurrentItem.getAttribute("title");

            System.out.println("Item name is :" + itemName);

            if (itemName.contains(productName)) {
                //Yes, this item to purchase

                //get full item name
                this.productFullName = itemName;

                //before clicking the link, store the rate here.
                String p = "Dome Top Going Home Keepsake Urn Red";
                String locatorSalePrice = "//a[@title='" + p + "']/..//div[@class='price']/p";


                //found. before clicking and moving next page, store this page values may be required in next pages.
                // instead of this, store values/whole web elements using page factory model.

                this.productSalePrice =  driver.findElement(By.xpath(locatorSalePrice)).getText();


                //get the item's link to click , so that user can move to cart page
                elmCurrentItem.click();
                break;

            }
        } // end for loop



    }


    public String getProductName(){
        return productFullName;
    }
    public String getSalePrice(){

        return productSalePrice;
    }


}
