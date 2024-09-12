package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    AppiumDriver driver;

    public CategoryPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='trendyol.com:id/textViewTitle' and @text='Erkek']")
    private WebElement manSubCategory;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='trendyol.com:id/imageCollapsibleBannerItem'])[3]")
    private WebElement manSubCategoryShort;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='trendyol.com:id/imageCollapsibleBannerItem'])[8]")
    private WebElement manSubCategoryJeans;

    public void selectManCategoryAndSubCategory(String subCategory) {
        manSubCategory.click();
        selectManSubCategory(subCategory);
    }

    private void selectManSubCategory(String subCategory) {
        switch (subCategory.toLowerCase()) {
            case "şort":
                manSubCategoryShort.click();
                break;
            case "kot pantolon":
                manSubCategoryJeans.click();
                break;
            default:
                throw new IllegalArgumentException("Geçersiz alt kategori adı: " + subCategory);
        }
    }
}
