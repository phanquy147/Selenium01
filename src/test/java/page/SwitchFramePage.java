package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class SwitchFramePage {
    int time = 60;
    By frameOldCouple = By.xpath("//iframe[@src='oddcouple.htm']");
    By txtFrameOld = By.xpath("//td[@align='center']/div[contains(@style,'font-family')]");

    public void getTxtFrameOldCouple() {
        Element element = new Element(frameOldCouple);
        element.waitForElementVisibility(frameOldCouple, time);
        DriverUlti.switchToFrame(frameOldCouple);
        System.out.println(DriverUlti.getText(txtFrameOld));
        DriverUlti.switchToDefaultFrame();
    }
}
