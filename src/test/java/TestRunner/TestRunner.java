package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/resources/features",
        glue="stepDefinitions",
        tags="@smoke",
        plugin = {"pretty", "html:target/cucumber.html"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {


}
