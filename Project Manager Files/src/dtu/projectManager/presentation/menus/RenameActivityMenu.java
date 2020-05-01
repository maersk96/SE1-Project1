package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class RenameActivityMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo activity;
	private String newName;
	
	public RenameActivityMenu(EmployeeInfo user, ProjectInfo project, ActivityInfo activity) {
		this.user = user;
		this.project = project;
		this.activity = activity;
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
		startText.add("Enter the new name for the activity:");
		startText.add(this.project.getID()+": "+this.project.getName());
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
		input[2] = this.newName;
		return input;
	}

	@Override
	protected void setInput(String input) {
		this.newName = input;
	}

	@Override
	protected String getMethodName() {
		return "set activity name";
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
		this.activity.setName(this.newName);
		return new ManageProjectActivityMenu(this.user,this.project,this.activity);
	}

	@Override
	public Menu rewindState() {
		return new ManageProjectActivityMenu(this.user,this.project,this.activity);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
