package pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class OrderSummaryPage{

    // private variables
    WebDriver driver;

//    ProductDetailPage productDetailPage;

    List<WebElement> orderElements;
    List<WebElement> orderSummaryProductNameList;

    List<WebElement> orderSummaryProductSalePriceList;

    List<WebElement> orderSummaryProductSubTotalList;

    WebElement orderSummaryHeaderTotal;

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

    ProductDetailPage productDetailPage;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
//        loadData();

    }

    public String getOrderSummaryPageTitle(){
        return driver.findElement(By.xpath("//button[@id='acc0id']")).getText();
    }

    public String getQuantity() {

        //verify that the qty in editbox is same as qty selected in last page
        WebElement elmQty = driver.findElement(byQty);
        String qtyDisplayed = elmQty.getAttribute("value");
        return qtyDisplayed;

    }


    public String getOrderTotal() {

        loadData();

        // ============  STEP 3 : ORDER SUMMARY ============
        //verify Total amount is same as previous screen
//        WebElement elmTotalAmount_in_SummaryPage = driver.findElement(orderSummaryHeaderTotal);
        String totalAmount_in_SummaryPage = orderSummaryHeaderTotal.getText();
        return totalAmount_in_SummaryPage;


    }

    public WebElement getOrderHeaderExpandButton(){
        WebElement elm = driver.findElement(By.xpath("//button[@id='acc0id']"));
        return elm;
    }

    public Boolean isOrderSummaryHeaderExpanded(){
        WebElement elm = this.getOrderHeaderExpandButton();
        String elm_area_expanded = elm.getAttribute("aria-expanded").toString();
        Boolean isExpanded = (elm_area_expanded.contains("true"));
        return isExpanded;
    }

    public void expand_OrderSummaryHeader_if_closed(){
        WebElement elm = this.getOrderHeaderExpandButton();
        if (!this.isOrderSummaryHeaderExpanded()){
            elm.click(); //expand it.
        }

    }

    public void loadData(){

        orderElements = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']"));
        orderSummaryProductNameList = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']/*/div[@class='titl']/a"));
        orderSummaryProductSalePriceList = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']/*/div[@class='titl_price']"));
        orderSummaryProductSubTotalList = driver.findElements(By.xpath("//div[@id='acc0']/div[@class='ordersummer_main']/div[@class='ordersummer_price']"));

        orderSummaryHeaderTotal = driver.findElement(By.xpath("//button[@id='acc0id']/div"));
    }


    public int getProductRows(){
        this.loadData();
        return orderElements.size();
    }

    public void clickProductName_byRow(int RowIndex){
        this.loadData();
        WebElement elm = orderSummaryProductNameList.get(RowIndex);
        elm.click();

    }
    public String getProductName_byRow(int RowIndex){
        this.loadData();
        return orderSummaryProductNameList.get(RowIndex).getText();
    }

    public String getProductSalePrice_ByRow(int RowIndex){
        this.loadData();
        return orderSummaryProductSalePriceList.get(RowIndex).getText();
    }

    public String getProductSubTotal_ByRow(int RowIndex){
        this.loadData();
        return orderSummaryProductSubTotalList.get(RowIndex).getText();
    }

    public void verify_ProductDetailsPage_opens_on_new_tab(ProductDetailPage prodDetailPage){

        // *** Note:
        //expects new tab to open. and assume that it is already opened it. But not switched.
        // Before switch, save the current tab product details to compare

        String expected_prodName = getProductName_byRow(0);
        Set<String> winHandles = driver.getWindowHandles();
        String newTabHandle = winHandles.toArray()[winHandles.size()-1].toString();
        driver.switchTo().window(newTabHandle);

        String actual_ProName = prodDetailPage.getProductNameDisplayed();

        Assert.assertTrue(expected_prodName.contains(actual_ProName), "Product name is not matching between Order summary and Product Deails page.");
        driver.switchTo().defaultContent();


    } //end method

    public String getOrderTotal_FooterSection(){
        return driver.findElement(By.xpath("//span[@class='showamount2aaa']")).getText().toString();
    }



} // end class
