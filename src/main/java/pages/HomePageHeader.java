package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageHeader {

    @FindBy(how = How.XPATH, using = "//a[@title='Elegant Decors']")
    public WebElement eleganDecorsNameAndLogo;

    // Web Elements on header
//    By eleganDecorsNameAndLogo = By.xpath("//a[@title='Elegant Decors']");
    WebDriver driver;
    By freeNextAndDeliveryMsg = By.xpath("//div[@class='nextdeltext']");
    By contactPhoneNumber = By.xpath("//div[@id='rightbar']/div[@Class='phone']");
    By menuButton = By.xpath("//div/ul/li/img");
    By cart = By.xpath("//div[@class='viewcart']");
    By productSearch = By.xpath("//div[@class='pattren']");

    public HomePageHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isDisplayed_eleganDecorsNameAndLogo() {
//        WebElement elmLogo = driver.findElement(eleganDecorsNameAndLogo);
//        return elmLogo.isDisplayed();

        return eleganDecorsNameAndLogo.isDisplayed();
    }

    public boolean isDisplayed_freeNextAndDeliveryMsg() {
        WebElement elmLogo = driver.findElement(freeNextAndDeliveryMsg);
        return elmLogo.isDisplayed();
    }

    public boolean isDisplayed_contactPhoneNumber() {
        WebElement elmLogo = driver.findElement(contactPhoneNumber);
        return elmLogo.isDisplayed();
    }

    public boolean isDisplayed_menuButton() {
        WebElement elmLogo = driver.findElement(menuButton);
        return elmLogo.isDisplayed();
    }

    public boolean isDisplayed_cartn() {
        WebElement elmLogo = driver.findElement(cart);
        return elmLogo.isDisplayed();
    }

    public boolean isDisplayed_productSearch() {
        WebElement elmLogo = driver.findElement(productSearch);
        return elmLogo.isDisplayed();
    }


}
