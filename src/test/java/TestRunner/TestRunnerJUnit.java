package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue="stepDefinitions",
        tags="",
        plugin = {
                "pretty"
//                ,"html:target/cucumberReport/cucumber-html-report.html"
                ,"json:target/cucumberReport/cucumber.json"
//                ,"junit:target/cucumberReport/cucumber.xml"
                },
        monochrome = true,
        dryRun = false
        )
public class TestRunnerJUnit  {

//        @Override
//        @DataProvider(parallel=true)
//        public Object[][] scenarios(){
//                return super.scenarios();
//        }

}
