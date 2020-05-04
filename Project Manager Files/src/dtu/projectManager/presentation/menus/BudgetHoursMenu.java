package dtu.projectManager.presentation.menus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class BudgetHoursMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo activity;
	private double budgetedHours;
	private DecimalFormat df;
	
	public BudgetHoursMenu(EmployeeInfo user, ProjectInfo project, ActivityInfo activity) {
		this.user = user;
		this.project = project;
		this.activity = activity;

		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		this.df = new DecimalFormat("#.#", otherSymbols);
	    this.df.setMinimumFractionDigits(0);
	    this.df.setMaximumFractionDigits(1);

	}

	// Special check for double
	@Override
	public boolean validateInput(String input) {

		double x;
		try {
		x = Double.parseDouble(input);
		} catch (NumberFormatException e) {
		return false;
		}
		
		if (x<0)
			return false;
		
		return true;
	}

	@Override
	protected List<String> getStartText() {
		
		String bHours = this.df.format(this.activity.getBudgetHours());
		List<String> startText = new ArrayList<String>();

		startText.add("Project:");
		startText.add(this.project.getID()+": "+this.project.getName());
		startText.add("");
		startText.add("Activity:");
		startText.add(this.activity.getID()+": "+this.activity.getName());
		startText.add("going from week "+this.activity.getStartWeek()+" to week "+this.activity.getEndWeek()+".");
		startText.add("");
		startText.add("Current budgeted hours: "+bHours);
		startText.add("Enter the new number of budgeted hours (using \".\" for decimals)");
		startText.add("");
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
		Object[] input = new Object[3];
		input[0] = this.activity.copy();
		input[1] = this.user.copy();
		input[2] = this.budgetedHours;
		return input;
	}

	@Override
	protected void setInput(String input) {
		this.budgetedHours = Double.parseDouble(input);
	}

	@Override
	protected String getMethodName() {
		return "budget hours";
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a string of letters");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return new ManageProjectActivityMenu(this.user,this.project,this.activity);
	}

	@Override
	public Menu rewindState() {
		return new ManageProjectActivityMenu(this.user,this.project,this.activity);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}
