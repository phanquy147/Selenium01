package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class WindowHandlePage {
    int time = 60;
    By btnNewTab = By.id("tabButton");
    By txtNewTab = By.id("sampleHeading");
    By btnNewWindow = By.id("windowButton");
    By txtNewWindow = By.id("sampleHeading");
    Element element;

    public void openNewtab() {
        element = new Element(btnNewTab);
        element.waitForElementVisibility(btnNewTab, time);
        DriverUlti.click(btnNewTab);
    }

    public static void switchToLastTab() {
        DriverUlti.waitMinus(3000);
        DriverUlti.switchToWindow(DriverUlti.getLastedWindow());
    }

    public static void closeLastTab() {
        DriverUlti.close();
    }

    public void switchToFirstWindow() {
        closeLastTab();
        DriverUlti.switchToWindow(DriverUlti.getFirstWindow());
        DriverUlti.waitMinus(3000);
    }

    public String txtNewWindowTab() {
        switchToLastTab();
        element = new Element(txtNewTab);
        element.waitForElementVisibility(txtNewTab, time);
        return DriverUlti.getText(txtNewTab);
    }

    public void openNewWindow() {
        switchToFirstWindow();
        element = new Element(btnNewWindow);
        element.waitForElementVisibility(btnNewWindow, time);
        DriverUlti.click(btnNewWindow);
        DriverUlti.waitMinus(3000);
    }

    public String txtNewWindow() {
        switchToLastTab();
        element = new Element(txtNewWindow);
        element.waitForElementVisibility(txtNewWindow, time);
        return DriverUlti.getText(txtNewWindow);
    }

}
