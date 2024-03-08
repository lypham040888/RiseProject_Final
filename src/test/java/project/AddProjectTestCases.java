package project;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import constants.WebInfo;
import pom.AddProjectForm;
import pom.DashboardPage;
import pom.LogInPage;
import pom.ProjectPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AddProjectTestCases {
	WebDriver driver;
	CommonBrowser commonBrowser;
	CommonActions action;

	// Check add project success when input all require fields
	@Test
	public void TC_ADDPRO_001() {
		String titleName = "project codestar 1";

		LogInPage login = new LogInPage(driver);
		login.clickLogin("admin@demo.com", "riseDemo");

		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickProjectLink();

		ProjectPage project = new ProjectPage(driver);
		project.clickAddProject();

		AddProjectForm addProject = new AddProjectForm(driver);
		addProject.save(titleName);
		addProject.closeForm();

	}

	// Check add project un-success when missing at least require fields
	@Test
	public void TC_ADDPRO_002() {
		String titleName = "";
		ProjectPage project = new ProjectPage(driver);
		project.clickAddProject();

		AddProjectForm addProject = new AddProjectForm(driver);
		addProject.save(titleName);
		addProject.showRequireMessage("This field is required.");

	}

//	@BeforeTest
//	public void beforeTest() {
//		/// driver = new ChromeDriver();
//		commonBrowser = new CommonBrowser();
//		action = new CommonActions();
//		driver = browser.initEdgeDriver(WebInfo.test_URL);
//	}

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional("firefox") String browser) {
		commonBrowser = new CommonBrowser();
		action = new CommonActions();
		driver = commonBrowser.setupDriver(browser, WebInfo.test_URL);
		commonBrowser.pause(4000);

	}

	@AfterTest
	public void afterTest() {
		commonBrowser.quitDriver(driver);
	}

}
