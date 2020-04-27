package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class ManageProjectMenu extends Menu {

	private String username;
	private String project;
	private int choice;
	
	public ManageProjectMenu(String username, String project) {
		this.username = username;
		this.project = project;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("You have selected the project: "+this.project);
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
	protected String[] getMethodInput() {
		String[] emptyInput = new String[0];
		return emptyInput;
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
		if (this.choice == 1)
			return new AssignLeaderMenu(this.username,this.project);
		if (this.choice == 2)
			return new RenameProjectMenu(this.username,this.project);
		if (this.choice == 3)
			return this;
		if (this.choice == 4)
			return new AdminMenu(this.username);
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
