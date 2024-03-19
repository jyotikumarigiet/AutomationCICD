package cucumber.stepDefinitions;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponants.BaseTest_166;
import rahulshettyacademy.pageobjects.CartPage_164;
import rahulshettyacademy.pageobjects.CheckoutPage_165;
import rahulshettyacademy.pageobjects.ConfirmationPage_165_1;
import rahulshettyacademy.pageobjects.LandingPage_159;
import rahulshettyacademy.pageobjects.ProductCatalogue_160_1;
public class StepDefinitionImpl_194 extends BaseTest_166 {
	public LandingPage_159 landingPage;
	public ProductCatalogue_160_1 productCatalogue;
	public ConfirmationPage_165_1 confirmatioPage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_username_and_password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}
	@When("^I add product the (.+) to Cart$")
	public void I_add_product_to_Cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
//	 @And("^Checkout (.+) and submit the order$")
	@When("^Checkout (.+) and submit the order$")
	public void submit_order(String productName)
	{
		CartPage_164 cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage_165 checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmatioPage = checkoutPage.submitOrder();
	}
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string)
    {
    	String confirmMessage = confirmatioPage.getConfirmationMessage();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    }
    @Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg1) throws Throwable
	{
    	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
    	driver.quit();
	}
}