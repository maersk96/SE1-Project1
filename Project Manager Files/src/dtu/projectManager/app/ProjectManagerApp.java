package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagerApp {

	private List<Project> projects = new ArrayList<>();

	Employee currentUser = null;

	public void login(Employee e) {
		currentUser = e;
	}
	public void logout() {
		currentUser = null;
	}
	public boolean adminLoggedIn() {
		return currentUser.getInitials().equals("ADMIN");
	}

	/**
	 * Adds a project to the manager.
	 * Only the administrator can do this. Thus, the administrator has to be logged in.
	 * @param project, the project to be added
	 * @throws OperationNotAllowedException if the administrator is not logged in
	 */
	public void addProject(Project project) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		projects.add(project);
	}

}
