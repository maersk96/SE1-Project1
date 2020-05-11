package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.*;
import io.cucumber.java.en.When;

// Steps for handling testing of mock data

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
}
