package org.example.stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utils.BaseStepDef;
import org.example.utils.Contexts;
import org.example.utils.StepContext;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryStepDef extends BaseStepDef {

    public CategoryStepDef(StepContext context) {
        super(context);
    }

    @Given("I login successfully to {string} with email {string} & password {string}")
    public void iLoginSuccessfullyToWithEmailPassword(String arg0, String arg1, String arg2) {
        LoginPage page = new LoginPage(driver);
        page.navigate(arg0);
        page.login(arg1, arg2);
    }

    @When("I browse following categories as below:")
    public void iBrowseFollowingCategoriesAsBelow(DataTable table) {
        List<Map<String, String>> breadcrumbList = new ArrayList<>();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        HomePage page = new HomePage(driver);
        for (Map<String, String> columns : rows) {
            page.selectCategory(columns.get(Contexts.CATEGORY), columns.get(Contexts.SUB_CATEGORY));

            Map<String, String> map = new HashMap<>();
            map.put(Contexts.CATEGORY, columns.get(Contexts.CATEGORY));
            map.put(Contexts.SUB_CATEGORY, columns.get(Contexts.SUB_CATEGORY));
            map.put(Contexts.TITLE, page.getCurrentCategory());

            breadcrumbList.add(map);
        }

        context.setContext(Contexts.BREADCRUMB, breadcrumbList);
    }

    @Then("The page display correctly with selected category.")
    public void thePageDisplayCorrectlyWithSelectedCategory() {
        List<Map<String, String>> breadcrumbList = (List<Map<String, String>>) context.getContext(Contexts.BREADCRUMB);
        breadcrumbList.forEach(map -> {
            if (map.get(Contexts.SUB_CATEGORY) != null) {
                Assert.assertEquals(map.get(Contexts.TITLE), map.get(Contexts.SUB_CATEGORY));
            } else {
                Assert.assertEquals(map.get(Contexts.TITLE), map.get(Contexts.CATEGORY));
            }

        });

    }
}
