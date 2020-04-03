package dtu.library.acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import dtu.library.app.Employee;
import dtu.library.app.ProjectManagerApp;
import dtu.library.app.OperationNotAllowedException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;


	/*
	 * Note that the constructor is apparently never called, but there are no null
	 * pointer exceptions regarding that projectManagerApp is not set. When creating the
	 * BookSteps object, the Cucumber libraries are using that constructor with an
	 * object of class projectManagerApp as the default.
	 * 
	 * This also holds for all other step classes that have a similar constructor.
	 * In this case, the <b>same</b> object of class projectManagerApp is used as an
	 * argument. This provides an easy way of sharing the same object, in this case
	 * the object of class projectManagerApp, among all step classes.
	 * 
	 * This principle is called <em>dependency injection</em>. More information can
	 * be found in the "Cucumber for Java" book available online from the DTU Library.
	 */
	public ProjectSteps(ProjectManagerApp projectManagerApp, ErrorMessageHolder errorMessageHolder) {
		this.projectManagerApp = projectManagerApp;
		this.errorMessageHolder = errorMessageHolder;
	}

	
	

@Given("that the admin is logged in")
public void thatTheAdminIsLoggedIn() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("there is a project with the ID ”{String}”")
public void thereIsAProjectWithTheID(String id) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("there is an employee with the initials ”{String}”")
public void thereIsAnEmployeeWithTheInitials(String initials) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("the employee is assigned as project leader")
public void theEmployeeIsAssignedAsProjectLeader() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("the project with the ID ”{String}” has the project leader with the initials ”{String}”")
public void theProjectWithTheIDHasTheProjectLeaderwithTheInitials(String id, String initials) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("that the admin is not logged in")
public void thatTheAdminIsNotLoggedIn() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}


@Then("the project with the ID ”{String}” does not have the project leader with the initials ”{String}”")
public void theProjectWithTheIDDoesNotHaveTheProjectLeaderWithTheInitials(String id, String initials) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
