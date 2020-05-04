package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

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

	public void addMockData(int amount) throws OperationNotAllowedException {
		login("ADMIN");
		MockData mock = new MockData(this);
		mock.generate(amount);
		logout();
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

	public void deleteProject(String projectID) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		
		projects.removeIf(project -> projectID.equals(project.getID()));
		// delete all activities?
			
		
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
	
	public List<Project> getProjects() {
		// Hvorfor ikke bare "return projects" ?
		List<Project> allProjects = new ArrayList<Project>();
		for (Project p : this.projects) {
			allProjects.add(p);
		}
		return allProjects;
	}
	
	public List<Activity> getProjectActivities(String projectID) throws OperationNotAllowedException{
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		
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

	public void assignEmployeeProjectLeader(String projectID, String employeeInitials) throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		Project p = getProjectWithID(projectID);
		Employee e = getEmployeeWithInitials(employeeInitials);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		if (e == null) {
			throw new OperationNotAllowedException("Employee does not exist");
		}
		p.setProjectLeader(e);
	}
	
	
	public String addActivityToProject(String projectID, Activity activity) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if (p.isProjectLeader(currentUser) || adminLoggedIn()) {
			return p.addActivity(activity);
		} else {
			throw new OperationNotAllowedException("Project Leader login required");
		}
	}
	
	public void renameActivity(String projectID, String activityID, String newName) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}

		Activity a = p.getActivityWithID(activityID);		
		if (a == null) {
			throw new OperationNotAllowedException("The activity does not exist in this project");
		}

		if (p.isProjectLeader(currentUser) || adminLoggedIn()) {
			a.setName(newName);
		} else {
			throw new OperationNotAllowedException("Project Leader login required");
		}
	}
	
	public void deleteActivity(String projectID, String activityID)throws OperationNotAllowedException {

		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}

		Activity a = p.getActivityWithID(activityID);		
		if (a == null) {
			throw new OperationNotAllowedException("Employee is not assigned this activity");
		}
		
		// delete from all employee lists?
		
		
	}

	public void assignEmployeeToActivity(String projectID, String employeeInitials, String activityID) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if ((p.isProjectLeader(currentUser)) || adminLoggedIn() || p.getActivityWithID(activityID).containsEmployeeWithInitials(currentUser.getInitials())) {
			Employee e = getEmployeeWithInitials(employeeInitials);
			Activity a = p.getActivityWithID(activityID);
			if (!e.isAvailableForActivity(a)) {
				throw new OperationNotAllowedException("The employee is not available in this period");
			}
			e.addAssignedActivity(a);
			a.addAssignedEmployee(e);
		} else {
			throw new OperationNotAllowedException("Project leader og assigned employee login required");
		}
	}
	
	
	public void askForAssistance(String employeeInitials, String activityID) throws OperationNotAllowedException {
		Activity a = this.currentUser.getActivityWithID(activityID);		
		if (a == null) {
			throw new OperationNotAllowedException("You are not assigned this activity");
		}

		Employee e = getEmployeeWithInitials(employeeInitials);
		if (e == null) {
			throw new OperationNotAllowedException("Employee does not exist");
		}
		if (!e.isAvailableForActivity(a)) {
			throw new OperationNotAllowedException("The employee is not available in this period");
		}
		e.addAssignedActivity(a);
		a.addAssignedEmployee(e);
	}
	
	
	public List<Employee> getEmployeesAssignedToActivity(String projectID, String activityID) throws OperationNotAllowedException{
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}

		Activity a = p.getActivityWithID(activityID);		
		if (a == null) {
			throw new OperationNotAllowedException("Activity does not exist");
		}

		return a.getAssignedEmployees();
	}
	
	
//	public void budgetHoursInActivity(Project project, Activity activity, double bHours) throws OperationNotAllowedException {
//		if (project.hasProjectLeader() && project.isProjectLeader(currentUser) && project.getActivities().contains(activity)) {
//			activity.setBudgetHours(bHours);
//		} else {
//			throw new OperationNotAllowedException("Project Leader login required");
//		}
//	}

	public List<Employee> getAvailableEmployees(int week) {
		return (List<Employee>) employees.stream()
				.filter(employee -> employee.isAvailableInWeek(week))
				.collect(Collectors.toList());
	}

	
	// Current  user registers hours to activity
	public void registerHoursToActivity(String projectID, String activityID, double hours) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		Activity a = p.getActivityWithID(activityID);
		if (!a.containsEmployeeWithInitials(currentUser.getInitials())) {
			throw new OperationNotAllowedException("Employee is not assigned this activity");
		}
		a.registerHours(currentUser, hours);
	}

	public double totalRegisteredHoursToActivity(String projectID, String activityID) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		
		if (!p.isProjectLeader(currentUser)) {
			throw new OperationNotAllowedException("Project Leader login required");
		}
		
		
		Activity a = p.getActivityWithID(activityID);		
		if (a == null) {
			throw new OperationNotAllowedException("Activity does not exist");
		}
		
		double hours = a.getTotalRegisteredHours();
		return hours;
	}

	public void budgetHours(String activityID, String projectID, double hours) throws OperationNotAllowedException {
		
		Project p = getProjectWithID(projectID);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		
		if (currentUser == null || !p.isProjectLeader(currentUser)) {
			throw new OperationNotAllowedException("Project Leader login required");
		}
		
		
		Activity a = p.getActivityWithID(activityID);		
		if (a == null) {
			throw new OperationNotAllowedException("Activity does not exist");
		}

		a.setBudgetHours(hours);;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	
	public List<Activity> getEmployeeActivities(String initials){
		Employee employee = getEmployeeWithInitials(initials);
		return employee.getAssignedActivities();
	}

	public List<Project> getProjectsLeadByEmployee(String employeeInitials) throws OperationNotAllowedException {
		
		Employee e = getEmployeeWithInitials(employeeInitials);
		if (e == null) {
			throw new OperationNotAllowedException("Employee does not exist");
		}

		if (!currentUser.hasInitials(employeeInitials) && !adminLoggedIn()) {
			throw new OperationNotAllowedException("You can only see projects that you are leading");
		}

		return getProjects().stream()
		.filter(e::isProjectLeader)
		.collect(Collectors.toList());
	}


	public Activity getActivity(String projectId, String activityId) throws OperationNotAllowedException {
		Project p = getProjectWithID(projectId);
		if (p == null) {
			throw new OperationNotAllowedException("Project does not exist");
		}
		Activity a = p.getActivityWithID(activityId);
		if (a == null) {
			throw new OperationNotAllowedException("Activity does not exist");
		}
		return a;
	}
}
