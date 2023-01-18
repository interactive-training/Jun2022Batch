package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class HomePage {

    private WebDriver driver;
    private String productSalePrice;
    private String productFullName;

    //locators
    private By searchEditBox = By.xpath("//input[@name='q']");
    private By searchButton = By.xpath("//input[@id='search_butn']");
    private By itemsList = By.xpath("//div[@id='divgrid']//div[@class='newcategory_box']/a");

    //constructor
    public  HomePage(WebDriver driver){

        this.driver = driver;
    }

    //methods
    public void goToHomePage(){
        driver.get("https://www.bipin.co.uk/elegant_decors/");

    }

    public void searchProduct(String searchProductName){

        WebElement editSearch = driver.findElement(searchEditBox);
        editSearch.clear();
        editSearch.sendKeys(searchProductName);

        driver.findElement(searchButton).click();

    }

    public void pickTheProductToPurchase(String productName){

        List<WebElement> elmItems = driver.findElements(itemsList);
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
//                String locatorSalePrice =

                //found. before clicking and moving next page, store this page values may be required in next pages.
                // instead of this, store values/whole web elements using page factory model.
                By salePrice = By.xpath("//a[@title='" + p + "']/..//div[@class='price']/p");
                //homework - try to take this xpath to top and fix the error (hits : we shold not use any variable in xpath -ex: p, for this, it is not allowing to put this xpath on top)


                this.productSalePrice =  driver.findElement(salePrice).getText();

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
