package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.app.Employee;
import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.Project;
import dtu.projectManager.app.ProjectManagerApp;

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


	public Object[] callMethod(String[] methodArguments) {
		this.feedback.clear();
		this.hadError = false;
		this.printFeedback = true;
		Object[] result;
		String methodName = methodArguments[0];
		
		try {
			switch (methodName) {
			case "login":
				String username = methodArguments[1];
				application.login(username);
				result = new Object[1];
				result[0] = this.application.adminLoggedIn();
				this.printFeedback = false;
				return result;
				
//			case "list all projects":
				
				
			case "create employee":
				String initials = methodArguments[1];
				Employee employee = new Employee(initials);
				result = new Object[0];
				this.application.addEmployee(employee);
				this.printFeedback = true;
				this.feedback.add("An employee with initials "+initials+" has been created");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				return result;
				
			case "create project":
				result = new Object[1];
				Project project = new Project("");
				result[0] = this.application.addProject(project);
				this.printFeedback = false;
				return result;
			
//			case "assign project leader":
				
								
			case "set project name":
				result = new Object[0];
				String projectID = methodArguments[1];
				String projectName = methodArguments[2];
				this.application.renameProject(projectID,projectName);
				this.feedback.add("Project "+projectID+" has been assigned the name");
				this.feedback.add(projectName+".");
				this.feedback.add("");
				this.feedback.add("Press enter to continue");
				
				return result;
				
//			case "delete project":

				
//			case "list all activities":
				
				
//			case "find projects where employee is leader":
				
			
//			case "ask for assistance":
			
				
//			case "register hours":
				
				
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
}