package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dtu.EmployeeInfo;
import dtu.projectManager.dtu.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class AdminMenu extends Menu {

	private String username;
	private int choice;
	
	public AdminMenu(EmployeeInfo user) {
		this.username = user.getInitials();
	}
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Welcome, "+this.username);
		startText.add("These are your options:");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("Create a new employee");
		options.add("Create a new project");
		options.add("Manage an existing project");
		return options;
	}

	@Override
	protected List<String> getEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for the action you want to do.");
		endText.add("Remember that you can always type \"logout\" to return");
		endText.add("to the login screen, or \"exit\" to quit the session.");
		return endText;
	}

	@Override
	protected boolean hasOptions() {
		return true;
	}

	@Override
	protected Object[] getMethodInput() {
		Object[] emptyInput = new Object[0];
		return emptyInput;
	}
	
	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		if (this.choice == 3)
			return "list all projects";
		if (this.choice == 2)
			return "create project";
		else
			return null;
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a number between 1 and "+getOptions().size());
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return true;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		
		
		if (this.choice == 1)
			return new CreateEmployeeMenu(new EmployeeInfo(this.username));
		if (this.choice == 2) {
			ProjectInfo project = (ProjectInfo) result[0];
			EmployeeInfo employee = new EmployeeInfo(this.username);
			return new CreateProjectMenu(employee,project);			
		}
		if (this.choice == 3) {
			if (result.length == 0) {
				return this;
			}
			ProjectInfo[] Projects = new ProjectInfo[result.length];
			for (int i=0; i<result.length; i++) {
				Projects[i] = (ProjectInfo)result[i];
			}
			return new SelectProjectMenu(new EmployeeInfo(this.username), Projects);
			
		}
		else
			throw new Exception("Choice was not valid");
	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		if (this.choice == 2 || this.choice == 3)
			return true;
		else
			return false;
		}



}
