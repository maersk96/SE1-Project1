package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dtu.EmployeeInfo;
import dtu.projectManager.dtu.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class RenameProjectMenu extends Menu {

	
	
	private String username;
	private String projectID;
	private String projectName;
	private String newName;

	
	public RenameProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.username = user.getInitials();
		this.projectName = project.getName();
		this.projectID = project.getID();
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Enter the new name for the project:");
		startText.add(this.projectID+": "+this.projectName);
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
		Object[] input = new Object[2];
		ProjectInfo project = new ProjectInfo(this.projectName);
		project.setID(this.projectID);
		input[0] = project;
		input[1] = this.newName;
		return input;
	}

	@Override
	protected void setInput(String input) {
		this.newName = input;
	}

	@Override
	protected String getMethodName() {
		return "set project name";
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
		ProjectInfo project = new ProjectInfo(this.projectName);
		project.setID(this.projectID);
		return new ManageProjectMenu(new EmployeeInfo(this.username),project);
	}

	@Override
	public Menu rewindState() {
		ProjectInfo project = new ProjectInfo(this.projectName);
		project.setID(this.projectID);
		return new ManageProjectMenu(new EmployeeInfo(this.username),project);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
