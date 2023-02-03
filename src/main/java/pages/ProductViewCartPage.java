package pages;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
        import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductViewCartPage {

    WebDriver driver;

    By tableData = By.xpath("//div[@id='view_cart']//div[@class='options_a']");

    By by_cartTableImageLinkList = By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/span/a");
    By by_cartTableImageList = By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/span/a/img");
    By by_cartTableProductNameList =  By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/following-sibling::*[position()=1]/span");
    By by_cartTableProductSalePriceList =  By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/following-sibling::*[position()=1]/p/span");
    By by_cartTableProductQtyList =  By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/following-sibling::*[position()=2]/span/input");
    By by_cartTableProductQtyUpdateButtonList =  (By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/following-sibling::*[position()=2]/span/span/img"));
    By by_cartTableProductSubTotal =  By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/following-sibling::*[position()=3]/span");
    By by_cartTableProductDeleteButton =  By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']/following-sibling::*[position()=4 and @class='cz']");

    //order total
    By by_orderTotal = By.xpath("//div[@id='totprice']");


    //checkout button
    By by_CheckoutImage = By.xpath("//div[@id='bottom_con_div_c']/div/a/img");


    List<WebElement> cartTableImageLinkList;
    List<WebElement>  cartTableImageList;
    List<WebElement>  cartTableProductNameList;
    List<WebElement>  cartTableProductSalePriceList;
    List<WebElement>  cartTableProductQtyList;
    List<WebElement>  cartTableProductQtyUpdateButtonList;
    List<WebElement>  cartTableProductSubTotal;
    List<WebElement>  cartTableProductDeleteButton;

    WebElement orderTotalElement;

    public ProductViewCartPage(WebDriver driver) {

        this.driver = driver;
        loadAndSaveCartTableData();

    }

    public void loadAndSaveCartTableData(){

       cartTableImageLinkList = driver.findElements(by_cartTableImageLinkList);

       cartTableImageList = driver.findElements(by_cartTableImageList);

       cartTableProductNameList =  driver.findElements(by_cartTableProductNameList);

       cartTableProductSalePriceList =  driver.findElements(by_cartTableProductSalePriceList);

       cartTableProductQtyList =  driver.findElements(by_cartTableProductQtyList);

       cartTableProductQtyUpdateButtonList =  driver.findElements(by_cartTableProductQtyUpdateButtonList);

       cartTableProductSubTotal =  driver.findElements(by_cartTableProductSubTotal);

       cartTableProductDeleteButton =  driver.findElements(by_cartTableProductDeleteButton);

       orderTotalElement = driver.findElement(by_orderTotal);
    }

    public boolean isViewCartPageDisplayed(){
        WebElement elm = driver.findElement(By.xpath("//h1[normalize-space()='View Cart']"));
        return elm.isDisplayed();
    }

    public void verifyQtyMsgDisplayedOnTop(String qty) {
        //verify reached in the Cart page and verify the expected success msg.
        WebElement elmTextAddedToCart = driver.findElement(By.xpath("//div[@class='itemz']"));
        String msgAddToCart = elmTextAddedToCart.getText();
        Assert.assertEquals("You have " + qty + " item in your shopping cart", msgAddToCart, "Message displayed on top is not matching.");
    }

    public int getRows(){

        By tableRows = By.xpath("//div[@id='view_cart']//div[@class='options_a']/ul/li[@class='imgz']");
        List<WebElement> rowsElements = driver.findElements(tableRows);
        return rowsElements.size();
    }

    public boolean isProductImageDisplayed_ByRow(int rowIndex) throws Exception {

        WebElement elm = cartTableImageList.get(rowIndex);

        //verify if the naturalHeight is > 0 for image to be displayed on page.

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String h = js.executeScript("return arguments[0].naturalHeight",elm).toString();

        if (StringUtils.isNumeric(h)){
            return (Integer.parseInt(h) > 0);
        }
        else{
            throw new Exception("Invalid output returned from javascript executor while getting the naturalHeight of an object. Please check if it is undefined.");
        }

    }

    public WebElement getProductImageLink_ByRow(int rowIndex){
        WebElement elm = cartTableImageLinkList.get(rowIndex);
        return elm;
    }

    public String getProductName_ByRow(int rowIndex){
        WebElement elm = cartTableProductNameList.get(rowIndex);
        return elm.getText();
    }

    public String getProductSalePrice_ByRow(int rowIndex){
        WebElement elm = cartTableProductSalePriceList.get(rowIndex);
        return elm.getText().trim();
    }

    public String getProductSalePrice_Without_CurrencySymbol_ByRow(int rowIndex){
        String salePrice =  getProductSalePrice_ByRow(rowIndex);
        salePrice = salePrice.replace("£","").trim();
        return salePrice;
    }

    public WebElement getProductQtyEditBox_ByRow(int rowIndex){
        return cartTableProductQtyList.get(rowIndex);
    }
    public WebElement getProductUpdateButton_ByRow(int rowIndex){
        return cartTableProductQtyUpdateButtonList.get(rowIndex);
    }

    public String getProductSubTotal_ByRow(int rowIndex){
        return cartTableProductSubTotal.get(rowIndex).getText();
    }

    public WebElement getProductDeleteButton_ByRow(int rowIndex){
        return cartTableProductDeleteButton.get(rowIndex);
    }

    public String getProductOrderTotal(){
        return orderTotalElement.getText();
    }


    public void updateQuanity_ByRow(int rowIndex, String Qty){
        WebElement elm = getProductQtyEditBox_ByRow(rowIndex);
        elm.clear();
        elm.sendKeys(Qty);

        //update
        WebElement elmButton = getProductUpdateButton_ByRow(rowIndex);
        elmButton.click();

        //after updating quanity, update the data. Actually this particular row should be updated, but as of now, just calling the method to update all again.
        loadAndSaveCartTableData();

    }

    public void deleteProduct_ByRow(int rowIndex){
        WebElement elm = getProductDeleteButton_ByRow(rowIndex);
        elm.click();

        //expecting alert present, click 'ok'
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        //*** Note verify the msg  displayed on top as delted , The row is removed actually. *** Do not verify in page object, verification done in Step defintioins / test files. (testng)
        // how to verify if the row is deleted ? check the rowcount should be reduced to -1 , (store the rowcount before deleting)
        // and the item by name should not exist.

    }

    public void checkOut(){


        WebElement elm = driver.findElement(by_CheckoutImage);

        //befor clicking ? update the webelement, but it should be cached, use pagefactory here, because aftter moving out from this page, I should be able to access the element and its data, but could not do any action, that is fine.

        loadAndSaveCartTableData();

        elm.click();

    }

}

