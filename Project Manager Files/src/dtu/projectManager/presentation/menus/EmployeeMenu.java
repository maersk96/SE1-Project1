package dtu.projectManager.presentation.menus;

import java.util.List;

import dtu.projectManager.presentation.Menu;

public class EmployeeMenu extends Menu {

	private String username;
	
	public EmployeeMenu(String username) {
		this.username = username;
	}
	
	@Override
	protected List<String> GetStartText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> GetOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> GetEndText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean HasOptions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String[] GetMethodInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String GetMethodName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> GetInputSpecification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean IsInt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu RewindState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean NeedsExecution() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void SetInput(String input) {
		// TODO Auto-generated method stub
		
	}

}
