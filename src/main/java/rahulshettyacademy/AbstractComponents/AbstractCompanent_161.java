package rahulshettyacademy.AbstractComponents;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageobjects.CartPage_164;
import rahulshettyacademy.pageobjects.OrderPage_169;
public class AbstractCompanent_161 {
	WebDriver driver;
	public AbstractCompanent_161(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	//Wait untill element is appear
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	//Wait untill webelement is appear
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	//Wait untill loading is displaying
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(1000);
	}
	//Click on header Cart button and go to cart page
	public CartPage_164 goToCartPage() {
		cartHeader.click();
		CartPage_164 cartPage = new CartPage_164(driver);
		return cartPage;
	}
	//Click on header Order button and go to order page
	public OrderPage_169 goToOrderPage() {
		orderHeader.click();
		OrderPage_169 orderPage = new OrderPage_169(driver);
		return orderPage;
	}
}