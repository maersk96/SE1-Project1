package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class CreateProjectMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private String projectName;
	
	public CreateProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.user = user;
		this.project = project;

	}
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("A new project with ID "+this.project.getID()+" has been created.");
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
		MethodInput[0] = this.project.copy();
		MethodInput[1] = this.projectName;
		return MethodInput;
	}
	
	@Override
	protected void setInput(String name) {
		this.projectName = name;
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
		return new AdminMenu(this.user);
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
