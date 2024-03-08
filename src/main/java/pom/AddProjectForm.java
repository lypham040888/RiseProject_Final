package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectForm extends BasePage {

	public AddProjectForm(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "title")
	WebElement txtTitle;
	@FindBy(xpath = "//button[contains(text(),' Close')]")
	WebElement btnClose;

	@FindBy(id = "save-and-continue-button")
	WebElement btnSave;
	@FindBy(id="title-error")
	WebElement errorMsg;

	public void save(String titleName) {
		cAction.sendKeys(txtTitle, titleName);
		cAction.click(btnSave);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeForm() {
		cAction.click(btnClose);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showRequireMessage(String message) {
		assertEquals(errorMsg.isDisplayed(), true);
		assertEquals(errorMsg.getText(), message);
	}

}
