package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//For running cumcumber we used TestNG and Junit
@CucumberOptions(features="src/test/java/cucumber", glue="cucumber.stepDefinitions", monochrome=true, tags="@Regression" ,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
}