//package TestRunner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;
//import stepDefinitions.BaseTest;
//
//@CucumberOptions (
//        features = "src/test/resources/features",
//        glue="stepDefinitions",
//
//        tags="",
//        plugin = {
//                "pretty"
////                ,"html:target/cucumber/cucumber-html-report.html"
//                ,"json:target/cucumber/cucumber.json"
////                ,"junit:target/cucumber/cucumber.xml"
//                },
//        monochrome = true,
//        dryRun = false
//        )
//public class TestRunner extends AbstractTestNGCucumberTests {
//
////        @Override
////        @DataProvider(parallel=true)
////        public Object[][] scenarios(){
////                return super.scenarios();
////        }
//
//}