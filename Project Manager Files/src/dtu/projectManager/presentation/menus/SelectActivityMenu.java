package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.presentation.Menu;

public class SelectActivityMenu extends Menu {

	private String username;
	private int choice;
	private String[] activities;
	
	public SelectActivityMenu(String username, Object[] activities) {
		this.username = username;
		this.activities = new String[activities.length];
		for (int i=0; i<activities.length; i++)
			this.activities[i]= activities[i].toString();

	}
	
	@Override
	protected List<String> GetStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("These are all your activities");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> GetOptions() {
		List<String> options = new ArrayList<String>();
		
		for (int i=0; i<this.activities.length; i++) {
			options.add(this.activities[i]);
		}
		return options;
	}

	@Override
	protected List<String> GetEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for the activity you want to manage.");
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
		return new ManageActivityMenu(this.username,this.activities[this.choice-1]);
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
