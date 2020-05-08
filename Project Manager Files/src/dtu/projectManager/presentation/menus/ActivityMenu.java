package dtu.projectManager.presentation.menus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.presentation.Menu;

public class ActivityMenu extends Menu {

	private EmployeeInfo user;
	private ActivityInfo activity;
	private int choice;
	private double currentHours;
	private DecimalFormat df;

	
	public ActivityMenu(EmployeeInfo user, ActivityInfo activity, double currentHours) {
		this.user = user;
		this.activity = activity;
		this.currentHours = currentHours;
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		this.df = new DecimalFormat("#.#", otherSymbols);
	    this.df.setMinimumFractionDigits(0);
	    this.df.setMaximumFractionDigits(1);
	}
	
	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("You have chosen activity");
		startText.add(this.activity.getID()+": "+this.activity.getName());
		startText.add("going from week "+this.activity.getStartWeek()+" to week "+this.activity.getEndWeek()+".");
		startText.add("Hours you have registered to this activity: "+this.df.format(this.currentHours));
		startText.add("");
		startText.add("These are your options");
		startText.add("");
		return startText;
	}

	@Override
	protected List<String> getOptions() {
		List<String> options = new ArrayList<String>();
		
		options.add("Assign hours");
		options.add("Ask for assistance");
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
		Object[] emptyInput = new Object[0];
		return emptyInput;
	}

	@Override
	protected void setInput(String choice) {
		this.choice = Integer.parseInt(choice);
	}

	@Override
	protected String getMethodName() {
		if (this.choice == 2)
			return "list available employees";
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
			return new RegisterHoursMenu(this.user, this.activity,this.currentHours);			
		}
		if (this.choice == 2) {
			EmployeeInfo[] employees = new EmployeeInfo[result.length];
			for (int i=0; i<result.length; i++) {
				employees[i] = (EmployeeInfo)result[i];
			}
			return new AssistanceMenu(this.user, this.activity,employees, this.currentHours);			
		}
		if (this.choice == 3) {
			return new EmployeeMenu(this.user);			
		}
		else {
			throw new Exception("Choice was not valid");
			
		}
	}

	@Override
	public Menu rewindState() {
		return this;
	}

	@Override
	public boolean needsExecution() {
		if (this.choice == 2)
			return true;
		else
			return false;
	}

}
