package org.example.pages;

import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private final int TIMEOUT = 30;

    private final Logger logger = LogManager.getLogger(BasePage.class);
    private final WebDriverWait wait;

    @Getter
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    protected void navigate(String url) {
        logger.info("Navigate to {}", url);
        driver.get(url);
    }

    protected WebElement findElement(String locator) {
        By by = parseSelector(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    protected void click(String locator) {
        logger.info("Click element located by '{}'", locator);
        findElement(locator).click();
    }

    protected void enterText(String locator, String text) {
        logger.info("Enter text into element located by '{}', text '{}'", locator, text);
        findElement(locator).sendKeys(text);
    }

    protected void hover(String locator) {
        logger.info("Mouse hover on element located by '{}'", locator);

        WebElement element = findElement(locator);

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    protected String getText(String locator) {
        String text = findElement(locator).getText();
        logger.info("Get text element located by '{}', text '{}'", locator, text);
        return text;
    }

    /**
     * Parse string to selector automatically
     *
     * @param stringSelector css selector or xpath
     * @return select
     */
    private By parseSelector(String stringSelector) {
        stringSelector = StringUtils.strip(stringSelector, "(");
        stringSelector = StringUtils.strip(stringSelector, ")");

        if (stringSelector.startsWith("/") || stringSelector.startsWith("./")) {
            return By.xpath(stringSelector);
        } else return By.cssSelector(stringSelector);
    }
}
