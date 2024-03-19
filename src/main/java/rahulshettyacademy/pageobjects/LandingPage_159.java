package rahulshettyacademy.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractCompanent_161;
public class LandingPage_159 extends AbstractCompanent_161 {
	WebDriver driver;
	//How this annotion know about the driver
	//There is one method called iniElements which we have to write first, this will take care of constructing that driver argument once set in the method
	public LandingPage_159(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
//	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
//	WebElement psswordEle;
	
	@FindBy(id="login")
	WebElement login;
//	WebElement submit;
	
	@FindBy(css="[class*='toast-message']")//.ng-tns-c4-47.toast-message.ng-star-inserted
	WebElement errorMessage;
	
	public ProductCatalogue_160_1 loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalogue_160_1 productCatalogue = new ProductCatalogue_160_1(driver);
		return productCatalogue;
	}
	public String getErrorMessage() 
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
}