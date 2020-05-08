package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class SelectProjectActivityMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo[] activities;
	private int choice;
	
	public SelectProjectActivityMenu(EmployeeInfo user, ProjectInfo project, ActivityInfo[] activities) {
		this.user = user;
		this.project = project;
		this.activities = activities;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("These are the activities in project");
		startText.add(this.project.getID()+": "+this.project.getName());
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
		String[] emptyInput = new String[0];
		return emptyInput;
	}
	
	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
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
			return new ProjectLeaderActivityMenu(this.user,this.project,this.activities[this.choice-1]);
	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		return false;
		}
}
