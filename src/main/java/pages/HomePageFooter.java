package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePageFooter {

    @FindBy(how = How.XPATH, using = "//div[@id='fleft']/div/div[@class='h']")
    public WebElement footerAddressBlock;

    // Web Elements on header
//    By eleganDecorsNameAndLogo = By.xpath("//a[@title='Elegant Decors']");
    WebDriver driver;

//    public WebElement footerAddressBlock = driver.findElement(By.xpath("//div[@id='fleft']/div/div[@class='h']"));

    public HomePageFooter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
