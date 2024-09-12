package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;

public class CartSteps {

    AppiumDriver driver;
    CartPage cartPage;

    public CartSteps() {
        this.driver = Hooks.driver;
        cartPage = new CartPage(driver);
    }

    @And("Kullanıcı ürünün sayısını arttırır ve fiyatını kontrol eder")
    public void kullanıcıÜrününSayısınıArttırırVeFiyatınıKontrolEder() {
        cartPage.clickPriceDetailsAndCheckPrice();
        cartPage.clickPriceDetailsButton();
        cartPage.increaseItemQuantityAndCheckNewPrice();
    }

    @And("Kullanıcı sepeti onaylar")
    public void kullanıcıSepetiOnaylar() {
        cartPage.approveCart();
    }

    @Then("Sepeti onayladıktan sonra çıkan popup'ta {string} yazısı beklenir")
    public void sepetiOnayladıktanSonraÇıkanPopuptaYazısıBeklenir(String alertText) {
        cartPage.verifyAlertPopup(alertText);
    }
}
