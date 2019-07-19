import org.junit.runner.Description;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import java.util.List;

/**
 * This is the runner class for the entire framework
 * Do not change this Class's name, it is required by JUnit
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = false, tags={"@all"},glue="stepdefinitions", plugin= { "pretty", "html:target/cucumber-reports" })
public class CucumberTest extends ParentRunner {

    protected CucumberTest(Class testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected List getChildren() {
        return null;
    }

    @Override
    protected Description describeChild(Object o) {
        return null;
    }

    @Override
    protected void runChild(Object o, RunNotifier runNotifier) {
        System.out.println("affasfasf");
    }
}
