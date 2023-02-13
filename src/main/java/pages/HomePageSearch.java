package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePageSearch {

    WebDriver driver;

    //product details
    private String productSalePrice;
    private String productFullName;


    //search locators
    private final By searchEditBox = By.xpath("//input[@name='q']");
    private final By searchButton = By.xpath("//input[@id='search_butn']");
    private final By itemsList = By.xpath("//div[@id='divgrid']//div[@class='newcategory_box']/a");


    public HomePageSearch(WebDriver driverParameter) {
        this.driver = driverParameter;

    }



    public List<String> getItemsNameFromSearchDropDown() {

        //***Note:
        // expect that the dropdown is on Open state (after typing any key)
        // how to check, there are many ways (using if condition),
        // but prefer to use in built Seleniums method. -- Wait.
        // If this wait does not work, then it will throw error , work like Assertions.

        WebElement elmDropDownBox = driver.findElement(By.xpath("//ul[@id='ui-id-1']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000)); //waiting for 2 seconds to appear the drop down
        wait.until(ExpectedConditions.visibilityOf(elmDropDownBox));


        // get list of items (html tag - li) in the dropdown
        List<WebElement> elmItems = elmDropDownBox.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

        List<String> elmItemsNameList = new ArrayList();

        for (WebElement elm : elmItems) {
            //get the text
            System.out.println(elm.getText());
            elmItemsNameList.add(elm.getText());
        }

        return elmItemsNameList;

    } // method close


    public void searchProductWithKeyPressEnter(String searchProductName) {

        enterProductNameInSearchEditBox(searchProductName);

        //press enter key using action
        Actions action = new Actions(driver);
        action.keyDown(driver.findElement(searchEditBox), Keys.ENTER);
        action.build().perform();

    }

    public void enterProductNameInSearchEditBox(String searchProductName) {
        WebElement editSearch = driver.findElement(searchEditBox);
        editSearch.clear();
        editSearch.click(); // for android chrome , keyboard should appear
        editSearch.sendKeys(searchProductName);
    }

    public void searchProduct(String searchProductName) throws InterruptedException {

        enterProductNameInSearchEditBox(searchProductName);
        Thread.sleep(1000);
        driver.findElement(searchButton).click();
    }

    public void BuyItemFromSearchResult(String itemName) {

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

    public void pickTheProductToPurchase(String productName) {

        List<WebElement> elmItems = driver.findElements(itemsList);
        System.out.println("Items count : " + elmItems.size());
        System.out.println("Items list and printing .................");


        for (int x = 0; x < elmItems.size(); x++) {
            WebElement elmCurrentItem = elmItems.get(x);
            String itemName = elmCurrentItem.getAttribute("title");

            System.out.println("Item name is :" + itemName);

            if (itemName.contains(productName)) {
                //Yes, this item to purchase

                //get full item name
                this.productFullName = itemName;


                //before clicking the link, store the rate here.
                String p = "Dome Top Going Home Keepsake Urn Red";
//                String locatorSalePrice =

                //found. before clicking and moving next page, store this page values may be required in next pages.
                // instead of this, store values/whole web elements using page factory model.
                By salePrice = By.xpath("//a[@title='" + p + "']/..//div[@class='price']/p");
                //homework - try to take this xpath to top and fix the error (hits : we shold not use any variable in xpath -ex: p, for this, it is not allowing to put this xpath on top)


                this.productSalePrice = driver.findElement(salePrice).getText();

                //get the item's link to click , so that user can move to cart page
                elmCurrentItem.click();
                break;

            }
        } // end for loop

    }

    public boolean isProductAlertDisplayed() {
        //there are 2 ways we can check.
        // 1. using Expected Conditions
        // 2. using try catch and handle error
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    public String getProductName() {

        return productFullName;
    }

    public String getSalePrice() {

        return productSalePrice;
    }

    public List<WebElement> get_All_ProductsDisplayed_in_SearchResultSection(){
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@id='divgrid']/div[@class='newcategory_main']/div"));
        return listOfProducts;
    }

}
