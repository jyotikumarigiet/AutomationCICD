package rahulshettyacademy.pageobjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractCompanent_161;
public class CartPage_164 extends AbstractCompanent_161{
	WebDriver driver;
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	public CartPage_164(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Store all added cart product under cartProducts 
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	//Clicking on Checkout button
	public CheckoutPage_165 goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage_165(driver);
	}
}