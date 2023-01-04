package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderSummary {

    WebDriver driver;

    public OrderSummary(WebDriver driver){
        this.driver = driver;

    }

    public String getQuantity(){

        //verify that the qty in editbox is same as qty selected in last page
        WebElement elmQty = driver.findElement(By.xpath("//input[@id='quantity0']"));
        String qtyDisplayed = elmQty.getAttribute("value");
        return qtyDisplayed;

    }


    public void fillUpStep1BillingInformation(){
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

    }

    public void fillUpStep2DeliveryInformation(){


        // ============  STEP 2 : DELIVERY INFORMATION ============

//        homework

    }

    public void verifyStep3OrderSummary(){

        // ============  STEP 3 : ORDER SUMMARY ============
        //verify Total amount is same as previous screen
        WebElement elmTotalAmount_in_SummaryPage = driver.findElement(By.xpath("//table[@id='checkout-review-table']//tr[@class='last']/td[2]//span"));
        String totalAmount_in_SummaryPage = elmTotalAmount_in_SummaryPage.getText();
        Assert.assertEquals(totalAmount_in_SummaryPage, "49.98");




    }

    public void proceedToPayment(){

        //click 'proceed to payment' button
        WebElement btnProceedToPayment = driver.findElement(By.xpath("//img[@id='pay_button']"));
        btnProceedToPayment.click();

//        Thread.sleep(2000);


        //explicit wait
        WebDriverWait myExplicitWait = new WebDriverWait(driver,10);
        myExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='credit_card_type']")));

    }

}
