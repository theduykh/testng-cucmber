package org.example.utils;

import org.openqa.selenium.WebDriver;

public class BaseStepDef {

    protected WebDriver driver;
    protected StepContext context;

    public BaseStepDef(StepContext context) {
        driver = context.getDriver();
        this.context = context;
    }
}
