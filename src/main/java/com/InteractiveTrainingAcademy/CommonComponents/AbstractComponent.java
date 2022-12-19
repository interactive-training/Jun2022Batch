package com.InteractiveTrainingAcademy.CommonComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

    WebDriver driver;


    //locators


    //constructor
    public AbstractComponent(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToAppear_XPath(String elementXPATH){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPATH)));
    }

    public void waitForElementToAppear_By(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementToAppear_WebElementObject(WebElement webElementObject){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(webElementObject));
    }

}
