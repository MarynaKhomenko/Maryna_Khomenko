import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/feature"},
        glue = {"tests"},
        plugin = {"html:target/cucumber-report/report.html"},
        monochrome = true)
public class TestRunner {
}