package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class ProgressBarPage {
    By btnStartStop = By.id("startStopButton");
    By progressBar = By.xpath("//div[@id='progressBar']/div[@role='progressbar']");
    int time = 60;
    Element element;

    public void clickBtnToStartProgress() {
        element = new Element(btnStartStop);
        element.waitForElement(btnStartStop, time);
        DriverUlti.click(btnStartStop);
    }

    public void stopProgressBar(int number) {
        element = new Element(progressBar);
        element.waitForElement(progressBar, time);
        int value = 0;

        while (value <= number) {
            value = Integer.parseInt(DriverUlti.getAttribute(progressBar, "aria-valuenow"));
            value++;
        }
        DriverUlti.click(btnStartStop);
    }


    public String getValueProgressBar() {
        element = new Element(progressBar);
        element.waitForElementtNotChange(progressBar, time);
        return DriverUlti.getText(progressBar);
    }
}
