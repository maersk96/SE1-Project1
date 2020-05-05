package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class NameEmployee extends Menu {
	private EmployeeInfo user;
	private EmployeeInfo employee;
	private String employeeName;
	
	public NameEmployee(EmployeeInfo user, EmployeeInfo employee) {
		this.user = user;
		this.employee = employee;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Please enter the name of the new employee");
		startText.add("If name is empty, the employee will be named \"Anonymous\"");
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
		MethodInput[0] = this.employee.copy();
		MethodInput[1] = this.employeeName;
		return MethodInput;
	}
	
	@Override
	protected void setInput(String name) {
		this.employeeName = name;
	}

	@Override
	protected String getMethodName() {
		return "create employee";
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be the new name of the employee");
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
		return new AdminMenu(this.user);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}

}
