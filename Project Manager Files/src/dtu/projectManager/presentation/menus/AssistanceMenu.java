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
	protected List<String> getStartText() {

		List<String> startText = new ArrayList<String>();
		startText.add("Activity: "+this.activity);
		startText.add("Please enter the initials of the employee assisting you");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> getOptions() {
		return null;
	}

	@Override
	protected List<String> getEndText() {
		return null;
	}

	@Override
	protected boolean hasOptions() {
		return false;
	}

	@Override
	protected String[] getMethodInput() {
		String[] input = new String[3];
		input[0] = this.username;
		input[1] = this.activity;
		input[2] = this.helperID;
		return input;
	}

	@Override
	protected void setInput(String helperID) {
		this.helperID = helperID;
	}

	@Override
	protected String getMethodName() {
		return "ask for assistance";
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be the initials of the employee");
		inputSpecification.add("that is helping you.");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return new ManageActivityMenu(this.username,this.activity);
	}

	@Override
	public Menu rewindState() {
		return new ManageActivityMenu(this.username,this.activity);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}

}
