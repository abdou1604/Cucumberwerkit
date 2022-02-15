package cucumberIU;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")  // tjr
@SelectClasspathResource("BDD") //  de la feature
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumberIU") // le nom du package
public class CucumberTest {
}
