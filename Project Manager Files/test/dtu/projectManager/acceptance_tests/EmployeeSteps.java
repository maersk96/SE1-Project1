package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import static org.junit.Assert.*;

// Steps for handling testing of employee functionality

// Work distribution:
// Mainly Jonas, Mikkel and Lukas have contributed to this class and its methods. It would be incorrect to put individual names on any method, as they have all been developed, or reviewed and edited by everyone, also Anton
// For a more accurate representation of who did what, see each feature file, and which steps it references

public class EmployeeSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;
	private AdminSession adminSession;

	Employee employee;

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
		adminSession.end();
		projectManagerApp.login(initials);
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
		List<Employee> employees = projectManagerApp.getAvailableEmployees(week);
		assertTrue(employees.contains(employee));
	}
	@Then("the employee is unavailable in week {int}")
	public void theEmployeeIsUnavailable(int week) {
		List<Employee> employees = projectManagerApp.getAvailableEmployees(week);
		assertFalse(employees.contains(employee));
	}

	@And("the employee with initials {string} has a name")
	public void theEmployeeHasAName(String initials) {
		assertNotEquals("", projectManagerApp.getEmployeeWithInitials(initials).getName());
	}
}
