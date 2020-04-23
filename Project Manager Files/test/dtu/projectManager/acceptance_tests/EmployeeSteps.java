package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeeSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;
	private AdminSession adminSession;

	Employee employee;
	String projectId;

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
		employee = new Employee(initials);
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

	@Given("an employee registered in the Project Manager")
	public void anEmployeeRegisteredInTheProjectManager() throws OperationNotAllowedException {
		theEmployeeWithInitialsIsRegistered("XYZ");
	}
	@Given("the employee is assigned to {int} (more )active activit(y)(ies)")
	public void theEmployeeIsAssignedToActivities(int activitiesAmount) throws OperationNotAllowedException {
		adminSession.start();
		Project project = new Project("Sample project");
		String projectId = projectManagerApp.addProject(project);
		for(int i=1; i <= activitiesAmount; i++){
			Activity activity = new Activity("Sample activity " + i, 1,52);
			String activityId = projectManagerApp.addActivityToProject(projectId, activity);
			projectManagerApp.assignEmployeeToActivity(projectId, employee.getInitials(), activityId);
		}
		adminSession.end();
	}
	@Then("the employee is available")
	public void theEmployeeIsAvailable() {
		Employee e = projectManagerApp.getEmployeeWithInitials(employee.getInitials());
		assertTrue(e.isAvailable());
	}
	@Then("the employee is unavailable")
	public void theEmployeeIsUnavailable() {
		Employee e = projectManagerApp.getEmployeeWithInitials(employee.getInitials());
		assertFalse(e.isAvailable());
	}
}
