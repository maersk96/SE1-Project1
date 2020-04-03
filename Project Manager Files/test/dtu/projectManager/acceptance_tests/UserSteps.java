package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.ProjectManagerApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserSteps {

	private ProjectManagerApp projectManagerApp;
	private Employee user;

	public UserSteps(ProjectManagerApp projectManagerApp) {
		this.projectManagerApp = projectManagerApp;
	}

	@Given("there exists an employee with initials {string}")
	public void thereExistsAnEmployeeWithInitials(String initials) throws Exception {
		assertTrue(projectManagerApp.containsEmployeeWithInitials(initials));
	}

	@Given("the employee with initials {string} is registered")
	public void theEmployeeWithInitialsIsAlreadyRegistered(String initials) throws OperationNotAllowedException {
		projectManagerApp.login("ADMIN");
		Employee employee = new Employee(initials);
		projectManagerApp.addEmployee(employee);
		projectManagerApp.logout();
	}

	@Given("the employee with initials {string} is not registered")
	public void theEmployeeWithInitialsIsNotRegistered(String initials) throws Exception {
		assertFalse(projectManagerApp.containsEmployeeWithInitials(initials));
	}


}
