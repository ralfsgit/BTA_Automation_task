package testrunner;


import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value =
        "pretty, summary, json:target/reports/cucumber-reports/cucumber.json,"
                + " io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class TestRunner {

}
