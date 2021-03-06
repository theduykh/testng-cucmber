package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/main/resources/features"})
public class Main extends AbstractTestNGCucumberTests {
    private final Logger logger = LogManager.getLogger(Main.class);

    public Main() {
        WebDriverManager.chromedriver().setup();
        logger.info("Starting test");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
