package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {

	public ProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@title='Add project']")
	WebElement btnAdd;

	@FindBy(xpath = "//span[@class='user-name ml10']")
	WebElement lbbLoggedUser;

	public void checkLoggedUser(String user) {
		assertEquals(lbbLoggedUser.getText(), user);

	}

	public void clickAddProject() {
		cAction.click(btnAdd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
