package pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepDefinitions.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class ProductListSearchPage {

    WebDriver driver;

    //product details
    public String productSalePrice;
    public String productFullName;


    //search locators
    private final By searchEditBox = By.xpath("//input[@name='q']");
    private final By searchButton = By.xpath("//input[@id='search_butn']");
    private final By itemsList = By.xpath("//div[@id='divgrid']//div[@class='newcategory_box']/a");


//    ProductDetailPage productDetailPage;

    public ProductListSearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public void buyProduct_fromSearchResult_By_ProdName(String itemName) {

        List<WebElement> elmItems = driver.findElements(itemsList);
        if (elmItems.size() <= 0) {
            Assert.fail("No items found to buy."); // instead of that we can throw exception as well , but we have to add exception handler to methods including step definition method, which is not good.(overwrite all exceptions, will not show detailed error messages)
        }

        System.out.println("Items count from search result : " + elmItems.size());
        Boolean itemFound = false;

        for (int x = 0; x < elmItems.size(); x++) {

            if (elmItems.get(x).getAttribute("title").contains(itemName)) {
                elmItems.get(x).click();
                itemFound = true;
                return;
            }

        }

        if (!itemFound) {
            Assert.fail("Could not find a matched item to buy. Please check the item name in your test data.");
        }

    }

    public List getProductNameListDisplayedFromSearch() {

        List<WebElement> elmItems = driver.findElements(itemsList);
        System.out.println("Items count : " + elmItems.size());
        System.out.println("Items list and printing .................");

        List s = new ArrayList();

//        List<String> s ;


        for (int x = 0; x < elmItems.size(); x++) {
            s.add(elmItems.get(x).getAttribute("title"));

        }

        return s;

    }

    public WebElement getProduct_Image_from_ProductCardElement(WebElement prodCard){

        WebElement elm = null;

        if (prodCard.getAttribute("class").equalsIgnoreCase("newcategory_box")){
            //get product image element
            elm = prodCard.findElement(By.xpath("/a/img"));
        }
        return elm;

    }

    public String getProduct_Title_from_ProductCardElement(WebElement prodCard){
        WebElement elm = null;
        String elmText = "";

        if (prodCard.getAttribute("class").contains ("newcategory_box")){
            //get product image element
            elm = prodCard.findElement(By.xpath("p/a"));
            elmText = elm.getText().trim();
        }
        else if (prodCard.getAttribute("class").equalsIgnoreCase("newmain_category_box")) {
            elm = prodCard.findElement(By.xpath("p/a"));
            elmText = elm.getAttribute("title").trim();
        }

            return elmText;

    }


    public String getProduct_SalePrice_from_ProductCardElement(WebElement prodCard){
        WebElement elm = null;
        String elmText = "";

        if (prodCard.getAttribute("class").equalsIgnoreCase("newcategory_box")){
            //get product image element
            elm = prodCard.findElement(By.xpath("div/div[@class='price']"));
            elmText = elm.getText().trim();
        }
        if (prodCard.getAttribute("class").equalsIgnoreCase("newmain_category_box")){
            //get product image element
            elm = prodCard.findElement(By.xpath("div[@class='price1']/div/p"));
            elmText = elm.getText().trim();
        }

        return elmText;
    }


    public WebElement getProduct_BasketImage_from_ProductCardElement(WebElement prodCard){
        WebElement elm = null;

        if (prodCard.getAttribute("class").equalsIgnoreCase("newcategory_box")){
            //get product image element
            elm = prodCard.findElement(By.xpath("div[@class='cart']"));
        }else if (prodCard.getAttribute("class").equalsIgnoreCase("newmain_category_box")) {
            elm = prodCard.findElement(By.xpath("div[@class='cart']/a"));
        }
        return elm;
    }

//
//    public void pickTheProductToPurchase(String productName) {
//
//        List<WebElement> elmItems = driver.findElements(itemsList);
//        System.out.println("Items count : " + elmItems.size());
//        System.out.println("Items list and printing .................");
//
//
//        for (int x = 0; x < elmItems.size(); x++) {
//            WebElement elmCurrentItem = elmItems.get(x);
//            String itemName = elmCurrentItem.getAttribute("title");
//
//            System.out.println("Item name is :" + itemName);
//
//            if (itemName.contains(productName)) {
//                //Yes, this item to purchase
//
//                //get full item name
//                this.productFullName = itemName;
//
//
//                //before clicking the link, store the rate here.
//                String p = "Dome Top Going Home Keepsake Urn Red";
////                String locatorSalePrice =
//
//                //found. before clicking and moving next page, store this page values may be required in next pages.
//                // instead of this, store values/whole web elements using page factory model.
//                By salePrice = By.xpath("//a[@title='" + p + "']/..//div[@class='price']/p");
//                //homework - try to take this xpath to top and fix the error (hits : we shold not use any variable in xpath -ex: p, for this, it is not allowing to put this xpath on top)
//
//
//                this.productSalePrice = driver.findElement(salePrice).getText();
//
//                //get the item's link to click , so that user can move to cart page
//                elmCurrentItem.click();
//                break;
//
//            }
//        } // end for loop
//
//    }

//    public boolean isProductAlertDisplayed() {
//        //there are 2 ways we can check.
//        // 1. using Expected Conditions
//        // 2. using try catch and handle error
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (Exception e) {
//
//            return false;
//        }
//
//    }

//    public String getProductName() {
//
//        return productFullName;
//    }
//
//    public String getSalePrice() {
//
//        return productSalePrice;
//    }

    public List<WebElement> get_All_ProductsDisplayed_in_SearchResultSection(){

        List<WebElement> listOfProducts;
        //when user moves from top categoris setion 'home deors', the elements ar different , so handling it.
        if (driver.getCurrentUrl().contains("/home-decors.html")){

           listOfProducts = driver.findElements(By.xpath("//div[@id='maincd']/div[@class='newmain_category_main']/div[@class='newmain_category_box']"));
        }
        else{
            listOfProducts = driver.findElements(By.xpath("//div[@id='divgrid']/div[@class='newcategory_main']/div"));

        }


        return listOfProducts;
    }


    public void buyFirstProductFromList() throws Exception {

        List<WebElement> prods = get_All_ProductsDisplayed_in_SearchResultSection();

        if (prods.size() <= 0){
            throw new Exception("No products displayed in product list page to buy.");
        }

        WebElement elmToBuy = prods.get(0);

        WebElement elmBasketToClick = getProduct_BasketImage_from_ProductCardElement(elmToBuy);

        //before moving out of this page, store values in class variables to access from other page / other step / next step in cucumber step
        this.productFullName = getProduct_Title_from_ProductCardElement(elmToBuy);
        this.productSalePrice = getProduct_SalePrice_from_ProductCardElement(elmToBuy);


        //click basket , it will move out of this page
        elmBasketToClick.click();


    }
    public void buyLastProductFromList() throws Exception {
        List<WebElement> prods = get_All_ProductsDisplayed_in_SearchResultSection();

        if (prods.size() <= 0){
            throw new Exception("No products displayed in product list page to buy.");
        }

        WebElement elmToBuy = prods.get(prods.size()-1);
        WebElement elmBasketToClick = getProduct_BasketImage_from_ProductCardElement(elmToBuy);

        //before moving out of this page, store values in class variables to access from other page / other step / next step in cucumber step
        this.productFullName = getProduct_Title_from_ProductCardElement(elmToBuy);
        this.productSalePrice = getProduct_SalePrice_from_ProductCardElement(elmToBuy);

        //click basket , it will move out of this page
        elmBasketToClick.click();
    }

}
