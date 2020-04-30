package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class LoginMenu extends Menu {

	private EmployeeInfo user;
	
	public LoginMenu() {
		
	}
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Welcome to the login menu");
		startText.add("Please enter your username");
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
		input[0] = this.user.copy();
		return input;
	}
	
	@Override
	protected void setInput(String username) {
		this.user = new EmployeeInfo(username);
	}

	@Override
	protected String getMethodName() {
		return "login";
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The username should be a single string of letters,");
		inputSpecification.add("for example your employee initials");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] input) throws Exception {
		EmployeeInfo employee = (EmployeeInfo)input[1];
		boolean isAdmin = Boolean.valueOf(input[0].toString());
		if (isAdmin)
			return new AdminMenu(employee);
		else
			return new EmployeeMenu(employee);		
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
