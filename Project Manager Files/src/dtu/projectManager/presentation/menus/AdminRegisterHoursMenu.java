package dtu.projectManager.presentation.menus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class AdminRegisterHoursMenu extends Menu {
	private EmployeeInfo user;
	private ActivityInfo activity;
	private EmployeeInfo employee;
	private double hours;
	private double currentHours;
	private DecimalFormat df;
	
	
	public AdminRegisterHoursMenu(EmployeeInfo user, EmployeeInfo employee, ActivityInfo activity, double currentHours) {
		this.user = user;
		this.activity = activity;
		this.employee = employee;
		this.currentHours = currentHours;
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
		List<String> startText = new ArrayList<String>();
		
		startText.add("Activity:");
		startText.add(this.activity.getID()+": "+this.activity.getName());
		startText.add("going from week "+this.activity.getStartWeek()+" to week "+this.activity.getEndWeek()+".");
		startText.add(this.employee.getInitials()+" currently has "+this.df.format(this.currentHours)+" hours registered to this activity.");
		startText.add("");
		startText.add("How many hours did "+this.employee.getInitials()+" work on this activity?");
		startText.add("(use \".\" for decimals)");
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
	input[1] = this.employee.copy();
	input[2] = this.hours;
	return input;

	}

	@Override
	protected void setInput(String hours) {
		this.hours = Double.parseDouble(hours);
	}

	@Override
	protected String getMethodName() {
		return "register hours";
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("The input should be a positive number.");
		inputSpecification.add("(use \".\" for decimals)");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return false;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
		return rewindState();
	}

	@Override
	public Menu rewindState() {
		return new AdminMenu(this.user);
	}

	@Override
	public boolean needsExecution() {
		return true;
	}
}