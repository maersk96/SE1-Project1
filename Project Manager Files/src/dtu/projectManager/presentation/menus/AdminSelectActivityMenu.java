package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class AdminSelectActivityMenu extends Menu {

	private EmployeeInfo user;
	private EmployeeInfo employee;
	private int choice;
	private ActivityInfo[] activities;

	
	public AdminSelectActivityMenu(EmployeeInfo user, EmployeeInfo employee, ActivityInfo[] activities) {
		this.user = user;
		this.employee = employee;
		this.activities = activities;
	}
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("These are all the activities that the employee "+this.employee.getInitials());
		startText.add("is assigned to");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		for (int i=0; i<this.activities.length; i++) {
			options.add(this.activities[i].getID()+": "+this.activities[i].getName());
		}
		return options;
	}

	@Override
	protected List<String> getEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for the activity you want to manage.");
		return endText;
	}

	@Override
	protected boolean hasOptions() {
		return true;
	}

	@Override
	protected Object[] getMethodInput() {
		Object[] input = new Object[2];
		input[0] = this.employee.copy();
		input[1] = this.activities[this.choice-1].copy();
		return input;
	}
	
	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		return "see registered hours";
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
		double hours = (double) result[0];
		return new AdminRegisterHoursMenu(this.user,this.employee,this.activities[this.choice-1],hours);
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
