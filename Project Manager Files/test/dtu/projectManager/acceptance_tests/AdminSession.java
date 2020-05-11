package dtu.projectManager.acceptance_tests;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.ProjectManagerApp;

// Starts an admin session, that makes it easier to test in the other step files

// Work distribution:
// Jonas s183635 for all methods

public class AdminSession {

	private ProjectManagerApp projectManagerApp;
	private Employee previousUser;

	public AdminSession(ProjectManagerApp projectManagerApp) {
		this.projectManagerApp = projectManagerApp;
	}

	public void start() throws OperationNotAllowedException {
		previousUser = projectManagerApp.getCurrentUser();
		projectManagerApp.login("ADMIN");
	}

	public void end() throws OperationNotAllowedException {
		projectManagerApp.logout();
		if (previousUser != null) {
			projectManagerApp.login(previousUser.getInitials());
		}
	}
}
