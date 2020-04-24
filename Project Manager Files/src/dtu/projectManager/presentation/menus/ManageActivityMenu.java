package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class ManageActivityMenu extends Menu {

	private String username;
	private String activity;
	private int choice;
	
	public ManageActivityMenu(String username, String activity) {
		this.username = username;
		this.activity = activity;
	}
	
	@Override
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("You have chosen activity "+this.activity);
		startText.add("These are your options");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> GetOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("Assign hours");
		options.add("Ask for assistance");
		options.add("Return to main menu");

		return options;
	}

	@Override
	protected List<String> GetEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for what you want to do.");
		return endText;
	}

	@Override
	protected boolean HasOptions() {
		return true;
	}

	@Override
	protected String[] GetMethodInput() {
		String[] emptyInput = new String[0];
		return emptyInput;
	}

	@Override
	protected void SetInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String GetMethodName() {
		return null;
	}

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a number between 1 and "+GetOptions().size());
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return true;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {

		if (this.choice == 1)
			return new RegisterHoursMenu(this.username, this.activity);
		if (this.choice == 2)
			return new AssistanceMenu(this.username, this.activity);
		if (this.choice == 3)
			return new EmployeeMenu(this.username);
		else
			throw new Exception("Choice was not valid");
	}

	@Override
	public Menu RewindState() {
		return this;
	}

	@Override
	public boolean NeedsExecution() {
		return false;
	}

}
