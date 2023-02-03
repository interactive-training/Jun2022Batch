package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import org.w3c.dom.html.HTMLMenuElement;

public class ProductDetailPage {

    WebDriver driver;
    HomePage homePage;
    HomePageSearch homePageSearch;
    //Locators
    By byProductName = By.xpath("//div[@class='prodductdetails']/div[@class='htag']/h1");
    By byQtyDisplayed = By.xpath("//select[@name='quantity']");
    By byItemSalePrice = By.xpath("//span[@class='price']");
    By byQtyDropdown = By.xpath("//select[@name='quantity']");

    By by_AddToCart = By.xpath("//input[@id='add_to_cart']");
    By by_BuyNow = By.xpath("//img[@id='add_to_cart']");

    public String productQuanity = "1";
    public String prodSalePrice;

    public String productTitle;

    public WebElement get_AddToCartButton(){
        return driver.findElement(by_AddToCart);
    }
    public WebElement get_BuyNowButton(){
        return driver.findElement(by_BuyNow);
    }

    public String getBreadScrumbText(){
        return driver.findElement(By.xpath("//div[@class='breadcrumb']")).getText();
    }

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;

        //get item price from homepage
        homePage = new HomePage(driver);
        homePageSearch = new HomePageSearch(driver);

//        itemPrice = homePageSearch.getSalePrice();
    }

    public void verifyProductNameIsDisplayedCorrectly(String expectedProdName) {

        WebElement elmProdName = driver.findElement(byProductName);
        Assert.assertEquals(expectedProdName, elmProdName.getText(), "Product name is not matching in product detail page.");

    }

    public String getQuantity() {
        return this.productQuanity;
    }

    public String getProductTitle(){
        return this.productTitle;
    }
    public String getProdSalePrice() {
        return this.prodSalePrice;
    }

    public String getProductNameDisplayed() {

        WebElement elmProdName = driver.findElement(byProductName);
        return elmProdName.getText();

    }

    public void verifyQtyDisplayed() {

        String expQty = this.productQuanity;

        WebElement elmQtyDisplayed = driver.findElement(byQtyDisplayed);
        Select selectQty = new Select(elmQtyDisplayed);
        String actualQty = selectQty.getFirstSelectedOption().getText();
//        Integer intActQty = Integer.parseInt(strActQty);
        Assert.assertEquals(actualQty, expQty, "Quanity does not match.");

    }

    public void verifyItemRateDisplayed() {

        WebElement elmPrice = driver.findElement(byItemSalePrice);
        String actualSalePrice = elmPrice.getText();
        actualSalePrice = actualSalePrice.split("&")[0].trim();
        Assert.assertEquals(actualSalePrice, this.prodSalePrice, "The sale price is not matching");

    }

    public void updateQuantity(String qty) {
        // step 4 - add the product to the cart , qty = 2 (product details paga)
        WebElement elm = driver.findElement(byQtyDropdown);
        Select qtyDropdown = new Select(elm);
        qtyDropdown.selectByVisibleText(qty);
        this.productQuanity = qty;

    }

    public void addToCart() {

        //before add to cart, save details
        storeProdDetails();

        //add to cart
        driver.findElement(by_AddToCart).click();
    }

    public void buyNow(){

        //before add to cart, save details
        storeProdDetails();

        driver.findElement(by_BuyNow).click();
    }

    private void storeProdDetails(){

        this.productTitle = getProductNameDisplayed();
//        this.qty = getQuantity();
        this.prodSalePrice = getProdSalePrice();

        //store price
        String saleprice = driver.findElement(By.xpath("//span[@class='price']")).getText();
        saleprice =  saleprice.split("&")[0].toString().trim();
        this.prodSalePrice = saleprice;

    }

}
