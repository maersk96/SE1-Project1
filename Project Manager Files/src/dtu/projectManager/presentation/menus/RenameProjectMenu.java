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
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Enter the new name for the project:");
		startText.add(this.project);
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> GetOptions() {
		return null;
	}

	@Override
	protected List<String> GetEndText() {
		return null;
	}

	@Override
	protected boolean HasOptions() {
		return false;
	}

	@Override
	protected String[] GetMethodInput() {
		String[] input = new String[2];
		input[0] = this.project;
		input[1] = this.projectName;
		return input;
	}

	@Override
	protected void SetInput(String input) {
		this.projectName = input;
	}

	@Override
	protected String GetMethodName() {
		return "rename project";
	}

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters");
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return false;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {
		return new ManageProjectMenu(this.username, this.project);
	}

	@Override
	public Menu RewindState() {
		return new ManageProjectMenu(this.username, this.project);
	}

	@Override
	public boolean NeedsExecution() {
		return true;
	}
}
