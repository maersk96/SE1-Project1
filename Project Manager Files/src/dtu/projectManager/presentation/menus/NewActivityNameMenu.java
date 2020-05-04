package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class NewActivityNameMenu extends Menu {

	
	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo activity;
	
	public NewActivityNameMenu(EmployeeInfo user, ProjectInfo project) {
		this.user = user;
		this.project = project;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Please enter the name of the new activity");
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
		Object[] methodInput = new Object[0];
		return methodInput;
	}
	
	@Override
	protected void setInput(String name) {
		this.activity = new ActivityInfo(name,0,0);
	}

	@Override
	protected String getMethodName() {
		return null;
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters identifying the new activity");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return new NewActivityStartWeekMenu(this.user, this.project, this.activity);
	}

	@Override
	public Menu rewindState() {
		return new ProjectLeaderMenu(this.user,this.project);
	}

	@Override
	public boolean needsExecution() {
		return false;
	}
}
