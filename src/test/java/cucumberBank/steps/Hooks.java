package cucumberBank.steps;

import cucumberBank.context.TestContext;
import cucumberBank.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static cucumberBank.context.TestContext.closeDriver;
import static cucumberBank.context.TestContext.getDriver;

public class Hooks {
    @Before
    public void beforeMethod(Scenario scenario){
        getDriver().get(ConfigurationReader.get("url"));
        TestContext.scenario=scenario;
    }

    @After
    public void afterMethod(){
        if(getDriver() !=null){
            closeDriver();
        }

    }
}
