package AccountServiceTest;

import org.junit.runner.RunWith;

//import org.junit.runner.RunWith;

/*import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)


@CucumberOptions( features = "src/test/resources/features" ,
glue = "ApplicationDataTest",
tags = {},
		
plugin = {"pretty:reports/cucumber-pretty-report/cucumber-pretty.txt",
"html:reports/cucumber-html-report",
 "json:reports/cucumber-usage-report/cucumber-usage.json",
 "junit:report/cucumber-junit-report/cucumber.xml"
}
		)
public class RunnerTest {
		
}*/

//import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(ExtendedCucumber.class)

@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml"
        },
        features = { "src/test/resources/features" },
        glue = {"classpath:AccountServiceTest"},
        tags = {"@Sonic"})
public class runnerTest{
}



