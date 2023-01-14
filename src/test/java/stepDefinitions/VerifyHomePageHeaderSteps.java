package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerifyHomePageHeaderSteps {

    WebDriver driver;

    public VerifyHomePageHeaderSteps(BaseTest hooks){

        this.driver = hooks.driver;
    }


}
