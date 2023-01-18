package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions (
        features = "src/test/resources/features",
        glue="stepDefinitions",
//        tags="@smoke",
        plugin = { "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "junit:target/cucumber/cucumber.xml"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel=true)
        public Object[][] scenarios(){
                return super.scenarios();
        }


}
