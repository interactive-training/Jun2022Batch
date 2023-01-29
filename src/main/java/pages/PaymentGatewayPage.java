package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PaymentGatewayPage {

    //member variables / class variables / instance variables
    WebDriver driver;


    //locators
    By byTotal = By.xpath("//div[@id='orderSummaryTotal']//span[@class='amount']");
    By byCardType = By.xpath("//select[@id='credit_card_type']");
    By byCreditCardNumber = By.xpath("//input[@name='creditCardNumber']");
    By byExpiryMonth = By.xpath("//input[@name='expiryMonth']");
    By byExpiryYear = By.xpath("//input[@name='expiryYear']");
    By byCVV = By.xpath("//input[@name='cvv2']");

    By byPayNow = By.xpath("//input[@name='_eventId_pay']");


    //constructor
    public PaymentGatewayPage(WebDriver driver) {
        this.driver = driver;

    }

    public void verfyOrderSummaryDetailSection(String expectedOrderTotal) {

        //verify total
        WebElement elmTotal_in_Payment_page = driver.findElement(byTotal);
        String total_in_Payment_page = elmTotal_in_Payment_page.getText();
        Assert.assertEquals(expectedOrderTotal, total_in_Payment_page, "order summary total amount is not matching");

    }

    public void payByCardTypeVisa() {

        // Pay with my debit or credit card
        //card type
        WebElement elmCardType = driver.findElement(byCardType);
        Select optCardType = new Select(elmCardType);
        optCardType.selectByVisibleText("Visa/Delta/Electron");

        //card number
        WebElement elmCardNumber = driver.findElement(byCreditCardNumber);
        elmCardNumber.sendKeys("7373 3738 8484 4848");

        //Expiry date
        WebElement elmExpiryDate_MM = driver.findElement(byExpiryMonth);
        elmExpiryDate_MM.sendKeys("12");

        WebElement elmExpiryDate_YY = driver.findElement(byExpiryYear);
        elmExpiryDate_MM.sendKeys("24");

        //CSC
        WebElement elmCSC = driver.findElement(byCVV);
        elmCSC.sendKeys("111");

        //Click button 'Pay now'
        WebElement btnPayNow = driver.findElement(byPayNow);
        btnPayNow.click();

    }


//        paymentPage.payByCardTypeMaster();
    //homework

//        paymentPage.payByCardTypeMaestro();
    //homework

//        paymentPage.payByPayPalAccount();
    // homework


}
