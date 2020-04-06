package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.Project;
import dtu.projectManager.app.ProjectManagerApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ProjectSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;

	private Project project;

	public ProjectSteps(ProjectManagerApp projectManagerApp, ErrorMessageHolder errorMessageHolder) {
		this.projectManagerApp = projectManagerApp;
		this.errorMessageHolder = errorMessageHolder;
	}

	@Given("there are no projects in the project manager")
	public void thereAreNoProjectsInTheManager() throws Exception {
		assertEquals(0, projectManagerApp.amountOfProjects());
	}

	@When("the user adds a project")
	public void theUserAddsAProject() {
		try {
			projectManagerApp.addProject();
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("a project with the ID {string} exists in the project manager")
	public void aProjectWithIDExists(String projectID) throws Exception {
		assertTrue(projectManagerApp.containsProjectWithID(projectID));
	}

	@Then("the error message {string} is given")
	public void theErrorMessageIsGiven(String errorMessage) throws Exception {
		assertEquals(errorMessage, this.errorMessageHolder.getErrorMessage());
	}
	
	
	@Given("a project with the ID {string} exists")
	public void aProjectWithIDGiven(String projectID) throws Exception {
		projectManagerApp.login("ADMIN");
		String pID=projectManagerApp.addProject();
		Project p=projectManagerApp.getProjectWithID(pID);
		p.setID(projectID);
		projectManagerApp.logout();
	}
	
	@When("the employee with initials {string} is assigned as project leader for the project with the ID {string}")
	public void employeeAssignedProjectLeader(String eInit, String projectID) throws Exception {
		try {
			projectManagerApp.assignEmployeeProjectLeader(eInit,projectID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the project with the ID {string} has project leader with initials {string}")
	public void employeeIsProjectLeader(String projectID, String eInit) throws Exception {
		assertEquals(projectManagerApp.getEmployeeWithInitials(eInit), projectManagerApp.getProjectWithID(projectID).getProjectleader());
	}
	
	@Then("the project with the ID {string} does not have a project leader with initials {string}")
	public void employeeIsNotProjectLeader(String projectID, String eInit) throws Exception {
		assertFalse(projectManagerApp.getEmployeeWithInitials(eInit).equals(projectManagerApp.getProjectWithID(projectID).getProjectleader()));
	}

}
