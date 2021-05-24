package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MousePage {
    int timemode = 60;
    By header = By.xpath("//div[@class='page_heading']");
    By btnVideoBase = By.id("Video Based");
    By btnLike = By.xpath("//div[@class='tools']/span[@role='toolbar']/button[contains(@class,'left')]");
    By frame = By.xpath("//iframe[contains(@data-src,'video-player')]");
    By txtLike = By.xpath("//div[contains(@class,'ui-tooltip-content')]");
    By framePhotoManager = By.xpath("//iframe[contains(@data-src,'photo-manager')]");
    By trash = By.id("trash");
    String photoXpath = "//img[contains(@src,'%s')]";
    By listPhoto = By.xpath("//ul[@id='gallery']/li");
    By listTrashPhoto = By.xpath("//div[@id='trash']//li");
    Element element;

    public String getTxtHeaderTooltip() {
        element = new Element(header);
        element.waitForElementVisibility(header, timemode);
        return DriverUlti.getText(header);
    }

    public void waitFrameVideoIsSwitch() {
        element = new Element(btnVideoBase);
        element.waitForElementVisibility(btnVideoBase, timemode);
        DriverUlti.click(btnVideoBase);
        element = new Element(frame);
        element.waitForFrameSwitch(frame, 500);
    }

    public void moveMouseToBtnLike() {
        waitFrameVideoIsSwitch();
        element = new Element(btnLike);
        element.waitForElementVisibility(btnLike, timemode);
        DriverUlti.moveToElement(btnLike);
        element.waitForElementVisibility(txtLike, timemode);
        System.out.println(DriverUlti.getText(txtLike));
    }

    public void switchToFramePhotoManager() {
        element = new Element(framePhotoManager);
        element.waitForElementVisibility(framePhotoManager, timemode);
        DriverUlti.switchToFrame(framePhotoManager);
    }

    public boolean isDisplayedPhotoIntoList(String name) {
        switchToFramePhotoManager();
        boolean isExisted = false;
        List<WebElement> listPhotoManager = DriverUlti.findElements(listPhoto);
        for (int i = 0; i < listPhotoManager.size(); i++) {
            WebElement txtNamePhoto = listPhotoManager.get(i).findElement(By.xpath("./h5"));
            if (txtNamePhoto.getText().equalsIgnoreCase(name)) {
                isExisted = true;
            }
        }
        DriverUlti.switchToDefaultFrame();
        return isExisted;
    }

    public boolean isDisplayPhotoIntoListTrash(String name) {
        switchToFramePhotoManager();
        boolean isExisted = false;
        List<WebElement> listTrashPhotos = DriverUlti.findElements(listTrashPhoto);
        for (int i = 0; i < listTrashPhotos.size(); i++) {
            WebElement txtNameTrashPhoto = listTrashPhotos.get(i).findElement(By.xpath(".//h5"));
            System.out.println();
            if (txtNameTrashPhoto.getAttribute("innerHTML").equalsIgnoreCase(name)) {
                isExisted = true;
            }
        }
        DriverUlti.switchToDefaultFrame();
        return isExisted;
    }


    public void movePictureToTrash(String name) {
        switchToFramePhotoManager();
        element = new Element(By.xpath(String.format(photoXpath, name)));
        element.waitForElementVisibility(By.xpath(String.format(photoXpath, name)), timemode);
        DriverUlti.dragAndDrop(By.xpath(String.format(photoXpath, name)), trash);
        element.waitForElementVisibility(listPhoto, timemode);
        element.waitForElementVisibility(listTrashPhoto, timemode);
        DriverUlti.switchToDefaultFrame();
    }

}
