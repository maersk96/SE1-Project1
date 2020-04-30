package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class AssistanceMenu extends Menu {
	
	private EmployeeInfo user;
	private ActivityInfo activity;
	private EmployeeInfo helper;

	
	public AssistanceMenu(EmployeeInfo user, ActivityInfo activity) {
		this.user = user;
		this.activity = activity;
	}
	@Override
	protected List<String> getStartText() {

		List<String> startText = new ArrayList<String>();
		startText.add("Activity:");
		startText.add(this.activity.getID()+": "+this.activity.getName());
		startText.add("going from week "+this.activity.getStartWeek()+" to week "+this.activity.getEndWeek()+".");
		startText.add("");
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
	protected Object[] getMethodInput() {
		Object[] input = new Object[3];
		input[0] = this.user;
		input[1] = this.activity;
		input[2] = this.helper;
		return input;
	}

	@Override
	protected void setInput(String helperID) {
		this.helper =  new EmployeeInfo(helperID);
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
