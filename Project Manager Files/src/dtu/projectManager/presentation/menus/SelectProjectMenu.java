package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class SelectProjectMenu extends Menu {

	private String username;
	private int choice;
	private String[] projects;
	
	
	public SelectProjectMenu(String username, Object[] projects) {
		this.projects = new String[projects.length];
		for (int i=0; i<projects.length; i++)
			this.projects[i]= projects[i].toString();
		this.username = username;
	}
	
	
	@Override
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("These are the existing projects");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> GetOptions() {
		List<String> options = new ArrayList<String>();
		
		for (int i=0; i<this.projects.length; i++) {
			options.add(this.projects[i]);
		}
		return options;
	}

	@Override
	protected List<String> GetEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for the project you want to manage.");
		return endText;
	}

	@Override
	protected boolean HasOptions() {
		return true;
	}

	@Override
	protected String[] GetMethodInput() {
		String[] emptyInput = new String[0];
		return emptyInput;
	}
	
	@Override
	protected void SetInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String GetMethodName() {
		return null;
	}
	

	@Override
	public List<String> GetInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a number between 1 and "+GetOptions().size());
		return inputSpecification;
	}

	@Override
	protected boolean IsInt() {
		return true;
	}

	@Override
	public Menu GetNextState(Object[] result) throws Exception {
		return new ManageProjectMenu(this.username,this.projects[this.choice-1]);
	}

	@Override
	public Menu RewindState() {
		return this;
	}

	@Override
	public boolean NeedsExecution() {
		return false;
		}



}
