package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.app.OperationNotAllowedException;
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


	public Object[] CallMethod(String[] methodArguments) {
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
				this.printFeedback = false;
				result = new Object[1];
				result[0] = application.adminLoggedIn();
				return result;
				
//			case "list all projects":
				
				
//			case "create employee":
				
			case "create project":
				result = new Object[1];
				result[0] = application.addProject();
				this.printFeedback = false;
				return result;
			
//			case "assign project leader":
				
								
//			case "rename project":
				

//			case "archive project":

				
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
	
	public List<String> GetFeedback() {
		List<String> F = new ArrayList<String>();
		
		for (String line : this.feedback) {
			F.add(line);
		}
		return F;
	}
	
	public boolean PrintFeedback() {
		return this.printFeedback;
	}
	
	public boolean HadError() {
		return this.hadError;
	}
}