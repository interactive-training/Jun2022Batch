package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    // private variables
    WebDriver driver;

//    ProductDetailPage productDetailPage;

//    List<WebElement> orderElements;
//    List<WebElement> orderSummaryProductNameList;
//
//    List<WebElement> orderSummaryProductSalePriceList;
//
//    List<WebElement> orderSummaryProductSubTotalList;
//
//    WebElement orderSummaryHeaderTotal;

    //locator variables

    By byQty = By.xpath("//input[@id='quantity0']");
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

//    ProductDetailPage productDetailPage;

    Faker faker = new Faker();

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;

    }


    public void proceedToPayment() {

        //click 'proceed to payment' button
        WebElement btnProceedToPayment = driver.findElement(byProceedToPaymentButton);
        btnProceedToPayment.click();



        //explicit wait
//        WebDriverWait myExplicitWait = new WebDriverWait(driver,10); // selenium 3

        WebDriverWait myExplicitWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Selenium 4

        myExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(byPaymentCardType));

    }

    public void fillUpStep1BillingInformation() {
        // step 1 - Billing information

        // Mr.
        WebElement elmOptTitle = driver.findElement(byTitle);
        Select optTitle = new Select(elmOptTitle);
        optTitle.selectByVisibleText("Mr");

        // First name
        WebElement elmFirstName = driver.findElement(byFirstName);
        elmFirstName.clear();
        elmFirstName.sendKeys(faker.name().firstName());

        //Middle name
        WebElement elmMiddleName = driver.findElement(byMiddleName);
        elmMiddleName.clear();
        elmMiddleName.sendKeys(faker.name().firstName());

        //Last name
        WebElement elmLastName = driver.findElement(byLastName);
        elmLastName.clear();
        elmLastName.sendKeys(faker.name().lastName());

//        //Billing email id - disabled
//        WebElement elmEmail = driver.findElement(By.xpath("//input[@name='EmailID']"));
//        elmEmail.clear();
//        elmEmail.sendKeys("test@BillingMail.com");

        //Home  phone number
        WebElement elmHomePhone = driver.findElement(byHomePhoneNumber);
        elmHomePhone.clear();
        elmHomePhone.sendKeys(faker.phoneNumber().phoneNumber());

        //Street name
        WebElement elmStreetName = driver.findElement(byStreetName);
        elmStreetName.clear();
        elmStreetName.sendKeys(faker.address().streetAddress());

        //City
        WebElement elmCity = driver.findElement(byCity);
        elmCity.clear();
        elmCity.sendKeys(faker.address().city());

        //County
        WebElement elmCounty = driver.findElement(byCounty);
        elmCounty.clear();
        elmCounty.sendKeys(faker.address().state());

        //Country
        WebElement elmCountry = driver.findElement(byCountry);
        Select optCountry = new Select(elmCountry);
        optCountry.selectByVisibleText("United Kingdom"); //drop down

        // Zip code
        WebElement elmZip = driver.findElement(byZipCode);
        elmZip.clear();
        elmZip.sendKeys(faker.address().zipCode());

    }

    public void fillUpStep2DeliveryInformation() {


        // ============  STEP 2 : DELIVERY INFORMATION ============

//        homework

    }

//
//    public void loadData(){
//
//        orderElements = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']"));
//        orderSummaryProductNameList = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']/*/div[@class='titl']/a"));
//        orderSummaryProductSalePriceList = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']/*/div[@class='titl_price']"));
//        orderSummaryProductSubTotalList = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']/div[@class='ordersummer_price']"));
//
//        orderSummaryHeaderTotal = driver.findElement(By.xpath("//button[@id='acc0id']/div"));
//    }



} // end class
