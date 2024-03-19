package rahulshettyacademy.Tests;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.m;
import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponants.BaseTest_166;
import rahulshettyacademy.pageobjects.CartPage_164;
import rahulshettyacademy.pageobjects.CheckoutPage_165;
import rahulshettyacademy.pageobjects.ConfirmationPage_165_1;
import rahulshettyacademy.pageobjects.LandingPage_159;
import rahulshettyacademy.pageobjects.OrderPage_169;
import rahulshettyacademy.pageobjects.ProductCatalogue_160_1;
public class SubmitOrderTest_160 extends BaseTest_166{
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		LandingPage_159 landingPage = launchApplication();
		ProductCatalogue_160_1 productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage_164 cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage_165 checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage_165_1 confirmatioPage = checkoutPage.submitOrder();		
		//Grasping Thank you message
		String confirmMessage = confirmatioPage.getConfirmationMessage();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	//To verify ZARA COAT 3 is displaying on the Order page
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue_160_1 productCatalogue = landingPage.loginApplication("jkcdatest@gmail.com", "Qwertyu1");
		OrderPage_169 ordersPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	//Extend Reports-
	
	//Integration of Hashmap to Data provider to send the data as one Hash Object_172
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
//	//Integration of Hashmap to Data provider to send the data as one Hash Object_172
//	@DataProvider
//	public Object[][] getData()
//	{
//		HashMap<String, String> map= new HashMap<String, String>();
//		map.put("email","jkcdatest@gmail.com");
//		map.put("password","Qwertyu1");
//		map.put("product","ZARA COAT 3");
//		HashMap<String, String> map1= new HashMap<String, String>();
//		map1.put("email","shetty@gmail.com");
//		map1.put("password","Iamking@000");
//		map1.put("product","ADIDAS ORIGINAL");
//		return new Object[][] {{map},{map1}};
//	}
	
/*	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException {
		LandingPage_159 landingPage = launchApplication();
		ProductCatalogue_160_1 productCatalogue = landingPage.loginApplication(email, password);
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage_164 cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage_165 checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmatioPage_165_1 confirmatioPage = checkoutPage.submitOrder();		
		//Grasping Thank you message
		String confirmMessage = confirmatioPage.getConfirmationMessage();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	// Implementing Parameterization into tests with TestNG Data Provider_171
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"jkcdatest@gmail.com","Qwertyu1","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
	}*/
}