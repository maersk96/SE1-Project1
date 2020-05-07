package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

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

	@Given("the user is logged in as a registered employee")
	public void theUserIsARegisteredEmployee() throws OperationNotAllowedException {
		adminSession.start();
		String initials = "SAMPLE";
		employee = new Employee(initials, "John");
		projectManagerApp.addEmployee(employee);
		projectManagerApp.login(initials);
		adminSession.end();
	}

	@Given("the employee with initials {string} is registered")
	public void theEmployeeWithInitialsIsRegistered(String initials) throws OperationNotAllowedException {
		adminSession.start();
		employee = new Employee(initials, "Name");
		projectManagerApp.addEmployee(employee);
		adminSession.end();
	}


	@Given("there does not exist an employee with initials {string}")	
	public void thereDoesNotExistAnEmployeeWithInitials(String initials) throws Exception {
		assertFalse(projectManagerApp.containsEmployeeWithInitials(initials));
	}

	@When("the user adds an employee with initials {string}")
	public void theUserAddsAnEmployeeWithInitials(String initials) throws OperationNotAllowedException {
		Employee employee = new Employee(initials, "Name");
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
	@Given("the employee is assigned to {int} (more )activit(y )(ies )in week {int}")
	public void theEmployeeIsAssignedToActivities(int activities, int week) throws OperationNotAllowedException {
		adminSession.start();
		Project project = new Project("Sample project");
		String projectId = projectManagerApp.addProject(project);
		for(int i=1; i <= activities; i++){
			Activity activity = new Activity("Sample activity " + i, week, 1);
			String activityId = projectManagerApp.addActivityToProject(projectId, activity);
			try {
				projectManagerApp.assignEmployeeToActivity(projectId, activityId, employee.getInitials());
			} catch (OperationNotAllowedException e) {
				errorMessageHolder.setErrorMessage(e.getMessage());
			}
		}
		adminSession.end();
	}
	@Then("the employee is (still)(now) assigned to {int} activities in week {int}")
	public void theEmployeeIsNowAssignedToActivities(int activities, int week) {
		Employee e = projectManagerApp.getEmployeeWithInitials(employee.getInitials());
		int actualActivities = e.getActivitiesInWeek(week).size();
		assertEquals(activities, actualActivities);
	}

	@Then("the employee is available in week {int}")
	public void theEmployeeIsAvailable(int week) {
		Employee e = projectManagerApp.getEmployeeWithInitials(employee.getInitials());
		assertTrue(e.isAvailableInWeek(week));
	}
	@Then("the employee is unavailable in week {int}")
	public void theEmployeeIsUnavailable(int week) {
		Employee e = projectManagerApp.getEmployeeWithInitials(employee.getInitials());
		assertFalse(e.isAvailableInWeek(week));
	}
	

}
