package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@AndroidChrome",
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//                , "rerun:target/rerun_features.txt"
        }
)

public class TestRunnerMobileAndroidChrome extends AbstractTestNGCucumberTests {


}
