package com;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DriverUlti {

    private static WebDriver driver;
    private static String runDriver = "chromed";
    private static List<WebElement> list;
    private static String windowName;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void manageDriver() {
        driver.manage().window().maximize();
    }

    public static void setDriver(String key) {
        switch (key) {
            case "edge":
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/driver/msedgedriver");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/driver/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "safari":
                System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "/src/main/resources/driver/SafariDriver.safariextz");
                driver = new SafariDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
    }

    public static void getDriverLogin() {
        setDriver(runDriver);
        getDriver().get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
    }

    public static void getDriverSelenium() {
        setDriver(runDriver);
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        driver.manage().window().maximize();
    }

    public static void getDriverProfile() {
        setDriver(runDriver);
        driver.get("http://www.way2automation.com/angularjs-protractor/multiform/#/form/profile");
    }

    public static void getDriverCalculator() {
        setDriver(runDriver);
        driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
    }

    public static void getDriverCheckbox() {
        setDriver(runDriver);
        driver.get("http://www.way2automation.com/angularjs-protractor/checkboxes/");
    }

    public static void getDriverGlobal() {
        setDriver(runDriver);
        driver.get("https://www.globalsqa.com/");
    }

    public static void getDriverDragAndDrop() {
        setDriver(runDriver);
        driver.get("http://demo.guru99.com/test/drag_drop.html");
    }

    public static void getDriverSwitchFrame() {
        setDriver(runDriver);
        driver.get("https://nunzioweb.com/");
    }

    public static void getDriverWindowHandle() {
        setDriver(runDriver);
        driver.get("https://demoqa.com/browser-windows");
    }

    public static void getDriverSlider() {
        setDriver(runDriver);
        driver.get("https://demoqa.com/slider");
    }

    public static void getDriverAutoComplete() {
        setDriver(runDriver);
        driver.get("https://demoqa.com/auto-complete");
    }


    public static void getDriverDatePicker() {
        setDriver(runDriver);
        driver.get("https://demoqa.com/date-picker");
    }

    public static void getWebInfo() {
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    public static void backPage() {
        driver.navigate().back();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void getDriverProgressBar() {
        setDriver(runDriver);
        driver.get("https://demoqa.com/progress-bar");
    }

    public static void getDriverGlobeDr() {
        setDriver(runDriver);
        driver.get("https://web1.globedr.com/");
        driver.manage().window().maximize();
    }


    public static void getLink(String url) {
        setDriver(runDriver);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void getDriverDemoQa() {
        setDriver(runDriver);
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public static void sendKeys(By by, CharSequence... content) {
        findElement(by).sendKeys(content);
    }

    public static void sendKeys(By by, String content) {
        findElement(by).sendKeys(content);
    }

    public static void sendKeys1(By by, int number) {
        String nb = String.valueOf(number);
        findElement(by).sendKeys(nb);
    }

    public static boolean isDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    public static boolean isSelected(By by) {
        return findElement(by).isSelected();
    }

    public static void waitMinus(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getText(By by) {
        return findElement(by).getText();
    }

    public static void click(By by) {
        findElement(by).click();
    }

    public static void clickRadioBtn(By by, String value, String attribute) {
        list = findElements(by);
        for ( int i = 0; i < list.size(); i++ ) {
            if (list.get(i).getAttribute(attribute).equalsIgnoreCase(value)) {
                list.get(i).click();
                System.out.println(list.get(i).isSelected());
            }
        }
    }


    public static String getAttribute(By by, String value) {
        return findElement(by).getAttribute(value);
    }

    public static void clear(By by) {
        findElement(by).clear();
    }

    public static void close() {
        driver.close();
    }

    public static void quit() {
        driver.quit();
    }

    public static String txtAlert() {
        return driver.switchTo().alert().getText();
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }



    public static void waitAlert(int seconds) {
        WebDriverWait waitAlert = new WebDriverWait(driver, seconds);
        waitAlert.until(ExpectedConditions.alertIsPresent());
    }

    public static void selectCb(By by, String value) {
        Select select = new Select(findElement(by));
        select.selectByValue(value);
    }

    public static void clickChB(By by) {
        list = findElements(by);
        for ( int i = 0; i < list.size(); i++ ) {
            if (!(list.get(i).isSelected())) {
                list.get(i).click();
            }
        }
    }

    public static void unclickChB(By by) {
        list = findElements(by);
        for ( int i = 0; i < list.size(); i++ ) {
            if (list.get(i).isSelected()) {
                list.get(i).click();
            }
        }
    }


    public static void moveToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public static void dragAndDrop(By dragElement, By dropElement) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(findElement(dragElement))
                .pause(Duration.ofMillis(3000))
                .moveToElement(findElement(dropElement))
                .release().pause(Duration.ofMillis(3000)).build().perform();
    }

    public static void switchToFrame(By by) {
        driver.switchTo().frame(findElement(by));
    }

    public static void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public static void switchToWindow(String windowName) {
        driver.switchTo().window(windowName);
    }

    public static String getLastedWindow() {
        Set<String> handles = driver.getWindowHandles();
        Object[] list = handles.toArray();
        return windowName = list[list.length - 1].toString();
    }

    public static String getFirstWindow() {
        Set<String> handles = driver.getWindowHandles();
        Object[] list = handles.toArray();
        return windowName = list[0].toString();
    }

    public static void slideToPoint(By by, String attribute, int x) {
        Actions actions = new Actions(driver);
        if (Integer.parseInt(getAttribute(by, attribute)) == 0) {
            for ( int i = 0; i < x; i++ ) {
                actions.sendKeys(Keys.ARROW_UP).perform();
            }
        }
    }

    public static void sliderToStartPoint(By by, String attribute) {
        Actions actions = new Actions(driver);
        if (Integer.parseInt(getAttribute(by, attribute)) > 0) {
            for ( int i = Integer.parseInt(getAttribute(by, attribute)); i >= 0; i-- ) {
                actions.sendKeys(Keys.ARROW_DOWN).perform();
            }
        }
    }

    public static void moveToLocator(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(xOffset, yOffset);
        waitMinus(2000);
        actions.click().perform();
    }

    public static void executeJS(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", findElement(by));
    }


//    public static void scrollDownJS(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//    }

    public static long jsHeight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long offsetY = (long) js.executeScript("return window.screenY + (window.outerHeight - window.innerHeight)");
        return offsetY;
//        - window.scrollY;
    }

    public static long jsWidth() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long offsetX = (long) js.executeScript("return window.screenX + (window.outerWidth - window.innerWidth)");
        return offsetX;
//        / 2- window.scrollX;
    }

    public static void scrollToViewJs(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }

    public static String getColor(By by, String value) {
        String color = findElement(by).getCssValue(value);
        return color;
    }

    public static String getIcon(By by, String value) {
        String icon = findElement(by).getCssValue(value);
        return icon;
    }

    public static void takeShot(String fileWithPath) {
//      Screenshot scrShot = new AShot().takeScreenshot(driver);
//      ImageIO.write(scrShot.getImage(), "png", new File(fileWithPath));
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File scrShotFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        try {
            FileUtils.copyFile(scrShotFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void setDriverChromeHeadless() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
//        ChromeOptions option = new ChromeOptions();
//        option.setHeadless(true);
//        driver = new ChromeDriver(option);
//    }

//    public static void getaaa() {
//        setDriverChromeHeadless();
//        driver.manage().window().fullscreen();
//        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
//    }

//    public static void setDriverChromeCertificate() {
//        DesiredCapabilities ch = DesiredCapabilities.chrome();
//        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
//        WebDriver driver = new ChromeDriver(ch);
//        driver.get("");
//    }

}