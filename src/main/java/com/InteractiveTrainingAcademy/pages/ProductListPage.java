package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage {

    WebDriver driver;


    //locators


    //constructor
    public ProductListPage(WebDriver driver){
        this.driver = driver;
    }

    //methods


    public void pickProduct(String productName){

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
    }


}
