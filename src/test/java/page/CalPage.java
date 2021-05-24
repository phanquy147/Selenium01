package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class CalPage {
    int timeMode = 60;
    By btnGo = By.id("gobutton");
    By txtLeft = By.xpath("//input[@ng-model='first']");
    By txtRight = By.xpath("//input[@ng-model='second']");
    By result = By.xpath("//tr[contains(@class,'ng')]/td/following-sibling::td[count(//th[contains(.,'Result')]/preceding-sibling::th)]");
    By expression = By.xpath("//tr[contains(@class,'ng')]/td/following-sibling::td[count(//th[contains(.,'Expression')]/preceding-sibling::th)]");
    By txtNewReusult = By.xpath("//h2[contains(@class,'ng')]");
    By cbMathEquation = By.xpath("//select[@ng-model='operator']");
    Element element;

    public void sendkeyTxtLeft(int numberLeft) {
        DriverUlti.sendKeys1(txtLeft, numberLeft);
    }

    public void sendkeyTxtRight(int numberRight) {
        DriverUlti.sendKeys1(txtRight, numberRight);
    }

    public void clickBtnGo() {
        element = new Element(btnGo);
        element.waitForElementVisibility(btnGo, timeMode);
        DriverUlti.click(btnGo);
        element.waitForElementtNotChange(txtNewReusult, timeMode);
    }

    public String getTxtResult() {
        return DriverUlti.getText(result);
    }

    public String getTxtExpression() {
        return DriverUlti.getText(expression);
    }

    public void enterValue(int numberLeft, int numberRight, String key) {
        element = new Element(txtLeft);
        element.waitForElementVisibility(txtLeft, timeMode);
        sendkeyTxtLeft(numberLeft);
        sendkeyTxtRight(numberRight);
        DriverUlti.selectCb(cbMathEquation, key);
        clickBtnGo();

    }
}
