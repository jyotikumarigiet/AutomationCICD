package rahulshettyacademy.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractCompanent_161;
public class ConfirmationPage_165_1 extends AbstractCompanent_161{
	WebDriver driver;
	public ConfirmationPage_165_1(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	//Graping Thank you message
	public String getConfirmationMessage() {
		CheckoutPage_165 cp = new CheckoutPage_165(driver);
//		cp.submit.click();
		return confirmationMessage.getText();
	}
}