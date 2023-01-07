package com.InteractiveTrainingAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderSummaryPage {

    // private variables
    WebDriver driver;


    //locator variables
    By byTitle = By.xpath("//select[@name='Title']");
    By byFirstName = By.xpath("//input[@name='FirstName']");
    By byMiddleName = By.xpath("//input[@name='MiddleName']");
    By byLastName = By.xpath("//input[@name='LastName']");
    By byHomePhoneNumber = By.xpath("//input[@name='Home']");
    By byStreetName = By.xpath("//input[@name='StreetName']");
    By byCity = By.xpath("//input[@name='City']");
    By byCounty = By.xpath("//input[@name='County']");
    By byCountry = By.xpath("//select[@name='Country']");
    By byZipCode = By.xpath("//input[@name='ZipCode']");
    By byProceedToPaymentButton = By.xpath("//img[@id='pay_button']");
    By byTotalAmount = By.xpath("//table[@id='checkout-review-table']/tbody/tr[@class='last']/td[2]");
    By byPaymentCardType = By.xpath("//select[@id='credit_card_type']");


    public OrderSummaryPage(WebDriver driver){
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
        WebElement elmOptTitle = driver.findElement(byTitle);
        Select optTitle = new Select(elmOptTitle);
        optTitle.selectByVisibleText("Mr");

        // First name
        WebElement elmFirstName = driver.findElement(byFirstName);
        elmFirstName.clear();
        elmFirstName.sendKeys("BillingFirstName");

        //Middle name
        WebElement elmMiddleName = driver.findElement(byMiddleName);
        elmMiddleName.clear();
        elmMiddleName.sendKeys("BillingMiddleName");

        //Last name
        WebElement elmLastName = driver.findElement(byLastName);
        elmLastName.clear();
        elmLastName.sendKeys("Test");

//        //Billing email id - disabled
//        WebElement elmEmail = driver.findElement(By.xpath("//input[@name='EmailID']"));
//        elmEmail.clear();
//        elmEmail.sendKeys("test@BillingMail.com");

        //Home  phone number
        WebElement elmHomePhone = driver.findElement(byHomePhoneNumber);
        elmHomePhone.clear();
        elmHomePhone.sendKeys("242244223233");

        //Street name
        WebElement elmStreetName = driver.findElement(byStreetName);
        elmStreetName.clear();
        elmStreetName.sendKeys("Arboretum place");

        //City
        WebElement elmCity = driver.findElement(byCity);
        elmCity.clear();
        elmCity.sendKeys("London");

        //County
        WebElement elmCounty = driver.findElement(byCounty);
        elmCounty.clear();
        elmCounty.sendKeys("Essex");

        //Country
        WebElement elmCountry = driver.findElement(byCountry);
        Select optCountry = new Select(elmCountry);
        optCountry.selectByVisibleText("United Kingdom");

        // Zip code
        WebElement elmZip = driver.findElement(byZipCode);
        elmZip.clear();
        elmZip.sendKeys("IS15 12M");

    }

    public void fillUpStep2DeliveryInformation(){


        // ============  STEP 2 : DELIVERY INFORMATION ============

//        homework

    }

    public void verifyStep3OrderSummary(String expectedAmount){

        // ============  STEP 3 : ORDER SUMMARY ============
        //verify Total amount is same as previous screen
        WebElement elmTotalAmount_in_SummaryPage = driver.findElement(byTotalAmount);
        String totalAmount_in_SummaryPage = elmTotalAmount_in_SummaryPage.getText();
        Assert.assertEquals(totalAmount_in_SummaryPage, expectedAmount);

    }

    public void proceedToPayment(){

        //click 'proceed to payment' button
        WebElement btnProceedToPayment = driver.findElement(byProceedToPaymentButton);
        btnProceedToPayment.click();

//        Thread.sleep(2000);


        //explicit wait
        WebDriverWait myExplicitWait = new WebDriverWait(driver,10);
        myExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(byPaymentCardType));

    }

}
