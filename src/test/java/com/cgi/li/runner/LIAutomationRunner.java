package com.cgi.li.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\Features\\login.feature"},
        glue = {"com/cgi/li/glucode"},
        monochrome = true,
        plugin = {"pretty","html:target\\result"}
)
public class LIAutomationRunner {
}
