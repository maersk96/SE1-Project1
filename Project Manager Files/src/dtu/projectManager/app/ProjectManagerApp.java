package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProjectManagerApp {

	private List<Project> projects = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	private Integer year;
	private Integer projectNumber = 1;
	private Employee currentUser = null;

	public ProjectManagerApp () {
		Employee admin = new Employee("ADMIN");
		employees.add(admin);
		year = Calendar.getInstance().get(Calendar.YEAR);
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
		String projectID = year + "-" + projectNumber;
		Project p = new Project(projectID);
		projects.add(p);
		projectNumber ++;
		return p.getID();
	}

	public Employee getEmployeeWithInitials(String initials) {
		return employees.stream()
				.filter(employee -> initials.equals(employee.getInitials()))
				.findFirst()
				.orElse(null);
	}

	public boolean containsEmployeeWithInitials(String initials) {
		return getEmployeeWithInitials(initials) != null;
	}

	public Employee getCurrentUser() {
		return currentUser;
	}

	public int amountOfProjects() {
		return projects.size();
	}
	
	public Project getProjectWithID(String projectID) {
		return projects.stream()
				.filter(project -> projectID.equals(project.getID()))
				.findFirst()
				.orElse(null);
	}

	public boolean containsProjectWithID(String projectID) {
		return getProjectWithID(projectID) != null;
	}

	public void assignEmployeeProjectLeader(String eInit, String projectID) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		Project p = getProjectWithID(projectID);
		Employee e = getEmployeeWithInitials(eInit);
		if (p == null) {
			throw new OperationNotAllowedException("Project" + projectID + "does not exist");
		}
		if (e == null) {
			throw new OperationNotAllowedException("Employee" + eInit + "does not exist");
		}
		p.setProjectLeader(e);
	}
	
	public void addActivityToProject(String projectID, String activityID) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if (!p.hasProjectLeader() || !p.isProjectLeader(currentUser)) {
			throw new OperationNotAllowedException("Project Leader login required");
		}
		String activityName = "Unnamed";
		Activity a = new Activity(activityID, activityName);
		p.addActivity(a);
	}
	
	public boolean projectContainsActivityWithID(String projectID, String activityID) {
		Project p = getProjectWithID(projectID);
		return p.containsActivityWithID(activityID);
	}

	public void assignEmployeeToActivity(String projectID, String employeeInitials, String activityID) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if (!p.hasProjectLeader() || !p.isProjectLeader(currentUser)) {
			throw new OperationNotAllowedException("Project Leader login required");
		}
		Employee e = getEmployeeWithInitials(employeeInitials);
		Activity a = p.getActivityWithID(activityID);
		e.addAssignedActivity(a);
		a.addAssignedEmployee(e);
	}

	public boolean projectContainsActivityWithAssignedEmployee(String projectID, String activityID, String employeeInitials) {
		Project p = getProjectWithID(projectID);
		Activity a = p.getActivityWithID(activityID);
		return a.containsEmployeeWithInitials(employeeInitials);
	}

	// funktioner som denne burde tage imod Employee og Activity som inputs og ikke ID's i thinkk :)
	public boolean employeeContainsAssignedActivity(String employeeInitials, String activityID) {
		Employee e = getEmployeeWithInitials(employeeInitials);
		e.containsActivityWithID(activityID);
		return e.containsActivityWithID(activityID);
	}
}
