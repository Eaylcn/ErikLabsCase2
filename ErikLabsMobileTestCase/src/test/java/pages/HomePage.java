package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    AppiumDriver driver;
    private WebDriverWait wait;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "trendyol.com:id/buttonSelectGenderMan")
    private WebElement selectManButton;

    @FindBy(id = "trendyol.com:id/buttonSelectGenderWoman")
    private WebElement selectWomanButton;

    @FindBy(id = "trendyol.com:id/imageButtonClose")
    private WebElement closePopupButton;

    @FindBy(id = "trendyol.com:id/linearLayoutFirstItem")
    private WebElement categoryButton;

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void chooseGenderAndSkipPopup(String gender) {
        switch (gender.toLowerCase()) {
            case "erkek":
                clickElement(selectManButton);
                break;
            case "kadın":
                clickElement(selectWomanButton);
                break;
            default:
                throw new IllegalArgumentException("Geçersiz cinsiyet seçimi: " + gender);
        }
        clickElement(closePopupButton);
    }

    public void clickCategoryButton() {
        clickElement(categoryButton);
    }
}
