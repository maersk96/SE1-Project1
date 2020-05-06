package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class NewActivityDurationMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo activity;
	
	public NewActivityDurationMenu(EmployeeInfo user, ProjectInfo project, ActivityInfo activity) {
		this.user = user;
		this.project = project;
		this.activity = activity;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Please enter the duration of the new activity");
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
		Object[] methodInput = new Object[2];
		methodInput[0] = this.activity;
		methodInput[1] = this.project;
		return methodInput;
	}
	
	@Override
	protected void setInput(String duration) {
		this.activity.setEndWeek(this.activity.getStartWeek() - 1 + Integer.parseInt(duration));
	}

	@Override
	protected String getMethodName() {
		return "create activity";
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be an integer.");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return true;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return new ManageProjectActivityMenu(this.user,this.project, this.activity);
	}

	@Override
	public Menu rewindState() {
		if (this.user.getInitials().equals("ADMIN")) {
			return new ManageProjectMenu(this.user,this.project);
		}
		else {
			return new ProjectLeaderMenu(this.user,this.project);
		}
	}
	@Override
	public boolean needsExecution() {
		return true;
	}
}
