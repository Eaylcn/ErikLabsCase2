package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    AppiumDriver driver;
    private WebDriverWait wait;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "trendyol.com:id/approveBasketArrow")
    private WebElement priceDetailsButton;

    @FindBy(id = "trendyol.com:id/textViewPaymentItemPrice")
    private WebElement itemPriceText;

    @FindBy(id = "trendyol.com:id/image_add")
    private WebElement increaseQuantityButton;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id='trendyol.com:id/composeViewApproveBasket']/android.view.View/android.view.View")
    private WebElement approveCartButton;

    @FindBy(id = "trendyol.com:id/textViewWithoutAuthentication")
    private WebElement continueWithoutRegistrationButton;

    @FindBy(id = "trendyol.com:id/alertTitle")
    private WebElement alertTitleText;

    private float itemPrice;

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getItemPrice() {
        String priceText = itemPriceText.getText();
        return priceText.replaceAll("[^\\d.]", "").trim(); // Only keep numbers and decimals
    }

    public void clickPriceDetailsButton() {
        clickElement(priceDetailsButton);
    }

    public void clickPriceDetailsAndCheckPrice() {
        clickPriceDetailsButton();
        itemPrice = Float.parseFloat(getItemPrice());
    }

    public void increaseItemQuantityAndCheckNewPrice() {
        clickElement(increaseQuantityButton);
        clickPriceDetailsButton();

        float actualPrice = Float.parseFloat(getItemPrice());
        float expectedPrice = itemPrice * 2;

        Assert.assertEquals("Beklenen fiyat: " + expectedPrice + " fakat alınan fiyat: " + actualPrice, expectedPrice, actualPrice, 0);
    }

    public void approveCart() {
        clickElement(approveCartButton);
        clickElement(continueWithoutRegistrationButton);
    }

    public void verifyAlertPopup(String alertText) {
        Assert.assertEquals("Trendyol hesabınız yok mu? mesajını içeren popup görüntülenemedi!", alertText, alertTitleText.getText());
    }
}
