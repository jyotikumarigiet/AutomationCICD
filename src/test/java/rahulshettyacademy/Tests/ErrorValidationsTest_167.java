package rahulshettyacademy.Tests;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponants.BaseTest_166;
import rahulshettyacademy.TestComponants.Retry_179;
import rahulshettyacademy.pageobjects.CartPage_164;
import rahulshettyacademy.pageobjects.LandingPage_159;
import rahulshettyacademy.pageobjects.ProductCatalogue_160_1;
public class ErrorValidationsTest_167 extends BaseTest_166{
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry_179.class)
	public void LoginErrorValidaton() throws IOException {
		String productName = "ZARA COAT 3";
		ProductCatalogue_160_1 productCatalogue = landingPage.loginApplication("jkcdatest@gmail.com", "Qwer89yu1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	@Test
	public void ProductErrorValidaton() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		LandingPage_159 landingPage = launchApplication();
		ProductCatalogue_160_1 productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage_164 cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
}