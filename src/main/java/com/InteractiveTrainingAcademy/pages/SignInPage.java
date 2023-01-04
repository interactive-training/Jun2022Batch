package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    WebDriver driver;


    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String username, String passwrod){


        //Login with the existing customer ********* Sign In Page while ordering *****
        //enter username
        WebElement elmUserName = driver.findElement(By.xpath("//input[@id='user']"));
        elmUserName.sendKeys(username);

        //enter password
        WebElement editPassword = driver.findElement(By.xpath("//input[@id='pwd']"));
        editPassword.sendKeys(passwrod);

        //submit the page
        WebElement btnLogon = driver.findElement(By.xpath("//div[@class='forgot_r']/input[@name='image']"));
        btnLogon.click();

        //homework
        //verify that the element (see top right corner of text with red color after logging in )
        // text should contain 'Welcome' , ex: Welcome Mr BillingFirstName Test



        //************

    }

}
