package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class LoginMenu extends Menu {

	private String username;
	
	public LoginMenu() {
		
	}
	@Override
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Welcome to the login menu");
		startText.add("Please enter your username");
		return startText;
	}

	@Override
	protected List<String> GetOptions() {
		return null;
	}

	@Override
	protected List<String> GetEndText() {
		return null;
	}

	@Override
	protected boolean HasOptions() {
		return false;
	}

	@Override
	protected String[] GetMethodInput() {
		String[] input = new String[1];
		input[0] = this.username;
		return input;
	}
	
	@Override
	protected void SetInput(String username) {
		this.username = username;
	}

	@Override
	protected String GetMethodName() {
		return "login";
	}
	

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The username should be a single string of letters,");
		inputSpecification.add("for example your employee initials");
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return false;
	}

	@Override
	public Menu GetNextState(Object[] input) throws Exception {
		boolean isAdmin = Boolean.valueOf(input[0].toString());
		if (isAdmin)
			return new AdminMenu(this.username);
		else
			return new EmployeeMenu(this.username);		
	}

	@Override
	public Menu RewindState() {
		return this;
	}

	@Override
	public boolean NeedsExecution() {
		return true;
	}


	
}
