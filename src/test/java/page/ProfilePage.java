package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class ProfilePage {
    private int timeMode = 50;
    By userName = By.xpath("//input[@ng-model='formData.name']");
    By email = By.xpath("//input[@ng-model='formData.email']");
    By btnNext = By.xpath("//a[@class='btn btn-block btn-info']");
    By radioBtn = By.xpath("//div[@class='radio']//input");
    By btnSubmit = By.xpath("//button[@type='submit']");
    Element element;

    public void enterUserName(String name) {
        DriverUlti.sendKeys(userName, name);
    }

    public void enterEmail(String mail) {
        DriverUlti.sendKeys(email, mail);
    }

    public void clickBtnNext() {
        DriverUlti.click(btnNext);
    }

    public void clickRadioBtn(String value, String attribute) {
        DriverUlti.clickRadioBtn(radioBtn, value, attribute);
    }

    public void clickRadioBtn(String value) {
        DriverUlti.clickRadioBtn(radioBtn, value, "value");
    }

    public void clickBtnSubmit() {
        DriverUlti.click(btnSubmit);
    }

    public String txtInfoInput() {
        return DriverUlti.getText(By.xpath("//pre"));
    }

    public String txtSubmitPage() {
        element = new Element(By.xpath("//h3"));
        element.waitForElementVisibility(By.xpath("//h3"),timeMode);
        return DriverUlti.getText(By.xpath("//h3"));
    }

    public void infoPage(String name, String mail) {
        element = new Element(userName);
        element.waitForElementVisibility(userName, timeMode);
        enterUserName(name);
        enterEmail(mail);
        clickBtnNext();
    }

    public void interestPage(String value) {
        element = new Element(radioBtn);
        element.waitForPositionNotChange(radioBtn, timeMode);
        clickRadioBtn(value);
        clickBtnNext();
    }

    public void submitPage() {
        element = new Element(btnSubmit);
        element.waitForPositionNotChange(btnSubmit, timeMode);
        clickBtnSubmit();
    }

    public String txtAlert() {
        DriverUlti.waitAlert(60);
         return DriverUlti.txtAlert();
    }

    public void acceptAlert(){
        DriverUlti.acceptAlert();
    }

}
