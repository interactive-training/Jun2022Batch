package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@working",
        dryRun = true,
        plugin = {
                "pretty",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//                , "rerun:target/rerun_features.txt"
        }
)

public class TestRunnerDryRun extends AbstractTestNGCucumberTests {


}
