import org.junit.runner.Description;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},tags={"@signup"},glue="stepdefinitions")
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
