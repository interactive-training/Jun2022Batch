package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;


    //locators


    //constructor
    public  HomePage(WebDriver driver){
        this.driver = driver;
    }

    //methods
    public void goToHomePage(){
        driver.get("https://www.bipin.co.uk/elegant_decors/");

    }

    public void SearchProduct(String searchProductName){
        WebElement editSearch = driver.findElement(By.xpath("//input[@name='q']"));
        editSearch.clear();
        editSearch.sendKeys(searchProductName);

        driver.findElement(By.xpath("//input[@id='search_butn']")).click();

    }


}
