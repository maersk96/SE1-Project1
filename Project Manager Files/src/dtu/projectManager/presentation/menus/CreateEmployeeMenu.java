package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class CreateEmployeeMenu extends Menu {

	private EmployeeInfo user;
	private EmployeeInfo employee;
	
	public CreateEmployeeMenu(EmployeeInfo user) {
		this.user = user;
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
		return null;
	}
	
	@Override
	protected void setInput(String id) {
		this.employee = new EmployeeInfo(id.toUpperCase());
	}

	@Override
	protected String getMethodName() {
		return null;
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
		return new NameEmployeeMenu(this.user,this.employee);
	}

	@Override
	public Menu rewindState() {
		return new AdminMenu(this.user);
	}

	@Override
	public boolean needsExecution() {
		return false;
	}

}
