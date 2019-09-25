package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"C:\\Users\\lakshmi7885\\eclipse-workspace\\com.gmail.BDD\\src\\test\\resources\\gmailresources\\feature1.feature",
		},
		monochrome=true,
		glue= {"classpath:test"},
		plugin= {"pretty","html:target\\resultsbdd"}
)
public class Gmailbddrunner {

}
