package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    //Popup Item
    @FindBy(id = "trendyol.com:id/closeButton")
    private WebElement closePopupButton;

    // Filter Items
    @FindBy(id = "trendyol.com:id/filterView")
    private WebElement filterButton;

    @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id='trendyol.com:id/linearLayoutFilterText'])[6]")
    private WebElement priceFilterButton;

    @FindBy(id = "trendyol.com:id/textInputLayoutMinimum")
    private WebElement minPriceTextField;

    @FindBy(id = "trendyol.com:id/textInputLayoutMaximum")
    private WebElement maxPriceTextField;

    @FindBy(id = "trendyol.com:id/buttonApplyFilterAttribute")
    private WebElement applyFilterAttributeButton;

    @FindBy(id = "trendyol.com:id/btnApplyFilter")
    private WebElement applyFilterButton;

    // SortBy Items
    @FindBy(id = "trendyol.com:id/sortingView")
    private WebElement sortByButton;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='trendyol.com:id/radioButtonSortingTypeItem' and @text='Çok Satanlar']")
    private WebElement sortByPopularButton;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='trendyol.com:id/constraintLayout'])[1]")
    private WebElement firstItemOnList;

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private void waitElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void closePopupIfPresent() {
        try {
            waitElement(closePopupButton);
            if (closePopupButton.isDisplayed()) {
                clickElement(closePopupButton);
            }
        } catch (Exception ignored) {
            // Popup yoksa devam et
        }
    }

    public void filterWithPrice(String minPrice, String maxPrice) {
        Actions action = new Actions(driver);

        closePopupIfPresent();

        clickElement(filterButton);
        clickElement(priceFilterButton);
        clickElement(minPriceTextField);
        action.sendKeys(minPrice).perform();
        clickElement(maxPriceTextField);
        action.sendKeys(maxPrice).perform();
        driver.navigate().back();

        clickElement(applyFilterAttributeButton);
        clickElement(applyFilterButton);
    }

    public void sortByPopular() {
        clickElement(sortByButton);
        clickElement(sortByPopularButton);
    }

    public void inspectFirstItem() {
        clickElement(firstItemOnList);
    }
}
