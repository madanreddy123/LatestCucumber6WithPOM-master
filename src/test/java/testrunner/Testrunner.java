package testrunner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/Login.feature"
                   , glue="steps", plugin = {"html:Report", "json:Report/report.json", "junit:Report/report.xml"},
                    monochrome=true)

//: is COLON 
//" QUOTATION MARK

public class Testrunner 
{
	
}