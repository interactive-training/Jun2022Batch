package TestRunner;

//import com.cucumber.listener.Reporter;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import com.aventstack.extentreports.*;
import org.testng.annotations.AfterClass;

import java.io.File;

@CucumberOptions (
        features = "src/test/resources/features",
        glue="stepDefinitions",
        tags="",
        plugin = {"pretty",
                "html:target/cucumber-html-reports/cucumber-html-report.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
        monochrome = true
    )
public class TestRunnerExtentReport extends AbstractTestNGCucumberTests {


}
