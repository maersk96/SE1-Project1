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
	public String addProject(Project project) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		String projectID = generateProjectId();
		project.setID(projectID);
		projects.add(project);
		projectNumber++;
		return projectID;
	}
	
	public void renameProject(String projectID, String newProjectName) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		
		p.setName(newProjectName);
	}

	
	

	public String generateProjectId() {
		return year + "-" + String.format("%0" + 4 + "d", projectNumber);
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
			throw new OperationNotAllowedException("Project " + projectID + " does not exist");
		}
		if (e == null) {
			throw new OperationNotAllowedException("Employee " + eInit + " does not exist");
		}
		p.setProjectLeader(e);
	}
	
	public String addActivityToProject(String projectID, Activity activity) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if ((p.hasProjectLeader() && p.isProjectLeader(currentUser)) || adminLoggedIn()) {
			return p.addActivity(activity);
		} else {
			throw new OperationNotAllowedException("Project Leader login required");
		}
	}

	public void assignEmployeeToActivity(String projectID, String employeeInitials, String activityID) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if ((p.hasProjectLeader() && p.isProjectLeader(currentUser)) || adminLoggedIn()) {
			Employee e = getEmployeeWithInitials(employeeInitials);
			Activity a = p.getActivityWithID(activityID);
			if (!e.isAvailableForActivity(a)) {
				throw new OperationNotAllowedException("The employee is not available in this period");
			}
			e.addAssignedActivity(a);
			a.addAssignedEmployee(e);
		} else {
			throw new OperationNotAllowedException("Project Leader login required");
		}
	}
	
	public void budgetHoursInActivity(Project project, Activity activity, double bHours) throws OperationNotAllowedException {
		if (project.hasProjectLeader() && project.isProjectLeader(currentUser) && project.getActivities().contains(activity)) {
			activity.setBudgetHours(bHours);
		} else {
			throw new OperationNotAllowedException("Project Leader login required");
		}
	}

	public List<Employee> getAvailableEmployees(int week) {
		return (List<Employee>) employees.stream()
				.filter(employee -> employee.isAvailableInWeek(week))
				.findAny()
				.orElse(null);
	}

	
}
