package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps",
        //if we set dryRun to true, then no actual execution happens
        //it will quickly scan all gherkin steps whether they have implementation or not
    //    dryRun = false,
        //it keeps console output for the cucumber test easily readable
        //it will remove all the unreadable character
        monochrome = true,
        tags = "@DB",
        //strict=true, it will check all the steps definition
        plugin = {"pretty"}
        //plugin  - we use it to generate report for the execution
        //pretty - takes care of printing the steps in console

)

public class FailedRunner {
}
