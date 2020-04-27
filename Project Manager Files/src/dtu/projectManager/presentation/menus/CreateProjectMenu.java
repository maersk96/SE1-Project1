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
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("A new project with ID "+this.projectID+" has been created.");
		startText.add("Please enter the name to be assigned to the new project.");
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
		String[] MethodInput = new String[2];
		MethodInput[0] = this.projectID;
		MethodInput[1] = this.projectname;
		return MethodInput;
	}
	
	@Override
	protected void setInput(String name) {
		this.projectname = name;
	}

	@Override
	protected String getMethodName() {
		return "set project name";
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters specifying");
		inputSpecification.add("the name of the new project.");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return new AdminMenu(this.username);
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
