package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PaymentGatewayPage {


    WebDriver driver;

    //constructor
    public PaymentGatewayPage(WebDriver driver){
        this.driver = driver;

    }


    public void verfyOrderSummaryDetailSection(String expectedOrderTotal){

        //verify total
        WebElement elmTotal_in_Payment_page = driver.findElement(By.xpath("//div[@id='orderSummaryTotal']//span[@class='amount']"));
        String total_in_Payment_page = elmTotal_in_Payment_page.getText();
        Assert.assertEquals(expectedOrderTotal, total_in_Payment_page, "order summary total amount is not matching");


    }

    public void payByCardTypeVisa(){




        // Pay with my debit or credit card
        //card type
        WebElement elmCardType = driver.findElement(By.xpath("//select[@id='credit_card_type']"));

//        WebElement elmCardType = driver.findElement(By.xpath("//select[@id='credit_card_type']"));
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

    }
}
