package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class CreateProjectMenu extends Menu {

	private String username;
	private String projectID;
	private String projectname;
	
	public CreateProjectMenu(String username, String ProjectID) {
		this.username = username;
		this.projectID = ProjectID;

	}
	
	@Override
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("A new project with ID "+this.projectID+" has been created.");
		startText.add("Please enter the name to be assigned to the new project.");
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
		String[] MethodInput = new String[2];
		MethodInput[0] = this.projectID;
		MethodInput[1] = this.projectname;
		return MethodInput;
	}
	
	@Override
	protected void SetInput(String name) {
		this.projectname = name;
	}

	@Override
	protected String GetMethodName() {
		return "set project name";
	}
	

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters specifying");
		inputSpecification.add("the name of the new project.");
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return false;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {
		return new AdminMenu(this.username);
	}

	@Override
	public Menu RewindState() {
		return this;
	}

	@Override
	public boolean NeedsExecution() {
		return true;
	}

}
