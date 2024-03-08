package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPage extends BasePage {

	public ClientPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a [@title='Add client']")
	WebElement addClientButton;
	@FindBy(xpath = "//span[text()='Total clients']")
	WebElement totalClientLink;
	@FindBy(xpath = "//input[@type='search']")
	WebElement txtSearch;
	@FindBy(xpath = "//td//a[contains(text(),'ABC Company 2')]")
	WebElement searchResult;

	// Click Add Client button
	// Chọn view 100 item/ page
	// Kết hợp JavascriptExector để tìm client đã add mà không cần chọn view 100
	// item/page
	// Search theo client name

	// Kiểm tra danh sách client sau khi add
	//

	public void clickAddClientButton() {
		addClientButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchClientName(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", totalClientLink);
		// js.executeScript("", null)
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtSearch.sendKeys(value);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyClient(String value) {
		assertEquals(searchResult.getText(), value);

	}

}
