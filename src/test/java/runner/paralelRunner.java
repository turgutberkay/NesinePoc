package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","util"},
        tags = "@All",
        plugin = {
                "summary",
                "html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = false
)
public class paralelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

}


