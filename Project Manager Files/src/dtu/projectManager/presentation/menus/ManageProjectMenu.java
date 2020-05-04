package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class ManageProjectMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private int choice;

	
	public ManageProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.user = user;
		this.project = project;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("You have selected the project: ");
		startText.add(this.project.getID()+": "+this.project.getName());
		startText.add("These are your options");
		startText.add("");
		return startText;

	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("Assign project leader");
		options.add("Rename project");
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
			Object[] input = new Object[0];
		return input;
	}

	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
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
			return new AssignLeaderMenu(this.user,this.project);
		}
		if (this.choice == 2) {
			return new RenameProjectMenu(this.user,this.project);
		}
		if (this.choice == 3)
			return new AdminMenu(this.user);
		else
			throw new Exception("Choice was not valid");	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		return false;
	}

}
