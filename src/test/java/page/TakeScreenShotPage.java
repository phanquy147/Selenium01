package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class TakeScreenShotPage {
    By topXpath = By.xpath("//div[@id='navbar-collapse']/ul/li/a/span");
    int time = 60;
    Element element;

    public void takeAScreenShot(String filePath) {
        element = new Element(topXpath);
        element.waitForElement(topXpath, time);
        DriverUlti.takeShot(filePath);
    }

    public String checkLogin(){
        element = new Element(topXpath);
        element.waitForElement(topXpath,time);
        String a = DriverUlti.getText(topXpath);
        return a;
    }
}
