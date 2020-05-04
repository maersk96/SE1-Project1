package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class EmployeeMenu extends Menu {

	private EmployeeInfo user;
	private int choice;
	
	
	public EmployeeMenu(EmployeeInfo user) {
		this.user = user;
	}
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Welcome, "+this.user.getName());
		startText.add("These are your options:");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("Manage your activities");
		options.add("See the projects that you are the leader of");
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
		Object[] methodInput = new Object[1];
		methodInput[0] = this.user.copy();
		return methodInput;
	}
	
	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		if (this.choice == 1)
			return "list all employee activities";
		if (this.choice == 2)
			return "find projects where employee is leader";
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
		
		if (result.length == 0) {
			return rewindState();
		}
		
		if (this.choice == 1) {
			ActivityInfo[] activities = new ActivityInfo[result.length];
			for (int i=0; i<result.length; i++) {
				activities[i] = (ActivityInfo) result[i];
			}
			return new SelectActivityMenu(this.user,activities);
		}
		if (this.choice == 2) {
			if (result.length == 0) {
				return rewindState();
			}
			ProjectInfo[] Projects = new ProjectInfo[result.length];
			for (int i=0; i<result.length; i++) {
				Projects[i] = (ProjectInfo)result[i];
			}
			return new SelectLeaderProjectMenu(user, Projects);
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
		return true;
	}


}
