package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.Project;
import dtu.projectManager.app.ProjectManagerApp;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;

public class Interpreter {

	private ProjectManagerApp application;
	private List<String> feedback;
	private boolean hadError;
	private boolean printFeedback;
	
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
		List<ProjectInfo> projectList;
		EmployeeInfo user,employee, leader;
		ProjectInfo project;
		String projectName;
		
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
				result = projectList.toArray(new Object[0]);
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
			    this.printFeedback = true;
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
				this.printFeedback = true;
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
				
				
//			case "list all employee activities":
				
				
//			case "find projects where employee is leader":
//				projectList = this.application.getProjects();
//				result = projectList.toArray(new Object[0]);
//				if (result.length == 0) {
//					this.printFeedback = true;
//					this.feedback.add("There are no existing projects to manage.");
//					this.feedback.add("Click enter to continue.");
//				}
//				else
//					this.printFeedback = false;
//				return result;

				
			
//			case "list available employees":
				
				
//			case "ask for assistance":
			
				
//			case "register hours":
				
				
//			case "list all project activities":

				
//			case "see project progress":
				
				
//			case "create activity":
				
				
//			case "show budgeted hours":

				
//			case "list employees on activity":

				
//			case "delete activity":
				
				
//			case "set activity name":
				
				
//			case "budget hours":
				
				
//			case "assign employee to activity":
				
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