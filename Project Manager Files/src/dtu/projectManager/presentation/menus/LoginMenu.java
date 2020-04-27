package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class LoginMenu extends Menu {

	private String username;
	
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
	protected String[] getMethodInput() {
		String[] input = new String[1];
		input[0] = this.username;
		return input;
	}
	
	@Override
	protected void setInput(String username) {
		this.username = username;
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
		boolean isAdmin = Boolean.valueOf(input[0].toString());
		if (isAdmin)
			return new AdminMenu(this.username);
		else
			return new EmployeeMenu(this.username);		
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
