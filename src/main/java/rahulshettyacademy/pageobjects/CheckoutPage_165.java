package rahulshettyacademy.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractCompanent_161;
public class CheckoutPage_165 extends AbstractCompanent_161{
	WebDriver driver;
	public CheckoutPage_165(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	By results = By.cssSelector(".ta-results");
	//Click on Country search field and select searched country name
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		//Wait untill search options are not displayed
		waitForElementToAppear(By.cssSelector(".ta-results"));
		//Select seached/entered name from search option area
		selectCountry.click();
	}
	//Clicking on Placeorder button
	public ConfirmationPage_165_1 submitOrder() {
		submit.click();
		return new ConfirmationPage_165_1(driver);
	}
}