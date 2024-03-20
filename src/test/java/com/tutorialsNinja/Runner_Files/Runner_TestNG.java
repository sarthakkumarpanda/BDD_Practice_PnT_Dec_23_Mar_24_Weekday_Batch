package com.tutorialsNinja.Runner_Files;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false, 
                 monochrome = true, 
                 features = { "src/test/resources/feature_files" }, 
                 glue = {"com.tutorialsNinja.Step_Definition_Files" }, 
                 plugin = { "pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json" })

public class Runner_TestNG extends AbstractTestNGCucumberTests{

}
