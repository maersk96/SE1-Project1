package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> feedback;
	private boolean hadError;
	private boolean printFeedback;
	private int week=0;
	
	public Interpreter(ProjectManagerApp p) {
		this.application = p;
		this.hadError = false;
		this.feedback = new ArrayList<String>();
		this.printFeedback = true;
		
	}


	public Object[] callMethod(Object[] methodArguments) {
		this.feedback.clear();
		this.hadError = false;
		this.printFeedback = true;
		Object[] result;
		String methodName = methodArguments[0].toString();
		List<Project> projectList;
		List<Employee> employeeList;
		List<Activity> activityList;
		EmployeeInfo user,employee, leader;
		ProjectInfo project;
		ActivityInfo activity;
		String projectName, activityName;
		double hours;
		
		try {
			switch (methodName) {
			case "login":
			    user = (EmployeeInfo)methodArguments[1];
			    application.login(user.getInitials());
			    result = new Object[2];
			    result[0] = this.application.adminLoggedIn();
			    user.setName(this.application.getEmployeeWithInitials(user.getInitials()).getName());
			    result[1] = user;
			    this.printFeedback = false;
			    return result;
				
			case "list all projects":
				projectList = this.application.getProjects();
				result = new Object[projectList.size()];
				for (int i=0; i< result.length; i++) {
					result[i] = projectList.get(i).asProjectInfo();
				}
				if (result.length == 0) {
					this.printFeedback = true;
					this.feedback.add("There are no existing projects to manage.");
					this.feedback.add("Click enter to continue.");
				}
				else
					this.printFeedback = false;
				return result;
				
			case "create employee":
			    employee = (EmployeeInfo)methodArguments[1];
			    result = new Object[0];
			    this.application.addEmployee(employee.asEmployee());
			    this.feedback.add("An employee with initials "+employee.getInitials()+" has been created");
			    this.feedback.add("");
			    this.feedback.add("Press enter to continue");
			    return result;
				
			case "create project":
			    result = new Object[1];
			    Project newProject = new Project("");
			    ProjectInfo newProjectInfo = new ProjectInfo("");
			    newProjectInfo.setID(this.application.addProject(newProject));
			    result[0] = newProjectInfo;
			    this.printFeedback = false;
			    return result;
			
			case "assign project leader":
				project = (ProjectInfo)methodArguments[1];
				leader = (EmployeeInfo)methodArguments[2];
				result = new Object[0];
				this.application.assignEmployeeProjectLeader(leader.getInitials(), project.getID());
				this.feedback.add("The employee with initials "+leader.getInitials()+" has been assigned");
				this.feedback.add("as project leader for the project "+project.getID()+": "+project.getName());
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				return result;
								
			case "set project name":
				result = new Object[0];
				project = (ProjectInfo)methodArguments[1];
				projectName = methodArguments[2].toString();
				this.application.renameProject(project.getID(),projectName);
				this.feedback.add("Project "+project.getID()+" has been assigned the name");
				this.feedback.add(projectName+".");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				return result;
				
			case "delete project":
				result = new Object[0];
				project = (ProjectInfo)methodArguments[1];
				this.application.deleteProject(project.getID());
				this.feedback.add("Project "+project.getID()+": "+project.getName()+" has been deleted");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				return result;
				
			
			case "list all employees":
				employeeList = application.getEmployees();
				this.feedback.add("These are all the employees registered in the app:");
				this.feedback.add("");
				for (Employee e : employeeList) {
					employee = e.asEmployeeInfo();
					this.feedback.add(employee.getName()+" ("+employee.getInitials()+")");
				}
				this.feedback.add("");
				this.feedback.add("Press enter to go back");
				this.printFeedback = true;
				result = new Object[0];
				return result;

				
				
			case "list all employee activities":
				employee = (EmployeeInfo)methodArguments[1];
				activityList = this.application.getEmployeeActivities(employee.getInitials());
				result = new Object[activityList.size()];
				for (int i=0; i<result.length; i++) {
					result[i] = activityList.get(i).asActivityInfo();
				}
				this.printFeedback = false;
				return result;
				
			case "find projects where employee is leader":
				employee = (EmployeeInfo) methodArguments[1];
				projectList = this.application.getProjectsLeadByEmployee(employee.getInitials());
				result = new Object[projectList.size()];
				for (int i=0; i< result.length; i++) {
					result[i] = projectList.get(i).asProjectInfo();
				}
				if (result.length == 0) {
					this.printFeedback = true;
					this.feedback.add("You are currently not leading any projects.");
					this.feedback.add("Click enter to continue.");
				}
				else
					this.printFeedback = false;
				return result;

				
			
			case "list available employees":
				employeeList = this.application.getAvailableEmployees(week);
				result = new Object[employeeList.size()];
				for (int i=0; i<result.length; i++) {
					result[0] = employeeList.get(i).asEmployeeInfo();
				}
				this.printFeedback = false;
				return result;
				
				
			case "ask for assistance":
				user = (EmployeeInfo) methodArguments[1];
				activity = (ActivityInfo) methodArguments[2];
				employee = (EmployeeInfo) methodArguments[3];
				this.application.askForAssistance(employee.getInitials(), activity.getID());
				this.feedback.add("Employee "+employee.getName()+"("+employee.getName()+") can now help with activity");
				this.feedback.add(activity.getID()+": "+activity.getName());
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				result = new Object[0];
				return result;

				
				
			case "register hours":
				activity = (ActivityInfo) methodArguments[1];
				employee = (EmployeeInfo) methodArguments[2];
				hours = (double) methodArguments[3];
				this.application.registerHours(activity.getID(), employee.getInitials(), hours);
				
				this.feedback.add("You have registered "+hours+" hours to activity");
				this.feedback.add(activity.getID()+": "+activity.getName());
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				result = new Object[0];
				return result;
				
				
				
			case "list all project activities":
				project = (ProjectInfo) methodArguments[1];
				activityList = this.application.getProjectActivities(project.getID());
				result = new Object[activityList.size()];
				for (int i=0; i< result.length; i++) {
					result[i] = activityList.get(i).asActivityInfo();
				}
				if (result.length == 0) {
					this.printFeedback = true;
					this.feedback.add("There are no activities for this project.");
					this.feedback.add("Click enter to go back.");
				}
				else
					this.printFeedback = false;
				return result;
				
				
//			case "see project progress":
				
				
				
			case "create activity":
				activity = (ActivityInfo) methodArguments[1];
				project = (ProjectInfo) methodArguments[2];
				activity.setID(application.addActivityToProject(project.getID(), activity.asActivity()));
				
				this.feedback.add("You have added the new activity");
				this.feedback.add(activity.getID()+": "+activity.getName());
				this.feedback.add("to the project "+project.getID()+": "+project.getName());
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				result = new Object[0];
				return result;

				
				
			case "list employees on activity":
				activity = (ActivityInfo) methodArguments[1];
				project = (ProjectInfo) methodArguments[2];
				employeeList = this.application.getEmployeesAssignedToActivity(project.getID(), activity.getID());
				result = new Object[employeeList.size()];
				for (int i=0; i<result.length; i++) {
					result[0] = employeeList.get(i).asEmployeeInfo();
				}
				this.printFeedback = false;
				return result;


				
			case "delete activity":
				result = new Object[0];
				activity = (ActivityInfo)methodArguments[1];
				project = (ProjectInfo)methodArguments[2];	
				this.application.deleteActivity(project.getID(),activity.getID());
				this.feedback.add("Project "+project.getID()+": "+project.getName()+" has been deleted");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				return result;
				
				
			case "set activity name":
				activity = (ActivityInfo) methodArguments[1];
				project = (ProjectInfo) methodArguments[2];
				activityName = methodArguments[3].toString();
				this.application.renameActivity(project.getID(),activity.getID(),activityName);
				this.feedback.add("The activity has been renamed to \""+activityName+"\".");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				result = new Object[0];
				return result;

				
				
				
				
			case "budget hours":
				activity = (ActivityInfo) methodArguments[1];
				project = (ProjectInfo) methodArguments[2];
				hours = (double) methodArguments[3];
				this.application.budgetHours(activity.getID(), project.getID(), hours);
				
				this.feedback.add("You have changed to budgeted hours for activity");
				this.feedback.add(activity.getID()+": "+activity.getName());
				this.feedback.add("to "+hours+".");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				result = new Object[0];
				return result;
				
				
			case "assign employee to activity":
				activity = (ActivityInfo) methodArguments[1];
				project = (ProjectInfo) methodArguments[2];
				employee = (EmployeeInfo) methodArguments[3];
				this.application.assignEmployeeToActivity(project.getID(),employee.getInitials(),activity.getID());
				
				this.feedback.add("You have assigned employee "+employee.getInitials()+" to activity");
				this.feedback.add(activity.getID()+": "+activity.getName());
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				result = new Object[0];
				return result;
				
				
				
				
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
}