package com;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static com.DriverUlti.waitMinus;

public class Element implements WebElement {
    private By by;
    private WebDriverWait waitElement;

    public Element(By by) {
        this.by = by;
    }

    public WebElement webElement() {
        return DriverUlti.findElement(by);
    }

    @Override
    public void click() {
        webElement().click();
    }

    @Override
    public void submit() {
        webElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement().clear();
    }

    @Override
    public String getTagName() {
        return webElement().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement().isEnabled();
    }

    @Override
    public String getText() {
        return webElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return webElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement().getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getScreenshotAs(outputType);
    }

    public void waitForElement(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementVisibility(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForAllElementVisibility(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForPositionNotChange(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                Point oldP = webElement().getLocation();
                waitMinus(2000);
                Point newP = webElement().getLocation();
                return oldP.equals(newP);

            }
        });
    }

    public void waitForElementtNotChange(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                String oldTxt = webElement().getText();
                waitMinus(2000);
                String newTxt = webElement().getText();
                return oldTxt.equals(newTxt);
            }
        });
    }

    public void waitForFrameSwitch(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void waitClick(By by, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitAttribute(By by, int seconds, String atribute, String value) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.attributeContains(by, atribute, value));
    }

    public void waitText(String title, int seconds) {
        waitElement = new WebDriverWait(DriverUlti.getDriver(), seconds);
        waitElement.until(ExpectedConditions.titleContains(title));
    }
}
