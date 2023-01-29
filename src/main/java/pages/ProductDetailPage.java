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
    By byAddToCartButton = By.xpath("//input[@id='add_to_cart']");
    private String qty;
    private final String itemPrice;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        qty = "1";

        //get item price from homepage
        homePage = new HomePage(driver);
        homePageSearch = new HomePageSearch(driver);

        itemPrice = homePageSearch.getSalePrice();
    }

    public void verifyProductNameIsDisplayedCorrectly(String expectedProdName) {

        WebElement elmProdName = driver.findElement(byProductName);
        Assert.assertEquals(expectedProdName, elmProdName.getText(), "Product name is not matching in product detail page.");

    }

    public String getQuantity() {
        return this.qty;
    }

    public String getItemPrice() {
        return this.itemPrice;
    }

    public String getItemNameDisplayed() {

        WebElement elmProdName = driver.findElement(byProductName);
        return elmProdName.getText();

    }

    public void verifyQtyDisplayed() {

        String expQty = this.qty;

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
        Assert.assertEquals(actualSalePrice, this.itemPrice, "The sale price is not matching");

    }

    public void updateQuantity(String qty) {
        // step 4 - add the product to the cart , qty = 2 (product details paga)
        WebElement elm = driver.findElement(byQtyDropdown);
        Select qtyDropdown = new Select(elm);
        qtyDropdown.selectByVisibleText(qty);
        this.qty = qty;

    }

    public void addToCart() {

        //click Add to cart button (product details page)
        WebElement btnAddToCart = driver.findElement(byAddToCartButton);
        btnAddToCart.click();
    }

}
