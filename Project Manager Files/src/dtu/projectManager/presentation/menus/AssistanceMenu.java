package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class AssistanceMenu extends Menu {
	
	private String username;
	private String activity;
	private String helperID;

	
	public AssistanceMenu(String username, String activity) {
		this.username = username;
		this.activity = activity;
	}
	@Override
	protected List<String> GetStartText() {

		List<String> startText = new ArrayList<String>();
		startText.add("Activity: "+this.activity);
		startText.add("Please enter the initials of the employee assisting you");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> GetOptions() {
		return null;
	}

	@Override
	protected List<String> GetEndText() {
		return null;
	}

	@Override
	protected boolean HasOptions() {
		return false;
	}

	@Override
	protected String[] GetMethodInput() {
		String[] input = new String[3];
		input[0] = this.username;
		input[1] = this.activity;
		input[2] = this.helperID;
		return input;
	}

	@Override
	protected void SetInput(String helperID) {
		this.helperID = helperID;
	}

	@Override
	protected String GetMethodName() {
		return "ask for assistance";
	}

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be the initials of the employee");
		inputSpecification.add("that is helping you.");
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return false;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {
		return new ManageActivityMenu(this.username,this.activity);
	}

	@Override
	public Menu RewindState() {
		return new ManageActivityMenu(this.username,this.activity);
	}

	@Override
	public boolean NeedsExecution() {
		return true;
	}

}
