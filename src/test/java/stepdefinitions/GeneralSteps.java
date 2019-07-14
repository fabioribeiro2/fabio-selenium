package stepdefinitions;

import cucumber.api.java.en.Given;
import org.junit.BeforeClass;

public class GeneralSteps {

    @BeforeClass
    public void testone() {
        System.out.println("asdf");
        System.out.format("Thread ID - %2d\n",
                Thread.currentThread().getId());
    }
    
    @Given("First Step")
    public void firststep() throws Throwable {

    }
}