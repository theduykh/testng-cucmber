package org.example.stepdef;

import io.cucumber.java.After;
import org.example.utils.BaseStepDef;
import org.example.utils.StepContext;

public class CommonStepDef extends BaseStepDef {
    public CommonStepDef(StepContext context) {
        super(context);
    }

    @After
    public void after() {
        driver.quit();
    }
}
