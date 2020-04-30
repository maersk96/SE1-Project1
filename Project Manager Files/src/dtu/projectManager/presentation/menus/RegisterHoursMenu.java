package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class RegisterHoursMenu extends Menu {

	private String username;
	private String activity;
	private double hours;
	
	public RegisterHoursMenu(String username, String activity) {
		this.username = username;
		this.activity = activity;
	}
	
	
	// Special check for double
	@Override
	public boolean validateInput(String input) {

		double x;
		try {
		x = Double.parseDouble(input);
		} catch (NumberFormatException e) {
		return false;
		}
		
		if (x<0)
			return false;
		
		return true;
	}

	
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Activity: "+this.activity);
		startText.add("How many hours did you work on this project?");
		startText.add("(use dot for decimals)");
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
	protected Object[] getMethodInput() {		
	String[] input = new String[3];
	input[0] = this.username;
	input[1] = this.activity;
	input[2] = Double.toString(this.hours);
	return input;

	}

	@Override
	protected void setInput(String hours) {
		this.hours = Double.parseDouble(hours);
	}

	@Override
	protected String getMethodName() {
		return "Register hours";
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a positive number. If there is a fraction,");
		inputSpecification.add("use a dot to seperate the decimals.");
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
