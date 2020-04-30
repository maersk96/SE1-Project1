package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dtu.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class CreateEmployeeMenu extends Menu {

	private String username;
	private String EmployeeID;
	
	public CreateEmployeeMenu(EmployeeInfo user) {
		this.username = user.getInitials();
	}
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Please enter the ID/initials of the new employee");
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
		Object[] MethodInput = new Object[1];
		MethodInput[0] = new EmployeeInfo(this.EmployeeID);
		return MethodInput;
	}
	
	@Override
	protected void setInput(String id) {
		this.EmployeeID = id;
	}

	@Override
	protected String getMethodName() {
		return "create employee";
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters identifying the new employee");
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
		return new AdminMenu(new EmployeeInfo(this.username));
	}

	@Override
	public boolean needsExecution() {
		return true;
	}

}
