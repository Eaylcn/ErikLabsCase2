package pages;

import org.junit.Assert;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {

    AppiumDriver driver;
    private WebDriverWait wait;

    public ItemPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "trendyol.com:id/primaryButton")
    private WebElement addToCartButton;

    @FindBy(id = "trendyol.com:id/variantSelectionDialogPrimaryButton")
    private WebElement variantSelectionAddToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Ürünü Sepete Eklendi!']")
    private WebElement addedCartPopupText;

    @FindBy(xpath = "//android.widget.TextView[@text='Sepete Git']")
    private WebElement goToCartOnPopup;

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private void waitElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void clickAddIfVariantSelectionPresent() {
        try {
            waitElement(variantSelectionAddToCartButton);
            if (variantSelectionAddToCartButton.isDisplayed()) {
                clickElement(variantSelectionAddToCartButton);
            }
        } catch (Exception ignored) {
            // Ürünün bir varyansı yoksa devam et
        }
    }

    private void clickGoToCartButtonIfItDidNtAutomatically() {
        try {
            waitElement(goToCartOnPopup);
            if (goToCartOnPopup.isDisplayed()) {
                clickElement(goToCartOnPopup);
            }
        } catch (Exception ignored) {
            // Ürünün bir varyansı yoksa devam et
        }
    }

    public void addToCartItemWithDefaultVariant() {
        clickElement(addToCartButton);
        clickAddIfVariantSelectionPresent();
        clickGoToCartButtonIfItDidNtAutomatically();
    }

}
