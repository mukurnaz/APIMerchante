package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.Test;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepdefinitions","hooks"},
        dryRun = false,
        tags = "@SmokeTest",
        plugin = {"pretty",
                "html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json"
//                "junit:target/xml-report/cucumber.xml",
        }
)
public class BookerRunner {
}
