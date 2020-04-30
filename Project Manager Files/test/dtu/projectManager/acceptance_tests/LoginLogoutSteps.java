package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.ProjectManagerApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginLogoutSteps {

	private ProjectManagerApp projectManagerApp;

	private ErrorMessageHolder errorMessage;
	private Employee user;

	public LoginLogoutSteps(ProjectManagerApp projectManagerApp, ErrorMessageHolder errorMessage) {
		this.projectManagerApp = projectManagerApp;
		this.errorMessage = errorMessage;
	}

	@Given("the user is not logged in as admin")
	public void theUserIsNotLoggedInAsAdmin() throws Exception {
		assertFalse(projectManagerApp.adminLoggedIn());
	}

	@Given("the user is logged in as admin")
	public void theUserIsAlreadyLoggedInAsAdmin() throws Exception {
		projectManagerApp.login("ADMIN");
		assertTrue(projectManagerApp.adminLoggedIn());
	}

	@Given("the user is already logged in with initials {string}")
	public void theUserIsAlreadyLoggedInWithInitials(String initials) throws OperationNotAllowedException {
		projectManagerApp.logout();
		projectManagerApp.login(initials);
		assertEquals(projectManagerApp.getCurrentUser().getInitials(), initials);
	}

	@Then("the user is now logged in as admin")
	public void theUserIsLoggedInAsAdmin() throws Exception {
		assertTrue(projectManagerApp.adminLoggedIn());
	}

	@When("the user logs in with initials {string}")
	public void theUserLogsInWithInitials(String initials) throws OperationNotAllowedException {
		try {
			projectManagerApp.login(initials);
		} catch (Exception e ) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the user is logged in with initials {string}")
	public void theUserIsLoggedInWithInitials(String initials) {
		Employee currentUser = projectManagerApp.getCurrentUser();
		assertEquals(currentUser.getInitials(), initials);
	}

	@When("the user logs out")
	public void theUserLogsOut() {
		projectManagerApp.logout();
	}

	@Then("the user is not logged in")
	public void theUserIsNotLoggedIn() {
		assertNull(projectManagerApp.getCurrentUser());
	}

}
