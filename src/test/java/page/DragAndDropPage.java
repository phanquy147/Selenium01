package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class DragAndDropPage {
    int timemode = 60;
    By dragElement = By.id("fourth");
    By dropElement = By.id("amt7");
    By txtResult = By.id("t7");


    public void dragAndDropElement(){
        DriverUlti.dragAndDrop(dragElement,dropElement);
    }

    public String getTxtResult(){
        Element element = new Element(txtResult);
        element.waitForElementVisibility(txtResult,timemode);
        return DriverUlti.getText(txtResult);
    }
}
