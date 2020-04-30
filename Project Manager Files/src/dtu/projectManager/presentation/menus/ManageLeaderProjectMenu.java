package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class ManageLeaderProjectMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private int choice;
	
	public ManageLeaderProjectMenu(EmployeeInfo user, ProjectInfo project) {
		this.user = user;
		this.project = project;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("You have selected the project: ");
		startText.add(this.project.getID()+": "+this.project.getName());
		startText.add("These are your options");
		startText.add("");
		return startText;
	}
	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("See progress");
		options.add("Create activity");
		options.add("Manage activities");
		options.add("Return to main menu");
		return options;
	}

	@Override
	protected List<String> getEndText() {
		List<String> endText = new ArrayList<String>();
		endText.add("");
		endText.add("Enter the number for what you want to do.");
		return endText;
	}

	@Override
	protected boolean hasOptions() {
		return true;
	}

	@Override
	protected Object[] getMethodInput() {
		Object[] input;
		if (this.choice == 1 || this.choice == 3)
		{
			input = new Object[1];
			input[0] = this.project.copy();
		}
		else
			input = new Object[0];
		return input;
	}

	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		if (this.choice == 1)
			return "see project progress";
		if (this.choice == 3)
			return "list all project activities";
		else
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
		if (this.choice == 1) {
			return new ProjectProgressMenu(this.user,this.project);
		}
		if (this.choice == 2) {
			return new NewActivityNameMenu(this.user,this.project);
		}
		if (this.choice == 3) {
			ActivityInfo[] activities = new ActivityInfo[result.length];
			for (int i=0; i<result.length; i++) {
				activities[i] = (ActivityInfo) result[i];
			}
			return new SelectProjectActivityMenu(this.user,this.project, activities);			
		}
		if (this.choice == 4) {
			return new EmployeeMenu(this.user);
		}
		else
			throw new Exception("Choice was not valid");	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		if (this.choice == 1 || this.choice == 3)
			return true;
		else 
			return false;
	}

}
