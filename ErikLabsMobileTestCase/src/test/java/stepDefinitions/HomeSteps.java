package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;

public class HomeSteps {

    AppiumDriver driver;
    HomePage homePage;
    CategoryPage categoryPage;
    ProductPage productPage;

    public HomeSteps() {
        this.driver = Hooks.driver;
        homePage = new HomePage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
    }

    @Given("Kullanıcı cinsiyet olarak {string} seçer ve popup'ı kapatır")
    public void kullanıcıCinsiyetOlarakSeçerVePopupIKapatır(String gender) {
        homePage.chooseGenderAndSkipPopup(gender);
    }

    @When("Kullanıcı kategori butonuna tıklar")
    public void kullanıcıKategoriButonunaTıklar() {
        homePage.clickCategoryButton();
    }

    @And("Kullanıcı erkek kategorisini ve {string} alt kategorisini seçer")
    public void kullanıcıKategorisiniSeçer(String subCategoryCode) {
        categoryPage.selectManCategoryAndSubCategory( subCategoryCode);
    }

    @And("Kullanıcı minimum {string} maksimum {string} TL aralığında fiyat filtrelemesi yapar")
    public void kullanıcıMinMaxTLAralığındaFiyatFiltrelemesiYapar(String minPrice, String maxPrice) {
        productPage.filterWithPrice(minPrice, maxPrice);
    }

    @And("Kullanıcı ürünleri çok satanlar olarak sıralar")
    public void kullanıcıÜrünleriÇokSatanlarOlarakSıralar() {
        productPage.sortByPopular();
    }

    @And("Kullanıcı sıralanan ürünlerden ilkine tıklar")
    public void kullanıcıSıralananÜrünlerdenİlkineTıklar() {
        productPage.inspectFirstItem();
    }
}
