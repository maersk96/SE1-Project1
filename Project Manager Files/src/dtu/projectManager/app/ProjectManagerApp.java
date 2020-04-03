package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagerApp {

	private List<Project> projects = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();

	public ProjectManagerApp () {
		Employee admin = new Employee("ADMIN");
		employees.add(admin);
	}

	Employee currentUser = null;

	public void login(String initials) throws OperationNotAllowedException {
		Employee newUser = getEmployeeWithInitials(initials);
		if (newUser == null) {
			throw new OperationNotAllowedException("Employee does not exist");
		}
		currentUser = newUser;
	}
	public void logout() {
		currentUser = null;
	}
	public boolean adminLoggedIn() {
		return currentUser.getInitials().equals("ADMIN");
	}

	public void addEmployee(Employee e) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		employees.add(e);
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

	public boolean containsEmployeeWithInitials(String initials) {
		// Brug getEmploy.... funktion
		return employees.stream().anyMatch(m -> m.getInitials().contentEquals(initials));
	}

	public Employee getEmployeeWithInitials(String initials) {
		return employees.stream()
				.filter(employee -> initials.equals(employee.getInitials()))
				.findFirst()
				.orElse(null);
	}
}
