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
	
	@Given("the employee with initials {string} is project leader for the project with the ID {string}")
	public void givenEmployeeIsProjectLeader(String eInit, String projectID) throws Exception {
		projectManagerApp.login("ADMIN");
		projectManagerApp.assignEmployeeProjectLeader(eInit,projectID);
		projectManagerApp.logout();
	}
	
	@Given("the employee with initials {string} is not project leader for the project with the ID {string}")
	public void givenEmployeeIsNotProjectLeader(String eInit, String projectID) throws Exception {
		Project p=projectManagerApp.getProjectWithID(projectID);
		if(p.getProjectleader()!=null) {
		if(p.getProjectleader().getInitials()==eInit) {
			projectManagerApp.login("ADMIN");
			projectManagerApp.assignEmployeeProjectLeader("Unassigned",projectID);
			projectManagerApp.logout();
		}
		}
	}
	
	@When("the user adds an activity with the ID {string} to the project with the ID {string}")
	public void userAddsActivityToProject(String activityID, String projectID) throws Exception {
		try {
			projectManagerApp.addActivityToProject(projectID, activityID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("an activity with the ID {string} is added to the project with the ID {string}")
	public void activityExists(String activityID, String projectID) throws Exception {
		assertTrue(projectManagerApp.projectContainsActivityWithID(projectID, activityID));
	}
	
	@Then("an activity with the ID {string} is not added to the project with the ID {string}")
	public void activityExistsNot(String activityID, String projectID) throws Exception {
		assertFalse(projectManagerApp.projectContainsActivityWithID(projectID, activityID));
	}

	@Given("an activity with the ID {string} exists on the project with ID {string}")
	public void activityExistsOnProject(String activityID, String projectID) throws Exception {
		try {
			projectManagerApp.addActivityToProject(projectID, activityID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@When("the user assigns the employee with initials {string} to the activity with ID {string} on the project with ID {string}")
	public void userAssignsEmployeeToActivity(String employeeInitials, String activityID, String projectID) throws Exception {
		try {
			projectManagerApp.assignEmployeeToActivity(projectID, employeeInitials, activityID);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}

	}

	@Then("the employee with initials {string} is assigned to the activity with ID {string} on the project with ID {string}")
	public void employeeIsAssignedToActivity(String employeeInitials, String activityID, String projectID) throws Exception {
		assertTrue(projectManagerApp.projectContainsActivityWithAssignedEmployee(projectID, activityID, employeeInitials));
	}

	@Then("the activity with ID {string} is assigned to the employee with initials {string}")
	public void employeeIsAssignedToActivity(String activityID, String employeeInitials) throws Exception {
		assertTrue(projectManagerApp.employeeContainsAssignedActivity(activityID, employeeInitials));
	}


}
