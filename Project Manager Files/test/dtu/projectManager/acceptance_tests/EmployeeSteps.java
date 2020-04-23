package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.ProjectManagerApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeeSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;
	private AdminSession adminSession;

	public EmployeeSteps(ProjectManagerApp projectManagerApp,
						 ErrorMessageHolder errorMessageHolder,
						 AdminSession adminSession) {
		this.projectManagerApp = projectManagerApp;
		this.errorMessageHolder = errorMessageHolder;
		this.adminSession = adminSession;
	}

	@Given("there exists an employee with initials {string}")
	public void thereExistsAnEmployeeWithInitials(String initials) throws Exception {
		assertTrue(projectManagerApp.containsEmployeeWithInitials(initials));
	}

	@Given("the employee with initials {string} is registered")
	public void theEmployeeWithInitialsIsRegistered(String initials) throws OperationNotAllowedException {
		adminSession.start();
		Employee employee = new Employee(initials);
		projectManagerApp.addEmployee(employee);
		adminSession.end();
	}


	@Given("there does not exist an employee with initials {string}")	
	public void thereDoesNotExistAnEmployeeWithInitials(String initials) throws Exception {
		assertFalse(projectManagerApp.containsEmployeeWithInitials(initials));
	}

	@When("the user adds an employee with initials {string}")
	public void theUserAddsAnEmployeeWithInitials(String initials) throws OperationNotAllowedException {
		Employee employee = new Employee(initials);
		try {
			projectManagerApp.addEmployee(employee);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}

	}

}
