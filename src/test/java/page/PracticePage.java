package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class PracticePage {
    By txtFirstName = By.id("firstName");
    By txtLastName = By.id("lastName");
    By txtEmail = By.id("userEmail");
    By txtPhone = By.id("userNumber");
    By txtDateOfBirt = By.id("dateOfBirthInput");
    By btnUploadPicture = By.id("uploadPicture");
    //    By radioBtnGender = By.xpath("//input[@value='%s']/following-sibling::label");
    By btnSubmit = By.id("submit");
    By txtAddress = By.id("currentAddress");
    By cbHobby = By.xpath("//input[contains(@id,'hobbies')]/following-sibling::label");
    By txtSubject = By.id("subjectsInput");
    By dropdownCity = By.xpath("//div[@id='city']//div[contains(@class,'control')]");
    By dropdownState = By.xpath("//div[@id='state']//div[contains(@class,'control')]");
    By lblAutoSubject = By.xpath("//div[contains(@class,'subjects-auto-complete__menu-list')]/div");
    By inforCheck = By.xpath("//div[contains(@class,'table')]//tr/td[1]");
    By btnClose = By.id("closeLargeModal");
    int time = 60;
    String linkImg = "data/image/";
    Element element;

    public void inputName(String firstName, String lastName) {
        element = new Element(txtFirstName);
        element.waitForElement(txtFirstName, time);
        DriverUlti.click(txtFirstName);
        DriverUlti.sendKeys(txtFirstName, firstName);
        element.waitForElement(txtLastName, time);
        DriverUlti.click(txtLastName);
        DriverUlti.sendKeys(txtLastName, lastName);
    }

    public void inputEmail(String email) {
        element = new Element(txtEmail);
        element.waitForElement(txtEmail, time);
        DriverUlti.click(txtEmail);
        DriverUlti.sendKeys(txtEmail, email);
    }

//    public String setLenghtPhone(String phoneNumber) {
//        if (phoneNumber.length() < 10) {
//            System.out.println("Phone: chua du 10 ky tu");
//        }
//        return phoneNumber;
//    }

    public void inputPhoneNumber(String phoneNumber) {
        element = new Element(txtPhone);
        element.waitForElement(txtPhone, time);
        DriverUlti.click(txtPhone);
        DriverUlti.sendKeys(txtPhone, phoneNumber);
    }

    public void setDateOfBirth(String dateOfBirth) {
        element = new Element(txtDateOfBirt);
        element.waitForElement(txtDateOfBirt, time);
        DriverUlti.click(txtDateOfBirt);
        DriverUlti.executeJS(txtDateOfBirt);
        DriverUlti.sendKeys(txtDateOfBirt, dateOfBirth);
        DriverUlti.sendKeys(txtDateOfBirt, Keys.RETURN);
    }

    public void selectGender(String gender) {
        if (gender != "") {
            String radioGender = String.format("//input[@value='%s']/following-sibling::label", gender);
            WebElement btnGender = DriverUlti.findElement(By.xpath(radioGender));
            btnGender.click();
        }
    }

    public void chooseSubject() {
        element = new Element(lblAutoSubject);
        element.waitForElement(lblAutoSubject, time);
        List<WebElement> listSubject = DriverUlti.findElements(lblAutoSubject);
        listSubject.get(0).click();
    }

    public void inputSubject(String[] sub) {
        element = new Element(txtSubject);
        element.waitForElement(txtSubject, time);
        DriverUlti.click(txtSubject);
        for (int i = 0; i < sub.length; i++) {
            DriverUlti.sendKeys(txtSubject, sub[i]);
            DriverUlti.waitMinus(2000);
            chooseSubject();
        }
        DriverUlti.waitMinus(2000);
    }

    public void selectHobbie(String[] hobbie) {
        List<WebElement> listCbHobby = DriverUlti.findElements(cbHobby);
        for (int i = 0; i < listCbHobby.size(); i++) {
            WebElement cbHobby = listCbHobby.get(i);
            for (int j = 0; j < hobbie.length; j++) {
                if (cbHobby.getText().equalsIgnoreCase(hobbie[j])) {
                    cbHobby.click();
                }
            }
        }
    }

    public void uploadFile(String fileName) {
        File file = new File(linkImg + fileName);
        WebElement uploadFilePath = DriverUlti.findElement(btnUploadPicture);
        uploadFilePath.sendKeys(file.getAbsolutePath());
    }

//    public String getFileName() {
//        DriverUlti.waitForElement(btnUploadPicture, time);
//        WebElement txtFileName = DriverUlti.findElement(btnUploadPicture);
//        String fileName = txtFileName.getAttribute("value").substring(12);
//        return fileName;
//    }

    public void inputAddress(String address) {
        element = new Element(txtAddress);
        element.waitForElement(txtAddress, time);
        DriverUlti.click(txtAddress);
//        if (address != null) {
//            DriverUlti.sendKeys(txtAddress, address);
//        } else {
//            DriverUlti.sendKeys(txtAddress,"");
//        }
        DriverUlti.sendKeys(txtAddress, address);
        DriverUlti.waitMinus(2000);
    }

    public void chooseState(String state) {
        List<WebElement> listState = DriverUlti.findElements(By.xpath("//div[contains(@id,'react-select-3')]"));
        for (int i = 0; i < listState.size(); i++) {
            if (listState.get(i).getText().equalsIgnoreCase(state)) {
                listState.get(i).click();
                break;
            }
        }
    }

    public void selectState(String state) {
        DriverUlti.scrollToViewJs(dropdownState);
        element = new Element(dropdownState);
        element.waitClick(dropdownState, time);
        DriverUlti.click(dropdownState);
        chooseState(state);
        DriverUlti.waitMinus(5000);
    }

    public void chooseCity(String city) {
        List<WebElement> listCity = DriverUlti.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (int i = 0; i < listCity.size(); i++) {
            if (listCity.get(i).getText().equalsIgnoreCase(city)) {
                listCity.get(i).click();
                break;
            }
        }
    }

    public void selectCity(String city) {
        DriverUlti.scrollToViewJs(dropdownCity);
        element = new Element(dropdownCity);
        element.waitForElementVisibility(dropdownCity, time);
        DriverUlti.click(dropdownCity);
        chooseCity(city);
        DriverUlti.waitMinus(5000);
    }

    public void submit() {
        DriverUlti.scrollToViewJs(btnSubmit);
        element = new Element(btnSubmit);
        element.waitClick(btnSubmit, time);
        DriverUlti.click(btnSubmit);
        DriverUlti.waitMinus(5000);
    }

    public String getProfile(String info) {
        element = new Element(inforCheck);
        element.waitForElementtNotChange(inforCheck, time);
        List<WebElement> listInfo = DriverUlti.findElements(inforCheck);
        String infoOut = " ";
        for (int i = 0; i < listInfo.size(); i++) {
            if (listInfo.get(i).getText().toLowerCase().contains(info)) {
                WebElement value = listInfo.get(i).findElement(By.xpath("./following-sibling::td"));
                System.out.println("aaaaa. " + value.getText());
                infoOut = value.getText();
            }
        }
        return infoOut;
    }

    public String convertStringFormat(String[] Arr) {
        String convertString = String.join(", ", Arr);
        return convertString;
    }

//    public void getValueMobile() {
//        DriverUlti.waitForElement(txtPhone, time);
//        System.out.println(DriverUlti.getAttribute(txtPhone, "value"));
//    }

    public void fillPracticeForm(String firstName, String lastName, String email, String gender, String phone, String date, String[] subjects, String[] hobbies, String fileName, String address, String state, String city) {
        inputName(firstName, lastName);
        inputEmail(email);
        selectGender(gender);
        inputPhoneNumber(phone);
        setDateOfBirth(date);
        inputSubject(subjects);
        selectHobbie(hobbies);
        uploadFile(fileName);
        inputAddress(address);
        selectState(state);
        selectCity(city);
    }

    public void close() {
        element = new Element(btnClose);
        element.waitForElement(btnClose, time);
        DriverUlti.click(btnClose);
    }

    public String getBorderFirstNameColor() {
        String color = DriverUlti.getColor(txtFirstName, "border-color");
        return color;
    }

    public String getFirstNameIcon() {
        String icon = DriverUlti.getIcon(txtFirstName, "background-image");
        return icon;
    }

    public String getBorderLastNameColor() {
        String color = DriverUlti.getColor(txtLastName, "border-color");
        return color;
    }

    public String getLastNameIcon() {
        String icon = DriverUlti.getIcon(txtLastName, "background-image");
        return icon;
    }

    public String getBorderMailColor() {
        String color = DriverUlti.getColor(txtEmail, "border-color");
        return color;
    }

    public String getMailIcon() {
        String icon = DriverUlti.getIcon(txtEmail, "background-image");
        return icon;
    }

    public String getGenderColor() {
        String color = DriverUlti.getColor(By.xpath("//input[@name='gender']/following-sibling::label[contains(@class,'custom-control-label')]"), "border-color");
        return color;
    }


    public String getBorderPhoneColor() {
        String color = DriverUlti.getColor(txtPhone, "border-color");
        return color;
    }

    public String getPhoneIcon() {
        String icon = DriverUlti.getIcon(txtPhone, "background-image");
        return icon;
    }

}
