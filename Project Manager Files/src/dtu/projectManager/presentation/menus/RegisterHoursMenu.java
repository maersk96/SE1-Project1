package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class RegisterHoursMenu extends Menu {

	private EmployeeInfo user;
	private ActivityInfo activity;
	private double hours;
	
	public RegisterHoursMenu(EmployeeInfo user, ActivityInfo activity) {
		this.user = user;
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
		
		startText.add("Activity:");
		startText.add(this.activity.getID()+": "+this.activity.getName());
		startText.add("going from week "+this.activity.getStartWeek()+" to week "+this.activity.getEndWeek()+".");
		startText.add("");
		startText.add("How many hours did you work on this activity?");
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
	Object[] input = new Object[3];
	input[0] = this.activity.copy();
	input[1] = this.user.copy();
	input[2] = this.hours;
	return input;

	}

	@Override
	protected void setInput(String hours) {
		this.hours = Double.parseDouble(hours);
	}

	@Override
	protected String getMethodName() {
		return "register hours";
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
		return new ManageActivityMenu(this.user,this.activity);
	}

	@Override
	public Menu rewindState() {
		return new ManageActivityMenu(this.user,this.activity);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
