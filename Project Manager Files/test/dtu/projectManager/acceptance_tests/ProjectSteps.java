package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ProjectSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;
	private AdminSession adminSession;

	private Project project;
	private String projectId;
	private Activity activity;
	private String activityId;
	private String oldProjectName;
	private String newProjectName;

	public ProjectSteps(ProjectManagerApp projectManagerApp, ErrorMessageHolder errorMessageHolder, AdminSession adminSession) {
		this.projectManagerApp = projectManagerApp;
		this.errorMessageHolder = errorMessageHolder;
		this.adminSession = adminSession;
	}


	@Given("there is a project named {string}")
	public void thereIsAProjectWithName(String name) throws Exception {
		project = new Project(name);
	}
	@When("the user adds the project to the Project Manager")
	public void theUserAddsTheProject() throws Exception {
		try {
			projectId = projectManagerApp.addProject(project);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	@Then("the project (exists)(is still) in the Project Manager")
	public void theProjectExistsInTheProjectManager() throws Exception {
		assertTrue(projectManagerApp.containsProjectWithID(projectId));
	}
	
	@Given("the project (does not exist in)(is removed from) the Project Manager")
	public void theProjectDoesNotExistInTheProjectManager() {
		assertFalse(projectManagerApp.containsProjectWithID(projectId));
	}
	
	@Given("there is a project in the Project Manager")
	public void thereIsAProjectInTheManager() throws Exception {
		adminSession.start();
		project = new Project("Sample project");
		projectId = projectManagerApp.addProject(project);
		adminSession.end();
	}
	
	@When("the user renames the project")
	public void theUserRenamesTheProject() {
	    this.oldProjectName = this.project.getName();
	    this.newProjectName = "New Name";
		try {
			projectManagerApp.renameProject(this.project.getID(),this.newProjectName);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}

	}

	@Then("the projects name is changed")
	public void theProjectsNameIsChanged() {
	    assertEquals(projectManagerApp.getProjectWithID(this.project.getID()).getName(),this.newProjectName);
	}
	
	@Then("the projects name is unchanged")
	public void theProjectsNameIsUnchanged() {
		assertEquals(projectManagerApp.getProjectWithID(this.project.getID()).getName(),this.oldProjectName);
	}



	@Given("there is an activity")
	public void thereIsAnActivity() throws Exception {
		activity = new Activity("Sample activity", 2, 13);
	}
	@Given("there is an activity called {string} starting week {int} lasting for {int} weeks")
	public void thereIsADetailedActivity(String name, int startWeek, int weeks) throws Exception {
		activity = new Activity(name, startWeek, weeks);
	}
	@Given("the activity ends in week {int}")
	public void theActivityEndsInWeek(int endWeek) throws Exception {
		assertEquals(endWeek, activity.getEndWeek());
	}
	@Given("the employee with initials {string} is Project Leader for the project")
	public void givenTheEmployeeWithInitialsIsProjectLeader(String initials) throws Exception {
		adminSession.start();
		projectManagerApp.assignProjectLeader(projectId, initials);
		adminSession.end();
	}

	@When("the user adds the activity to the project")
	public void theUserAddsTheActivityToTheProject() throws OperationNotAllowedException {
		try {
			activityId = projectManagerApp.addActivityToProject(projectId, activity);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	@Then("the activity exists on the project")
	public void theActivityExistsOnTheProject() throws Exception {
		assertTrue(projectManagerApp.getProjectWithID(projectId).containsActivityWithID(activityId));
	}
	@Then("the activity does not exist on the project")
	public void theActivityDoesNotExistsOnTheProject() throws Exception {
		Project project = projectManagerApp.getProjectWithID(projectId);
		assertFalse(project.containsActivityWithID(activityId));
	}
	@Given("there is an activity on the project")
	public void theProjectHasAnActivity() throws Exception {
		adminSession.start();
		activity = new Activity("Sample activity", 2, 13);
		activityId = projectManagerApp.addActivityToProject(projectId, activity);
		adminSession.end();
	}

	@Given("the registered employee {string} is assigned to the activity")
	public void theRegisteredEmployeeIsAssignedToTheActivity(String initials) throws OperationNotAllowedException {
		adminSession.start();
		Employee e = new Employee(initials, "John");
		projectManagerApp.addEmployee(e);
		projectManagerApp.assignEmployeeToActivity(projectId, activityId, initials);
		adminSession.end();
	}
	@Given("the registered employee {string} is not assigned to the activity")
	public void theRegisteredEmployeeIsNotAssignedToTheActivity(String initials) throws OperationNotAllowedException {
		adminSession.start();
		Employee e = new Employee(initials, "Michael");
		projectManagerApp.addEmployee(e);
		adminSession.end();
		Project p = projectManagerApp.getProjectWithID(projectId);
		Activity a = p.getActivityWithID(activityId);
		assertFalse(a.containsEmployeeWithInitials(initials));
	}

	@When("the user assigns the employee with initials {string} to the activity")
	public void theUserAssignsEmployeeToTheActivity(String employeeInitials) throws OperationNotAllowedException {
		try {
			projectManagerApp.assignEmployeeToActivity(projectId, activityId, employeeInitials);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the user asks the employee with initials {string} for help with the activity")
	public void theUserAsksTheEmployeeWithInitialsForHelpWithTheActivity(String employeeInitials) {
		try {
			projectManagerApp.askForAssistance(activityId, employeeInitials);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the employee with the initials {string} is assigned to the activity")
	public void theEmployeeWithInitialsIsAssignedToTheActivity(String employeeInitials) {
		Activity activity = projectManagerApp.getProjectWithID(projectId).getActivityWithID(activityId);
		assertTrue(activity.containsEmployeeWithInitials(employeeInitials));
	}
	@Then("the employee with the initials {string} is not assigned to the activity")
	public void theEmployeeWithInitialsIsNotAssignedToTheActivity(String employeeInitials) {
		Activity activity = projectManagerApp.getProjectWithID(projectId).getActivityWithID(activityId);
		assertFalse(activity.containsEmployeeWithInitials(employeeInitials));
	}
	@Then("the activity is assigned to the employee with initials {string}")
	public void theActivityIsAssignedToTheEmployeeWithInitials(String employeeInitials) {
		Employee employee = projectManagerApp.getEmployeeWithInitials(employeeInitials);
		employee.containsActivityWithID(activityId);
	}
	@When("the user assigns the employee with initials {string} as Project Leader of the project")
	public void theUserAssignsEmployeeWithInitialsAsProjectLeader(String employeeInitials) throws OperationNotAllowedException {
		try {
			projectManagerApp.assignProjectLeader(projectId, employeeInitials);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	@Then("the Project Leader of the project has the initials {string}")
	public void theProjectLeaderOfTheProjectHasTheInitials(String employeeInitials) {
		Project project = projectManagerApp.getProjectWithID(projectId);
		Employee employee = projectManagerApp.getEmployeeWithInitials(employeeInitials);
		assertTrue(project.isProjectLeader(employee));
	}
	@Then("the Project Leader of the project does not have the initials {string}")
	public void theProjectLeaderOfTheProjectDoesNotHaveTheInitials(String employeeInitials) throws Exception {
		Project project = projectManagerApp.getProjectWithID(projectId);
		Employee employee = projectManagerApp.getEmployeeWithInitials(employeeInitials);
		assertFalse(project.isProjectLeader(employee));
	}

	@Then("there are some projects in the Project Manager")
	public void someProjectsExist() {
		assertFalse(projectManagerApp.getProjects().isEmpty());
	}
	@Then("there are no projects in the Project Manager")
	public void noProjectsExist() {
		assertTrue(projectManagerApp.getProjects().isEmpty());
	}

	@When("the user adds a project")
	public void theUserAddsAProject() {
		Project project = new Project("Sample project");
		try {
			projectId = projectManagerApp.addProject(project);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	@When("the user adds another project")
	public void theUserAddsAnotherProject() {
		theUserAddsAProject();
	}

	@Then("a project with the ID {string} exists in the Project Manager")
	public void aProjectWithIDExists(String projectID) throws Exception {
		assertTrue(projectManagerApp.containsProjectWithID(projectID));
	}

	@Then("the error message {string} is given")
	public void theErrorMessageIsGiven(String errorMessage) throws Exception {
		assertEquals(errorMessage, this.errorMessageHolder.getErrorMessage());
	}
	

	@Given("the user is logged in as Project Leader for the project")
	public void theUserIsProjectLeaderForTheProject() throws OperationNotAllowedException {
		adminSession.start();
		String initials = "PLJ";
		Employee e = new Employee(initials, "Project Leader John");
		projectManagerApp.addEmployee(e);
		projectManagerApp.assignProjectLeader(projectId, initials);
		adminSession.end();
		projectManagerApp.login(initials);
	}
	
	@When("the user budgets {double} hours to the activity")
	public void budgetHoursToActivity(double hours) throws Exception {
		try {
			projectManagerApp.budgetHoursToActivity(projectId, activityId, hours);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the activity has a budget of {double} hours")
	public void activityHasBudgetHours(double hours) throws Exception {
		assertEquals(hours, activity.getBudgetHours(), 0.0);
	}

	@Then("the activity has no budget hours")
	public void activityHasNoBudgetHours() throws Exception {
		Activity a = projectManagerApp.getActivityFromProject(projectId, activityId);
		assertEquals(0, a.getBudgetHours(), 0.0);
	}

	@When("the user registers {double} (more )hours to the activity")
	public void userRegistersHoursToActivity(double hours) throws Exception {
		try {
			projectManagerApp.registerHoursToActivity(activityId,projectManagerApp.getCurrentUser().getInitials(), hours);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the activity has {double} hours registered with the employee with initials {string}")
	public void activityHasRegisteredHoursWithEmployee(double hours, String employeeInitials) throws Exception {
		Activity a = projectManagerApp.getActivityFromProject(projectId, activityId);
		Employee e = projectManagerApp.getEmployeeWithInitials(employeeInitials);
		assertEquals(hours, a.getEmployeesRegisteredHours(e), 0.0);
	}


	@Then("the activity is not assigned to the employee with initials {string}")
	public void theActivityIsNotAssignedTheEmployeeWithInitials(String employeeInitials) {
		assertFalse(projectManagerApp.getEmployeeWithInitials(employeeInitials).containsActivityWithID(activityId));
	}

	@When("the user requests the total hours registered to the activity")
	public void userRequestsTotalRegisteredHoursFromActivity() throws Exception {
		try {
			projectManagerApp.getTotalRegisteredHoursToActivity(project.getID(), activity.getID());
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the total hours registered to the activity is {double}")
	public void theTotalHoursRegisteredToTheActivityShouldBe(double hours) throws OperationNotAllowedException {
		double epsilon = 0.1;
		adminSession.start();
		assertEquals(projectManagerApp.getTotalRegisteredHoursToActivity(project.getID(), activity.getID()), hours,epsilon);
		adminSession.end();
	}

}
