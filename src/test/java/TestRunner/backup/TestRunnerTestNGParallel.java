//package TestRunner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.apache.commons.compress.utils.OsgiUtils;
//import org.testng.annotations.DataProvider;
//
//@CucumberOptions (
//        features = "src/test/resources/features",
//        glue="stepDefinitions",
//        tags="",
//        plugin = {
//                "pretty"
//                ,"html:target/cucumber-reports/cucumber-html-report.html"
//                ,"json:target/cucumber-reports/cucumber.json"
//                ,"junit:target/cucumber-reports/cucumber.xml"
//                },
//        monochrome = true,
//        dryRun = false
//        )
//public class TestRunnerTestNGParallel extends AbstractTestNGCucumberTests {
//
//        @Override
//        @DataProvider(parallel=true)
//        public Object[][] scenarios(){
//                System.out.println("before scenario output in test runner");
//
//                return super.scenarios();
//        }
//
//}
