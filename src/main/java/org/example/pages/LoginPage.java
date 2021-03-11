package org.example.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url) {
        super.navigate(url);
    }

    public void login(String username, String password) {
        click(".header_user_info .login");

        enterText("#email", username);
        enterText("#passwd", password);

        click("#SubmitLogin");
    }
}
