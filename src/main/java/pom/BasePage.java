package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;

public class BasePage {
	WebDriver driver;
	CommonActions cAction;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cAction = new CommonActions();

	}
}
