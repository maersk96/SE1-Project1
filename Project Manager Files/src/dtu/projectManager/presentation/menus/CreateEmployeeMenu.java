package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class CreateEmployeeMenu extends Menu {

	private String username;
	private String EmployeeID;
	
	public CreateEmployeeMenu(String username) {
		this.username = username;
	}
	
	@Override
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Please enter the ID/initials of the new employee");
		startText.add("");
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
		String[] MethodInput = new String[1];
		MethodInput[0] = this.EmployeeID;
		return MethodInput;
	}
	
	@Override
	protected void SetInput(String id) {
		this.EmployeeID = id;
	}

	@Override
	protected String GetMethodName() {
		return "create Employee";
	}
	

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters identifying the new employee");
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return false;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {
		return new AdminMenu(this.username);
	}

	@Override
	public Menu RewindState() {
		return new AdminMenu(this.username);
	}

	@Override
	public boolean NeedsExecution() {
		return true;
	}

}
