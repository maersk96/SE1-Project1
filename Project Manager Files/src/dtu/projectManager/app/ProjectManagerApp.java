package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;

public class ProjectManagerApp {

	private List<Project> projects = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	private Integer year = 2020;
	private Integer projectNumber = 1;
	private Employee currentUser = null;

	public void increaseProjectNumber() {
		projectNumber ++;
	}

	public ProjectManagerApp () {
		Employee admin = new Employee("ADMIN");
		employees.add(admin);
	}

	public void login(String initials) throws OperationNotAllowedException {
		Employee newUser = getEmployeeWithInitials(initials);
		if (newUser == null) {
			throw new OperationNotAllowedException("Employee with initials " + initials + " does not exist");
		}
		currentUser = newUser;
	}

	public void logout() {
		currentUser = null;
	}

	public boolean adminLoggedIn() {
		if (currentUser != null) {
			return currentUser.getInitials().equals("ADMIN");
		}
		return false;
	}

	public void addEmployee(Employee e) throws OperationNotAllowedException {

		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		if (containsEmployeeWithInitials(e.getInitials())) {
			throw new OperationNotAllowedException("Employee already exists");			
		}

		employees.add(e);
	}

	// Adds a project to the project manager, only the admin can do this
	public String addProject() throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		String projectID = String.valueOf(year) + "-" + String.valueOf(projectNumber);
		String projectName = "Unnamed";
		Project p = new Project(projectID, projectName);
		projects.add(p);
		increaseProjectNumber();
		return p.getID();
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

	public Employee getCurrentUser() {
		return currentUser;
	}

	public int amountOfProjects() {
		return projects.size();
	}

	public boolean containsProjectWithID(String projectID) {
		return projects.stream().anyMatch(m -> m.getID().contentEquals(projectID));
	}
	
	public Project getProjectWithID(String projectID) {
		return projects.stream()
				.filter(project -> projectID.equals(project.getID()))
				.findFirst()
				.orElse(null);
	}

	
	public void assignEmployeeProjectLeader(String eInit, String projectID) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		Project p=getProjectWithID(projectID);
		Employee e=getEmployeeWithInitials(eInit);
		if (p!=null && e!=null) {
			p.setProjectleader(e);;
		}else {
			throw new OperationNotAllowedException("Project or employee does not exist");
		}
	}
	
	public void addActivityToProject(String projectID, String activityID) throws OperationNotAllowedException {
		Project p=getProjectWithID(projectID);
		if (p.getProjectleader()==null) {
			throw new OperationNotAllowedException("Project Leader login required");
		}
		if (!p.getProjectleader().equals(currentUser)) {
			throw new OperationNotAllowedException("Project Leader login required");
		}
		String activityName = "Unnamed";
		Activity a = new Activity(activityID, activityName);
		p.getActivities().add(a);
	}
	
	public boolean projectContainsActivityWithID(String projectID, String activityID) {
		Project p=getProjectWithID(projectID);
		return p.getActivities().stream().anyMatch(m -> m.getID().contentEquals(activityID));
	}
}
