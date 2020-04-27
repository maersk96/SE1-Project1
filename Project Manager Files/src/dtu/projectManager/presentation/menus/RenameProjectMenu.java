package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class RenameProjectMenu extends Menu {

	
	
	private String username;
	private String project;
	private String projectName;

	
	public RenameProjectMenu(String username, String project) {
		this.username = username;
		this.project = project;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Enter the new name for the project:");
		startText.add(this.project);
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
		String[] input = new String[2];
		input[0] = this.project;
		input[1] = this.projectName;
		return input;
	}

	@Override
	protected void setInput(String input) {
		this.projectName = input;
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
		return new ManageProjectMenu(this.username, this.project);
	}

	@Override
	public Menu rewindState() {
		return new ManageProjectMenu(this.username, this.project);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
