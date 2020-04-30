package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dtu.EmployeeInfo;
import dtu.projectManager.dtu.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class ManageProjectMenu extends Menu {

	private String username;
	private String projectName;
	private String projectID;
	private int choice;

	
	public ManageProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.username = user.getInitials();
		this.projectName = project.getName();
		this.projectID = project.getID();
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("You have selected the project: ");
		startText.add(this.projectID+": "+this.projectName);
		startText.add("These are your options");
		startText.add("");
		return startText;

	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("Assign project leader");
		options.add("Rename project");
		options.add("Delete project");
		options.add("Return to main menu");
		return options;
	}

	@Override
	protected List<String> getEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for what you want to do.");
		return endText;
	}

	@Override
	protected boolean hasOptions() {
		return true;
	}

	@Override
	protected Object[] getMethodInput() {
		Object[] input;
		if (this.choice == 3)
		{
			ProjectInfo project = new ProjectInfo(this.projectName);
			project.setID(this.projectID);
			input = new Object[1];
			input[0] = project;
		}
		else
			input = new Object[0];
		return input;
	}

	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		if (this.choice == 3)
			return "delete project";
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
		if (this.choice == 1) {
			ProjectInfo project = new ProjectInfo(this.projectName);
			project.setID(this.projectID);
			EmployeeInfo user = new EmployeeInfo(this.username);
			return new AssignLeaderMenu(user,project);
		}
		if (this.choice == 2) {
			ProjectInfo project = new ProjectInfo(this.projectName);
			project.setID(this.projectID);
			EmployeeInfo user = new EmployeeInfo(this.username);
			return new RenameProjectMenu(user,project);
		}
		if (this.choice == 3 || this.choice == 4)
			return new AdminMenu(new EmployeeInfo(this.username));
		else
			throw new Exception("Choice was not valid");	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		if (this.choice == 3)
			return true;
		else 
			return false;
	}

}
