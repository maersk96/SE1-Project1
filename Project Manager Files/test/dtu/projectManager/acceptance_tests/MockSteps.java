package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MockSteps {

	private ProjectManagerApp projectManagerApp;
	private ErrorMessageHolder errorMessageHolder;
	private AdminSession adminSession;

	public MockSteps(ProjectManagerApp projectManagerApp,
                     ErrorMessageHolder errorMessageHolder,
                     AdminSession adminSession) {
		this.projectManagerApp = projectManagerApp;
		this.errorMessageHolder = errorMessageHolder;
		this.adminSession = adminSession;
	}

	@When("mock data is generated")
	public void mockDataIsGenerated() throws Exception {
		try {
			projectManagerApp.addMockData(10);
		} catch(OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	@Then("some projects exist")
	public void someProjectsExist() {
		assertFalse(projectManagerApp.getProjects().isEmpty());
	}
	@Then("no projects exist")
	public void noProjectsExist() {
		assertTrue(projectManagerApp.getProjects().isEmpty());
	}
}
