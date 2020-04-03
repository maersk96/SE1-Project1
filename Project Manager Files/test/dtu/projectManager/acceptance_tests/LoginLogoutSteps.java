package dtu.projectManager.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.ProjectManagerApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutSteps {

	private ProjectManagerApp projectManagerApp;
	private Employee user;

	/*
	 * Note that the constructor is apparently never called, but there are no null
	 * pointer exceptions regarding that libraryApp is not set. When creating the
	 * LoginSteps object, the Cucumber libraries are using that constructor with an
	 * object of class LibraryApp as the default.
	 * 
	 * This also holds for all other step classes that have a similar constructor.
	 * In this case, the <b>same</b> object of class LibraryApp is used as an
	 * argument. This provides an easy way of sharing the same object, in this case
	 * the object of class LibraryApp, among all step classes.
	 * 
	 * This principle is called <em>dependency injection</em>. More information can
	 * be found in "The Cucumber for Java Book" available online from the DTU Library.
	 * (search using findit.dtu.dk).
	 */
	public LoginLogoutSteps(ProjectManagerApp projectManagerApp) {
		this.projectManagerApp = projectManagerApp;
	}

	@Given("the user is not logged in as admin")
	public void theUserIsNotLoggedInAsAdmin() throws Exception {
		assertFalse(projectManagerApp.adminLoggedIn());
	}

	@Given("the user is logged in as admin")
	public void theUserIsLoggedInAsAdmin() throws Exception {
		assertTrue(projectManagerApp.adminLoggedIn());
	}

	@Given("there is a user with initials {string}")
	public void thereIsAUserWithInitials(String initials) throws Exception {
		user = new Employee(initials);
	}

	@When("the user logs in with initials {string}")
	public void theUserLogsInWithInitials(String initials) throws Exception {
		projectManagerApp.login(initials);
	}

	@Given("there exists an employee with initials {string}")
	public void thereExistsAnEmployeeWithInitials(String initials) throws Exception {
		projectManagerApp.containsEmployeeWithInitials(initials);
	}

}
