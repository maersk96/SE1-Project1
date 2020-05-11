package dtu.projectManager.presentation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import dtu.projectManager.app.Activity;
import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.Project;
import dtu.projectManager.app.ProjectManagerApp;
import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;

public class Interpreter {

	private ProjectManagerApp application;
	private List<String> feedback = new ArrayList<String>();
	private boolean hadError = false;
	private boolean printFeedback = true;
	private DecimalFormat df;

	
	public Interpreter(ProjectManagerApp p) {
		this.application = p;	
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		this.df = new DecimalFormat("#.#", otherSymbols);
	    this.df.setMinimumFractionDigits(0);
	    this.df.setMaximumFractionDigits(1);

	}


	public Object[] callMethod(Object[] methodArguments) {
		this.feedback.clear();
		this.hadError = false;
		this.printFeedback = true;
		String methodName = methodArguments[0].toString();

		try {
			switch (methodName) {
			case "login": return login(methodArguments);
			
			case "list all projects": return listAllProjects(methodArguments);
				
			case "create employee": return createEmployee(methodArguments);
				
			case "create project": return createProject(methodArguments);
			
			case "assign project leader": return assignProjectLeader(methodArguments);
								
			case "set project name": return setProjectName(methodArguments);
			
			case "list all employees": return listAllEmployees(methodArguments);
			
			case "list all employee activities": return listAllEmployeeActivities(methodArguments);
				
			case "find projects where employee is leader": return listLeaderProjects(methodArguments);
					
			case "list available employees": return listAvailableEmployees(methodArguments);
				
			case "ask for assistance": return askForAssistance(methodArguments);
				
			case "see registered hours": return seeRegisteredHours(methodArguments);	
				
			case "register hours": return registerHours(methodArguments);
				
			case "list all project activities": return listProjectActivities(methodArguments);
				
			case "see project progress": return seeProjectProgress(methodArguments);				
				
			case "create activity": return createActivity(methodArguments);

			case "list employees on activity": return listActivityEmployees(methodArguments);
	
			case "set activity name": return setActivityName(methodArguments);
				
			case "budget hours": return budgetHours(methodArguments);				
				
			case "assign employee to activity": return assignEmployeeToActivity(methodArguments);
				
			default: 
				throw new OperationNotAllowedException("Not implemented yet");
			}
		} catch (OperationNotAllowedException e) {
			this.feedback.add(e.getMessage());
			this.feedback.add("Press enter to go back");
			this.hadError = true;
		}
		return null;
	}
	
	public List<String> getFeedback() {
		List<String> F = new ArrayList<String>();
		
		for (String line : this.feedback) {
			F.add(line);
		}
		return F;
	}
	
	public boolean printFeedback() {
		return this.printFeedback;
	}
	
	public boolean hadError() {
		return this.hadError;
	}


	public void resetErrorState() {
		this.hadError = false;
	}
	
	
	private Object[] login(Object[] methodArguments) throws OperationNotAllowedException {
	    EmployeeInfo user = (EmployeeInfo)methodArguments[1];
	    application.login(user.getInitials());
	    Object[] result = new Object[2];
	    result[0] = this.application.adminLoggedIn();
	    user.setName(this.application.getEmployeeWithInitials(user.getInitials()).getName());
	    result[1] = user;
	    this.printFeedback = false;
	    return result;
	}
	
	private Object[] listAllProjects(Object[] methodArguments) throws OperationNotAllowedException {
		List<Project> projectList = this.application.getProjects();
		Object[] result = new Object[projectList.size()];
		for (int i=0; i< result.length; i++) {
			result[i] = new ProjectInfo(projectList.get(i));
		}
		if (result.length == 0) {
			this.printFeedback = true;
			this.feedback.add("There are no existing projects to manage.");
			this.feedback.add("Click enter to continue.");
		}
		else
			this.printFeedback = false;
		return result;
	}
	
	private Object[] createEmployee(Object[] methodArguments) throws OperationNotAllowedException {
	    EmployeeInfo employee = (EmployeeInfo)methodArguments[1];
	    String employeeName = methodArguments[2].toString();
	    if (employeeName.equals("")) {
	    	employee.setName("Anonymous");			    	
	    }
	    else {
	    	employee.setName(employeeName);			    	
	    }
	    Object[] result = new Object[0];
	    this.application.addEmployee(employee.asEmployee());
	    this.feedback.add("The employee "+employee.getName()+" ("+employee.getInitials()+") has been created");
	    this.feedback.add("");
	    this.feedback.add("Press enter to continue");
	    return result;
	}
	
	private Object[] createProject(Object methodArguments) throws OperationNotAllowedException {
	    Object[] result = new Object[1];
	    Project newProject = new Project("");
	    ProjectInfo newProjectInfo = new ProjectInfo("");
	    newProjectInfo.setID(this.application.addProject(newProject));
	    result[0] = newProjectInfo;
	    this.printFeedback = false;
	    return result;
	}
	
	private Object[] assignProjectLeader(Object[] methodArguments) throws OperationNotAllowedException {
		ProjectInfo project = (ProjectInfo)methodArguments[1];
		EmployeeInfo leader = (EmployeeInfo)methodArguments[2];
		Object[] result = new Object[0];
		this.application.assignProjectLeader(project.getID(),leader.getInitials());
		this.feedback.add("The employee with initials "+leader.getInitials()+" has been assigned");
		this.feedback.add("as project leader for the project "+project.getID()+": "+project.getName());
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		return result;
	}
	
	private Object[] setProjectName(Object[] methodArguments) throws OperationNotAllowedException {
		Object[] result = new Object[0];
		ProjectInfo project = (ProjectInfo)methodArguments[1];
		String projectName = methodArguments[2].toString();
		this.application.renameProject(project.getID(),projectName);
		this.feedback.add("Project "+project.getID()+" has been assigned the name");
		this.feedback.add(projectName+".");
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		return result;
	}
	
	private Object[] listAllEmployees(Object[] methodArguments) throws OperationNotAllowedException {
		List <Employee> employeeList = application.getEmployees();
		this.feedback.add("These are all the employees registered in the app:");
		this.feedback.add("");
		for (Employee e : employeeList) {
			EmployeeInfo employee = new EmployeeInfo(e);
			this.feedback.add(employee.getName()+" ("+employee.getInitials()+")");
		}
		this.feedback.add("");
		this.feedback.add("Press enter to go back");
		this.printFeedback = true;
		Object[] result = new Object[0];
		return result;
	}
	
	private Object[] listAllEmployeeActivities(Object[] methodArguments) throws OperationNotAllowedException {
		EmployeeInfo employee = (EmployeeInfo)methodArguments[1];
		List<Activity> activityList = this.application.getEmployeeActivities(employee.getInitials());
		Object[] result = new Object[activityList.size()];
		for (int i=0; i<result.length; i++) {
			result[i] = new ActivityInfo(activityList.get(i));
		}
		if (result.length == 0) {
			this.printFeedback = true;
			this.feedback.add("The employee is currently not assigned to any activities.");
			this.feedback.add("Click enter to go back.");
		}
		else
			this.printFeedback = false;
		return result;
	}
	
	private Object[] listLeaderProjects(Object[] methodArguments) throws OperationNotAllowedException {
		EmployeeInfo employee = (EmployeeInfo) methodArguments[1];
		List<Project> projectList = this.application.getProjectsLeadByEmployee(employee.getInitials());
		Object[] result = new Object[projectList.size()];
		for (int i=0; i< result.length; i++) {
			result[i] = new ProjectInfo(projectList.get(i));
		}
		if (result.length == 0) {
			this.printFeedback = true;
			this.feedback.add("You are currently not leading any projects.");
			this.feedback.add("Click enter to continue.");
		}
		else
			this.printFeedback = false;
		return result;
	}
	
	private Object[] listAvailableEmployees(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo)methodArguments[1];
		List<Employee> employeeList = this.application.getEmployees();
		employeeList = employeeList.stream()
				.filter(e -> e.isAvailableForActivity(activity.asActivity()))
				.collect(Collectors.toList());
		Object[] result = new Object[employeeList.size()];
		for (int i=0; i<result.length; i++) {
			result[i] = new EmployeeInfo(employeeList.get(i));
		}
		this.printFeedback = false;
		return result;
	}
	
	private Object[] askForAssistance(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		EmployeeInfo employee = (EmployeeInfo) methodArguments[2];
		this.application.askForAssistance( activity.getID(), employee.getInitials());
		employee = new EmployeeInfo(this.application.getEmployee(employee.getInitials()));
		this.feedback.add(employee.getName()+" ("+employee.getInitials()+") can now help with activity");
		this.feedback.add(activity.getID()+": "+activity.getName());
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		Object[] result = new Object[0];
		return result;
	}
	
	private Object[] seeRegisteredHours(Object[] methodArguments) throws OperationNotAllowedException {
		EmployeeInfo employee = (EmployeeInfo) methodArguments[1];
		ActivityInfo activity = (ActivityInfo) methodArguments[2];
		double hours = this.application.getEmployeesRegisteredHoursToActivity(activity.getID(), employee.getInitials());
		this.printFeedback = false;
		System.out.println(hours);
		Object[] result = new Object[1];
		result[0] = hours;
		return result;
	}
	
	private Object[] registerHours(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		EmployeeInfo employee = (EmployeeInfo) methodArguments[2];
		double hours = (double) methodArguments[3];
		this.application.registerHoursToActivity(activity.getID(), employee.getInitials(), hours);
		
		this.feedback.add("You have registered "+this.df.format(hours)+" hours to activity");
		this.feedback.add(activity.getID()+": "+activity.getName());
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		Object[] result = new Object[0];
		return result;
	}
	
	private Object[] listProjectActivities(Object[] methodArguments) throws OperationNotAllowedException {
		ProjectInfo project = (ProjectInfo) methodArguments[1];
		List<Activity> activityList = this.application.getProjectActivities(project.getID());
		Object[] result = new Object[activityList.size()];
		for (int i=0; i< result.length; i++) {
			result[i] = new ActivityInfo(activityList.get(i));
		}
		if (result.length == 0) {
			this.printFeedback = true;
			this.feedback.add("There are no activities for this project.");
			this.feedback.add("Click enter to go back.");
		}
		else
			this.printFeedback = false;
		return result;
	}
	
	private Object[] seeProjectProgress(Object[] methodArguments) throws OperationNotAllowedException {
		ProjectInfo project = (ProjectInfo) methodArguments[1];
		ActivityInfo activity;
		List<Activity> activityList = this.application.getProjectActivities(project.getID());
		Object[] result = new Object[activityList.size()];
		for (int i=0; i< result.length; i++) {
			activity = new ActivityInfo(activityList.get(i));
			activity.setTotalHours(application.getTotalRegisteredHoursToActivity(project.getID(),activity.getID()));
			result[i] = activity;
		}
		this.printFeedback = false;
		return result;
	}
	
	private Object[] createActivity(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		ProjectInfo project = (ProjectInfo) methodArguments[2];
		activity.setID(application.addActivityToProject(project.getID(), activity.asActivity()));
		
		this.feedback.add("You have added the new activity");
		this.feedback.add(activity.getID()+": "+activity.getName());
		this.feedback.add("to the project "+project.getID()+": "+project.getName());
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		Object[] result = new Object[0];
		return result;
	}
	
	private Object[] listActivityEmployees(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		ProjectInfo project = (ProjectInfo) methodArguments[2];
		List<Employee> employeeList = this.application.getEmployeesAssignedToActivity(project.getID(), activity.getID());
		Object[] result = new Object[employeeList.size()];
		for (int i=0; i<result.length; i++) {
			result[i] = new EmployeeInfo(employeeList.get(i));
		}
		this.printFeedback = false;
		return result;
	}
	private Object[] setActivityName(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		ProjectInfo project = (ProjectInfo) methodArguments[2];
		String activityName = methodArguments[3].toString();
		this.application.renameActivity(project.getID(),activity.getID(),activityName);
		this.feedback.add("The activity has been renamed to \""+activityName+"\".");
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		Object[] result = new Object[0];
		return result;
	}
	
	private Object[] budgetHours(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		ProjectInfo project = (ProjectInfo) methodArguments[2];
		double hours = (double) methodArguments[3];
		this.application.budgetHoursToActivity(project.getID(), activity.getID(), hours);	
		this.feedback.add("You have changed to budgeted hours for activity");
		this.feedback.add(activity.getID()+": "+activity.getName());
		this.feedback.add("to "+hours+".");
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		Object[] result = new Object[0];
		return result;
	}
	
	private Object[] assignEmployeeToActivity(Object[] methodArguments) throws OperationNotAllowedException {
		ActivityInfo activity = (ActivityInfo) methodArguments[1];
		ProjectInfo project = (ProjectInfo) methodArguments[2];
		EmployeeInfo employee = (EmployeeInfo) methodArguments[3];
		this.application.assignEmployeeToActivity(project.getID(), activity.getID(), employee.getInitials());
		employee = new EmployeeInfo(this.application.getEmployee(employee.getInitials()));
		this.feedback.add("You have assigned "+employee.getName()+" ("+employee.getInitials()+") to activity");
		this.feedback.add(activity.getID()+": "+activity.getName());
		this.feedback.add("");
		this.feedback.add("Press enter to continue");
		Object[] result = new Object[0];
		return result;
	}
	
}