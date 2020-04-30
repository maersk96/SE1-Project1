package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dtu.EmployeeInfo;
import dtu.projectManager.dtu.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class SelectProjectMenu extends Menu {

	private String username;
	private int choice;
	private String[] projectNames;
	private String[] projectIDs;
	
	
	public SelectProjectMenu(EmployeeInfo user, ProjectInfo[] projects) {
		this.projectNames = new String[projects.length];
		this.projectIDs = new String[projects.length];
		for (int i=0; i<projects.length; i++) {
			this.projectNames[i]= projects[i].getName();
			this.projectIDs[i]= projects[i].getID();			
		}
		this.username = user.getInitials();
	}
	
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("These are the existing projects");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		for (int i=0; i<this.projectNames.length; i++) {
			options.add(this.projectIDs[i]+": "+this.projectNames[i]);
		}
		return options;
	}

	@Override
	protected List<String> getEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for the project you want to manage.");
		return endText;
	}

	@Override
	protected boolean hasOptions() {
		return true;
	}

	@Override
	protected Object[] getMethodInput() {
		Object[] emptyInput = new Object[0];
		return emptyInput;
	}
	
	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		return null;
	}
	

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a number between 1 and "+getOptions().size());
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return true;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		ProjectInfo project = new ProjectInfo(this.projectNames[this.choice-1]);
		project.setID(this.projectIDs[this.choice-1]);
		return new ManageProjectMenu(new EmployeeInfo(this.username),project);
	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		return false;
		}



}
