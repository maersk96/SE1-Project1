package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class AssignEmployeeMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo activity;
	private EmployeeInfo[] assignedEmployees;
	private EmployeeInfo newEmployee;
	
	public AssignEmployeeMenu(EmployeeInfo user, ProjectInfo project, ActivityInfo activity, EmployeeInfo[] assignedEmployees) {
		this.user = user;
		this.project = project;
		this.activity = activity;
		this.assignedEmployees = assignedEmployees;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		
		startText.add("Project:");
		startText.add(this.project.getID()+": "+this.project.getName());
		startText.add("");
		startText.add("Activity:");
		startText.add(this.activity.getID()+": "+this.activity.getName());
		startText.add("going from week "+this.activity.getStartWeek()+" to week "+this.activity.getEndWeek()+".");
		startText.add("");
		startText.add("These are the employees that are available for this activity:");
		
		for (int i=0; i<this.assignedEmployees.length; i++) {
			startText.add(this.assignedEmployees[i].getName()+" ("+this.assignedEmployees[i].getInitials()+")");
		}
		
		startText.add("");
		startText.add("Enter the initials of the employee that you want to assign");
		startText.add("to this activity.");
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
		input[1] = this.project.copy();
		input[2] = this.newEmployee.copy();
		return input;
	}

	@Override
	protected void setInput(String initials) {
		this.newEmployee = new EmployeeInfo(initials.toUpperCase());
	}

	@Override
	protected String getMethodName() {
		return "assign employee to activity";
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return new ProjectLeaderActivityMenu(this.user,this.project,this.activity);
	}

	@Override
	public Menu rewindState() {
		return new ProjectLeaderActivityMenu(this.user,this.project,this.activity);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
