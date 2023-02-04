package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

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
    public PaymentPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getPageHeaderText(){
        WebElement elm = driver.findElement(By.xpath("//h2[@class='contentTitle']"));
        return elm.getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void payNow(){
        //click the button paynow

        //Click button 'Pay now'
        WebElement btnPayNow = driver.findElement(byPayNow);
        btnPayNow.click();


    }
    public void choosePayByCard(String cardType){

        // Pay with my debit or credit card
        //card type
        if (cardType.equalsIgnoreCase("Visa/Delta/Electron")){
            WebElement elmCardType = driver.findElement(byCardType);
            Select optCardType = new Select(elmCardType);
            optCardType.selectByVisibleText("Visa/Delta/Electron");
        }
        else{
            System.out.println("It is not visa");
        }


    }

    public String getOrderTotal() {

        //verify total
        WebElement elmTotal_in_Payment_page = driver.findElement(byTotal);
        String total_in_Payment_page = elmTotal_in_Payment_page.getText();
        return total_in_Payment_page;


    }

    public void fillupDetailsForCardTypeVisa() {

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


    }


//        paymentPage.payByCardTypeMaster();
    //homework

//        paymentPage.payByCardTypeMaestro();
    //homework

//        paymentPage.payByPayPalAccount();
    // homework


}
