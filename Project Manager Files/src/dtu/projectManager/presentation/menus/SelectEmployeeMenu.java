package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class SelectEmployeeMenu extends Menu {

	public EmployeeInfo user;
	public EmployeeInfo employee;
	
	public SelectEmployeeMenu(EmployeeInfo user) {
		this.user = user;
	}

	

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Enter the initials of the employee who the hours");
		startText.add("should be registered to.");
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
	Object[] input = new Object[1];
	input[0] = this.employee.copy();
	return input;

	}

	@Override
	protected void setInput(String initials) {
		this.employee = new EmployeeInfo(initials);
	}

	@Override
	protected String getMethodName() {
		return "list all employee activities";
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be the initials of an employee");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		if (result.length == 0) {
			return rewindState();
		}
		
		ActivityInfo[] activities = new ActivityInfo[result.length];
		for (int i=0; i<result.length; i++) {
			activities[i] = (ActivityInfo) result[i];
		}
		return new AdminSelectActivityMenu(this.user,this.employee,activities);
	}


	@Override
	public Menu rewindState() {
		return new AdminMenu(this.user);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
