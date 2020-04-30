package dtu.projectManager.presentation.menus;

import java.util.List;

import dtu.projectManager.presentation.Menu;

public class SeeProjectsMenu extends Menu {

	
	private String username;
	
	
	public SeeProjectsMenu(String username) {
		this.username = username;
	}
	
	@Override
	protected List<String> getStartText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> getEndText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean hasOptions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object[] getMethodInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setInput(String input) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getMethodName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getInputSpecification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isInt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu rewindState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean needsExecution() {
		// TODO Auto-generated method stub
		return false;
	}

}
