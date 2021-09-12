package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features = {
//        "src/test/resources/Features/Login.feature",
//        "src/test/resources/Features/Order.feature",
        "src/test/resources/Features/DeliveryAddress.feature"
},
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-reports/cucumber.json"})
public class Runner extends AbstractTestNGCucumberTests {

}