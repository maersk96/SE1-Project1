package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class RenameProjectMenu extends Menu {

	
	
	private EmployeeInfo user;
	private ProjectInfo project;
	private String newName;

	
	public RenameProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.user = user;
		this.project = project;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Enter the new name for the project:");
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
		Object[] input = new Object[2];
		input[0] = this.project.copy();
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
		this.project.setName(this.newName);
		return new ManageProjectMenu(this.user,this.project);
	}

	@Override
	public Menu rewindState() {
		return new ManageProjectMenu(this.user,this.project);	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
