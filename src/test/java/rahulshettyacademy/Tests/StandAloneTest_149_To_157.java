package rahulshettyacademy.Tests;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class StandAloneTest_149_To_157 {
	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("jkcdatest@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Qwertyu1");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		//Wait untill all products are visible or not
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		//Store all products under products webelement
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//Store filtered product under prod webelement
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		//Click Add to cart button of selected/filtered product
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//Wait untill add to cart is in proccessing
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		//Wait untill loading is displaying
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//Click on Cart button and go to cart page
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		//Store all added cart product under cartProducts 
		List<WebElement>cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		List<WebElement>cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		//Match the added product is same as whatever mention in productName
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		//Clicking on Checkout button and go to checkout/place order page
		driver.findElement(By.cssSelector(".totalRow button")).click();
//		driver.findElement(By.xpath("//*[@class='totalRow']/button")).click();
		//Click on Country search field and select searched country name
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "india").build().perform();
		//Wait untill search options are not displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		//Select seached/entered name from search option area
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		//Clicking on Placeorder button
		driver.findElement(By.cssSelector(".action__submit")).click();
		//Graping Thank you message
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		String confirmMessage = driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
}