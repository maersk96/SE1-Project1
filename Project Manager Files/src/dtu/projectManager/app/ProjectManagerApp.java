package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Main application class

// Work distribution:
// Mainly Jonas, Mikkel and Lukas have contributed to this class and its methods. It would be incorrect to put individual names on any method, as they have all been developed, or reviewed and edited by everyone, also Anton

public class ProjectManagerApp {

	private List<Project> projects = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	private Integer year;
	private Integer projectNumber = 1;
	private Employee currentUser = null;

	public ProjectManagerApp () {
		Employee admin = new Employee("ADMIN", "Administrator");
		employees.add(admin);
		year = Calendar.getInstance().get(Calendar.YEAR);
	}

	// Adds sample data using MockData class
	public void addMockData(int amount) throws OperationNotAllowedException {
		requiresAdmin();
		MockData mock = new MockData(this);
		mock.generate(amount);
	}

	//
	// AUTHENTICATION METHODS
    //

	public void login(String initials) throws OperationNotAllowedException {
		currentUser = getEmployee(initials);
	}

	public void logout() {
		currentUser = null;
	}

	public boolean adminLoggedIn() {
		return currentUser != null && currentUser.getInitials().equals("ADMIN");
	}

	public Employee getCurrentUser() {
		return currentUser;
	}

	// Require-functions run in methods that require specific access
	public void requiresAdmin() throws OperationNotAllowedException{
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
	}

	public void requiresProjectLeader(String projectID) throws OperationNotAllowedException {

		// Pre-conditions:
		assert true;

		Project p = getProjectWithID(projectID);
		if (p == null /* 1 */ || !(adminLoggedIn() /* 2 */ || p.isProjectLeader(currentUser) /* 3 */) ) {
			throw new OperationNotAllowedException("Project Leader login required");
		}

		// Post-conditions:
		assert adminLoggedIn() == true || getProject(projectID).isProjectLeader(currentUser) == true;
	}

    //
	// EMPLOYEE METHODS
    //

	public void addEmployee(Employee e) throws OperationNotAllowedException {
		requiresAdmin();
		if (containsEmployeeWithInitials(e.getInitials())) {
			throw new OperationNotAllowedException("Employee already exists");			
		}
		employees.add(e);
	}

	public Employee getEmployeeWithInitials(String initials) {
		return getEmployees().stream()
				.filter(employee -> initials.equals(employee.getInitials()))
				.findFirst()
				.orElse(null);
	}

	public boolean containsEmployeeWithInitials(String initials) {
		return getEmployeeWithInitials(initials) != null;
	}

	public void assignProjectLeader(String projectID, String employeeInitials) throws OperationNotAllowedException {
		requiresAdmin();

		Project p = getProject(projectID);
		Employee e = getEmployee(employeeInitials);
		p.setProjectLeader(e);
	}

    //
	// PROJECT METHODS
    //

	private String generateProjectID() {
		return year + "-" + String.format("%0" + 4 + "d", projectNumber);
	}

	public String addProject(Project project) throws OperationNotAllowedException {
		requiresAdmin();

		String projectID = generateProjectID();
		project.setID(projectID);
		projects.add(project);
		projectNumber++;
		return projectID;
	}

	public void renameProject(String projectID, String newName) throws OperationNotAllowedException {
		requiresAdmin();
		
		Project p = getProject(projectID);
		p.setName(newName);
	}

	public List<Project> getProjects() {
		return new ArrayList<Project>(this.projects);
	}

	public List<Activity> getProjectActivities(String projectID) throws OperationNotAllowedException{
		Project p = getProject(projectID);
		return p.getActivities();
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
	
	public String addActivityToProject(String projectID, Activity activity) throws OperationNotAllowedException {
		requiresProjectLeader(projectID);

		Project p = getProject(projectID);
		return p.addActivity(activity);
	}
	
	public void renameActivity(String projectID, String activityID, String newName) throws OperationNotAllowedException {
		requiresProjectLeader(projectID);

		Activity a = getActivityFromProject(projectID, activityID);
		a.setName(newName);
	}
	
	private void addEmployeeToActivity(Employee e, Activity a) throws OperationNotAllowedException {
		if (!e.isAvailableForActivity(a)) {
			throw new OperationNotAllowedException("The employee is not available in this period");
		}
		if (a.containsEmployeeWithInitials(e.getInitials()) || e.containsActivityWithID(a.getID())) {
			throw new OperationNotAllowedException("Employee is already assigned this activity");
		}
		e.addAssignedActivity(a);
		a.addAssignedEmployee(e);
	}
	
	public void assignEmployeeToActivity(String projectID, String activityID, String employeeInitials) throws OperationNotAllowedException {

		// Pre-conditions:
		assert true;

		requiresProjectLeader(projectID);										// 1
		Activity a = getActivityFromProject(projectID, activityID);				// 2
		Employee e = getEmployee(employeeInitials);								// 3
		addEmployeeToActivity(e,a);												// 4

		// Post-conditions:
		assert a.containsEmployeeWithInitials(employeeInitials) == true && a.getEmployeesRegisteredHours(getEmployee(employeeInitials)) == 0;
		assert e.containsActivityWithID(activityID) == true && Collections.frequency(e.getAssignedActivities(), getActivityFromEmployee(employeeInitials, activityID)) == 1;
	}
	
	public void askForAssistance(String activityID,String employeeInitials) throws OperationNotAllowedException {
		Employee e = getEmployee(employeeInitials);
		Activity a = getActivityFromEmployee(currentUser.getInitials(),activityID);
		addEmployeeToActivity(e,a);
	}
	
	public List<Employee> getEmployeesAssignedToActivity(String projectID, String activityID) throws OperationNotAllowedException{
		Activity a = getActivityFromProject(projectID, activityID);
		return a.getAssignedEmployees();
	}

	public List<Employee> getAvailableEmployees(int week) {
		return (List<Employee>) employees.stream()
				.filter(e -> e.isAvailableInWeek(week))
				.collect(Collectors.toList());
	}

	// a user registers hours to activity
	public void registerHoursToActivity(String activityID, String employeeInitials,  double hours) throws OperationNotAllowedException {
		Employee e = getEmployee(employeeInitials);
		Activity a = getActivityFromEmployee(employeeInitials, activityID);
		a.registerHours(e, hours);
	}

	public double getEmployeesRegisteredHoursToActivity(String activityID, String employeeInitials) throws OperationNotAllowedException {
		Employee e = getEmployee(employeeInitials);
		Activity a = getActivityFromEmployee(employeeInitials, activityID);
		return a.getEmployeesRegisteredHours(e);
	}

	public double getTotalRegisteredHoursToActivity(String projectID, String activityID) throws OperationNotAllowedException {
		requiresProjectLeader(projectID);

		Activity a = getActivityFromProject(projectID, activityID);
		return a.getTotalRegisteredHours();
	}

	public void budgetHoursToActivity(String projectID, String activityID, double hours) throws OperationNotAllowedException {
		requiresProjectLeader(projectID);

		Activity a = getActivityFromProject(projectID, activityID);
		a.setBudgetHours(hours);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public List<Activity> getEmployeeActivities(String initials) throws OperationNotAllowedException {
		Employee employee = getEmployee(initials);
		return employee.getAssignedActivities();
	}

	public List<Project> getProjectsLeadByEmployee(String initials) throws OperationNotAllowedException {

		// Pre-conditions:
		assert true;

		Employee e = getEmployee(initials);					// 1
		if (!(currentUser.hasInitials(initials) /* 2 */ || adminLoggedIn() /* 3 */ )) {
			throw new OperationNotAllowedException("You can only see projects that you are leading");
		}

		// Post-conditions:
		for (Project p : getProjects().stream().filter(e::isProjectLeader).collect(Collectors.toList())) {
			assert p.isProjectLeader(e);
		}

		return getProjects().stream()
		.filter(e::isProjectLeader)
		.collect(Collectors.toList());
	}

	// Getter functions with built in errors
	public Employee getEmployee(String initials) throws OperationNotAllowedException {
		Employee e = getEmployeeWithInitials(initials);
		if (e == null) {
			throw new OperationNotAllowedException("Employee does not exist");
		}
		return e;
	}
	
	public Project getProject(String projectID) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		return p;
	}
	public Activity getActivityFromProject(String projectID, String activityID) throws OperationNotAllowedException {
		Project p = getProject(projectID);
		Activity a = p.getActivityWithID(activityID);
		if (a == null) {
			throw new OperationNotAllowedException("Activity does not exist");
		}
		return a;
	}

	public Activity getActivityFromEmployee(String employeeInitials, String activityID) throws OperationNotAllowedException {
		Employee e = getEmployee(employeeInitials);
		Activity a = e.getActivityWithID(activityID);
		if (a == null) {
			throw new OperationNotAllowedException("The employee is not assigned to this activity");
		}
		return a;
	}
}
