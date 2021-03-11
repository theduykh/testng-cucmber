package org.example.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage selectCategory(String category, String subCategory) {
        if (subCategory != null && !subCategory.isEmpty()) {
            hover("#block_top_menu > ul > li > a[title='" + category + "']");
            click(".sfHover a[title='" + subCategory + "']");
        } else {
            click("#block_top_menu > ul > li > a[title='" + category + "']");
        }
        return this;
    }

    public String getCurrentBreadcrumb() {
        return getText(".breadcrumb");
    }

    public String getCurrentCategory() {
        String text = getText(".breadcrumb");
        String[] arr = text.split(">");
        return arr[arr.length - 1];
    }
}
