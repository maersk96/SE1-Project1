package dtu.library.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dtu.library.app.ProjectManagerApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutSteps {

	private ProjectManagerApp projectManagerApp;
	private String password;

	/*
	 * Note that the constructor is apparently never called, but there are no null
	 * pointer exceptions regarding that projectManagerApp is not set. When creating the
	 * LoginSteps object, the Cucumber libraries are using that constructor with an
	 * object of class projectManagerApp as the default.
	 * 
	 * This also holds for all other step classes that have a similar constructor.
	 * In this case, the <b>same</b> object of class projectManagerApp is used as an
	 * argument. This provides an easy way of sharing the same object, in this case
	 * the object of class projectManagerApp, among all step classes.
	 * 
	 * This principle is called <em>dependency injection</em>. More information can
	 * be found in "The Cucumber for Java Book" available online from the DTU Library.
	 * (search using findit.dtu.dk).
	 */
	public LoginLogoutSteps(ProjectManagerApp projectManagerApp) {
		this.projectManagerApp = projectManagerApp;
	}

	@Given("that the administrator is not logged in")
	public void thatTheAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(projectManagerApp.adminLoggedIn());
	}

	@Given("the password is {string}")
	public void thePasswordIs(String password) throws Exception {
		this.password = password;
	}

	@Then("the administrator login succeeds")
	public void theAdministratorLoginSucceeds() throws Exception {
		assertTrue(projectManagerApp.adminLogin(password));
	}

	@Then("the adminstrator is logged in")
	public void theAdminstratorIsLoggedIn() throws Exception {
		assertTrue(projectManagerApp.adminLoggedIn());
	}

	@Then("the administrator logs in successfully")
	public void theAdministratorLoginsSuccessfully() throws Exception {
	}

	@Then("the administrator login fails")
	public void theAdministratorLoginFails() throws Exception {
		assertFalse(projectManagerApp.adminLogin(password));
	}

	@Then("the administrator is not logged in")
	public void theAdministratorIsNotLoggedIn() throws Exception {
		assertFalse(projectManagerApp.adminLoggedIn());
	}

	@Given("that the administrator is logged in")
	public void thatTheAdministratorIsLoggedIn() throws Exception {
		assertTrue(projectManagerApp.adminLogin("adminadmin"));
	}

	@When("the administrator logs out")
	public void theAdministratorLogsOut() throws Exception {
		projectManagerApp.adminLogout();
	}
}
