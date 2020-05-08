package dtu.projectManager.dto;

import dtu.projectManager.app.Activity;

public class ActivityInfo {
	
	private String ID = "";
	private String name;
	private int startWeek;
	private int endWeek;
	private double budgetHours=0;
	private double totalHours=0;

	
	public ActivityInfo(String name, int startWeek, int endWeek) {
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.name = name;
	}
	
	public ActivityInfo(Activity activity) {
		this.name = activity.getName();
		this.ID = activity.getID();
		this.startWeek = activity.getStartWeek();
		this.endWeek = activity.getEndWeek();
		this.budgetHours = activity.getBudgetHours();
		this.totalHours = activity.getTotalRegisteredHours();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getEndWeek() {
		return this.endWeek;
	}

	public int getStartWeek() {
		return this.startWeek;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek; 
	}
	
	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	public double getBudgetHours() {
		return budgetHours;
	}

	public void setBudgetHours(double bHours) {
		this.budgetHours = bHours;
	}
	
	public double getTotalHours() {
		return this.totalHours;
	}
	
	public void setTotalHours(double tHours) {
		this.totalHours = tHours;
	}

	public ActivityInfo copy() {
		ActivityInfo copy = new ActivityInfo(this.name, this.startWeek, this.endWeek);
		copy.setID(this.ID);
		copy.setName(this.name);
		copy.setBudgetHours(this.budgetHours);
		copy.setTotalHours(this.totalHours);
		return copy;
	}
	
	public Activity asActivity() {
		return new Activity(this.name, this.startWeek, this.endWeek-this.startWeek+1);
	}
}
