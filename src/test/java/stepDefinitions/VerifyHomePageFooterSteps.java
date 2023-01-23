package stepDefinitions;

import com.InteractiveTrainingAcademy.pages.HomePage;
import com.InteractiveTrainingAcademy.pages.HomePageFooter;
import com.InteractiveTrainingAcademy.pages.HomePageHeader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class VerifyHomePageFooterSteps {

    WebDriver driver;

    HomePageFooter homePageFooter = null;

    public VerifyHomePageFooterSteps(BaseTest hooks){

        this.driver = hooks.driver;
        this.homePageFooter = hooks.getHomePageFooter();

        System.out.println("HOme page footer initialized");
    }

    @Then("I should see below address in footer section")
    public void I_should_see_below_address_in_footer_section(String s){

        System.out.println(s);

        //remove space

        /*
            === Note : Pramod, read to understnd ===

            Now, the task is get the actual text displayed in the browser for 'contact us' addres in footer setino of home page
            There are couple of ways we can do.
            Option 1. create webelement here and get the 'Text' preopry, which is dismissed as we will follow page object model
                as not to use any driver commands here in the step definition file.
            Option 2. Create a method called getContactUS()  in Homepage object which will return a String of contact us address.
            Option 3. Directly call the method of webelement getText here in the file,
                    The webelement should be public in pageobject
                    The webelement should already be initialied, means (using findElement ),
                    we should not call findElement method or driver here in the step definition.
                    ** This is achieved using page facttory class. (refer the code)

         */

        // using simple string comparison

        String expectedValue = s;
        expectedValue = s.trim();

        String actualValue = homePageFooter.footerAddressBlock.getText();
        actualValue = actualValue.trim();

        Assert.assertEquals(actualValue,expectedValue, "The address in footer is not displaying as expected.");


    }

    @Then("I should see below items in footer section")
    public void i_should_see_below_items_in_footer_section(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println("testing....");

        System.out.println(dataTable);

        List<Map<String ,String>>  data = dataTable.asMaps();

        //1st value
        System.out.println( "1 value : " + data.get(0).get("Categories") );

        for (int x=0; x < data.size(); x++)
        {
            //store the value in a variable
            String expectedValue  = data.get(x).get("Categories");
            By obj1 = null;

            if (expectedValue.equalsIgnoreCase("Cremation Urns")){
                obj1 = By.xpath("//a[@title='Cremation Urns' and @class='link1']");
            }
            else if (expectedValue.equalsIgnoreCase("Home Decors")) {
                obj1 = By.xpath("//a[@title='Home Decors' and @class='link1']");

            }

            WebElement elmactualValue = driver.findElement(obj1);
            String actualValue = elmactualValue.getText();

            //compare
            Assert.assertEquals(actualValue, expectedValue, "Footer text is not matching " + expectedValue);


        }


    }

}
