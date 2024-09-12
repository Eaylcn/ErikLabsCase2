package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.When;
import pages.ItemPage;

public class ItemSteps {

    AppiumDriver driver;
    ItemPage itemPage;

    public ItemSteps() {
        this.driver = Hooks.driver;
        itemPage = new ItemPage(driver);
    }

    @When("Kullanıcı ürünü varsayılan haliyle sepete ekler")
    public void kullanıcıÜrünüVarsayılanHaliyleSepeteEkler() {
        itemPage.addToCartItemWithDefaultVariant();
    }

}
