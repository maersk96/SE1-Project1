package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dtu.EmployeeInfo;
import dtu.projectManager.dtu.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class CreateProjectMenu extends Menu {

	private String username;
	private String projectID;
	private String projectname;
	
	public CreateProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.username = user.getInitials();
		this.projectID = project.getID();

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
	protected Object[] getMethodInput() {
		Object[] MethodInput = new Object[2];
		ProjectInfo project = new ProjectInfo("");
		project.setID(this.projectID);
		MethodInput[0] = project;
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
		return new AdminMenu(new EmployeeInfo(this.username));
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
