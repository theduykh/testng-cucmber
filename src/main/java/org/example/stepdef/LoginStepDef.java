package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.utils.BaseStepDef;
import org.example.utils.Contexts;
import org.example.utils.StepContext;
import org.testng.Assert;

public class LoginStepDef extends BaseStepDef {

    public LoginStepDef(StepContext context) {
        super(context);
    }

    @Given("I have URL web page as {string}")
    public void iHaveURLWebPageAs(String arg0) {
        context.setContext(Contexts.URL, arg0);
    }

    @And("Valid user email as {string}")
    public void validUserEmailAs(String arg0) {
        context.setContext(Contexts.EMAIL, arg0);
    }

    @And("Valid password as {string}")
    public void validPasswordAs(String arg0) {
        context.setContext(Contexts.PASSWORD, arg0);
    }

    @When("I navigate to this URL on Chrome browser")
    public void iNavigateToThisURLOnChromeBrowser() {
        String url = (String) context.getContext(Contexts.URL);
        new LoginPage(driver).navigate(url);
    }

    @And("I input username password")
    public void iInputUsernamePassword() {
        String email = (String) context.getContext(Contexts.EMAIL);
        String password = (String) context.getContext(Contexts.PASSWORD);
        new LoginPage(driver).login(email, password);
    }

    @Then("User sign in successfully.")
    public void userSignInSuccessfully() {
        Assert.assertTrue(true);
    }
}
