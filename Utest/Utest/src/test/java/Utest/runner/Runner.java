package Utest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "/Users/nickyjr/Desktop/Selenium/JavaLab/Utest/Utest/src/test/java/Utest/features" }, glue = {
		"Utest.steps" }, monochrome = true, plugin = { "pretty" })
public class Runner {

}
