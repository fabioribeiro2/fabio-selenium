import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},features={"src/test/resources/features/Test.feature"},glue="stepdefinitions")
public class CucumberTest {

}
